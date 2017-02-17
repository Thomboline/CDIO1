<<<<<<< HEAD
package dto;

import java.util.List;

/**
 * Created by jonathanlarsen on 16/02/2017.
 */
public interface IUserDTO {

    void userDTO();
    int getUserID();
    void setUserID(int ID);
    String getUserName();
    void setUserName(String name);
    String getIni();
    void setIni(String ini);
    List <String> getRoles();
    void setRoles();
    String addRole();
    void setUserCpr(String CPR);
    String getUserCpr();



}
=======
package dto;

import java.util.List;

import dal.IUserDAO;

public interface IUserDTO 
{
	
	public String getUserID();
	public void setUserID(int iD);
	
	public String getUserName();
	public void setUserName(String name);
	
	public String getIni();
	public void setIni(String ini);
	
	public List<String> getRoles();
	public void setRoles(List<String> roles);
	public void addRole(String role);

	public void setUserCpr(String cPR);
	public int getUserCpr();
	public void setUserDAO(IUserDAO userDAO);
	
}
>>>>>>> origin/Stuart
