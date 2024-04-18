package DTO;

public class Task {

	private int taskid;
	private String tasktitle;
	private String taskdescription;
	private String taskpriority;
	private String duedate;
	private String taskstatus;
	private int userid;
	
	public Task() {
		// TODO Auto-generated constructor stub
	super();
	}


	public Task(int taskid2, String tasktitle2, String taskdescription2, String taskpriority2, String taskduedate,
			String taskstatus2) {
		// TODO Auto-generated constructor stub
	}

	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTasktitle() {
		return tasktitle;
	}
	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	public String getTaskpriority() {
		return taskpriority;
	}
	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public Task(int taskid, String tasktitle, String taskdescription, String taskpriority, String duedate,
			String taskstatus, int userid) {
		super();
		this.taskid = taskid;
		this.tasktitle = tasktitle;
		this.taskdescription = taskdescription;
		this.taskpriority = taskpriority;
		this.duedate = duedate;
		this.taskstatus = taskstatus;
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", tasktitle=" + tasktitle + ", taskdescription=" + taskdescription
				+ ", taskpriority=" + taskpriority + ", taskduedate=" + duedate + ", taskstatus=" + taskstatus
				+ ", userid=" + userid + "]";
	}
	
}
