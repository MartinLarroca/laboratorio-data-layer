package controllers;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataEvaluator;
import entities.Evaluator;

@Stateless
@LocalBean
public class EvaluatorsController implements EvaluatorsControllerRemote {

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public EvaluatorsController() {

	}

	public ArrayList<DataEvaluator> findAll() {

		ArrayList<Evaluator> evaluators = (ArrayList<Evaluator>) em.createQuery("from Evaluator", Evaluator.class)
				.getResultList();

		ArrayList<DataEvaluator> dataEvaluators = new ArrayList<DataEvaluator>();

		for (int i = 0; i < evaluators.size(); i++) {

			dataEvaluators.add(new DataEvaluator(evaluators.get(i)));

		}

		return dataEvaluators;

	}

}
