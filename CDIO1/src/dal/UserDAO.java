package dal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import dto.IUserDTO;
import dto.UserDTO;
import java.security.SecureRandom;

public class UserDAO implements IUserDAO
{
	private java.sql.Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/cdio1";
	private String user = "root";
	private String password = "root";
	
	IUserDTO TempUser = new UserDTO();
	
	
	public IUserDTO getUser(int userId) throws DALException 
	{
		
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    Statement st = (Statement) con.createStatement(); 


		    rs = st.executeQuery("SELECT * FROM personale where UserID = " + userId + "");
		    
		    while(rs.next())
		    {
		        
		          int id  = rs.getInt("UserID");
		          String CPR = rs.getString("Cpr");
		          String name = rs.getString("Username");
		          String ini = rs.getString("Ini");
		          
		          TempUser.setUserID(id);
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

	
	public List<IUserDTO> getUserList() throws DALException 
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    Statement st = (Statement) con.createStatement(); 

		    
		    rs = st.executeQuery("SELECT UserID, Username, Ini, Cpr FROM personale");
		    
		    ArrayList<IUserDTO> UserList = new ArrayList<>();
		    
		    while(rs.next())
		    {
		    	this.TempUser = new UserDTO();
		    	TempUser.setUserID(rs.getInt("UserID"));
		    	TempUser.setUserName(rs.getString("Username"));
		    	TempUser.setIni(rs.getString("Ini"));
		    	TempUser.setUserCpr(rs.getString("Cpr"));
		    	
		    	UserList.add(TempUser);
		    }
		    
		    return UserList;
		    
		}
		catch(SQLException ex)
		{
			 Logger lgr = Logger.getLogger(UserDAO.class.getName());
		     lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	
	public void createUser(IUserDTO user) throws DALException 
	{
		try 
		{	
			Class.forName(driver);
			con = DriverManager.getConnection(this.url, this.user, this.password);
			pst = con.prepareStatement(" insert into personale (UserID, Username, Ini, Cpr, Password)"
			        + " values (?, ?, ?, ?, ?)");
			
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUserName());
		    pst.setString(3, user.getIni());
		    pst.setString(4, user.getUserCpr());
		    pst.setString(5, PasswordGenerator());
		    pst.execute();
			
			/*Statement st = (Statement) con.createStatement(); 
		    st.executeUpdate("INSERT INTO `UserTable`(ID,UserName,ini,CPR,Password) VALUE ('"+user.getUserId()+"','"+user.getUserName()+"','"+user.getIni()+"',"+user.getUserCpr()+"')");
		    */
		    con.close();
		   
		}

		catch (SQLException | ClassNotFoundException ex) 
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
		    pst = con.prepareStatement("UPDATE personale SET Username = ? , Ini =? , Cpr =? " + " WHERE UserID = ? ");
		    

		    pst.setString(1, user.getUserName());
		    pst.setString(2, user.getIni());
		    pst.setString(3, user.getUserCpr());
		    pst.setInt(4, user.getUserId());
		    pst.execute();
		    
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
			Class.forName(driver);
			con = DriverManager.getConnection(this.url, this.user, this.password);
			
		    pst = con.prepareStatement("delete from personale where UserID = ?");
		    pst.setInt(1, userId);
		    pst.execute();
		    
		    con.close();
		   
		}

		catch (SQLException | ClassNotFoundException ex) 
		{
		     Logger lgr = Logger.getLogger(UserDAO.class.getName());
		     lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} 
		
	}
	
	public String PasswordGenerator()
	{
		String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Characters = "0123456789._-+!?=";
	    SecureRandom RANDOM = new SecureRandom();
	    
	    StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; ++i) 
        {

            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        String PW1 = sb.toString();
        
        for (int i = 0; i < 4; ++i) 
        {

            sb.append(Characters.charAt(RANDOM.nextInt(Characters.length())));
        }
        String PW2 = sb.toString();
        
        String Password = PW1 + PW2;
        	
		return Password;
	}

}
