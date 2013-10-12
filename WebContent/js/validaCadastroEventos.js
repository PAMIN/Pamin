	
	/**
	 * @author Claudio Djohnnatha Duarte Lourenco
	 * since 07/2013
	 */

function validaForm()
{
	/*
	 * Variaveis de acesso ao formulario 
	 * 
	 */
	
		var nomeEvento=form['form:nomeEvento'];
		var localEvento=form['form:localEvento'];
		var endereco=form['form:end'];
		var bairro=form['form:bairro'];
		var cidade=form['form:cidade'];
		var dataInicio=form['form:dataInicio'];
		var valor=form['form:preco'];
		var time=form['form:hora'];
		var horas=-1;
		var minutos=-1;
		
		
		
		
		
	/*FUNCOES DE VALIDACAO DE CAMPOS:*/
		
		/*Funcao que verifica se campo Nome do Evento estao vazio.*/
			
			if(nomeEvento.value.length == 0)
			{
				return false;
			}
			
		/*Funcao que verifica se o campo Local do Evento estao vazio*/
			
			if(localEvento.value.length == 0)
			{
				return false;
			}
			
		/*Funcao que verifica se o campo Endereco estao vazio*/
			if(endereco.value.length == 0)
			{
				return false;
			}
		
		/*Funcao que verifica se o campo bairro estao vazio*/
			if(bairro.value.length == 0)
			{
				return false;
			}
			
		/*Funcao que verifica se o campo cidade estao vazio*/	
			if(cidade.value.length == 0 )
			{
				return false;
			}
		
		/*Funcao que verifica se foi digitado no campo Data de Inicio*/
			if(dataInicio.value == "")
			{
				return false;
			}
			
			
		/*Funcoes para o campo hora*/
			
			/*Funcao que verifica se o campo hora do evento estao vazio*/
				if(hora.value.length == 0)
				{
					return false;
				}
				
				if(isNaN(hora.value))
				{
					return false;
				}
				
				if(time.value.length != 0)
				{
					
					/*Guarda o que foi digitado separando horas e minutos*/
					horas = parseInt(time.value.substr(0,2),10);
					minutos = parseInt(time.value.substr(3,5),10);
						
						alert("hora= " + horas + " minutos= " +minutos);
						
						
					/*Verifica o campo horas*/
						if(((horas.value < 0) && (horas.value > 23)) || ((minutos.value < 0) && (minutos.value > 59)) )
							{
								alert("Hora não foi digitado corretamente! hh:MM");
								return false;
							}
						
				}
			
			/*Funcaio que ira verificar se o campo horas foi digitado corretamente*/
			
		/*Funcoes para o campo Preco*/
			
			/*Funcao que verifica se campo valor estao vazio*/
				if(valor.value.length == 0)
				{
					return false;
				}
			/*Funcao que verifica se foi digitado sao numeros no campo Preco*/
				if (isNaN(valor.value)) {       
				       valor.select();    
				       return false;    
				}
				
			/*Funcao que verifica se foi digitado numeros*/
				if(isNaN(valor.value))
				{
					return false;
				}
				
			return true;
			
			
}
