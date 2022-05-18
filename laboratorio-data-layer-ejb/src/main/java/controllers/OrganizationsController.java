package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataInitiative;
import dataEntities.DataOrganization;
import entities.Initiative;
import entities.Organization;

@Stateless
@LocalBean
public class OrganizationsController implements OrganizationsControllerRemote {

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public OrganizationsController() {

	}

	public ArrayList<DataOrganization> findAll() {

		ArrayList<Organization> organizations = (ArrayList<Organization>) em
				.createQuery("from Organization", Organization.class).getResultList();

		ArrayList<DataOrganization> dataOrganizations = new ArrayList<DataOrganization>();

		for (int i = 0; i < organizations.size(); i++) {

			dataOrganizations.add(new DataOrganization(organizations.get(i)));

		}

		return dataOrganizations;
	}

	public DataOrganization create(DataOrganization dataOrganization) {

		Organization organization = new Organization(dataOrganization.getName(), dataOrganization.getEmail(),
				dataOrganization.getAddress(), dataOrganization.getTelephone(), dataOrganization.getClientId(),
				dataOrganization.getToken());

		em.persist(organization);

		return new DataOrganization(organization);

	}

	public DataOrganization update(DataOrganization dataOrganization) {

		Organization organization = em.find(Organization.class, dataOrganization.getId());

		organization.setName(dataOrganization.getName());
		organization.setEmail(dataOrganization.getEmail());
		organization.setAddress(dataOrganization.getAddress());
		organization.setTelephone(dataOrganization.getTelephone());
		organization.setClientId(dataOrganization.getClientId());
		organization.setToken(dataOrganization.getToken());

		em.persist(organization);

		return new DataOrganization(organization);
	}

	public ArrayList<DataInitiative> getInitiatives(Long id) {

		Organization organization = em.find(Organization.class, id);

		List<Initiative> initiatives = organization.getInitiatives();

		ArrayList<DataInitiative> dataInitiatives = new ArrayList<DataInitiative>();

		for (int i = 0; i < initiatives.size(); i++) {

			dataInitiatives.add(new DataInitiative(initiatives.get(i)));

		}

		return dataInitiatives;

	}

	public DataInitiative addInitiative(DataInitiative dataInitiative) {

		Initiative initiative = new Initiative(dataInitiative.getTitle(), dataInitiative.getProblem(),
				dataInitiative.getSolution(), dataInitiative.getBenefits(), dataInitiative.getStatus());

		Organization organization = em.find(Organization.class, dataInitiative.getDataOrganization().getId());

		initiative.setOrganization(organization);

		em.persist(initiative);

		return new DataInitiative(initiative);

	}

}
