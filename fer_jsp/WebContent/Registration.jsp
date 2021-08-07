<html>
<head>
<title>Registration</title>
<script>
	function validateForm() {
		var form = document.RegistrationForm;
		var errorMessages = '';

		if (form.firstname.value.trim() == '') {
			errorMessages += 'Please enter First Name<BR>';
		}

		if (form.lastname.value.trim() == '') {
			errorMessages += 'Please enter Last Name<BR>';
		}
		if (form.email.value.trim() == '') {
			errorMessages += 'Please enter Email<BR>';
		} else if (form.isEmailAvailable.value == "N") {
			errorMessages += 'Email is not available<BR>';

		}
		if (form.username.value.trim() == '') {
			errorMessages += 'Please enter UserName<BR>';
		}
		if (form.password.value.trim() == '') {
			errorMessages += 'Please enter Password<BR>';
		}
		if (form.mobile.value.trim() == '') {
			errorMessages += 'Please enter Mobile<BR>';
		}

		if (errorMessages != '') {
			//alert(errorMessages);
			var errorTrObj = document.getElementById('errorTrId');
			var errorTdObj = document.getElementById('errorTdId');

			errorTdObj.innerHTML = errorMessages;
			errorTrObj.style.display = '';

		} else {
			form.submit();
		}
	}

	function validateEmail(email) {

		var xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			// alert(this.responseText.trim());
			//document.getElementById("txtHint").innerHTML = this.responseText;

			var emailTrIdObj = document.getElementById('emailTrId');
			var emailTdIdObj = document.getElementById('emailTdId');

			var message = '';
			var colorName = '';

			var form = document.RegistrationForm;
			if (this.responseText.trim() == "Y") {
				message = 'Email is available..';
				colorName = 'green';
				form.isEmailAvailable.value = 'Y';
			} else {
				message = 'Email is not available..';
				colorName = 'red';
				form.isEmailAvailable.value = 'N';

			}

			emailTdIdObj.innerHTML = message;
			emailTdIdObj.style.color = colorName;

			emailTrIdObj.style.display = '';

		}
		xhttp.open("GET", "FER_AJAX.jsp?email="+email, true);
		xhttp.send();
	}
</script>
</head>

<body>
	<form action='RegistrationPost.jsp' method='post' name=RegistrationForm>
		<table border='1' align='center'>
			<tr>
				<td colspan='2' align='center'>Registration</td>
			</tr>

			<tr style='display: none; color: red' id='errorTrId'>
				<td colspan='2' align='left' id='errorTdId'></td>
			</tr>


			<tr>
				<td>FirstName<font color='red'>*</font></td>
				<td><input type='text' name='firstname'></td>
			</tr>

			<tr>
				<td>middleName</td>
				<td><input type='text' name='middlename'></td>
			</tr>

			<tr>
				<td>LastName<font color='red'>*</font></td>
				<td><input type='text' name='lastname'></td>
			</tr>

			<tr>
				<td>Email<font color='red'>*</font></td>
				<td><input type='text' name='email' onchange="javascript: validateEmail(this.value)"></td>
			</tr>

			<tr style='display: none;' id='emailTrId'>
				<td colspan='2' align='left' id='emailTdId'></td>
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
				<td>Mobile<font color='red'>*</font></td>
				<td><input type='text' name='mobile'></td>
			</tr>

			<tr>
				<td colspan='2' align='center'><input type='button'
					value='Register' onclick="javascript: validateForm()"></td>
			</tr>
		</table>
		<input type='hidden' name='isEmailAvailable'>
	</form>
</body>
</html>