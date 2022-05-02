<%@page language="java" import="java.util.ArrayList,modele.domaine.Student"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Fiche User</title>
</head>
<body >
		Veuillez saisir les propriétés de l'etudiant...
		<hr>
		
		<%
		
	      //gestion des erreurs
			ArrayList erreurs = (ArrayList) request.getAttribute("err");
			if (erreurs != null) 
			{
				%>
				<div class="erreur">
				<%
				out.println("<ul>");
				for (int i = 0; i < erreurs.size(); i++) {
					out.println("<li> " + (String) erreurs.get(i) + "</li>");
				}
				out.println("</ul>");
				%>
				</div>
			<%
			}
			
			
			// gestion de la saisie de  l'etudiant en cours
			int matricNo =0;
			String email =null;
			String address =null;
			String name =null;
			Student student = (Student)request.getAttribute("student");
			if (student!=null)
			{
			 matricNo= student.getMatricNo();
			 email = student.getEmail();
			 address = student.getAddress();
			 name = student.getName();
			}
			
			// Correction des  valleurs nulles
			if (email==null)email="";
			if (address==null)address="";
			if (name==null)name="";
		%>
		
		<form action="StudentEditionController" method="POST">
			<table>
			<tr>
				<td><input type="hidden" name="id" value ="<%=matricNo%>"/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value ="<%=name%>"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value ="<%=email%>"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value ="<%=address%>"/></td>
			</tr>

			<tr>
				<td align="center" colspan="2"><input type="submit" value="ok" />
					<input type="reset" value="Annuler" /></td>
			</tr>

		</table>
	</form>

</body>
</html>