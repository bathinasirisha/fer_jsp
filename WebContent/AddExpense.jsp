
			<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
		<html>
<head>
<title>AddExpense</title>
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
			submitForm('AddExpensePost.jsp');
		}
	}
</script>
</head>
					<table border='1' align='center'>
						<tr>

							<td colspan='6' align='center'>Add EXpenses</td>
						</tr>
						<tr style='display:none; color:red' id='errorTrId'>
							<td colspan='2' align='left' id='errorTdId'></td>
						</tr>

						<tr>
							<td>Expense Type<font color='red'>*</font></td>
							<td><input type='text' name='expenseType'></td>
						</tr>


						<tr>
							<td>Date<font color='red'>*</font></td>
							<td><input type='text' name='date'></td>
						</tr>

						
						<tr>
							<td>Price<font color='red'>*</font></td>
							<td><input type='text' name='price'></td>
						</tr>

						<tr>
							<td>No Of Items<font color='red'>*</font></td>
							<td><input type='text' name='noOfItems'></td>
						</tr>

						<tr>
							<td>Total<font color='red'>*</font></td>
							<td><input type='text' name='total'></td>
						</tr>

						<tr>
							<td>By Whom<font color='red'>*</font></td> 
							<td><input type='text' name='byWhom'></td>
						</tr>

						<tr>
							<td colspan='2' align='center'>
								<input type='button' value='Save expense' onclick="javascript: validateForm()">

							</td>
						</tr>
						
					</table>
					</html>
						<jsp:include page="Layout/Footer.jsp"/>
		