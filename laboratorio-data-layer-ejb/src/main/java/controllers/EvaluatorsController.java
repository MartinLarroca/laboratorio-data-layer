package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataEvaluation;
import dataEntities.DataEvaluator;
import entities.Evaluation;
import entities.Evaluator;

@Stateless
@LocalBean
public class EvaluatorsController implements EvaluatorsControllerRemote {

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public EvaluatorsController() {

	}

	public ArrayList<DataEvaluator> findAll() {

		ArrayList<Evaluator> evaluators = (ArrayList<Evaluator>) em.createQuery("from Evaluation", Evaluator.class)
				.getResultList();

		ArrayList<DataEvaluator> dataEvaluators = new ArrayList<DataEvaluator>();

		for (int i = 0; i < evaluators.size(); i++) {

			dataEvaluators.add(new DataEvaluator(evaluators.get(i)));

		}

		return dataEvaluators;

	}

	public ArrayList<DataEvaluation> getEvaluations(Long id) {

		Evaluator evaluator = em.find(Evaluator.class, id);

		List<Evaluation> evaluations = evaluator.getEvaluations();

		ArrayList<DataEvaluation> dataEvaluations = new ArrayList<DataEvaluation>();

		for (int i = 0; i < evaluations.size(); i++) {

			dataEvaluations.add(new DataEvaluation(evaluations.get(i)));

		}

		return dataEvaluations;

	}

}
