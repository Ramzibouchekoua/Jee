<%@ page language="java"  import="java.util.ArrayList, modele.domaine.Student" contentType="text/html ; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String name =(String) request.getParameter("name");
if (name==null || name.equals(""))
{
	name="";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>		
<body >
Sélectionner un nom :
	<div>
		<form action=StudentController method="GET">

			<table>
				<tr>
					<td class="label">Name</td>
					<td><input type="text" name="name" value="<%=name%>" /></td>
				<td align="center" ><input type="submit" value="Rechercher " />
				</tr>
				
			</table>
		</form>
	</div>


		Liste des Students
		<hr>
			<table border ="1">
			<tr>
				<th>matricNo:</th>
				<th>name:</th>
				<th>address:</th>
				<th>Email:</th>
				
			</tr>
		<%
			ArrayList lp = (ArrayList) request.getAttribute("listOfStudent");
			if (lp != null) {
				
				for (int i = 0; i < lp.size(); i++) 
				{
					out.println("<tr>");
					out.println("<td> " + ((Student) lp.get(i)).getMatricNo() + "</td>");
					out.println("<td> " + ((Student) lp.get(i)).getName() + "</td>");
					out.println("<td> " + ((Student) lp.get(i)).getAddress() + "</td>");
					out.println("<td> " + ((Student) lp.get(i)).getEmail() + "</td>");		
					out.println("</tr>");
				}
				
			}
		%>
		
			
		</table>

</div>

</body>
</html>