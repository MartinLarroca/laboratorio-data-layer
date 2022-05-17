package dataEntities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import entities.ParticipativeProcess;
import utils.Gender;

@XmlRootElement
public class DataParticipativeProcess implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String description;

	private Gender gender;

	private Integer minAge;

	private Integer maxAge;

	private Boolean forUruguayans;

	private Boolean forForeigns;

	private DataApplicationUser functionary;

	private List<DataPhase> phases;

	public DataParticipativeProcess() {
		super();
	}

	public DataParticipativeProcess(ParticipativeProcess participativeProcess) {
		super();

		this.id = participativeProcess.getId();
		this.name = participativeProcess.getName();
		this.description = participativeProcess.getDescription();
		this.gender = participativeProcess.getGender();
		this.minAge = participativeProcess.getMinAge();
		this.maxAge = participativeProcess.getMaxAge();
		this.forUruguayans = participativeProcess.getForUruguayans();
		this.forForeigns = participativeProcess.getForForeigns();

		this.functionary = new DataApplicationUser(participativeProcess.getFunctionary());

		this.phases = null;

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

	public DataApplicationUser getFunctionary() {
		return functionary;
	}

	public void setFunctionary(DataApplicationUser functionary) {
		this.functionary = functionary;
	}

	public List<DataPhase> getPhases() {
		return phases;
	}

	public void setPhases(List<DataPhase> phases) {
		this.phases = phases;
	}

}
