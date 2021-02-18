package com.freetuition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.freetuition.dbutil.PostresqlConnection;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Request;
import com.freetuition.model.RequestApproved;
import com.freetuition.model.RequestRejected;

public class EmployeeDAOImpl {

	// Create Employee // Create Login
	public boolean createEmployee() {
		return false;	
	}
	// Get Employee // Get his Manager Name
	public Employee getEmployeeById(int id) throws BusinessException {
		Employee  employee = null;
		try (Connection connection = PostresqlConnection.getConnection()) {
			String sql="select first_name, last_name, company, position, manager_id, email, contact , address from freetuition.employee where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(id);
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setCompany(resultSet.getString("company"));
				employee.setPosition(resultSet.getString("position"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setEmail(resultSet.getString("email"));
				employee.setContact(resultSet.getLong("contact"));
				employee.setAddress(resultSet.getString("address"));
			}else {
				throw new BusinessException("No car found with id "+id);
			}
		}catch (SQLException e) {

			System.out.println(e);
			throw new BusinessException("Internal error occured contact admin ");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employee;
	}
	
	//Create Request with status "open"
	public boolean createRequest() {
		return false;	
	}
	
	//Create ReimbursementApproved //Update status of Request to "approved"
	public boolean approveRequest() {
		return false;	
	}
	
	//Create ReimbursementRejected //Update status of Request to "rejected"
	public boolean rejectRequest() {
		return false;	
	}
	
	//Get All Requests join with Employee (Sort by employee or manager and status)
	public List<Request> getAllRequests() {
		return null;	
	}
	
	public Request getRequestById(int requestId) {
		return null;	
	}
	
	public RequestApproved getApprovedRequest (int  requestId) {
		return null;
		
	}
	public RequestRejected getRejectedRequest (int  requestId) {
		return null;
		
	}
	
}
