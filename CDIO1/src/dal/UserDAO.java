package dal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
	private PreparedStatement pst2 = null;
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
		          String Role = rs.getString("Roles");
		          
		          TempUser.setUserID(id);
		          TempUser.setUserCpr(CPR);
		          TempUser.setUserName(name);
		          TempUser.setIni(ini);
		          TempUser.addRole(Role);
		     }
		    
		    con.close();
		    
		    return TempUser;
		    
		}
		catch(Exception e)
		{
			throw new DALException(DALException.dataDoesNotExist);
		}		
	}

	public List<IUserDTO> getUserList() throws DALException 
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
		    Statement st = (Statement) con.createStatement(); 

		    
		    rs = st.executeQuery("SELECT UserID, Username, Ini, Roles, Cpr FROM personale");
		    
		    ArrayList<IUserDTO> UserList = new ArrayList<>();
		    
		    while(rs.next())
		    {
		    	this.TempUser = new UserDTO();
		    	TempUser.setUserID(rs.getInt("UserID"));
		    	TempUser.setUserName(rs.getString("Username"));
		    	TempUser.setIni(rs.getString("Ini"));
		    	TempUser.addRole("Roles");
		    	TempUser.setUserCpr(rs.getString("Cpr"));
		    	
		    	UserList.add(TempUser);
		    }
		    
		    return UserList;
		    
		}
		catch(SQLException | ArrayIndexOutOfBoundsException ex)
		{	
			throw new DALException(DALException.dataDoesNotExist);
		}
	}

	
	public void createUser(IUserDTO user) throws DALException 
	{
		try 
		{	
			Class.forName(driver);
			String Password = PasswordGenerator();
			
			con = DriverManager.getConnection(this.url, this.user, this.password);
			pst = con.prepareStatement(" insert into personale (UserID, Username, Ini, Roles, Cpr, Password)"
			        + " values (?, ?, ?, ?, ?, ?)");
			
			pst.setInt(1, user.getUserId());
			System.out.println("ID sat");
			
			pst.setString(2, user.getUserName());
			System.out.println("User name sat");
			
		    pst.setString(3, user.getIni());
			System.out.println("Initialer sat");
			
		    pst.setString(4, user.getRoles().get(0));
			System.out.println("Role sat");
			
		    pst.setString(5, user.getUserCpr());
			System.out.println("Cpr sat");
			
		    pst.setString(6, Password);
			System.out.println("Password sat");
			
		    pst.execute();
		    
		    con.close();
		}
		catch (SQLException | ClassNotFoundException ex) 
		{	
			if (((SQLException)ex).getErrorCode() == DALException.duplicateErrorCode) {
				System.out.println(DALException.duplicateData);
			}
			else {
				ex.printStackTrace();
			throw new DALException(DALException.wrongData);
			}
		}
	}
		
//--------EKSTRA KODE TIL DATABASE BRUGEROPRETTELSE---------------
//--------OPRETTER BRUGER, GIVER PRIVILEGIER----------------------
//--------KODE ER VELFUNGERENDE. KASSERET DA DROP IKKE VIRKER-----
//--------SKAL IMPLEMENTERES I createUser(); i CDIO2--------------
		
