package dataEntities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import entities.Initiative;
import utils.Status;

@XmlRootElement
public class DataInitiative implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String problem;

	private String solution;

	private String benefits;

	private Status status;

	private DataOrganization dataOrganization;

	public DataInitiative(Initiative initiative) {
		super();

		this.id = initiative.getId();
		this.title = initiative.getTitle();
		this.problem = initiative.getProblem();
		this.solution = initiative.getSolution();
		this.benefits = initiative.getBenefits();
		this.status = initiative.getStatus();

		this.dataOrganization = new DataOrganization(initiative.getOrganization());

	}

	public DataInitiative() {
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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public DataOrganization getDataOrganization() {
		return dataOrganization;
	}

	public void setDataOrganization(DataOrganization dataOrganization) {
		this.dataOrganization = dataOrganization;
	}

}
