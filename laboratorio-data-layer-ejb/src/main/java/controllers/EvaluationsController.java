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

		Initiative initiative = em.find(Initiative.class, dataEvaluation.getDataInitiative().getId());

		Evaluator evaluator = em.find(Evaluator.class, dataEvaluation.getDataEvaluator().getId());

		evaluation.setEvaluator(evaluator);

		evaluation.setInitiative(initiative);

		em.persist(evaluation);

		return new DataEvaluation(evaluation);

	}

	public DataEvaluation evaluate(DataEvaluation dataEvaluation) {

		Evaluation evaluation = em.find(Evaluation.class, dataEvaluation.getId());

		evaluation.setResult(dataEvaluation.getResult());

		em.persist(evaluation);

		return new DataEvaluation(evaluation);

	}

	public List<EvaluationType> getEvaluationTypes() {

		return Arrays.asList(EvaluationType.values());

	}

}