//		    if(user.getRoles().get(0)=="Admin")
//			{
//				String s = "Create user \"" + user.getUserName() + "\"@\"localhost\" identified by \"" + Password + "\";";
//		    	Statement st = (Statement) con.createStatement(); 
//		    	System.out.println(s);
//		        st.execute(s);
//		        
//				String p = "GRANT all privileges on *.* TO \"" + user.getUserName() + "\"@\"localhost\";";
//				System.out.println(p);
//				Statement st2 = (Statement) con.createStatement(); 
//		        st2.execute(p);
//			}
//			else if(user.getRoles().get(0).equals("Operator"))
//			{
//				String s = "Create user \"" + user.getUserName() + "\"@\"localhost\" identified by \"" + Password + "\";";
//		    	Statement st = (Statement) con.createStatement(); 
//		    	System.out.println(s);
//		        st.execute(s);
//		        
//				String p = "GRANT update, delete on *.* TO \"" + user.getUserName() + "\"@\"localhost\";";
//				System.out.println(p);
//				Statement st2 = (Statement) con.createStatement(); 
//		        st2.execute(p);
//			}
//			else if(user.getRoles().get(0)=="Foreman")
//			{
//				String s = "Create user \"" + user.getUserName() + "\"@\"localhost\" identified by \"" + Password + "\";";
//		    	Statement st = (Statement) con.createStatement(); 
//		    	System.out.println(s);
//		        st.execute(s);
//		        
//				String p = "GRANT insert on *.* TO \"" + user.getUserName() + "\"@\"localhost\";";
//				System.out.println(p);
//				Statement st2 = (Statement) con.createStatement(); 
//		        st2.execute(p);
//				
//			}
//			else if(user.getRoles().get(0)=="Pharmacist")
//			{
//				String s = "Create user \"" + user.getUserName() + "\"@\"localhost\" identified by \"" + Password + "\";";
//		    	Statement st = (Statement) con.createStatement(); 
//		    	System.out.println(s);
//		        st.execute(s);
//		        
//				String p = "GRANT select on *.* TO \"" + user.getUserName() + "\"@\"localhost\";";
//				System.out.println(p);
//				Statement st2 = (Statement) con.createStatement(); 
//		        st2.execute(p);
//			
//			}
	
	
	public void updateUser(IUserDTO user, int option) throws DALException
	{
		try 
		{
			con = DriverManager.getConnection(this.url, this.user, this.password);
			
			if(option==1)
			{
				pst = con.prepareStatement("UPDATE personale SET Username = ? , Ini =? , Roles = ? , Cpr = ? " + " WHERE UserID = ? ");
			    
			    pst.setString(1, user.getUserName());
			    pst.setString(2, user.getIni());
			    pst.setString(3, user.getRoles().get(0));
			    pst.setString(4, user.getUserCpr());
			    pst.setInt(5, user.getUserId());
			    pst.execute();
			}
			else if (option==2)
			{
				pst = con.prepareStatement("UPDATE personale SET Username = ? , Ini =? , Roles = ? , UserID = ? " + " WHERE Cpr = ? ");
			    
			    pst.setString(1, user.getUserName());
			    pst.setString(2, user.getIni());
			    pst.setString(3, user.getRoles().get(0));
			    pst.setInt(3, user.getUserId());
			    pst.setString(4, user.getUserCpr());
			    pst.execute();
			}
			else if (option==3)
			{
				pst = con.prepareStatement("UPDATE personale SET Password = ?  " + " WHERE UserID = ? ");
			    
			    pst.setString(1, PasswordGenerator());
			    pst.setInt(2, user.getUserId());
			    pst.execute();
			}
		    con.close();
		}

		catch (SQLException | IndexOutOfBoundsException ex) 
		{
		     throw new DALException(DALException.dataDoesNotExist);

		} catch (InputMismatchException e) {
			
			System.out.println("Invalid input.");
		}
		
	}


	public void deleteUser(int userId) throws DALException 
	{
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(this.url, this.user, this.password);
			String s = "delete from personale where UserID = " + userId + ";";
	    	Statement st = (Statement) con.createStatement(); 
	    	System.out.println(s);
	        st.execute(s);
		    con.close();
		}
		catch (SQLException | ClassNotFoundException ex) 
		{	
			throw new DALException(DALException.dataDoesNotExist);
		} 
	}

//--------EKSTRA KODE TIL AT SLETTE DATABASE BRUGER --------------
//--------VIRKER IKKE. SKAL ÆNDRES--------------------------------
//--------SKAL IMPLEMENTERES I deleteUser(); I CDIO2--------------
	
//	this.TempUser = getUser(userId);
//	String name = TempUser.getUserName();
//	System.out.println(name);
//	
//    String p = "DROP USER \"" + name + "\"@\"localhost\";";
//    System.out.println(p);
//    Statement st2 = (Statement) con.createStatement();
//    st2.executeUpdate(p);
	
	public String PasswordGenerator() throws DALException
	{	
		try
		{
		String UpCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String LowCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String Characters = "0123456789._-+!?=";
		int numberLength = (int) ((Math.random()*4) + 1);
		
	    SecureRandom RANDOM = new SecureRandom();
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < numberLength; ++i) 
        {
            sb.append(UpCaseAlphabet.charAt(RANDOM.nextInt(UpCaseAlphabet.length())));
        }
	    
	    String PW1 = sb.toString();
	    sb.setLength(0);
        for (int i = 0; i < 6; ++i) 
        {
            sb.append(LowCaseAlphabet.charAt(RANDOM.nextInt(LowCaseAlphabet.length())));
        }
        
        String PW2 = sb.toString();
        sb.setLength(0);
        
        for (int i = 0; i < 4; ++i) 
        {
            sb.append(Characters.charAt(RANDOM.nextInt(Characters.length())));
        }
        
        String PW3 = sb.toString();
        String Password = PW1 + PW2 + PW3;

        return Password;
		} 
		catch(Exception e)
		{
			throw new DALException(DALException.unidentifiedException);
        }
	}
}

