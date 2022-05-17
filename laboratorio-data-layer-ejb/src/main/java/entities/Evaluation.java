package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import utils.EvaluationType;

@Entity

public class Evaluation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String result;

	private EvaluationType evaluationType;

	public Evaluation(String result, EvaluationType evaluationType) {
		super();

		this.result = result;
		this.evaluationType = evaluationType;
	}

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

	public EvaluationType getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(EvaluationType evaluationType) {
		this.evaluationType = evaluationType;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	public Initiative getInitiative() {
		return initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

}
