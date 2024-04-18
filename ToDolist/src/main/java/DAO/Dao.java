package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		
		
		Blob imageblob= new SerialBlob(user.getUserimage());
		pst.setBlob(5,imageblob);
		pst.setString(6,user.getUserpassword());

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

public List<Task> getalltasks(int userid) throws ClassNotFoundException, SQLException{
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("select * from task where userid=? ");
	pst.setInt(1, userid);
	ResultSet rs=pst.executeQuery();
	List<Task> tasks=new ArrayList<>();
	while (rs.next()) {
		Task task=new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
		tasks.add(task);
	}
	return tasks;
}

public int Deletetask(int taskid) throws ClassNotFoundException, SQLException {
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("delete from task where taskid=?");
	pst.setInt(1, taskid);
	int res=pst.executeUpdate();
	return res;
}

public int getTaskId() throws ClassNotFoundException, SQLException {
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("select max(taskid) from task");
	ResultSet rs=pst.executeQuery();
	if (rs.next()) {
		int id=rs.getInt(1);
		return id+1;
	}
	else {
	    return 1;
	}
}

public int getUserId() throws ClassNotFoundException, SQLException {
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("select max(userid) from user");
	ResultSet rs=pst.executeQuery();
	if (rs.next()) {
		int id=rs.getInt(1);
		return id+1;
	}
	else {
	    return 1;
	}
}

public Task findtaskById(int taskid) throws ClassNotFoundException, SQLException {
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("select * from task where taskid=?");
	pst.setInt(1, taskid);
	ResultSet rs=pst.executeQuery();
	rs.next();
	Task task=new Task(taskid, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)); 
	return task;
}

public void UpdateTask(Task task) throws SQLException, ClassNotFoundException {
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("update task set tasktitle=?,taskdescription=?,taskpriority=?,taskduedate=?,taskstatus=?,userid=? where taskid=?");
	pst.setString(1, task.getTasktitle());
	pst.setString(2, task.getTaskdescription());
	pst.setString(3, task.getTaskpriority());
	pst.setString(4, task.getDuedate());
	pst.setString(5, task.getTaskstatus());
	pst.setInt(6, task.getUserid());
	pst.setInt(7, task.getTaskid());
	
	pst.executeUpdate();
	
}
public void updatePriorityBasedOnDuration() throws ClassNotFoundException, SQLException {
	
	Connection conn = getConnection();
	Statement st = conn.createStatement();
	st.execute("UPDATE task SET taskpriority = 'high' WHERE taskduedate BETWEEN CURDATE() AND CURDATE() +  INTERVAL 3 DAY");
	st.execute("UPDATE task SET taskpriority = 'medium' WHERE taskduedate BETWEEN CURDATE() + INTERVAL 4 DAY AND CURDATE() + INTERVAL 7 DAY");
	st.execute("UPDATE task SET taskpriority = 'low' WHERE taskduedate > CURDATE() + INTERVAL 7 DAY");
}


}
