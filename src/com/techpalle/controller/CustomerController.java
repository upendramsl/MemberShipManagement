package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.Dao.CustomerDao;
import com.techpalle.model.Customer;

@WebServlet("/")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		
		switch (path)
		{
		case "/delete":
			deletePage(request,response);
			break;
		case "/cusUpdate":
			updateDetails(request,response);
			break;
		case "/update":
			getupdatePage(request,response);
			break;
		case "/reg":
			getCustomerRegPage(request,response);
			break;
		case "/cusReg":
			insertCustomerDetails(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
	
	
	}

	
	private void getupdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("customer_update.jsp");
		rd.forward(request, response);
		
		
	}


	private void updateDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("tbid"));
		String name=request.getParameter("tbname");
		String email=request.getParameter("tbemail");
		long mobile=Long.parseLong(request.getParameter("tbtel"));
		Customer c=new Customer(id,name,email,mobile);
		CustomerDao.updateDetailes(c);
		getStartUpPage(request, response);
		
	}


	private void deletePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int i=Integer.parseInt(request.getParameter("id"));
		CustomerDao.deleteDetailes(i);
		getStartUpPage(request, response);
		
	}


	private void insertCustomerDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("tbname");
		String email=request.getParameter("tbemail");
		long mobile=Long.parseLong(request.getParameter("tbtel"));
		Customer c=new Customer(name, email, mobile);
		CustomerDao.insertDetailes(c);
		getStartUpPage(request, response);
	}


	private void getCustomerRegPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("customer_form.jsp");
		rd.forward(request, response);

	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
	rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
