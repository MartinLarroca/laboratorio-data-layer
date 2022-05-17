package controllers;

import java.util.Arrays;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataEvaluation;
import entities.Evaluation;
import entities.Evaluator;
import entities.Initiative;
import utils.EvaluationType;

@Stateless
@LocalBean
public class EvaluationsController implements EvaluationsControllerRemote {

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public EvaluationsController() {

	}

	public DataEvaluation create(DataEvaluation dataEvaluation) {

		Evaluation evaluation = new Evaluation(dataEvaluation.getResult(), dataEvaluation.getEvaluationType());

		Initiative initiative = em.find(Initiative.class, evaluation.getInitiative().getId());

		Evaluator evaluator = em.find(Evaluator.class, evaluation.getEvaluator().getId());

		evaluation.setEvaluator(evaluator);

		evaluation.setInitiative(initiative);

		em.persist(initiative);

		return new DataEvaluation(evaluation);

	}

	public List<EvaluationType> getEvaluationTypes() {

		return Arrays.asList(EvaluationType.values());

	}

}
