package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dal.IUserDAO;

public class UserDTO implements Serializable, IUserDTO
{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId, CPR;                     
	private String userName;                
	private String ini;                 
	private List<String> roles;
	
	//TODO Add relevant fields
	
	
	public UserDTO() 
	{
		this.roles = new ArrayList<>();
	}
	
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
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
	

	/**
	 * 
	 * @param role
	 * @return true if role existed, false if not
	 */
	public boolean removeRole(String role)
	{
		return this.roles.remove(role);
	}

	
	public String toString() 
	{
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}




	public void setUserCpr(int Cpr) 
	{
	
		
	}


	public void setUserDAO(IUserDAO userDAO) 
	{
	
		
	}


	public int getUserCpr() 
	{
		
		return this.CPR;
	}


	public void setUserID(int iD) 
	{
		this.userId = iD;
		
	}



}
