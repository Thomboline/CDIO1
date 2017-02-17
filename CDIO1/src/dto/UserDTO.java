package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class UserDTO implements Serializable, IUserDTO{
=======
import dal.IUserDAO;

public class UserDTO implements Serializable, IUserDTO
{
>>>>>>> origin/Stuart

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId, CPR;                     
	private String userName;                
	private String ini;                 
	private List<String> roles;
<<<<<<< HEAD
	private String userCpr;
=======
	
>>>>>>> origin/Stuart
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
	public String getUserCpr() { return userCpr; }
	public void setUserCpr(String userCpr) { this.userCpr = userCpr; }

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

	@Override
	public String toString() 
	{
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}


	@Override
	public void getUserID() 
	{
	
		
	}

	@Override
	public void setUserID(int iD) 
	{
		
		
	}


	@Override
	public void setUserCpr(String cPR) 
	{
	
		
	}

	@Override
	public void setUserDAO(IUserDAO userDAO) 
	{
	
		
	}

	@Override
	public int getUserCpr() 
	{
		
		return this.CPR;
	}

	
	
	
}
