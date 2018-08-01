package com.Deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View_Passengers
 */
@WebServlet("/View_Passengers")
public class View_Passengers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Passengers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		PrintWriter pw=response.getWriter();
		String destination=request.getParameter("des");
		DB_helper db=new DB_helper();
		
		ArrayList PassengerList=db.getAllPassengers(destination);
		String str="<table border =1>"+
		           "<tr><th>First Name</th>"+
				   "<th>Last Name</th>"+
		          "<th>Source</th>"+
				  "<th>Destination</th>"+
		           "<th>Gender</th>"+"</tr>";
		pw.println(str);
		
		for(int i=0;i<PassengerList.size();i++)
		{
			PassengerVO pvo=(PassengerVO)PassengerList.get(i);
			
			 String str1="<tr>"+"<td>"+pvo.getFirstName()+"</td>"+"<td>"+
			 pvo.getLastName()+"</td>"+"<td>"+
			 pvo.getSource()+"</td>"+"<td>"+
			 pvo.getDestination()+"</td>"+"<td>"+
			 pvo.getGender()+"</td>"+"</tr>";
			pw.println(str1);	
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
