package controllers;

import java.util.ArrayList;

import javax.ejb.Remote;

import dataEntities.DataInitiative;
import dataEntities.DataOrganization;

@Remote
public interface OrganizationsControllerRemote {

	public ArrayList<DataOrganization> findAll();

	public DataOrganization create(DataOrganization dataOrganization);

	public DataOrganization update(DataOrganization dataOrganization);

	public ArrayList<DataInitiative> getInitiatives(Long id);

	public DataInitiative addInitiative(DataInitiative dataInitiative);

}
