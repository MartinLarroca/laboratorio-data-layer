package dataEntities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import entities.Evaluator;

@XmlRootElement
public class DataEvaluator implements Serializable {

	private static final long serialVersionUID = 1L;

	public DataEvaluator() {

		super();
	}

	public DataEvaluator(Evaluator evaluator) {
		super();

		this.id = evaluator.getId();
		this.name = evaluator.getName();

	}

	private Long id;

	private String name;

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

}
