package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import DTO.Task;

@WebServlet("/edit")
public class EditTask extends HttpServlet {
 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		Dao dao=new Dao();
		
		try {
			Task task=dao.findtaskById(id);
			req.setAttribute("task", task);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("EditTask.jsp");
			dispatcher.include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
