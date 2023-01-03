const form = document.querySelector('form');
const email = document.querySelector('email');
const password = document.querySelector('password');

form.onSubmit = function(e) {
	if(email.value == '' || password.value == ''){
		alert("Inserire email e password!")
		e.preventDefault();
	}
}