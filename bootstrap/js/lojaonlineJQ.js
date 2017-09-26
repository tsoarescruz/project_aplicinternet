/*Funções Java Script para o formulário - com Jquery*/

/*
 * A função LOAD abaixo pode também ser escrita das seguintes formas:
 * 
 * jquery(document).ready(function(){
 *      //faça alguma coisa
 * });
 * ou
 * 
 * $(document).ready(function(){
 *      //faça alguma coisa
 * });
 *
 *  OBS: caracter $ é utilizado como um modo bem curto de dizer jquery.
 *  Ou seja, $("p") é o mesmo que jquery("p").
 *   
 */

/*Comandos que serão executados com a página for carregada*/
$(function() {
  	
    /* Ação do botão voltar */
    $(".btvoltar").click(function(){window.location.href='indexBS.jsp';});
    $(".btvoltarcons").click(function(){window.location.href='ConsultarClienteBS.jsp';}); 
    /***********************************************************************/
    
    /* Sumir com todas as medidas*/
    $("#cbotamanhoroupa").hide(); $("#tamanhonum").hide(); $("#tamanhocalcado").hide(); 
    
        
    /*Máscara dos campos com Jquery - biblioteca JQUERY- MASKED INPUT*/ 
    $(".data").mask("99/99/9999");
    $("#telefone").mask("(99) 9999-9999");
    $("#celular").mask("(99) 99999-9999");
    $("#cpf").mask("999.999.999-99");
    $("#cep").mask("99.999-999");
    //$(".hora").mask("99:99");
    $(".sonums").mask("9?99"); //depois da interrogação é tudo opcional
    $(".2dignum").mask("99");
    $(".percentual").mask("9?9%");
    
    /*Jquery UI para exibição de calendário*/
    $( "#datanascimento" ).datepicker({
    	dateFormat: 'dd/mm/yy', /*formato Brasil*/
    	showOn: "button",
        buttonImage: "../js/jquery-ui-1.11.4.custom/images/calendar.gif",
        buttonImageOnly: true,
        buttonText: "Select date"
    });    
    
    /* Máscara dos campos com valor monetário - biblioteca JQUERY MASK MONEY */
    $(".dinheiro").maskMoney({showSymbol:true, symbol:"R$ ", decimal:",", thousands:"."});   
    
    /*
     * FONT: https://github.com/plentz/jquery-maskmoney
     * showSymbol: deverá mostrar o símbolo monetário? (Padrão: false)
     * symbol: qual o símbolo? (US$, R$, etc) (Padrão: US$)
     * decimal: qual sinal para decimal? ( Nos EUA é ponto(.) e no Brasil é vírgula(,) )
     * thousands: qual sinal para casa de milhar? (Nos EUA é vírgula(,) e no Brasil é ponto(.))
     * precision: qual o nível de precisão? (Padrão: 2)
     * defaultZero: 0 por padrão (true ou false) (Padrão: true)
     * allowZero: permitir 0 (Padrão: false)
     * allowNegative: permitir valores negativos (Padrão: false)  
     * */
    
    
    /*Regras de validação dos campos do form CLIENTE - biblioteca JQUERY VALIDATION*/
    $("#formcliente").validate({ //usa o name dos campos do form
        rules: {
            //email:{required: true, email:true},
            nome:{required: true, minlength: 4},
            senha:{required:true, minlength: 6},
            confirmasenha:{required:true, minlength: 6, equalTo:"#senha"},
            rbsexo:{required:true},
            cpf:{required: true},
            dtnasc:{required: true, dateBR:true},
            telefone:{required: true},            
            celular:{required: false},                        
            cbocategoria:{required: true},
            cep:{required:true},
            endereco:{required:true},
            numero:{required:true, minlength: 3},
            complemento:{required:false},
            bairro:{required:true},
            cidade:{required:true},
            cboestado:{required:true},
            inforef:{required:true}            
        },
    
        messages: {
        	email:{required: "Informe o Email", email:"Email inválido"},
        	nome:{required: "Informe o nome", 
                minlength:"Informe ao menos 4 caracteres"},            
            senha:{required: "Informe uma senha", 
                    minlength:"Informe uma senha com ao menos 6 dígitos"},
            confirmasenha:{required: "Informe a confirmação da senha", 
                        minlength:"Informe uma confirmação de senha com ao menos 6 dígitos",
                        equalTo:"As senhas informadas não conferem."},
            rbsexo:{required: "Informe o sexo"},
            cpf:{required: "Informe o número do CPF"},
            dtnasc:{required: "Informe a data de nascimento", dateBR:"Informe uma data de nascimento válida "},
            telefone:{required: "Informe o telefone"},            
            cbocategoria:{required: "Informe o tipo de endereço"},
            cep:{required: "Informe o CEP"},                        
            endereco:{required: "Informe o Endereco"},
            numero:{required: "Informe o Número"},
            bairro:{required: "Informe o Bairro"},
            cidade:{required: "Informe a Cidade"},
            cboestado:{required: "Informe a UF"},
            inforef:{required:"Informe dados de referência do endereço"}            
        },
    
        //Monta a mensagem em uma caixa separada
        errorLabelContainer: $("#mensagens"),
        errorElement: "li"
    });
 
   //Fazer as validacoes iguais ao de produto, com os campos
    $("#formfornecedor").validate({
        rules: {

        	cnpj:{required: true, minlength: 6},
        	email:{required: true},
        	nome:{required: true},
        	dtcadastro:{required: true, dateBR:true},
        	telefone:{required: true},
            celular:{required: true},
            cep:{required: true},
        	endereco:{required: true},
        	numero:{required: true},
        	bairro:{required: true},
        	cidade:{required: true},
        	cboestado:{required: true},
        	cbocategoria:{required: false},
        },

        messages: {
        	cnpj:{required: "Informe um CNPJ válido",
        				  minlength:"Informe um CNPJ com pelo menos 6 caracteres" },
        	email:{required: "Informe um E-mail válido"},
        	nome:{required: "Informe um Nome Fantasia válido"},
        	dtcadastro:{required: "Informe a data de início de cadastro do fornecedor",
        				dateBR:"Informe uma data válida"},


        	telefone:{required: "Informe um número de telefone válido"},
        	celular:{required: "Informe um número de celular válido"},

        	cep:{required: "Informe um número de CEP válido",
        	            minlength:"Informe um CEP com pelo menos 8 caracteres" },
        	endereco:{required: "Informe um Endereço válido"},
        	numero:{required: "Informe um Número válido"},
        	bairro:{required: "Informe um Bairro"},
        	cidade:{required: "Informe uma Cidade"},
        	cboestado:{required: "Informe um Estado"},
        },
            //Monta a mensagem em uma caixa separada
        errorLabelContainer: $("#mensagens"),
        errorElement: "li"
    });
    /*Regras de validação dos campos do form PRODUTO - biblioteca JQUERY VALIDATION*/
    $("#formproduto").validate({
        rules: {            
        	descrproduto:{required: true, minlength: 6},
        	cbocategoria:{required: true},
        	marca:{required: true},
        	cbotamanhoroupa:{required: true},
        	tamanhonum:{required: true},
        	tamanhosapato:{required: true},        	
        	valorproduto:{required: true},
        	percdesconto:{required: false},
        	pagtoparcelado:{required: true},
        	proddestaque:{required: false},
        	dataproduto:{required: true, dateBR:true},
        	qtdestoque:{required: true}                        
        },
    
        messages: {        	
        	descrproduto:{required: "Informe a descrição do produto",
        				  minlength:"Informe uma descrição com ao menos 6 caracteres" },
        	cbocategoria:{required: "Informe a categoria do produto"},
        	marca:{required: "Informe a marca do produto"},
        	cbotamanhoroupa:{required: "Informe o tamanho da roupa"},
        	tamanhonum:{required: "Informe o tamanho da roupa"},
        	tamanhosapato:{required: "Informe o tamanho do sapato"},
        	valorproduto:{required: "Informe o valor do produto"},        	
        	pagtoparcelado:{required: "Informe se o pagamento será parcelado"},
        	dataproduto:{required: "Informe a data de início de comercialização do produto",
        				dateBR:"Informe uma data válida"},
        	qtdestoque:{required: "Informe a quantidade em estoque"}        	
        },
    
        //Monta a mensagem em uma caixa separada
        errorLabelContainer: $("#mensagens"),
        errorElement: "li"
    });
    
    
    /* Exibir tipos de tamanho, conforme a categoria do produto */
    $("#cbocategoria").change(function(){    	
    	var categoria = $("#cbocategoria").val();
    	
    	if((categoria === "1")||(categoria === "5")){ //Camisa ou Saia
    		$("#cbotamanhoroupa").show(); $("#tamanhonum").hide(); $("#tamanhocalcado").hide();
    		$("#idtamnum").val(""); $("#idtamcalcado").val(""); 
    	}
    	else if((categoria === "2")||(categoria === "3")||(categoria === "4")){ //Calça Short Bermuda
    		$("#cbotamanhoroupa").hide(); $("#tamanhonum").show(); $("#tamanhocalcado").hide();
    		$("#idtamroupa").val(""); $("#idtamcalcado").val("");
    	}
    	else if(categoria === "6"){ //Calçado
    		$("#cbotamanhoroupa").hide(); $("#tamanhonum").hide(); $("#tamanhocalcado").show(); 
    		$("#idtamroupa").val(""); $("#idtamnum").val("");
    	}    	
    	/* A função Jquery "toggle" mostra se estava escondido ou esconde se estava sendo exibido*/
    });
    
    $("#cbocategoria").trigger("change"); /* OBS: COLOCADO PARA FAZER UM GATILHO COM O EVENTO CHANGE 
    QUANDO A PÁGINA FOR CARREGADA PELA CONSULTA - OBJETIVO DE EXBIR O TAMANHO*/
    
    /*Limpar campos de um form quando o usuário clicar no botão Limpar */    
    $(".btlimpar").click(function(){
    	$('form').each (function(){
    		  this.reset();
    	});
    });
    
    
}); //FUNÇÃO LOAD
