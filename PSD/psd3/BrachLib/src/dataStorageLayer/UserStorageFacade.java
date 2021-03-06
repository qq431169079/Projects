package dataStorageLayer;

import applicationLayer.BranchUser;
import applicationLayer.BranchUserImpl;
import uk.ac.gla.dcs.psd3.ay2009.project.CentralLibClient;
import uk.ac.gla.dcs.psd3.ay2009.project.CentralLibClientImpl;
import uk.ac.gla.dcs.psd3.ay2009.project.model.User;
import java.util.*;


public class UserStorageFacade {
	private static UserStorageFacade instance = null;
	private CentralLibClient libClient = null;
	
	// *ToDo* Change this to the config file
	private static String dbPropertiesFN = "config/test/db.properties";
	
	private UserStorageFacade() {
		libClient = new CentralLibClientImpl(dbPropertiesFN);
	}
	
	public static UserStorageFacade getInstance() {
		if (instance == null)
			instance = new UserStorageFacade();
		
		return instance;
	}
	
	public BranchUser getUserById(int id) {
		User u = libClient.getUserByID(id);
		//u.get
		
		BranchUser bu = new BranchUserImpl();
		bu.setFirstName(u.getForename());
		bu.setLastName(u.getSurname());
		bu.setId(u.getID());
		bu.setIsStaff(u.getIsStaff());
		// *todo* get the privilege from the SQL database
		
		return bu;
	}
	
	public BranchUser getUsersByName(String firstname, String lastname) {
		List<User> ul = libClient.findUsers(String.format("Surname='%s' AND Forename='%s'", firstname, lastname));
		 
	}
}
