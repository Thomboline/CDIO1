package dal;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

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
	
	IUserDTO TempUser = new UserDTO();
	
	
	public IUserDTO getUser(int userId) throws DALException 
	{
		
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    Statement st = (Statement) con.createStatement(); 

		    
		    rs = st.executeQuery("SELECT * FROM test where id = " + userId + "");
		    
		    while(rs.next())
		    {
		        
		          int id  = rs.getInt("id");
		          String  CPR = rs.getString("CPR");
		          String name = rs.getString("name");
		          String ini = rs.getString("ini");
		          
		          TempUser.setUserId(userId);
		          TempUser.setUserCpr(CPR);
		          TempUser.setUserName(name);
		          TempUser.setIni(ini);
		          
		          /*
		          System.out.print("ID: " + id);
		          System.out.print(", name: " + name);
		          System.out.print(", ini: " + ini);
		          System.out.println(", CPR: " + CPR);
		          */
		     }
		    
		    con.close();
		    
		    return TempUser;
		    
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Sorry! Connection Failed");
		}
		
		return null;

	}

	
	public List<UserDTO> getUserList() throws DALException 
	{
	  
		return null;
	}

	
	public void createUser(IUserDTO user) throws DALException 
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    Statement st = (Statement) con.createStatement(); 

		    st.executeUpdate("INSERT INTO `UserTable`(ID,UserName,ini,CPR,Password) VALUE ('"+user.getUserId()+"','"+user.getUserName()+"','"+user.getIni()+"',"+user.getUserCpr()+"')");
		    con.close();
		   
		}

		catch (SQLException ex) 
		{
		     Logger lgr = Logger.getLogger(UserDAO.class.getName());
		     lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} 
		
	}
	
	
	public void updateUser(IUserDTO user) throws DALException
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    pst = con.prepareStatement("UPDATE test SET UserName = ? , ini =? , CPR =?, WHERE ID LIKE ? ");
		    		
		    pst.setString(1, user.getUserName());
		    pst.setString(2, user.getIni());
		    pst.setString(3, user.getUserCpr());
		    pst.setInt(4, user.getUserId());
		    con.close();
		   
		}

		catch (SQLException ex) 
		{
		     Logger lgr = Logger.getLogger(UserDAO.class.getName());
		     lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} 
		
	}


	public void deleteUser(int userId) throws DALException 
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
			
		    pst = con.prepareStatement("delete from users where id = ?");
		    pst.setInt(1, userId);
		    
		    con.close();
		   
		}

		catch (SQLException ex) 
		{
		     Logger lgr = Logger.getLogger(UserDAO.class.getName());
		     lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} 
		
	}

}
