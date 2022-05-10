package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Option implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String text;

	@ManyToOne
	@JoinColumn(name = "voteId", referencedColumnName = "id")
	private Vote vote;

	@ManyToOne
	@JoinColumn(name = "citizenid", referencedColumnName = "id")
	private Citizen citizen;

	public Option() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
