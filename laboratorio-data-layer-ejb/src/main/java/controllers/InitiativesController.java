package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataEvaluation;
import dataEntities.DataInitiative;
import entities.Evaluation;
import entities.Initiative;
import entities.Organization;

@Stateless
@LocalBean
public class InitiativesController implements InitiativesControllerRemote {

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public InitiativesController() {

	}

	public ArrayList<DataInitiative> findAll() {

		ArrayList<Initiative> initiatives = (ArrayList<Initiative>) em.createQuery("from Initiative", Initiative.class)
				.getResultList();

		ArrayList<DataInitiative> dataInitiatives = new ArrayList<DataInitiative>();

		for (int i = 0; i < initiatives.size(); i++) {

			dataInitiatives.add(new DataInitiative(initiatives.get(i)));

		}

		return dataInitiatives;

	}

	public DataInitiative findOne(Long id) {

		return new DataInitiative(em.find(Initiative.class, id));

	}

	public DataInitiative create(DataInitiative dataInitiative) {

		Initiative initiative = new Initiative(dataInitiative.getTitle(), dataInitiative.getProblem(),
				dataInitiative.getSolution(), dataInitiative.getBenefits(), dataInitiative.getStatus());

		Organization organization = em.find(Organization.class, dataInitiative.getDataOrganization().getId());

		initiative.setOrganization(organization);

		em.persist(initiative);

		return new DataInitiative(initiative);

	}

	public DataInitiative update(DataInitiative dataInitiative) {

		Initiative initiative = em.find(Initiative.class, dataInitiative.getId());

		initiative.setTitle(dataInitiative.getTitle());
		initiative.setProblem(dataInitiative.getProblem());
		initiative.setSolution(dataInitiative.getSolution());
		initiative.setBenefits(dataInitiative.getBenefits());
		initiative.setStatus(dataInitiative.getStatus());

		Organization organization = em.find(Organization.class, dataInitiative.getDataOrganization().getId());

		initiative.setOrganization(organization);

		em.persist(initiative);

		return new DataInitiative(initiative);

	}

	public ArrayList<DataEvaluation> getEvaluations(Long id) {

		Initiative initiative = em.find(Initiative.class, id);

		List<Evaluation> evaluations = initiative.getEvaluations();

		ArrayList<DataEvaluation> dataEvaluations = new ArrayList<DataEvaluation>();

		for (int i = 0; i < evaluations.size(); i++) {

			dataEvaluations.add(new DataEvaluation(evaluations.get(i)));

		}

		return dataEvaluations;

	}

}
