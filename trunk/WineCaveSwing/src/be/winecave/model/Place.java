package be.winecave.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"emplacement_id", "x" , "y"}))
public class Place extends BaseEntity {
	private Integer x;
	private Integer y;
	
	@ManyToOne
	private Emplacement emplacement;
	
	public Place() {}
	public Place(Integer x, Integer y, Emplacement emplacement) {
		super();
		this.x = x;
		this.y = y;
		this.emplacement = emplacement;
	}
	
	public Emplacement getEmplacement() {
		return emplacement;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
}
