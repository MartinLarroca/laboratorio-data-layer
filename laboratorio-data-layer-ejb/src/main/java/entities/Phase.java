package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Phase implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String description;

	private Boolean current;

	@ManyToOne
	@JoinColumn(name = "participativeProcessId", referencedColumnName = "id")
	private ParticipativeProcess participativeProcess;

	@OneToMany(mappedBy = "phase")
	private List<Vote> vote;

	private static final long serialVersionUID = 1L;

	public Phase() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCurrent() {
		return current;
	}

	public void setCurrent(Boolean current) {
		this.current = current;
	}

}
