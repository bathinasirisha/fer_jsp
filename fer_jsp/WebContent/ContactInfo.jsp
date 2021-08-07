<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService = new FERServiceImpl();
 %>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<html>
<head>
<title>ContactInfo</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		if(form.email.value.trim() == ''){
			errorMessages+='Please enter Email<BR>';
		}
		if(form.mobile.value.trim() == ''){
			errorMessages+='Please enter Mobile<BR>';
		}
		
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('AddressInfo.jsp');
		}
	}
</script>
</head>
<% 

int userId = Integer.parseInt(session.getAttribute("userId").toString());

User user=(User)session.getAttribute("user");

user.setFirstName(request.getParameter("firstName"));
user.setMiddleName(request.getParameter("middleName"));
user.setLastName(request.getParameter("lastName"));


out.println("<table border='1' align='center' height='50px' width=60px>");
out.println("<tr>");

out.println("<td colspan='2' align='center'>Contact Info</td>");
out.println("</tr>");

out.println("<tr style='display:none; color:red' id='errorTrId'>");
out.println("<td colspan='2' align='left' id='errorTdId'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>email<font color='red'>*</font></td>");
out.println("<td><input type='text' name='email' value='"+user.getEmail()+"'></td>");
out.println("</tr>");


out.println("<tr>");
out.println("<td>Mobile<font color='red'>*</font></td>");
out.println("<td><input type='text' name='mobile' value='"+user.getMobile()+"'></td>");
out.println("</tr>");


out.println("<tr>");
out.println("<input type=\"button\"value=\"Next\"onclick=\"javascript: validateForm()\">");

	out.println("</td>");
	out.println("</tr>");
out.println("</tr>");
out.println("</table>");

%>
				<jsp:include page="Layout/Footer.jsp"/>
