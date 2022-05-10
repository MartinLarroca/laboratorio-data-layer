package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity

public class Citizen extends ApplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "citizens")
	List<Badge> badges;

	@OneToMany(mappedBy = "citizen")
	private List<Option> options;

	public Citizen() {
		super();
	}

}
