package controllers;

import java.util.List;

import javax.ejb.Remote;

import dataEntities.DataEvaluation;
import utils.EvaluationType;

@Remote
public interface EvaluationsControllerRemote {

	public DataEvaluation create(DataEvaluation dataEvaluation);

	public List<EvaluationType> getEvaluationTypes();

	public DataEvaluation evaluate(DataEvaluation dataEvaluation);

}
