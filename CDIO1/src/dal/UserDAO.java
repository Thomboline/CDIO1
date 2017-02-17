package dal;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import dto.IUserDTO;
import dto.UserDTO;

public class UserDAO implements IUserDAO
{
	private java.sql.Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String url = "jdbc:mysql://localhost:8889/deliveryEarn";
	private String user = "root";
	private String password = "root";
	
	@Override
	public UserDTO getUser(int userId) throws DALException 
	{

		return null;
	}

	@Override
	public List<UserDTO> getUserList() throws DALException 
	{
	
		return null;
	}

	@Override
	public void createUser(IUserDTO user) throws DALException 
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    Statement st = (Statement) con.createStatement(); 

	
		    
		    st.executeUpdate("INSERT INTO `UserTable`(ID,UserName,ini,CPR,Password) VALUE ('"+user.getUserID()+"','"+user.getUserName()+"','"+user.getIni()+"',"+user.getUserCpr()+"')");
		    con.close();
		   
		}

		catch (SQLException ex) 
		{
		     Logger lgr = Logger.getLogger(UserDAO.class.getName());
		     lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} 
		
	}
	
	@Override
	public void updateUser(IUserDTO user) throws DALException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
