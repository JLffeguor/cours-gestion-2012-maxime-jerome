
public class User {
	
	private String matricule;
	private String adress;
	private int childrenNumber;
	private int phone;
	
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getChildrenNumber() {
		return childrenNumber;
	}
	public void setChildrenNumber(int childrenNumber) {
		this.childrenNumber = childrenNumber;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [matricule=" + matricule + ", adress=" + adress
				+ ", childrenNumber=" + childrenNumber + ", phone=" + phone
				+ "]";
	}	
}
