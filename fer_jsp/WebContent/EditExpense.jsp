	<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<%!FERService ferService = new FERServiceImpl();
 %>
<html>
<head>
<title>EditExpense</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		if(form.expenseType.value.trim() == ''){
			errorMessages+='Please enter Expense Type<BR>';
		}
		
		if(form.date.value.trim() == ''){
			errorMessages+='Please enter Date<BR>';
		}
		if(form.price.value.trim() == ''){
			errorMessages+='Please enter Price<BR>';
		}
		if(form.noOfItems.value.trim() == ''){
			errorMessages+='Please enter Number of items<BR>';
		}
		if(form.total.value.trim() == ''){
			errorMessages+='Please enter Total<BR>';
		}
		if(form.byWhom.value.trim() == ''){
			errorMessages+='Please enter By Whome<BR>';
		}
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('EditExpensePost.jsp');
		}
	}
</script>
</head>
<% 
	int userId = Integer.parseInt(session.getAttribute("userId").toString());

	int expenseId = Integer.parseInt(request.getParameter("expenseId"));
	
	Expense expense=ferService.getExpense(expenseId);

	
	if (expense==null) {
		out.println("Expense not found");
	} else {
		
		session.setAttribute("expenseId",expenseId);
		out.println("<table border='1' align='center' height='50px' width=60px>");
		out.println("<tr>");

		out.println("<td colspan='6' align='center'>Edit EXpenses</td>");
		out.println("</tr>");
		
		out.println("<tr style='display:none; color:red' id='errorTrId'>");
		out.println("<td colspan='2' align='left' id='errorTdId'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Expense Type<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='expenseType' value='"+expense.getExpenseType()+"'></td>");
		out.println("</tr>");


		out.println("<tr>");
		out.println("<td>Date<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='date' value='"+expense.getDate()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Price<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='price' value='"+expense.getPrice()+"'></td>");
		out.println("</tr>");



		out.println("<tr>");
		out.println("<td>No Of Items<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='noOfItems' value='"+expense.getNumberOfItems()+"'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Total<font color='red'>*</font></td>");
		out.println("<td><input type='text' name='total' value='"+expense.getTotal()+"'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>By Whom<font color='red'>*</font></td>");
			out.println("<td><input type='text' name='byWhom' value='"+expense.getByWhom()+"'></td>");
			out.println("</tr>");

		out.println("<tr>");
		out.println("<input type=\"button\"value=\"Edit Expense\"onclick=\"javascript: validateForm()\">");

			out.println("</td>");
			out.println("</tr>");
		out.println("</tr>");
		out.println("</table>");
	}
	%>
				<jsp:include page="Layout/Footer.jsp"/>
