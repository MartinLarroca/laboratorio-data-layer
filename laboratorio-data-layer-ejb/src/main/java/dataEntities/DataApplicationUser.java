package dataEntities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import entities.Administrator;
import entities.ApplicationUser;
import entities.Authority;
import entities.Citizen;
import entities.Functionary;
import utils.UserType;

@XmlRootElement
public class DataApplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String gubUyToken;

	private String tokens;

	private String dni;
	private String email;

	private String names;
	private String surnames;

	private String birthDate;
	private String nationality;
	private String gender;

	private String password;

	private UserType userType;

	public DataApplicationUser() {
		super();
	}

	public DataApplicationUser(ApplicationUser user) {

		super();

		this.id = user.getId();
		this.gubUyToken = user.getGubUyToken();
		this.tokens = user.getTokens();
		this.dni = user.getDni();
		this.email = user.getEmail();
		this.names = user.getNames();
		this.surnames = user.getSurnames();
		this.birthDate = user.getBirthDate();
		this.nationality = user.getNationality();
		this.gender = user.getGender();

		this.password = null;

		if (user instanceof Administrator) {
			this.setUserType(UserType.Administrator);
		} else if (user instanceof Authority) {
			this.setUserType(UserType.Authority);
		} else if (user instanceof Functionary) {
			this.setUserType(UserType.Functionary);
		} else if (user instanceof Citizen) {
			this.setUserType(UserType.Citizen);
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGubUyToken() {
		return gubUyToken;
	}

	public void setGubUyToken(String gubUyToken) {
		this.gubUyToken = gubUyToken;
	}

	public String getTokens() {
		return tokens;
	}

	public void setTokens(String tokens) {
		this.tokens = tokens;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
