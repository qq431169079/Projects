package dataStorageLayer;

import applicationLayer.BranchUser;
import applicationLayer.BranchUserImpl;
import applicationLayer.Privilege;
import uk.ac.gla.dcs.psd3.ay2009.project.CentralLibClient;
import uk.ac.gla.dcs.psd3.ay2009.project.CentralLibClientSQLImpl;
import uk.ac.gla.dcs.psd3.ay2009.project.model.User;
import java.util.*;


public class UserStorageFacade {
	private static UserStorageFacade instance = null;
	private CentralLibClient libClient = null;
	
	// *ToDo* Change this to the config file
	private static String dbPropertiesFN = "config/db.properties";
	
	private UserStorageFacade() {
		libClient = new CentralLibClientSQLImpl(dbPropertiesFN);
	}
	
	public static UserStorageFacade getInstance() {
		if (instance == null)
			instance = new UserStorageFacade();
		
		return instance;
	}
	
	private BranchUser userToBranchUser(User u) throws Exception {
		BranchUser bu = new BranchUserImpl();
		bu.setFirstName(u.getForename());
		bu.setLastName(u.getSurname());
		bu.setId(u.getID());
		if (u.getIsStaff() == null)
			bu.setIsStaff(false);
		else
			bu.setIsStaff(true);
		
		BranchStorageInterface bsi = BranchStorageInterface.getInstance();
		try {
			bu.setPrivilege(bsi.getUserPrivilege(u.getID()));
		} catch (Exception e) {
			bu.setPrivilege(Privilege.BORROWER);
		}
	
		return bu;
	}
	
	public BranchUser getUserById(int id) throws Exception {
		User u = libClient.getUserByID(id);
		return userToBranchUser(u);
	}
	
	public List<BranchUser> getUsersByName(String firstname, String lastname) throws Exception {
		List<User> ul = libClient.findUsers(String.format("Surname='%s' AND Forename='%s'", firstname, lastname));
		List<BranchUser> bul = new ArrayList<BranchUser>();
	
		for(User u : ul) {
			bul.add(userToBranchUser(u));
		}
		
		return bul;
	}
	
	public void setUserPrivilege(int id, Privilege p) throws Exception {
		BranchStorageInterface bsi = BranchStorageInterface.getInstance();
		bsi.setUserPrivilege(id, p);
	}
	
	public BranchUser login(int id, String password) throws Exception {
		User u;
		u = libClient.getUserByID(id);
		if (u.getPassword().compareToIgnoreCase(password) != 0) {
			throw new Exception("Invalid password");
		}
		return userToBranchUser(u);
	}
}
