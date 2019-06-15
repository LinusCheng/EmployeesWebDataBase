<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.io.PrintWriter" %> 
<%@ page import="javax.servlet.http.HttpServlet" %> 
<%@ page import="javax.servlet.http.HttpServletRequest" %> 
<%@ page import="javax.servlet.http.HttpServletResponse" %> 
<%@ page import="javax.servlet.http.HttpSession" %> 




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<style><%@include file="/css/style.css"%></style>

</head>
<body>

<div class="topbar">
<%
HttpSession se = request.getSession(false);

if(se==null){
	out.print("Please Log in");
	}

else{
	String usr = (String) se.getAttribute("usr");
	if(usr==null){
		out.print("Please Log in");
	}else{
		out.print("Welcom: "+usr);
	}}
	
/* else{
	String usr = (String) se.getAttribute("usr");
	out.print("Welcom: "+usr);
	} */
	
	
%>
&nbsp;
</div>


<div class="tab">
<!-- <a class="tablinks" href="/NewWeb/LoginPage.html">Login</a>
<a class="tablinks" href="/NewWeb/LogoutServlet">Logout</a> -->

<%
if(se==null){
	out.print("<a class=\"tablinks\" href=\"/NewWeb/LoginPage.html\">Login</a>");
	}
else{
	String usr = (String) se.getAttribute("usr");
	if(usr==null){
		out.print("<a class=\"tablinks\" href=\"/NewWeb/LoginPage.html\">Login</a>");
	}else{
		out.print("<a class=\"tablinks\" href=\"/NewWeb/LogoutServlet\">Logout</a>");
	}}
%>

<a class="tablinks" href="/NewWeb/Show_Session">Profile</a>

<% 
int acc_type = 2;
if(se!=null){
	if(se.getAttribute("acc_type")!=null)
	   acc_type = (Integer) se.getAttribute("acc_type");
	if(acc_type==0){
		out.print("<a class=\"tablinks\" href=\"/NewWeb/NewAccount.html\">New Account</a>");
	}else{
		out.print("<a class=\"tablinks\" > New Account (Admin Login Required)</a>");
	}
}

%>



</div>



<h1>This Page is Homepage</h1>

<table style="width:20%">
<tr>
<th><a href="/NewWeb/show_dep">Show_Dep</a></th>
<th><a href="/NewWeb/show_emp">Show_People</a></th>
</tr>


<%
if(se==null){
	out.print("<tr><th>Please log in to view</th></tr>");
	}
else{
	String usr = (String) se.getAttribute("usr");
	if(usr==null){
		out.print("<tr><th>Please log in </th><th>to view this part</th></tr>");
	}else{
		out.print("<tr><th><a href=\"/NewWeb/Add_Dep.html\">Add_Dep</a></th>");
		out.print("<th><a href=\"/NewWeb/Add_People.html\">Add_People</a></th></tr>");
	}
}
%>


</table>
<br><br>






<br><br><br><br>




<form action="/NewWeb/CookieTry" method = "get">
<table style="width:20%">
<tr><th>CookieTry</th></tr>
<tr><th>Info_1 =</th>
<th><input type="text" name = "Info_1"/></th>
</tr>
<tr><th>Info_2 =</th>
<th><input type="text" name = "Info_2"/></th>
<th><input type="submit"/></th></tr>
</table>
</form> 




</body>
</html>
