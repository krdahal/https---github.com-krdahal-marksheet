<div id="templatemo_menu">

    <ul>
        <li><a href="home?page=home" class="current">Home</a></li>
        <c:if test="${sessionScope.user.role=='admin'}">
            <li><a href="userList?page=userList">User</a></li>
            <li><a href="studentList?page=studentList">Student</a></li>
            <li><a href="subject?page=subject">Subject</a></li>
            <li><a href="marks?page=marks">Marks</a></li>
        </c:if>
        <li><a href="logout?page=logout">Logout</a></li>
    </ul>

</div>