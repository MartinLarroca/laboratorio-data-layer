package dataEntities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import entities.Organization;

@XmlRootElement
public class DataOrganization implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String email;
	private String address;
	private String telephone;

	private String clientId;
	private String token;

	private List<DataInitiative> dataInitiatives;

	public DataOrganization(Organization organization) {
		super();

		this.id = organization.getId();
		this.name = organization.getName();
		this.email = organization.getEmail();
		this.address = organization.getAddress();
		this.telephone = organization.getTelephone();
		this.clientId = organization.getClientId();
		this.token = organization.getToken();

	}

	public DataOrganization() {
		super();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<DataInitiative> getDataInitiatives() {
		return dataInitiatives;
	}

	public void setDataInitiatives(List<DataInitiative> dataInitiatives) {
		this.dataInitiatives = dataInitiatives;
	}

}
