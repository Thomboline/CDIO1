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
		private static final long serialVersionUID = 7355418246336739229L;
		public static final int duplicateErrorCode = 1062;
		public static final String duplicateData = "You have entered an ID or username that is already in use.\nPlease try again.";
		public static final String wrongData = "Something went wrong. Beware of input syntax:"
				+ "\nUserID: {0, 1, 2..... 9}. Interval [1,99]."
				+ "\nUser name: All characters. Max 20 characters."
				+ "\nInitials: All characters. Max 4 characters."
				+ "\nCPR: {0, 1, 2..... 9}. Exactly 11 characters are required. Syntax: 12345678-1234"
				+ "\nPlease try again.\n";
		public static final String dataDoesNotExist = "This data does not exist.";
		public static final String unidentifiedException = "Somehing went wrong. Please try again.";
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
