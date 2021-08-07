<%@page import="com.rs.fer.bean.Address"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService = new FERServiceImpl();
 %>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<html>
<head>
<title>AddressInfo</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		if(form.line1.value.trim() == ''){
			errorMessages+='Please enter Line One<BR>';
		}
		
		if(form.city.value.trim() == ''){
			errorMessages+='Please enter City<BR>';
		}
		if(form.state.value.trim() == ''){
			errorMessages+='Please enter State<BR>';
		}
		if(form.pincode.value.trim() == ''){
			errorMessages+='Please enter Pincode<BR>';
		}
		if(form.country.value.trim() == ''){
			errorMessages+='Please enter Country<BR>';
		}
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('ReviewInfo.jsp');
		}
	}
</script>
</head>
<% 

int userId = Integer.parseInt(session.getAttribute("userId").toString());

User user=(User)session.getAttribute("user");

user.setEmail(request.getParameter("email"));
user.setMobile(request.getParameter("mobile"));

//session.setAttribute("user", user);
Address address=user.getAddress();

out.println("<table border='1' align='center' height='50px' width=60px>");
out.println("<tr>"); 

out.println("<td colspan='6' align='center'>Address Info</td>");
out.println("</tr>");

out.println("<tr style='display:none; color:red' id='errorTrId'>");
out.println("<td colspan='2' align='left' id='errorTdId'></td>");
out.println("</tr>");


out.println("<tr>");
out.println("<td>Line1<font color='red'>*</font></td>");
out.println("<td><input type='text' name='line1' value='"+address.getLine1()+"'></td>");
out.println("</tr>");


out.println("<tr>");
out.println("<td>Line2</td>");
out.println("<td><input type='text' name='line2' value='"+address.getLine2()+"'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>City<font color='red'>*</font></td>");
out.println("<td><input type='text' name='city' value='"+address.getCity()+"'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>State<font color='red'>*</font></td>");
out.println("<td><input type='text' name='state' value='"+address.getState()+"'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>Pincode<font color='red'>*</font></td>");
out.println("<td><input type='text' name='pincode' value='"+address.getPincode()+"'></td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td>Country<font color='red'>*</font></td>");
out.println("<td><input type='text' name='country' value='"+address.getCountry()+"'></td>");
out.println("</tr>");




out.println("<tr>");
out.println("<input type=\"button\"value=\"Review\"onclick=\"javascript: validateForm()\">");

	out.println("</td>");
	out.println("</tr>");
out.println("</tr>");
out.println("</table>");

%>
</html>
				<jsp:include page="Layout/Footer.jsp"/>
