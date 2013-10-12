	/**
	 * @author Claudio Djohnnatha Duarte Lourenco
	 * since 07/2013
	 */


function validaFaleConosco()
{
	var nome=faleConosco['faleConosco:nome'];
	var email=faleConosco['faleConosco:email'];
	var mensagem=faleConosco['faleConosco:mensagem'];
	
	
	
	
	if(nome.value.length==0)
	{
		alert("Nome n„o pode estar vazio!");
		return false;
	}
	
	if(email.value.length==0)
	{
		alert("Email n„o pode estar vazio!");
		return false;
	}
	
	/*
	 * Verifica se existem esse pontos principais no 
	 * campo email, caso n√£o retorna uma mensagem
	*/
	var filtroMail=/^.+@.+\..{2,3}$/;
	if(!filtroMail.test(email.value)||email.value.length == 0)
		{
			alert("Preencha corretamente o campo do email!");
			email.focus();
			return false;
		}
	
	alert("TEste")
	if(mensagem.value.length==0)
	{
		alert("Alguma mensagem deve existir!");
		return false;
	}
	
	
	alert("Mensagem enviada com sucesso!");
	return true;
	
}