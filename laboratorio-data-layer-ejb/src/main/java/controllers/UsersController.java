package controllers;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dataEntities.DataApplicationUser;
import dataEntities.DataBadge;
import entities.Administrator;
import entities.ApplicationUser;
import entities.Authority;
import entities.Badge;
import entities.Citizen;
import entities.Functionary;

@Stateless
@LocalBean
public class UsersController implements UsersControllerRemote {

	public UsersController() {

	}

	@PersistenceContext(name = "PostgresDS")
	private EntityManager em;

	public ArrayList<DataApplicationUser> findAll() {

		ArrayList<ApplicationUser> users = (ArrayList<ApplicationUser>) em
				.createQuery("from ApplicationUser", ApplicationUser.class).getResultList();

		ArrayList<DataApplicationUser> dataUsers = new ArrayList<DataApplicationUser>();

		for (int i = 0; i < users.size(); i++) {

			dataUsers.add(new DataApplicationUser(users.get(i)));

		}

		return dataUsers;

	};

	public DataApplicationUser findOne(Long id) {

		ApplicationUser user = em.find(ApplicationUser.class, id);

		return new DataApplicationUser(user);

	};

	public DataApplicationUser create(DataApplicationUser dataApplicationUser) {

		switch (dataApplicationUser.getUserType()) {

		case Authority:
			Authority authority = new Authority(dataApplicationUser.getGubUyToken(), dataApplicationUser.getTokens(),
					dataApplicationUser.getDni(), dataApplicationUser.getEmail(), dataApplicationUser.getNames(),
					dataApplicationUser.getSurnames(), dataApplicationUser.getBirthDate(),
					dataApplicationUser.getNationality(), dataApplicationUser.getGender(),
					dataApplicationUser.getPassword());

			em.persist(authority);

			return new DataApplicationUser(authority);

		case Administrator:
			Administrator administrator = new Administrator(dataApplicationUser.getGubUyToken(),
					dataApplicationUser.getTokens(), dataApplicationUser.getDni(), dataApplicationUser.getEmail(),
					dataApplicationUser.getNames(), dataApplicationUser.getSurnames(),
					dataApplicationUser.getBirthDate(), dataApplicationUser.getNationality(),
					dataApplicationUser.getGender(), dataApplicationUser.getPassword());

			em.persist(administrator);

			return new DataApplicationUser(administrator);

		case Functionary:
			Functionary functionary = new Functionary(dataApplicationUser.getGubUyToken(),
					dataApplicationUser.getTokens(), dataApplicationUser.getDni(), dataApplicationUser.getEmail(),
					dataApplicationUser.getNames(), dataApplicationUser.getSurnames(),
					dataApplicationUser.getBirthDate(), dataApplicationUser.getNationality(),
					dataApplicationUser.getGender(), dataApplicationUser.getPassword());

			em.persist(functionary);

			return new DataApplicationUser(functionary);

		case Citizen:
			Citizen citizen = new Citizen(dataApplicationUser.getGubUyToken(), dataApplicationUser.getTokens(),
					dataApplicationUser.getDni(), dataApplicationUser.getEmail(), dataApplicationUser.getNames(),
					dataApplicationUser.getSurnames(), dataApplicationUser.getBirthDate(),
					dataApplicationUser.getNationality(), dataApplicationUser.getGender(),
					dataApplicationUser.getPassword());

			em.persist(citizen);

			return new DataApplicationUser(citizen);
		}

		return null;

	}

	public ArrayList<DataBadge> getBadges(Long id) {

		Citizen citizen = em.find(Citizen.class, id);

		ArrayList<Badge> badges = (ArrayList<Badge>) citizen.getBadges();

		ArrayList<DataBadge> dataBadges = new ArrayList<DataBadge>();

		for (int i = 0; i < badges.size(); i++) {

			dataBadges.add(new DataBadge(badges.get(i)));

		}

		return dataBadges;

	}

}
