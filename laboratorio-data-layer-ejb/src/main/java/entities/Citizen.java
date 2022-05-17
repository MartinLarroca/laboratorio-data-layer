package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity

public class Citizen extends ApplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "citizens")
	List<Badge> badges;

	public Citizen() {
		super();
	}

	public Citizen(String gubUyToken, String tokens, String dni, String email, String names, String surnames,
			String birthDate, String nationality, String gender, String password) {
		super(gubUyToken, tokens, dni, email, names, surnames, birthDate, nationality, gender, password);
	}

	public List<Badge> getBadges() {
		return badges;
	}

}
