<%@ page language="java" %>
<%
    
    if   (session.getAttribute("session_id")==null)
    {
    response.sendRedirect("home.html");
    }
%>

<html>
    <head>
        <title>VIEW STUDENTS</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <script type="text/javascript" src="script/script.js" ></script> 
    </head>
    <body style="background-color: #e3f2fd;">

            <%@ include file="/teacher_header.html" %>
            <h1 class="display-1 text-center">View Students</h1>
        <div class="container">
            <form method="post" action="viewstudents" name="courses_form" onsubmit="return validation_courses()">
                
                    <div>  
                    <label class="display-6 mb-3" >Select Course</label>
                                <select name="courses" class="form-select form-select-lg mb-3" id="selectCourses">
                                    <option selected value="Open">Open menu</option>
                                    <option value="DBA">Data Base Administration</option>
                                    <option value="OOP">Object Oriented Programming</option>
                                    <option value="DSA">Data Structure Algorithms</option>
                                    <option value="COAL">Computer Organization & Assembly Language</option>
                                    <option value="ITC">Introduction To Computing</option>
                                    <option value="PF">Programming Fundamentals</option>
                                </select>
                    </div>
                     
                     <a href="viewstudents">
                        <button class="btn btn-primary ">View</button>
                    </a>
                
               
            </form>
        </div>
    </body>
</html>