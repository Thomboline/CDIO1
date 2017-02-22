package dal;
import java.util.List;
import dto.IUserDTO;

public interface IUserDAO 
{
	public IUserDTO getUser(int userId) throws DALException;
	public List<IUserDTO> getUserList() throws DALException;
	public void createUser(IUserDTO user) throws DALException;
	public void updateUser(IUserDTO user, int option) throws DALException;
	public void deleteUser(int userId) throws DALException;
	public String PasswordGenerator() throws DALException;
	
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
