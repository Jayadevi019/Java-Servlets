package com.Deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpBonus
 */
@WebServlet("/EmpBonus")
public class EmpBonus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpBonus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String empname =request.getParameter("en");
		double salary=Double.parseDouble(request.getParameter("sal"));
		String grade1 =request.getParameter("grade");
		double bonus=0.0,tax=0.0,nsal=0.0;
		if(salary >100000 && grade1.equals("A"))
		{
		bonus=salary*0.05;
		}
		else if(salary > 50000 && salary <=100000 && grade1.equals("B"))
		{
		bonus=salary*0.07;
		}
		else if(salary <=50000&& grade1.equals("C"))
		{
		bonus=salary*0.2;
		}
		tax=salary*0.25;
		nsal=salary+bonus-tax;
		pw.println("Employee Name  : "+empname+"<br>");
		pw.println("Basic Salary   : RS "+salary+"<br>");
		pw.println("Bonus          : RS "+bonus+"<br>");
		pw.println("Tax            : RS "+tax+"<br>");
		pw.println("Net Salary     : RS "+nsal+"<br>");
	   String str="<table border =1>"+"<tr><th>Name</th>"+"<th>Salary</th>"+"<th>Bonus</th>"
			   +"<th>Tax</th>"+"<th>Net Salary</th>"+"</tr>";
	   String str1="<tr>"+"<td>"+empname+"</td>"+"<td>"+salary+"</td>"+"<td>"+bonus+"</td>"+"<td>"+tax+"</td>"+"<td>"+nsal+"</td>"+"</TABLE>";
	pw.println(str+str1);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
