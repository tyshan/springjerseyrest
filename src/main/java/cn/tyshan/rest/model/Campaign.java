package cn.tyshan.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CAMPAIGN")
@XmlRootElement
public class Campaign extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -388173075328034218L;

	@XmlElement(name = "compaign_name")
	private String name;

	private BigDecimal price;

	@XmlElement(name = "target_list")
	@OneToMany()
	private List<Target> targets = new ArrayList<Target>();

	public Campaign() {
	}

	public Campaign(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public void addTarget(Target target) {
		this.targets.add(target);
	}
}
