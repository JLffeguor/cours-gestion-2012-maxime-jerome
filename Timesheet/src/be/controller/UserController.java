package be.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import be.exception.UnauthorizedAccessException;
import be.exception.UserAlreadyExistsException;
import be.exception.UserAlreadyExistsException.IdentifierType;
import be.model.User;
import be.repository.UserRepository;
import be.security.Privilege;
import be.security.SecurityContext;
import be.service.UserService;

@Controller
public class UserController extends BaseController<User> {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@RequestMapping("/user_manage")
	public ModelAndView userEdit() {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			System.out.println("user non loggé");
			return new ModelAndView("redirect:login");
		}

		User user = getRequiredEntity(SecurityContext.getUserId()); // get
																	// currentuser

		ModelAndView mv = new ModelAndView("user_manage");
		mv.addObject("id", user.getId()); // Do not remove because when we use
											// the dummy model attribute
											// (doNotUseThisUserInstance), it
											// has no id.
		// send user to be able to print his profil
		mv.addObject("user", user);

		if (user.hasAdminPrivileges()) {
			System.out.println(user.getUserName() + "  je suis un amdin");
			mv.addObject("admin", true);
			List<User> allUsers = userRepository.findAll();
			mv.addObject("usersList", allUsers);
		}

		return mv;
	}

	private ModelAndView prepareModelAndView(Long userId, User user) {
		ModelAndView mv = new ModelAndView("useredit");

		mv.addObject("id", userId); // Do not remove because when we use the
									// dummy model attribute
									// (doNotUseThisUserInstance), it has no id.
		mv.addObject("user", user);

		return mv;
	}

	@RequestMapping("/editsubmit")
	public ModelAndView userEditSubmit(
			@RequestParam(value = "userName") String newUserName,
			@RequestParam("id") long userId,
			@Valid @ModelAttribute User doNotUseThisUserInstance, // To enable
																	// the use
																	// of errors
																	// param.
			Errors errors) {

		User user = getRequiredEntity(userId);
		SecurityContext.assertCurrentUserMayEditThisUser(user);

		// userName
		boolean hasUserAlreadyExist = false;
		newUserName = org.springframework.util.StringUtils.trimAllWhitespace(
				newUserName).toLowerCase(); // remove blanks
		if (!org.apache.commons.lang3.StringUtils.equalsIgnoreCase(
				user.getUserName(), newUserName)) { // Want to change username
			// check duplicate
			User otherUser = userRepository.getUserByUserName(newUserName);
			if (otherUser != null) { // Another user already uses that userName
				errors.rejectValue("userName", null,
						"Ce pseudonyme est déjà utilisé par un autre utilisateur.");
				hasUserAlreadyExist = true;
			}
		}

		if (errors.hasErrors()) {
			ModelAndView mv = prepareModelAndView(userId,
					doNotUseThisUserInstance);
			if (doNotUseThisUserInstance.getUserName() == ""
					|| hasUserAlreadyExist == true) {
				doNotUseThisUserInstance.setUserName(user.getUserName()); // We
																			// need
																			// to
																			// restore
																			// the
																			// username,
																			// because
																			// the
																			// "Cancel"
																			// link
																			// in
																			// the
																			// JSP
																			// needs
																			// it.
			}
			return mv;
		}

		// We start modifiying user (that may then be automatically saved by
		// hibernate due to dirty checking.
		if ((SecurityContext.isUserHasPrivilege(Privilege.MANAGE_USERS))
				&& (!ObjectUtils.equals(newUserName, user.getUserName()))) {
			userService.changeUserName(user, newUserName);
		}

		user = userRepository.merge(user);

		return new ModelAndView("redirect:/user/" + user.getUserName());
	}

	@RequestMapping("/user_add")
	public String userAdd() {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			return "redirect:login";
		}

		return "user_add";
	}

	@RequestMapping("/registersubmit")
	public ModelAndView registerSubmit(
			@RequestParam("identifier") String userNameOrMail,
			@RequestParam(value = "password", required = false) String password,
			WebRequest request) {
		try {
			userService.registerUser(userNameOrMail,password);

		} catch (UserAlreadyExistsException uaee) {
			ModelAndView mv = new ModelAndView("register");

			if (uaee.getType() == IdentifierType.USERNAME) {

			} else { // defensive coding
				throw new RuntimeException("Bug - Unsupported type: "
						+ uaee.getType());
			}

			return mv;
		}

		return new ModelAndView("redirect:user_manage");
	}

}
