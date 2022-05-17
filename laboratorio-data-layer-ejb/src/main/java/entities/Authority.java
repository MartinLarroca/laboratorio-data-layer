package entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity

public class Authority extends ApplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;

	public Authority() {
		super();
	}

	public Authority(String gubUyToken, String tokens, String dni, String email, String names, String surnames,
			String birthDate, String nationality, String gender, String password) {
		super(gubUyToken, tokens, dni, email, names, surnames, birthDate, nationality, gender, password);
	}

}
