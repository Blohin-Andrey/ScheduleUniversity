function validationForm(data){
	
	var login = data.Login.value;
	var password = data.Password.value;
	var cpassword = data.ConfirmPassword.value;
	var email = data.EmailAddress.value;
	var firstName = data.FirstName.value;
	var lastName = data.LastName.value;
	var role = data.ChooseRole.value;
	var sex = data.ChooseSex.value;
	
	/* Login */	
	if (login === null || login.lenght === 0){
		alert("Input your <User Name>");
		data.Login.focus();
                return false;
	}
		else if (login.length < 3){
			alert("The length your <User Name> is too short");
			data.Login.focus();
                        return false;
		}	
		else if (login.length > 45){
			alert("The length your <User Name> is too long");
			data.Login.focus();
                        return false;			
		}
		
	/* Password */
	if (password === null || password.length === 0){
		alert("Input your <Password>");
                data.Password.focus();
		return false;            
        }
            else if (password !== cpassword){ 
		data.Password.value = "";
                data.ConfirmPassword.value = "";
                alert("Your password and confirmation password do not match");
                data.Password.focus();
		return false;
	}	
	
	/* E-mail */
	if (email === null || email.length === 0){
		alert("Input your <Email address>");
		data.EmailAddress.focus();
                return false;			
	}		
		else if (email.length < 6){
			alert("The length your <Email address> is too short");
			data.EmailAddress.focus();
                        return false;
		}
		else if (email.length > 45){ 
			alert("The length your <Email address> is too long");
			data.EmailAddress.focus();
                        return false;			
		}
		else if (!(/^\w+[-_\.]*\w+@\w+-?\w+\.[a-z]{2,4}$/.test(email))){ 
			alert("Input to correct <Email address>");
			data.EmailAddress.focus();
                        return false;			
		}
		
	/* Имя */
	if (firstName === null || firstName.lenght === 0){ 
		alert("Input to correct <Email address>");
		data.FirstName.focus();
                return false;		
	}
		else if (firstName.length < 3){ 
			alert("The length your <First Name> is too short");
			data.FirstName.focus();
                        return false;		
		}
		else if (firstName.length > 25){ 
			alert("The length your <First Name> is too long");
			data.FirstName.focus();
                        return false;		
		}
	
	/* Фамилия */
	if (lastName === null || lastName.lenght === 0){		
		alert("The length your <First Name> is too long");
                data.LastName.focus();   
		return false;
	}
		else if (lastName.length < 3){ 
			alert("The length your <Second Name> is too short");
			data.LastName.focus();
                        return false;
		}
		else if (lastName.length > 25){ 
			alert("The length your <Second Name> is too long");
			data.LastName.focus();
                        return false;
		}	

	/* Пол */
	if (sex === "None"){ 
		alert("Choose your <Sex>");
		data.ChooseSex.focus();
                return false;		
	}
	
	/* Роль */
	if (role === "None"){ 
		alert("Choose your <Role>");
		data.ChooseRole.focus();
                return false;
	}

}