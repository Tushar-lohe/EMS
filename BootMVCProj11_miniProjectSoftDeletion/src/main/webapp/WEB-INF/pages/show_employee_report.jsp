
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
 <c:when test="${!empty empsList}">
  <h1 style="color:red;text-align:center">Employee Report</h1>
   <table border="1" bgcolor="cyan" align="center">
     <tr style="color:red"><th>empno</th><th>emp name</th><th>job</th><th>salary</th><th>dept no</th><th>Operation</th></tr>
     <c:forEach var="emp" items="${empsList}">
      <tr style="color:blue">
       <td>${emp.empno}</td>
       <td>${emp.ename}</td>
       <td>${emp.job}</td>
       <td>${emp.sal}</td>
       <td>${emp.deptno}</td>
       <td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.png" width=30px height=40px/></a>
           <a href="emp_delete?no=${emp.empno}"
                    onclick="return confirm('Are u sure You Want to Delete The Employee.')">
                  ><img src="images/delete.png" width=30px height=40px ></a></td>
      </tr>
     </c:forEach>
   </table>
 </c:when>
  <c:otherwise>
   <h1 style="color:pink;text-align:center">Employee Not Found</h1>
  </c:otherwise> 
</c:choose>

<h2 style="color:red;text-align:center">${resultMsg}</h2>

<center>
  <h1 style="color:red"><a href="emp_add">Add_Employee<img src="images/addemployee.png" width=55px height=70px/></a></h1>
 &nbsp;&nbsp;&nbsp;
 <h1 style="text-align:left"><a href="./">Back<img src="images/home.png" width=45px height=60px/></a></h1>
<center>

