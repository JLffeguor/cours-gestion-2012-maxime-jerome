package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.model.Classement;
import be.winecave.repository.ClassementRepository;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationClassement extends PostInstallData<Classement> {

	@Autowired
	ClassementRepository classementRepository;

	@Override
	@PostConstruct
	protected void initalization() {
		XML_FILE_NAME = "classement.xml";
		ELEMENTS_NAME = "classement";
		ROOT_ELEMENTS_NAME = "liste_classement";
		xmlDocument = XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
		loadDataFromXml();
	}
	
	@Override
	protected Classement ParseXmlElement(Element element) {
		Classement result = new Classement();
		result.setNom(element.getAttributeValue("nom").toLowerCase());
		return result;
	}

	@Override
	protected void persistData(Classement data) {
		classementRepository.persist(data);		
	}

	@Override
	protected Element buildElement(Element element, Classement data) {
		element.setAttribute("nom", data.getNom());
		return element;
	}

}
