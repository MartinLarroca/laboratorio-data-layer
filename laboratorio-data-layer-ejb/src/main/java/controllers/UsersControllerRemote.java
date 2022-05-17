package controllers;

import java.util.ArrayList;

import javax.ejb.Remote;

import dataEntities.DataApplicationUser;

@Remote
public interface UsersControllerRemote {

	public ArrayList<DataApplicationUser> findAll();

	public DataApplicationUser findOne(Long id);

	public DataApplicationUser create(DataApplicationUser dataApplicationUser);
}
