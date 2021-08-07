<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService = new FERServiceImpl();
 %>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>

<html>
<head>
<title>NameInfo</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		if(form.firstName.value.trim() == ''){
			errorMessages+='Please enter First Name<BR>';
		}
		if(form.middleName.value.trim() == ''){
			errorMessages+='Please enter Middle Name<BR>';
		}
		if(form.lastName.value.trim() == ''){
			errorMessages+='Please enter Last Name<BR>';
		}
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('ContactInfo.jsp');
		}
	}
</script>
</head>
<% 

	int userId = Integer.parseInt(session.getAttribute("userId").toString());

	User user=ferService.getUser(userId);
	
	session.setAttribute("user", user);

	if (user==null) {
		out.println("User not found");
	} else {
		
		out.println("<table border='1' align='center' height='50px' width=60px>");
		out.println("<tr>");

		out.println("<td colspan='3' align='center'>Name Info</td>");
		out.println("</tr>");

		out.println("<tr style='display:none; color:red' id='errorTrId'>");
		out.println("<td colspan='2' align='left' id='errorTdId'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>FirstName<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='firstName' value='"+user.getFirstName()+"'></td>");
		out.println("</tr>");

		
		out.println("<tr>");
		out.println("<td>MiddleName<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='middleName' value='"+user.getMiddleName()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>LastName<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='lastName' value='"+user.getLastName()+"'></td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<input type=\"button\"value=\"Next\"onclick=\"javascript: validateForm()\">");

			out.println("</td>");
			out.println("</tr>");
		out.println("</tr>");
		out.println("</table>");
	}

%>
</html>
				<jsp:include page="Layout/Footer.jsp"/>
