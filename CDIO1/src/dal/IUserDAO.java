package dal;
import java.util.List;

import dto.IUserDTO;
import dto.UserDTO;

public interface IUserDAO 
{
	public UserDTO getUser(int userId) throws DALException;
	public List<UserDTO> getUserList() throws DALException;
	public void createUser(IUserDTO user) throws DALException;
	public void updateUser(IUserDTO user) throws DALException;
	public void deleteUser(int userId) throws DALException;
	
	public class DALException extends Exception 
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 7355418246336739229L;

		public DALException(String msg, Throwable e) 
		{
			super(msg,e);
		}

		public DALException(String msg) 
		{
			super(msg);
		}

	}

}
