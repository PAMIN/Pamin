	

/**
	 * @author Cláudio Djohnnatha Duarte Lourenço
	 * since 07/2013
	 */
   
function validaForm() {
	/*
	 * Verificar se o campo nome digitado no cadastro
	 * está vazio e retorna um alerta caso sim
	 */
	
	var nome=formulario['formulario:nome'];
	var senha=formulario['formulario:senha'];
	var email=formulario['formulario:email'];
	var login=formulario['formulario:login'];
	var confirmarSenha = formulario['formulario:senha2'];
	
	
	/**
	 * Verifica se o campo nome está vazio
	 */
	if(nome.value.length == 0)
		{
			nome.focus();
			return false;
		}
	
	/**
	 * Verifica se o login está vazio
	 */
	if(login.value.length == 0)
	{
		form.senha.focus();
		return false;
	}
		
	
	/*
	 * Verifica se existem esse pontos principais no 
	 * campo email, caso não retorna uma mensagem
	*/
	var filtroMail=/^.+@.+\..{2,3}$/;
	if(!filtroMail.test(email.value)||email.value.length == 0)
		{
			alert("Preencha corretamente o campo do email!");
			email.focus();
			return false;
		}
	
	/*
	 * ******************************
	 * CAMPOS DE VALIDACAO DE SENHA**
	 * ******************************
	 */
	
	if(senha.value.length == 0 || senha.value.length < 6){
		alert("A senha deve conter pelo menos 6 digitos!");
		form.senha.focus();
		return false;
	}
	
	else if(senha.value != confirmarSenha.value){
			alert("Senhas diferentes!");
			confirmarSenha.focus();
			return false;
	}
	
	return true;
	
}


	
	
	
	