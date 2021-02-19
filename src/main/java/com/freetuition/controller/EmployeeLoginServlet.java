package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.dao.LoginDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//working code
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("The employee is confirmed:" +request.getParameter("firstName") +" ");
//		out.println("</body></html>");
		
		//try code
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
       
        System.out.println(login);
        System.out.println(password);
     
        LoginDAOImpl dao = new LoginDAOImpl();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.  
		try {
			  Login user = dao.letEmployeeLogin(login, password);  // Obtain login info
			
			
        if(user !=null)   //On success, you can display a message to user on Home page
        {
        	 EmployeeDAOImpl daoE = new EmployeeDAOImpl();	
        	  Employee employee = daoE.getEmployeeById(123); // Obtain login info
              if(employee !=null)   //On success, you can display a message to user on Home page
              {
            	  ObjectMapper map = new ObjectMapper();
            	  final String JSON = map.writeValueAsString(employee);
            	 response.setContentType("application/json");
            	 response.getWriter().write(JSON);
            	 
//            	 for JSPs
//               request.setAttribute("employeeId", user.getId()); // Store id in request scope.
//               request.setAttribute("name", employee.getFirstName());
            	 
//                 request.getRequestDispatcher("employee-home-page.html").forward(request, response); // Forward to JSP page to display id in a HTML.
       		
              }
//         request.setAttribute("userid", user.getId()); // Store id in request scope.
//           request.getRequestDispatcher("employee-home-page.jsp").forward(request, response); // Forward to JSP page to display id in a HTML.
//    		response.getWriter().write("Your id is "+user.getId());
        }
//        else   //On Failure, display a meaningful message to the User.
//        {
//           request.setAttribute("errMessage", userRegistered);
//           request.getRequestDispatcher("/Register.jsp").forward(request, response);
//        }
		} catch (BusinessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String login = request.getParameter("login");
         String password = request.getParameter("password");

          Login registerBean = new Login();
        //Using Java Beans - An easiest way to play with group of related data
         registerBean.setLogin(login);
         registerBean.setPassword(password);
         
         System.out.println(login);
         System.out.println(password);
         
         LoginDAOImpl registerDao = new LoginDAOImpl();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.   
		try {
			  int userRegistered = registerDao.createLogin(registerBean);

         if(userRegistered !=0)   //On success, you can display a message to user on Home page
         {
//            request.getRequestDispatcher("student.html").forward(request, response);
     		response.getWriter().write("We added Login and poasswort ot db");
         }
         else   //On Failure, display a meaningful message to the User.
      		response.getWriter().write("Could not create login");
         {
//            request.setAttribute("errMessage", userRegistered);
//            request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
		} catch (BusinessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }

}
