package tui;

<<<<<<< HEAD

public interface ITUI
=======
import dal.IUserDAO;

public interface ITUI 
>>>>>>> origin/Stuart
{

	void startOperation(IUserDAO userDAO);

    void createUser();
    void updateUser();
    void listUsers();
    void deleteUser();
    void quitProgram();

}
