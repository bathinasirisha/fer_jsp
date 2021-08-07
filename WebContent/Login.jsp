<html>
<head>
<title>Fer-Login</title>
<script>
	function validateForm(){
		var form=document.LoginForm;
		var errorMessages='';
		
		if(form.username.value.trim() == ''){
			errorMessages+='Please enter UserName<BR>';
		}
		if(form.password.value.trim() == ''){
			errorMessages+='Please enter Password<BR>';
		}
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			form.submit();
		}
	}
</script>
</head>

<body>
<form action='LoginPost.jsp' method='post' name="LoginForm">
	<table border='1' align='center' height='100px ' width='80px'>
		<tr>
			<td colspan='2' align='center'>Login</td>
		</tr>
		<tr style='display:none; color:red' id='errorTrId'>
				<td colspan='2' align='left' id='errorTdId'></td>
			</tr>

		<tr>
			<td>UserName<font color='red'>*</font></td>
			<td><input type='text' name='username'></td>
		</tr>

		<tr>
			<td>Password<font color='red'>*</font></td>
			<td><input type='password' name='password'></td>
		</tr>

		<tr>
			<td colspan='2' align='center'>
<input type='button' value='Login' onclick="javascript: validateForm()">			&nbsp;&nbsp;&nbsp;
			<a href='Registration.jsp'>Registration</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>