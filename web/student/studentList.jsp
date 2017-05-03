<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <%@include file="../includes/header.jsp"%>
        <!-- end of templatemo_header -->

        <%@include file="../includes/menu.jsp" %>
        <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <h2>Our Services</h2>

                    <ul class="categories_list">
                        <li><a href="#">Test1</a></li>
                        <li><a href="#">Test2</a></li>
                    </ul>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>



            <div id="templatemo_content">

                <div class="content_section">

                    <h2><a href="studentForm?page=studentForm">Add Student</a></h2>

                    <table id="t01">
                          <tr>
                            <th>Roll Number</th>
                            <th>Age</th>
                            <th>Name</th>
                            <th> Address</th>
                            <th>Edit</th>
                            <th>Delete</th>
                          </tr>

                            <c:forEach items="${studentList}" var="student">

                                    <tr>
                                        <td>${student.rollNumber}</td>
                                        <td>${student.age}</td>
                                        <td>${student.name}</td>
                                        <td>${student.address}</td>
                                        <td><a href="studentEdit?page=studentEdit&id=${student.id}"><img src="images/edit.png" height="30" width="90"/></a></td>
                                        <td><a href="studentDelete?page=studentDelete&id=${student.id}"><img src="images/delete.png" height="30" width="90"/></a></td>
                                    </tr>
                            </c:forEach>



                    </table>

                </div>

            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">

            This is Footer
        </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>
