package dataEntities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataPhase implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String description;

	private Boolean current;

	private String surveyLink;

	public DataPhase() {
		super();
	}

	public DataPhase(String title, String description, Boolean current, String surveyLink) {
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

	public String getSurveyLink() {
		return surveyLink;
	}

	public void setSurveyLink(String surveyLink) {
		this.surveyLink = surveyLink;
	}

}
