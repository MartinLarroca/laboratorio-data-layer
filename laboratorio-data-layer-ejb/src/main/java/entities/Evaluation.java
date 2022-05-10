package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Evaluation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String result;

	@ManyToOne
	@JoinColumn(name = "evaluatorId", referencedColumnName = "id")
	private Evaluator evaluator;

	@ManyToOne
	@JoinColumn(name = "initiativeId", referencedColumnName = "id")
	private Initiative initiative;

	public Evaluation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
