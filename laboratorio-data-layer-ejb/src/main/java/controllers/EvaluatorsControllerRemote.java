package controllers;

import java.util.ArrayList;

import javax.ejb.Remote;

import dataEntities.DataEvaluation;
import dataEntities.DataEvaluator;

@Remote
public interface EvaluatorsControllerRemote {

	public ArrayList<DataEvaluator> findAll();

	public ArrayList<DataEvaluation> getEvaluations(Long id);

}
