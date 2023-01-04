import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;


public class viewstudents extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>VIEW STUDENTS</title><link rel='stylesheet' href='css/bootstrap.min.css'/></head>");
    out.println("<body style='background-color: #e3f2fd;'>");
    
    String courses=request.getParameter("courses");
   
    HttpSession session=request.getSession(false);  
    
    if(session == null)
    {
      out.println("<h1 class='text-center mt-3'>YOU ARE NOT SIGNED IN OR YOUR SESSION HAS BEEN EXPIRED</h1>");
      out.println("<BR/><br/><a href='signin.html'><button class='btn btn-primary ms-3'>SIGN IN</button></a>");    
    }
   else
  {
      RequestDispatcher rd = request.getRequestDispatcher("/teacher_header.html");
      rd.include(request,response);
      
    try
    {   
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://127.0.0.1/project";
      Connection con=DriverManager.getConnection(url,"root","root");
      Statement st=con.createStatement();
	    
      String name=(String)session.getAttribute("session_name");  
	    String id=(String)session.getAttribute("session_id"); 
      String teachers=(String)session.getAttribute("session_teachers");  	
    
      String query = "SELECT * FROM add_course WHERE courses = '"+ courses + "' && teachers ='"+ teachers +"' ";      
     	ResultSet rs = st.executeQuery( query );

      if(rs.next())
      {	
          out.println("<div class='container'>");
          out.println("<h1 class='mt-3 text-center'> Enrolled Students </h1>");
          out.println("<table class='table table-bordered border-dark'>"); 
          out.println("<thead>");
          out.println("<tr class='table-dark'>");
          out.println("<th>Roll #</th>");
          out.println("<th>Student Name</th>");
          out.println("<th>Day</th>");
          out.println("<th>Time Slot</th>");
           out.println("</tr>");
          out.println("</thead>");
                    
          ArrayList<String> course = new ArrayList<String>();
          do{
            course.add(rs.getString("signup_id"));
            course.add(rs.getString("name"));
            course.add(rs.getString("day"));
            course.add(rs.getString("time"));
          }while (rs.next());

          out.println("<tbody>");
          out.println("<tr>");

          int a = 0;
          for(int i=0;i<course.size();i++)
          {
              
            out.println("<td>");     
            out.println(course.get(i));  
            out.println("</td>");  
            if(a>2)
            {   
              out.println("</tr><tr>");   
              a = 0;
            }
            else
            {
                a++;
            }  
          }
          out.println("</tr>");
          out.println("</tbody></table>");
       }         
       else
       {
        out.println("<h1 style='color:red; 'class='mt-3 text-center display-5'>Note</h1>");
        out.println("<h1 class='mt-3 text-center'>None of the Student is Enrolled in this Course</h1>");
      
      }
     st.close();
     con.close();
    }
    catch(Exception e)
    {
      out.println(e);
    }
  } //ELSE END
    out.println("</div></body></html>");
}
}