<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/8/2016
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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




            <div id="templatemo_content">

                <div class="content_section">


                </div>


                <div>
                    <form method="post" action="studentUpdate">

                        <input type="hidden" name="page" value="studentUpdate">
                        <input type="hidden" name="id" value="${student.id}">

                        <table>
                            <tr>
                                <td>Roll Number:</td><td><input type="text" name="rollNumber" value="${student.rollNumber}"></td>
                            </tr>

                            <tr>
                                <td>Age:</td><td><input type="text" name="age" value="${student.age}"></td>
                            </tr>
                            <tr>
                                <td>Name:</td><td><input type="text" name="name" value="${student.name}"/></td>
                            </tr>

                            <tr>
                                <td>Address:</td><td><input type="text" name="address" value="${student.address}"/></td>
                            </tr>

                            <tr>
                                <td colspan="2" align="right"><input type="submit" value="Update Student Detail"></td>
                            </tr>
                        </table>
                    </form>
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

