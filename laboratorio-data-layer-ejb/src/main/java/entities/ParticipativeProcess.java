
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

	private Integer minAge;

	private Integer maxAge;

	private Boolean forUruguayans;

	private Boolean forForeigns;

	public ParticipativeProcess(String name, String description, Gender gender, Integer minAge, Integer maxAge,
			Boolean forUruguayans, Boolean forForeigns) {
		super();

		this.name = name;
		this.description = description;
		this.gender = gender;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.forUruguayans = forUruguayans;
		this.forForeigns = forForeigns;

	}

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

	public Functionary getFunctionary() {
		return functionary;
	}

	public void setFunctionary(Functionary functionary) {
		this.functionary = functionary;
	}

	public List<Phase> getPhase() {
		return phase;
	}

	public void setPhase(List<Phase> phase) {
		this.phase = phase;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

}
