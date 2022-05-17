package controllers;

import java.util.ArrayList;

import javax.ejb.Remote;

import dataEntities.DataParticipativeProcess;

@Remote
public interface ParicipativeProcessesControllerRemote {

	public ArrayList<DataParticipativeProcess> findAll();

	public DataParticipativeProcess findOne(Long id);

	public DataParticipativeProcess create(DataParticipativeProcess dataParticipativeProcess);

}
