<%@ page language="java" %>
<%    
    if   (session.getAttribute("session_id")==null)
    {
    response.sendRedirect("home.html");
    }
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DASHBOARD</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
    </head>

    <body style="background-color: #e3f2fd;">
   
        <%@ include file="/teacher_header.html" %>  
            <div class="container">
                <div class="row">
                    <div class="col-6 mt-5">   
                        <h3>View Students</h3><br/>
                        <p>View  Enrolled Students</p>
                        <a href="viewStudents.jsp">
                        <button class="btn btn-primary ">View STUDENTS</button>
                        </a>
                    </div>
                   
                    <div class="col-6 mt-5">
                        <h3>Add Marks</h3></br>
                        <p> Add Student Marks By clicking on Marks Button</p>
                        <a href="addMarks.jsp">
                         <button class="btn btn-primary ">ADD MARKS</button>
                        </a>
                    </div>
                    
                    <div class="col-6 mt-5">
                        <h3>Update Marks</h3><br/>
                        <p>Update Marks of Enrolled Students</p>
                        <a href="updateMarks.jsp">
                         <button class="btn btn-primary ">UPDATE MARKS</button>
                        </a>
                    </div>
                    
                    <div class="col-6 mt-5">
                        <h3>Drop Student Course</h3></br>
                        <p> Drop Student Course</p>
                        <a href="dropCourse.jsp">
                         <button class="btn btn-primary ">DROP COURSE</button>
                        </a>
                    </div>
                    
           
                </div>
            </div>
    </body>       
</html>