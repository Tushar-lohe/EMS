<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:red;text-align:center">Register Employee</h1>

<frm:form modelAttribute="emp">
<table align="center" bgcolor="cyan">
 <tr>
  <td>Employee Name:</td>
  <td><frm:input path="ename"/></td>
 </tr>
 
 <tr>
  <td>Employee Job:</td>
  <td><frm:input path="job"/></td>
 </tr> 
 
 <tr>
  <td>Employee salary:</td>
  <td><frm:input path="sal"/></td>
 </tr>
 
 <tr>
  <td>Dept. No.</td>
  <td><frm:input path="deptno"/></td>
 </tr>
 
 <tr>
  <td><input type="Submit" value="Submit"></td>
  <td><input type="reset" value="Cancle"></td>
 </tr>
 
</table>

</frm:form>
