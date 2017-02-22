package dto;

import java.util.List;

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

	public void setUserCpr(String Cpr);
	public String getUserCpr();
	
}
