package dto;

import java.util.List;

import dal.IUserDAO;

public interface IUserDTO 
{
	
	public int getUserId();
	public void setUserID(int iD);
	
	public String getUserName();
	public void setUserName(String name);
	
	public String getIni();
	public void setIni(String ini);
	
	public List<String> getRoles();
	public void setRoles(List<String> roles);
	public void addRole(String role);

	public void setUserCpr(String CPR);
	public int getUserCpr();
	public void setUserDAO(IUserDAO userDAO);
	
}
