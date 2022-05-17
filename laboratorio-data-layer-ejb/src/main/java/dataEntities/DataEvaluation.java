package dataEntities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import entities.Evaluation;
import utils.EvaluationType;

@XmlRootElement
public class DataEvaluation implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String result;

	private EvaluationType evaluationType;

	private DataEvaluator dataEvaluator;

	private DataInitiative dataInitiative;

	public DataEvaluation() {
		super();
	}

	public DataEvaluation(Evaluation evaluation) {
		super();

		this.id = evaluation.getId();
		this.result = evaluation.getResult();
		this.evaluationType = evaluation.getEvaluationType();
		this.dataEvaluator = new DataEvaluator(evaluation.getEvaluator());
		this.dataInitiative = new DataInitiative(evaluation.getInitiative());

	}

	public DataEvaluation(String result, EvaluationType evaluationType, Long evaluatorId, Long initiativeId) {

		super();

		this.result = result;
		this.evaluationType = evaluationType;
		this.dataEvaluator = new DataEvaluator();
		this.dataInitiative = new DataInitiative();

		this.dataEvaluator.setId(evaluatorId);
		this.dataInitiative.setId(initiativeId);

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

	public DataEvaluator getDataEvaluator() {
		return dataEvaluator;
	}

	public void setDataEvaluator(DataEvaluator dataEvaluator) {
		this.dataEvaluator = dataEvaluator;
	}

	public DataInitiative getDataInitiative() {
		return dataInitiative;
	}

	public void setDataInitiative(DataInitiative dataInitiative) {
		this.dataInitiative = dataInitiative;
	}

}
