package cn.tyshan.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TARGET")
@XmlRootElement
public class Target extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7078333948651251363L;

	@XmlElement(name = "target")
	private String name;

	@XmlElement(name = "attr_list")
	@ElementCollection
	private List<String> attrs = new ArrayList<String>();

	public Target() {
	}

	public Target(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<String> attrs) {
		this.attrs = attrs;
	}

	public void addAttr(String attr) {
		this.attrs.add(attr);
	}
}
