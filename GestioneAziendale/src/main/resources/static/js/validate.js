
	function validateForm(event) {
		event.preventDefault();
		//var email = document.getElementById("email").value;
		//var password = document.getElementById("password").value;	
		$.ajax({
			type: "post",
			url: "/doLogin",
			data: { email: $("#email").val(), 
        			password: $("#password").val() },
			success: function (logged) {
				if (!logged) {					
					$("#errorMessage").text("Credenziali non valide");
					$("#email, #password").css("border-color", "red");
				}
				else {
				window.location.href = '/views';
			}
			}
		});
	}

