package dataEntities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import entities.Badge;

@XmlRootElement
public class DataBadge implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String description;

	public DataBadge() {
		super();
	}

	public DataBadge(Badge badge) {
		super();

		this.id = badge.getId();
		this.name = badge.getName();
		this.description = badge.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
