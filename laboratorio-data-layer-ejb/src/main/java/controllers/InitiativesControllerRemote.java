package controllers;

import java.util.ArrayList;

import javax.ejb.Remote;

import dataEntities.DataEvaluation;
import dataEntities.DataInitiative;

@Remote
public interface InitiativesControllerRemote {

	public ArrayList<DataInitiative> findAll();

	public DataInitiative findOne(Long id);

	public DataInitiative update(DataInitiative dataInitiative);

	public ArrayList<DataEvaluation> getEvaluations(Long id);

}
