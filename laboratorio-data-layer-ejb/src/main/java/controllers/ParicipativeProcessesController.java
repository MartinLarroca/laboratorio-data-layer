package controllers;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataParticipativeProcess;
import dataEntities.DataPhase;
import entities.Functionary;
import entities.ParticipativeProcess;
import entities.Phase;

@Stateless
@LocalBean
public class ParicipativeProcessesController implements ParicipativeProcessesControllerRemote {

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public ParicipativeProcessesController() {

	}

	public ArrayList<DataParticipativeProcess> findAll() {

		ArrayList<ParticipativeProcess> praticipativeProcesses = (ArrayList<ParticipativeProcess>) em
				.createQuery("from ParticipativeProcess", ParticipativeProcess.class).getResultList();

		ArrayList<DataParticipativeProcess> dataParticipativeProcesses = new ArrayList<DataParticipativeProcess>();

		for (int i = 0; i < praticipativeProcesses.size(); i++) {

			dataParticipativeProcesses.add(new DataParticipativeProcess(praticipativeProcesses.get(i)));

		}

		return dataParticipativeProcesses;

	}

	public DataParticipativeProcess findOne(Long id) {

		return new DataParticipativeProcess(em.find(ParticipativeProcess.class, id));

	}

	public DataParticipativeProcess create(DataParticipativeProcess dataParticipativeProcess) {

		Functionary functionary = em.find(Functionary.class, dataParticipativeProcess.getFunctionary().getId());

		ParticipativeProcess participativeProcess = new ParticipativeProcess(dataParticipativeProcess.getName(),
				dataParticipativeProcess.getDescription(), dataParticipativeProcess.getGender(),
				dataParticipativeProcess.getMinAge(), dataParticipativeProcess.getMaxAge(),
				dataParticipativeProcess.getForUruguayans(), dataParticipativeProcess.getForForeigns());

		participativeProcess.setFunctionary(functionary);

		ArrayList<DataPhase> phases = (ArrayList<DataPhase>) dataParticipativeProcess.getPhases();

		for (int i = 0; i < phases.size(); i++) {

			String phaseTitle = phases.get(i).getTitle();
			String phaseDescription = phases.get(i).getDescription();
			String surveyLink = phases.get(i).getSurveyLink();
			Boolean phaseCurrent = phases.get(i).getCurrent();

			Phase phase = new Phase(phaseTitle, phaseDescription, phaseCurrent, surveyLink);

			phase.setParticipativeProcess(participativeProcess);
		}

		return new DataParticipativeProcess(participativeProcess);

	}

}
