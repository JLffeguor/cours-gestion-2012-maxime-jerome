package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Carafage extends BaseEntity {

	private String type_carafage;

	public String getType_carafage() {
		return type_carafage;
	}

	public void setType_carafage(String type_carafage) {
		this.type_carafage = type_carafage;
	}
	
	
}
