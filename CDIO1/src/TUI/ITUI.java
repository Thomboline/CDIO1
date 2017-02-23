package TUI;

import dal.IUserDAO;
import dal.IUserDAO.DALException;

public interface ITUI 
{

	void startOperation(IUserDAO userDAO);

}
