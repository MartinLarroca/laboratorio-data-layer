package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity

public class Functionary extends ApplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "functionary")
	private List<ParticipativeProcess> participativeProcesses;

	public Functionary() {
		super();
	}

}
