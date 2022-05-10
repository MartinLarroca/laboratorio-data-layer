package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import utils.Gender;

@Entity

public class ParticipativeProcess implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String description;

	private Gender gender;

	private Integer min_age;

	private Integer max_age;

	private Boolean forUruguayans;

	private Boolean forForeigns;

	@ManyToOne
	@JoinColumn(name = "functionaryId", referencedColumnName = "id")
	private Functionary functionary;

	@OneToMany(mappedBy = "participativeProcess")
	private List<Phase> phase;

	public ParticipativeProcess() {
		super();
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getMin_age() {
		return min_age;
	}

	public void setMin_age(Integer min_age) {
		this.min_age = min_age;
	}

	public Integer getMax_age() {
		return max_age;
	}

	public void setMax_age(Integer max_age) {
		this.max_age = max_age;
	}

	public Boolean getForUruguayans() {
		return forUruguayans;
	}

	public void setForUruguayans(Boolean forUruguayans) {
		this.forUruguayans = forUruguayans;
	}

	public Boolean getForForeigns() {
		return forForeigns;
	}

	public void setForForeigns(Boolean forForeigns) {
		this.forForeigns = forForeigns;
	}

}
