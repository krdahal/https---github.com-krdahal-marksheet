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

                    <h2>${message}</h2>

                </div>

                <form>
                    <table id="t01">
                        <tr>
                            <th>Student Name</th>
                            <td>
                                <select name="student_id">
                                    <c:forEach items="${studentList}" var="student">
                                        <option value="${student.id}">${student.name}</option>
                                    </c:forEach>
                                </select>
                            </td>

                            <th>Subject Name</th>
                            <td>
                                <select name="subject_id">
                                    <c:forEach items="${subjectList}" var="subject">
                                        <option value="${subject.id}">${subject.name}</option>
                                    </c:forEach>
                            </select>
                            </td>
                        </tr>

                        <tr>
                            <th>Full Marks</th>
                            <td> <select name="full_marks">
                                <c:forEach items="${fullMarks}" var="marks">
                                    <option value="${marks}">${marks}</option>
                                </c:forEach>
                            </select>
                            </td>

                            <th>Pass Marks</th>
                            <td>
                                <select name="pass_marks">
                            <c:forEach items="${passMarks}" var="marks">
                                <option value="${marks}">${marks}</option>
                            </c:forEach>
                        </select>
                            </td>

                        </tr>

                        <tr>
                            <th>Obtaine Marks</th>
                            <td><input type="text" name="obtained_marks"></td>

                            <th>Class</th>
                            <td>
                                <select name="cls">
                                <c:forEach items="${classList}" var="cls">
                                    <option value="${cls}">${cls}</option>
                                </c:forEach>
                            </select>
                            </td>

                        </tr>

                        <tr>
                            <th colspan="4" align="right"><input type="submit" value="Submit Marks"></th>
                        </tr>

                    </table>
                </form>


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
