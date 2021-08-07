	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<html>
<head>
<title>ResetPassword</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		if(form.currentPassword.value.trim() == ''){
			errorMessages+='Please enter Current Password<BR>';
		}
		if(form.newPassword.value.trim() == ''){
			errorMessages+='Please enter New Password<BR>';
		}
		if(form.reEnterNewPassword.value.trim() == ''){
			errorMessages+='Please re enter New Password<BR>';
		}
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('ResetPasswordPost.jsp');
		}
	}
</script>
</head>
					<table border='1' align='center'>
						<tr>

							<td colspan='6' align='center'>Reset Password</td>
						</tr>
						
						<tr style='display:none; color:red' id='errorTrId'>
				<td colspan='2' align='left' id='errorTdId'></td>
			</tr>

						<tr>
							<td>Current Password:<font color='red'>*</font></td>
							<td><input type='text' name='currentPassword'></td>
						</tr>


						<tr>
							<td>New Password:<font color='red'>*</font></td>
							<td><input type='text' name='newPassword'></td>
						</tr>



						<tr>
							<td>Re enter new password:<font color='red'>*</font></td>
							<td><input type='text' name='reEnterNewPassword'></td>
						</tr>

						

						 <tr>
							<td colspan='2' align='center'>
				<input type='button' value='Reset Password' onclick="javascript: validateForm()">

							</td>
						</tr>
						</tr>
					</table>
					</html>
									<jsp:include page="Layout/Footer.jsp"/>
					
			