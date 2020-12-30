<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>
	
	<form:form action="processForm" modelAttribute="student">
	
		Fist Name: <form:input path="firstName"/>
		<br><br>
		
		Last Name: <form:input path="lastName"/>
		<br><br>
		
		Country:
		
		<form:select path="country">
			
			<form:options items="${student.countryOptions }"/>
			
		</form:select> 
		
		<br><br>
		
		Favourite Language:
		
		Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		C# <form:radiobutton path="favouriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
		Python <form:radiobutton path="favouriteLanguage" value="Python"/>
		
		<br><br>
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		MAC OS <form:checkbox path="operatingSystems" value="MAC OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		
		<br><br>
		<input type="submit" value="Submit"/>
		
	</form:form>
	
</body>

</html>