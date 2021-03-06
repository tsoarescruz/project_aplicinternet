/*
Funções Java Script para o formulário - com Jquery
*/

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

/*
Comandos que serão executados com a página for carregada
*/

$(function() {
  	
    /*
    Ação do botão voltar
    */
    $(".btvoltar").click(function(){window.location.href='indexBS.jsp';});
    $(".btvoltarcons").click(function(){window.location.href='ConsultarClienteBS.jsp';}); 

    /*
    Máscara dos campos com Jquery - Biblioteca Jquery Masked Input
    */
    $("#cnpj").mask("99.999.999/9999-99");
    $("#lote").mask("99.999.999-9");
    $(".data").mask("99/99/9999");
    $("#telefone").mask("(99) 9999-9999");
    $("#celular").mask("(99) 99999-9999");
    $("#cpf").mask("999.999.999-99");
    $("#cep").mask("99.999-999");
    //$(".hora").mask("99:99");
    $(".sonums").mask("9?99"); //depois da interrogação é tudo opcional
    $(".2dignum").mask("99");
    $(".percentual").mask("9?9%");
    
    /*
    Jquery UI para exibição de calendario
    */
    $( "#datanascimento" ).datepicker({
    	dateFormat: 'dd/mm/yy', /*formato Brasil*/
    	showOn: "button",
        buttonImage: "../js/jquery-ui-1.11.4.custom/images/calendar.gif",
        buttonImageOnly: true,
        buttonText: "Select date"
    });    
    
    /*
    Máscara dos campos com valor monetário - Biblioteca Jquery Mask Money
    */
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
    
    
    /*
    Regras de validação dos campos do form Cliente - Biblioteca Jquery Validation
    */
    $("#formcliente").validate({
        rules: {
            email:{required: false},
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
            dtnasc:{required: "Informe a data de nascimento", dateBR:"Informe uma data de nascimento válida"},
            telefone:{required: "Informe o telefone"},            
            cbocategoria:{required: "Informe o tipo de endereço"},
            cep:{required: "Informe o CEP"},                        
            endereco:{required: "Informe o endereco"},
            numero:{required: "Informe o Número"},
            bairro:{required: "Informe o Bairro"},
            cidade:{required: "Informe a Cidade"},
            cboestado:{required: "Informe a UF"},
            inforef:{required:"Informe dados de referência do endereço"}            
        },
    
        /*
        Monta a mensagem em uma caixa separada
        */
        errorLabelContainer: $("#mensagens"),
        errorElement: "li"
    });
 
    /*
    Regras de validação dos campos do form Fornecedor - Biblioteca Jquery Validation
    */
    $("#formfornecedor").validate({
        rules: {

        	cnpj:{required: true, minlength: 6},
        	email:{required: false},
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

    /*
    Regras de validação dos campos do form Produto - Biblioteca Jquery Validation
    */
    $("#formproduto").validate({
        rules: {

        	lote:{required: true, minlength: 6},
        	email:{required: false},
        	nome:{required: true},
        	dtvalidade:{required: true, dateBR:true},
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
        	lote:{required: "Informe um Lote válido",
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
    
    
    /*
    Exibir tipos de tamanho, conforme a categoria do produto
    */

    /*
    Este metodo aqui nao esta sendo usado, porem pode ser utilizado para poder fazer o load com JSP
    */
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
    
    $("#cbocategoria").trigger("change");
    /*
    Obs: colocado para fazer um gatilho com o evento change
    quando a página for carregada pela consulta - objetivo de exbir o tamanho
    */
    
    /*
    Limpar campos de um form quando o usuário clicar no botão Limpar
    */
    $(".btnlimpar").click(function(){
    	$('form').each (function(){
    		  this.reset();
    	});
    });
    
    
});
/*
Funcao Load
*/
