
package be.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import be.security.Privilege;


@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class User extends BaseEntity implements Cloneable, Serializable{
   
    public enum Role {
        ADMIN(100l,"Administrator of all things"),
        PROJECT_ADMIN(101l,"project-Administrator"),
        PROJECT_MANAGER(102l,"project Administrator for current project"),
        USER(103l,"User");

        String name;
        
        private Role() {
        }

        private Role(long id, String aName) {
            this.name = aName;
        }

        public String getName() {
            return name;
        }

    }
    
    @Column(unique = true, nullable=false)
    @Size(max = 15, message = "votre pseudonyme ne peut contenir que 15 caractères maximum")
    @NotBlank(message="entrer votre pseudonyme")
    @Pattern(message ="ne peut contenir que des caractère alphanumériques, sans accents. Les 2 caractères \"-\" et \"_\" sont autorisés, mais pas les espaces.", regexp="[A-Za-z0-9_-]{2,256}")
    private String userName; 
    
    @Column(length = 100)
    //FIXME waarom ? --28/11/12
    //@NotBlank(message="entrer votre mot de passe")
    @Size(min = 4, message = "votre mot de passe doit contenir au moins 4 caractères")
    private String password;

    private Role role = Role.USER;
    
    @ElementCollection(targetClass=Privilege.class, fetch=FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @JoinTable(name="users_privileges")
    @Column(name="privilege", nullable=false,length = 50)
    private Set<Privilege> privileges = new HashSet<Privilege>();

    public void setRole(Role roleParam) {
        this.role = roleParam;
    }

    public boolean hasAdminPrivileges() {
        return role == Role.ADMIN;
    }

    public boolean hasProjectAdminPrivileges() {
        return role == Role.ADMIN
                || role == Role.PROJECT_ADMIN;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password != null ? password.toLowerCase() : password;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

	public Role getRole() {
		return role;
	}
}
