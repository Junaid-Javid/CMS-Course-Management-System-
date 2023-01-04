import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;


public class viewMarks extends HttpServlet {

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>VIEW MARKS</title><link rel='stylesheet' href='css/bootstrap.min.css'/></head>");
    out.println("<body style='background-color: #e3f2fd;'>");
   
    HttpSession session=request.getSession(false);  
    
    if(session == null)
    {
      out.println("<h1 class='text-center mt-3'>YOU ARE NOT SIGNED IN OR YOUR SESSION HAS BEEN EXPIRED</h1>");
      out.println("<BR/><br/><a href='signin.html'><button class='btn btn-primary ms-3'>SIGN IN</button></a>");    
    }
   else
  {
      RequestDispatcher rd = request.getRequestDispatcher("/header.html");
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
    
      String query = "SELECT * FROM marks WHERE signup_id ='"+ id +"' ";      
     	ResultSet rs = st.executeQuery( query );

      if(rs.next())
      {	
          out.println("<div class='container'>");
          out.println("<h1 class='mt-3 text-center'> Result </h1>");
          out.println("<table class='table table-bordered border-dark'>"); 
          out.println("<thead>");
          out.println("<tr class='table-dark'>");
          out.println("<th>Course</th>");
          out.println("<th>Teacher</th>");
          out.println("<th>Quiz</th>");
          out.println("<th>Assignment</th>");
          out.println("<th>Project</th>");
          out.println("<th>Mid</th>");
          out.println("<th>Final</th>");
           out.println("</tr>");
          out.println("</thead>");
                    
          ArrayList<String> course = new ArrayList<String>();
          do{
            course.add(rs.getString("courses"));
            course.add(rs.getString("oquiz"));
            course.add(rs.getString("oassignment"));
            course.add(rs.getString("oproject"));
            course.add(rs.getString("omid"));
            course.add(rs.getString("ofinal"));
            course.add(rs.getString("teachers"));
          }while (rs.next());

          out.println("<tbody>");
          out.println("<tr>");

          int a = 0;
          for(int i=0;i<course.size();i++)
          {
              
            out.println("<td>");     
            out.println(course.get(i));  
            out.println("</td>");  
            if(a>5)
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
        out.println("<h1 class='mt-3 text-center'>You Have'nt Enrolled IN any course Yet</h1>");
      
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