package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import DTO.Task;
import DTO.User;

public class Dao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
		return conn;
	}
	
	public static int saveUser(User user) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4, user.getUsercontact());
		pst.setString(6,user.getUserpassword());
		
		Blob imageblob= new SerialBlob(user.getUserimage());
		
		pst.setBlob(5,imageblob);
		int res=pst.executeUpdate();
		return res;
	}
	
	public User findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from user where useremail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		if (rs.next()) {
			User u=new User();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(6));
			
			Blob imageblob=rs.getBlob(5);
			byte[] image=imageblob.getBytes(1,(int) imageblob.length());
			u.setUserimage(image);
			return u;
		}
		else {
			return null;
		}
	}

	
public int createtask(Task task) throws ClassNotFoundException, SQLException {
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("insert into task values(?,?,?,?,?,?,?)");
	pst.setInt(1, task.getTaskid());
	pst.setString(2,task.getTasktitle());
	pst.setString(3, task.getTaskdescription());
	pst.setString(4, task.getTaskpriority());
	pst.setString(5, task.getDuedate());
	pst.setString(6, task.getTaskstatus());
	pst.setInt(7, task.getUserid());
	
	int res=pst.executeUpdate();
	return res;
	
}
	
}



































































































