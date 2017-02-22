package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable, IUserDTO
{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId;                     
	private String userName, CPR;                
	private String ini;                 
	private List<String> roles;
	
	//TODO Add relevant fields
	
	
	public UserDTO() 
	{
		this.roles = new ArrayList<>();
	}

	
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getIni() 
	{
		return ini;
	}
	public void setIni(String ini) 
	{
		this.ini = ini;
	}

	public List<String> getRoles() 
	{
		return roles;
	}
	public void setRoles(List<String> roles) 
	{
		this.roles = roles;
	}
	
	public void addRole(String role)
	{
		this.roles.add(role);
	}
	
	public boolean removeRole(String role)
	{
		return this.roles.remove(role);
	}

	
	public String toString() 
	{
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}




	public void setUserCpr(String Cpr) 
	{
		this.CPR = Cpr;
	}

	public String getUserCpr() 
	{
		return this.CPR;
	}
	
	public int getUserId() 
	{
		return this.userId;
	}

	public void setUserID(int iD) 
	{
		this.userId = iD;
	}

}
