package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;

/**
 * Servlet implementation class EmployeeInfo
 */
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Object id2 = request.getAttribute("userid");
        
       
        System.out.println(id);
        System.out.println(id2);
       
     
        EmployeeDAOImpl daoE = new EmployeeDAOImpl();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.  
		try {
			  Employee user = daoE.getEmployeeById(123); // Obtain login info
			
			
        if(user !=null)   //On success, you can display a message to user on Home page
        {
         request.setAttribute("userid", user.getId()); // Store id in request scope.
           request.getRequestDispatcher("employee-home-page.jsp").forward(request, response); // Forward to JSP page to display id in a HTML.
//    		response.getWriter().write("Your id is "+user.getId());
        }
//        else   //On Failure, display a meaningful message to the User.
//        {
//           request.setAttribute("errMessage", userRegistered);
//           request.getRequestDispatcher("/Register.jsp").forward(request, response);
//        }
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
