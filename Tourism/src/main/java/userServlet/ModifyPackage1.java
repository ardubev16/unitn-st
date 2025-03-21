package userServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConnectionString;

/**
 * Servlet implementation class ModifyPackage1
 */
@WebServlet("/ModifyPackage1")
public class ModifyPackage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packagename = request.getParameter("packagename");
		String place = request.getParameter("place");
		String days = request.getParameter("days");
		String packageCost = request.getParameter("packageCost");
		String persons = request.getParameter("persons");
		//String tmp=request.getParameter("totalCost");
		//System.out.println(tmp);
		int totalCost = -1;
		try {
			totalCost=Integer.parseInt(request.getParameter("totalCost"));
		} catch (NumberFormatException nfe) {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	      
	    }
		catch (NullPointerException np) {
		      System.out.println("NullPointerException: " + np.getMessage());
		   }
		catch (IndexOutOfBoundsException iob) {
		      System.out.println("IndexOutOfBoundsException: " + iob.getMessage());
		   }
	
		PrintWriter out = response.getWriter();
		
		if ((packagename!=null)&&(place!=null)&&(days!=null)&&(packageCost!=null)&&(persons!=null)&&(totalCost!=-1))  
		{ 
			
			HttpSession session = request.getSession();
			
			if(persons.equals("")||persons.equals("0")){
				out.println("Please enter no of persons");
			}else{
				
				try{
					Connection con=ConnectionString.getCon();//getting db connection
					PreparedStatement ps = con.prepareStatement("update bookpackage set noofPersons =?,totalcost=? where packagename='"+packagename+"'and place='"+place+"' and email='"+session.getAttribute("email")+"'");
					ps.setString(1,persons );
					ps.setInt(2,totalCost );
					ps.executeUpdate();
					
					out.println("Package "+packagename+" modified Successfully");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else
			out.println("Package "+packagename+" NOT modified");
	}

}
