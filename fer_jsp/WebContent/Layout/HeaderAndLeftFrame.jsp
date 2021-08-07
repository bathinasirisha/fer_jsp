<html>
<head>
<title>FER-DashBoard</title>
<script type="text/javascript">
function submitForm(nextPath){
	var form=document.DashboardForm;
	
	form.action=nextPath;
	
	form.submit();
}
</script>
</head>

<body>
	<form name='DashboardForm' method='post'>
		<table border='1' align='center'>

			<tr>
				<td colspan='2' align='center' height='60px'>FAMILY EXPENSE
					REPORT:User: 
					${username}
					</td>
</tr>


<tr>
	<td width='150px'><br></br> <a
		href="javascript: submitForm('AddExpense.jsp')">Add Expense</a> <br></br>
		<a href="javascript: submitForm('EditExpenseOptions.jsp')">EditExpense</a> <br></br> 
		<a href="javascript: submitForm('DeleteExpense.jsp')">DeleteExpense</a> <br></br> 
		<a href="javascript: submitForm('ExpenseReport.jsp')">ExpenseReport</a> <br></br> 
		<a href="javascript: submitForm('ResetPassword.jsp')">Reset Password</a> <br></br> 
		<a href="javascript: submitForm('NameInfo.jsp')">Update User</a> <br></br> 
	<td colspan='6' align='center'>