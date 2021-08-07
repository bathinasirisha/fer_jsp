	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<html>
<head>
<title>ExpenseReport</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		if(form.expenseType.value.trim() == ''){
			errorMessages+='Please enter Expense Type<BR>';
		}
		
		if(form.fromDate.value.trim() == ''){
			errorMessages+='Please enter From Date<BR>';
		}
		if(form.toDate.value.trim() == ''){
			errorMessages+='Please enter To Date<BR>';
		}
		
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('ExpenseReportPost.jsp');
		}
	}
</script>
</head>
					<table border='1' align='center'>
						<tr>

							<td colspan='6' align='center'>Expense Report</td>
						</tr>
						
							<tr style='display:none; color:red' id='errorTrId'>
							<td colspan='2' align='left' id='errorTdId'></td>
						</tr>
						
						<tr>
							<td>Expense Type<font color='red'>*</font></td>
							<td><input type='text' name='expenseType'></td>
						</tr>


						<tr>
							<td>From Date:<font color='red'>*</font></td>
							<td><input type='text' name='fromDate'></td>
						</tr>



						<tr>
							<td>To Date:<font color='red'>*</font></td>
							<td><input type='text' name='toDate'></td>
						</tr>

						

						<tr>
							<td colspan='2' align='center'>
								<input type='button' value='Get Expense Report' onclick="javascript: validateForm()">

							</td>
						</tr>
					
					</table>
				<jsp:include page="Layout/Footer.jsp"/>