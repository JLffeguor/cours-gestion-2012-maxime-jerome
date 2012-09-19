package model;

public class User extends BaseEntity{
	
	private String matricule;
	private String adress;
	private int childrenCount;
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
		return childrenCount;
	}
	public void setChildrenNumber(int childrenNumber) {
		this.childrenCount = childrenNumber;
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
				+ ", childrenNumber=" + childrenCount + ", phone=" + phone
				+ "]";
	}
	@Override
	public String toCsv(){
		return adress+","
				+childrenCount+","
				+matricule+","
				+phone;
	}
	@Override
	public String getCsvFieldsName() {
		return "adress,childrenCount,matricule,phone";
	}
}
