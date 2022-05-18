package controllers;

import java.util.ArrayList;

import javax.ejb.Remote;

import dataEntities.DataApplicationUser;
import dataEntities.DataBadge;

@Remote
public interface UsersControllerRemote {

	public ArrayList<DataApplicationUser> findAll();

	public DataApplicationUser findOne(Long id);

	public DataApplicationUser create(DataApplicationUser dataApplicationUser);

	public ArrayList<DataBadge> getBadges(Long id);
}
