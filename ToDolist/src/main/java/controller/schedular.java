package controller;

import java.sql.SQLException;

import DAO.Dao;

public class schedular implements Runnable {

	public void run() {
		while(Thread.currentThread().isInterrupted()) {
			Dao dao=new Dao();
			
			try {
				dao.updatePriorityBasedOnDuration();
				Thread.sleep(1000*30);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
		}
	}
}
