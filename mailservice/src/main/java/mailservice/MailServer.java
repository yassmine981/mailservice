package mailservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailServer{
	
	ResultSet rs = null;
	String MysqlUser = "root";
	String MysqlPassword = "";
	Connection cn = null;
	Statement st = null;
 
	
	// sending a message 
   public String sending_an_email(String from, String to,String subject,String message) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail_base", MysqlUser, MysqlPassword);
			st = cn.createStatement();
			String sql = "INSERT INTO mail VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt;
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setString(2, from);
			pstmt.setString(3, to);
			pstmt.setString(4, subject);
			pstmt.setString(5, message);
			pstmt.setBoolean(6, true);
			int count = pstmt.executeUpdate();
			if (count > 0)
			return "Message sent successfully";
			
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
    	finally {
    		try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		return null;

    }
   //reading all the messages
    public ArrayList<Message> reading_all_emails(String to) {
	// recupérer, dans un tableau, les messages dont le destinataire est "to", il faut les marquer comme étant "lu"
    	ArrayList<Message>message=new ArrayList<Message>();
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail_base", MysqlUser, MysqlPassword);
			String sql2 = "UPDATE mail SET mail.isNew= ? WHERE  mail.to= ?";
			PreparedStatement pstmt2;
			pstmt2 = cn.prepareStatement(sql2);
			pstmt2.setBoolean(1,false);
			pstmt2.setString(2, to);
			pstmt2.executeUpdate();
			String sql = "SELECT * FROM mail WHERE mail.to= ?";
			PreparedStatement pstmt;
			pstmt = cn.prepareStatement(sql);
			pstmt.setString(1, to);
			rs =  pstmt.executeQuery();
			while (rs.next()) {
				Message msg=new Message(rs.getInt("Id"),rs.getString("from"),rs.getString("to"),rs.getString("subject"),rs.getString("message"));
				message.add(msg);
		}

	
		
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
    	finally {
    		try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	// envoyer le résultat au client
    	return message;
    }
    
    
    
 // supprimer tous les messages marqué comme étant "lu" et dont le destinataire est "to"
    public String deleting_all_received_mails(String to)  {
	int rs2 = 0;

	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail_base", MysqlUser, MysqlPassword);
		st = cn.createStatement();
		String sql2 ="DELETE FROM mail WHERE mail.to= ? AND mail.isNew=?";
		PreparedStatement pstmt2;
		pstmt2 = cn.prepareStatement(sql2);
		pstmt2.setString(1, to);
		pstmt2.setBoolean(2,false);
		 rs2 = pstmt2.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();}

	finally {
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(rs2==0)
	   return ("No old messages");
	else
	   return ("Old messages removed successfully");
    }
    
    // delete an email
    public String remove_an_email(String to,int id) {
    	
    int rs2 = 0;

	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail_base", MysqlUser, MysqlPassword);
		st = cn.createStatement();
		String sql2 ="DELETE FROM mail WHERE mail.to= ? AND mail.Id=?";
		PreparedStatement pstmt2;
		pstmt2 = cn.prepareStatement(sql2);
		pstmt2.setString(1, to);
		pstmt2.setInt(2,id);
		 rs2 = pstmt2.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();}

	finally {
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(rs2==0)
	   return ("No email with this id");
	else
	   return ("Email removed successfully");
    }
 
 
}