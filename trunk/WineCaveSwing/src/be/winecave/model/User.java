package be.winecave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class User extends BaseEntity implements Cloneable, Serializable{

    @Column(length = 50)
    @Size(max=50, message="votre prénom ne peut contenir que 50 caractères maximum")
    private String firstName;// in case of a special user we use the firstname to display the name of the association.
    
    @Column(length = 50)
    @Size(max=50, message="votre nom ne peut contenir que 50 caractères maximum")
    private String lastName;
    
    @Column(length = 100)
    @Size(min = 4, message = "votre mot de passe doit contenir au moins 4 caractères")
    private String password;
    
	/////////////getters and setters/////////////////
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public String getFullName() {
        String lnChar = (lastName == null || lastName.isEmpty()) ? "" : " "
                + StringUtils.capitalize(lastName);
        String firstAndLastName = (firstName == null || firstName.isEmpty()) ? "" : " "
                + StringUtils.capitalize(firstName)
                + lnChar;
        
        if (!StringUtils.isBlank(firstAndLastName)  ) {
            return firstAndLastName;
        } else {
            return this.getFirstName();
        }
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
