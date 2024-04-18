package DTO;

import javax.servlet.http.Part;

public class User {

	private int userid;
	private String username;
	private String useremail;
	private long usercontact;
	private String userpassword;
	private byte[] userimage;
	
	
	
	

	public User() {
		// TODO Auto-generated constructor stub
	}



	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public void setUsercontact(long usercontact) {
		this.usercontact = usercontact;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public void setUserimage(byte[] userimage) {
		this.userimage = userimage;
	}
	public String getUsername() {
		return username;
	}
	public String getUseremail() {
		return useremail;
	}
	public long getUsercontact() {
		return usercontact;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public byte[] getUserimage() {
		return userimage;
	}
	
	public User(int userid, String username, String useremail, long usercontact, String userpassword,
			byte[] userimage) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userpassword = userpassword;
		this.userimage = userimage;
	}	
	
}
