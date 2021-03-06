package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Phase implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String description;

	private Boolean current;

	private String surveyLink;

	@ManyToOne
	@JoinColumn(name = "participativeProcessId", referencedColumnName = "id")
	private ParticipativeProcess participativeProcess;

	private static final long serialVersionUID = 1L;

	public Phase() {
		super();
	}

	public Phase(String title, String description, Boolean current, String surveyLink) {
		super();

		this.title = title;
		this.description = description;
		this.current = current;
		this.surveyLink = surveyLink;

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

	public ParticipativeProcess getParticipativeProcess() {
		return participativeProcess;
	}

	public void setParticipativeProcess(ParticipativeProcess participativeProcess) {
		this.participativeProcess = participativeProcess;
	}

	public String getSurveyLink() {
		return surveyLink;
	}

	public void setSurveyLink(String surveyLink) {
		this.surveyLink = surveyLink;
	}

}
