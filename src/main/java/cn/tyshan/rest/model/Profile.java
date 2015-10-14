package cn.tyshan.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PROFILE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8221564594252968615L;

	@XmlElement(name = "attr_A")
	private String attrA;
	@XmlElement(name = "attr_B")
	private String attrB;
	@XmlElement(name = "attr_C")
	private String attrC;

	public Profile() {
	}

	public Profile(String attrA, String attrB, String attrC) {
		this.attrA = attrA;
		this.attrB = attrB;
		this.attrC = attrC;
	}

	public String getAttrA() {
		return attrA;
	}

	public void setAttrA(String attrA) {
		this.attrA = attrA;
	}

	public String getAttrB() {
		return attrB;
	}

	public void setAttrB(String attrB) {
		this.attrB = attrB;
	}

	public String getAttrC() {
		return attrC;
	}

	public void setAttrC(String attrC) {
		this.attrC = attrC;
	}

	@Override
	public String toString() {
		return "Profile [attrA=" + attrA + ", attrB=" + attrB + ", attrC=" + attrC + "]";
	}

}
