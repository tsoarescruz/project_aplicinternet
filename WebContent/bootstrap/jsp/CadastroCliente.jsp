<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ****** Incluído para a tela de consulta ******* -->
<%@ page import="view.UtilsTela" %>   
<!-- *********************************************** -->
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">

    <title>Pharmácia</title>

 <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/shop-homepage.css" rel="stylesheet">

      <!-- LINK PARA A BIBLIOTECA JQUERY -->
	<script src="../js/jquery-2.1.4.min.js" type="text/javascript"></script>

	<!--LINK PARA O JQUERY MASKED INPUT -->
    <script src="../js/jquery-maskedinput/src/jquery.maskedinput.js" type="text/javascript"></script>

    <!--LINK PARA O JQUERY VALIDATION -->
    <script src="../js/jquery-validation/jquery.validate.js" type="text/javascript"></script>

    <!--LINK PARA O JQUERY MASK MONEY -->
    <script src="../js/jquery-maskmoney/jquery.maskmoney.js" type="text/javascript"></script>

    <!--LINK PARA O JQUERY-UI - CALENDARIO - Fonte: https://jqueryui.com/ -->
    <link rel="stylesheet" href="../js/jquery-ui-1.11.4.custom/jquery-ui.css">
    <script src="../js/jquery-ui-1.11.4.custom/jquery-ui.min.js" type="text/javascript"></script>
  	<script src="../js/jquery-ui-1.11.4.custom/jquery-ui.js" type="text/javascript"></script>

	<!-- LINK PARA O ARQUIVO JAVA SCRIPT DO PROJETO -->
	<script src="../js/lojaonlineJQ.js"></script>

  </head>
  <body>
<div id="main" class="container"> <!-- CONTAINER BS -->

<hr>
	<div id="mensagens">
	${msg } <!-- INSERIDO NA AULA DE BACKEND -->	
	</div>
<hr>

<!-- ************************ JSTL -tela de consulta***************** -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- Não usado -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Não usado -->
<!-- **************************************************************** -->

<!-- **** adaptar form de cadastro para a alteraçao ******************-->
<c:set var="url" value="cadcliente.html" />
<c:set var="btenviar" value="Enviar" />

<c:if test="${op eq 'C'}">
	<c:set var="url" value="altcliente.html" />
	<c:set var="btenviar" value="Alterar Cliente" />
</c:if>
<!-- ***************************************************************** -->

 <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Pharmácia</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="../index.html">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../jsp/Sobre.html">Sobre</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Cadastro
              </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  
                  <a class="dropdown-item" href="../jsp/CadastroCliente.html">Clientes</a>
                  <a class="dropdown-item" href="../jsp/CadastroFornecedores.html">Fornecedores</a>
				  <a class="dropdown-item" href="../jsp/CadastroFuncionarios.html">FuncionÃ¡rios</a>
				  <a class="dropdown-item" href="../jsp/CadastroProdutoS.html">Produtos</a>
				
				</div>
            </li>
          </ul>
        </div>
      </div>
    </nav>

<!-- Page Content -->

<section id="main" class="container">
	<form name="formcliente" id="formcliente" action="" method="post">

			<fieldset>
				<legend class="control-label">Dados do Cliente</legend>

				<div class="row">
					<div class="form-group col-md-12 col-sm-12">
						<label for="inputdefault">E-mail:</label>
						<!--&lt;!&ndash; USANDO HTML 5.0 para o tipo email - problema para personalizar mensagens de erro &ndash;&gt;-->
						<!--<input type="email" class="form-control" name="email" maxlength="30" size="30" placeholder="usuario@meudominio.com" required-->
							<!--pattern=â[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$â title="Informe um e-mail vÃ¡lido" />-->

                      <div class="input-group">
                        <input type="email" class="form-control" name="email" id=email maxlength="30" size="30" placeholder="usuario@example.com" aria-describedby="basic-addon2" value="${c.email}">
                        <span class="input-group-addon" id="basic-addon2">@example.com</span>
                      </div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12 col-sm-12">
						<label for="inputdefault">Nome Completo*:</label>
						<input type="text" class="form-control" name="nome" id="nome" maxlength="50" size="50" value="${c.nome}"/>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-4 col-sm-4">
						<label>Sexo*:</label><br>
						<div class="form-check form-check-inline">
							<label for="inputdefault">
								<input class="form-check-input" type="radio" name="rbsexo" value="M" 
								<c:if test= "${(c.sexo eq 'M')}">
   									checked="checked"	
   								</c:if>
   								/>Masculino		
								<input type="radio" name="rbsexo" value="F" 
								<c:if test="${(c.sexo eq 'F')}">
   									checked="checked"	
   								</c:if>
								/>Feminino
						</div>
					</div>

					<div class="form-group col-md-4 col-sm-4">
						<label for="cpf">CPF*:</label>
						<input type="text" id="cpf" class="form-control" name="cpf" maxlength="14" value="${c.cpf}"/>
					</div>

					<!--Ver a data no exemplo do professor e se o datapicker pode ser usado aqui  -->
                    <div class='col-md-4 col-sm-4'>
						<label for="datanascimento">Data de Nascimento*:</label>
							<div class="input-group date">
								<input id="dtnasc" type="text" class="form-control">
							</div>
					</div>
					<script>
						$('#dtnasc').datepicker({
							format: 'dd/mm/yyyy',
							startDate: '-3d'
						});
					</script>
				</div>

              <div class="row">

                    <div class="form-group col-md-4 col-sm-3">
                        <label for="pwd">Senha:</label>
                        <input type="password" id="senha" class="form-control" name="senha" maxlength="8" size="8" />
                    </div>

					<div class="form-group col-md-4 col-sm-3">
						<label for="pwd">Confirmar Senha*:</label>
						<input type="password" id="confirmasenha" class="form-control" name="confirmasenha" maxlength="8" size="8"/>
					</div>
              </div>

				<div class="row">
					<div class="form-group col-md-4 col-sm-6">
						<label for="telcontato">Telefone para Contato*:</label>
						<input type="text" id="telefone" class="form-control" name="telefone" maxlength="14"/>
					</div>

					<div class="form-group col-md-4 col-sm-6">
						<label for="telcelular">Celular(opcional):</label>
						<input type="text" id="celular" class="form-control" name="celular" maxlength="15"/>
					</div>
				</div>

              <fieldset>
                <legend class="control-label">Dados de EndereÃ§o</legend>
                  <div class="row">
                      <div class="form-group col-md-8 col-sm-8">
                          <label for="cbocategoria">Tipo de EndereÃ§o*:</label>
                          <select name="cbocategoria" id=cbocategoria class="form-control">
                              <option value="0"> </option>
                              <option value="1">Casa</option>
                              <option value="2">Apartamento</option>
                              <option value="3">Comercial</option>
                              <option value="4">Outros</option>
                          </select>
                      </div>
                      <div class="form-group col-md-4 col-sm-4">
                          <label for="cep">CEP*:</label>
                          <input type="text" id="cep" class="form-control" name="cep" id="cep" maxlength="10" size="10" />
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-8 col-sm-8">
                          <label for="endereco">EndereÃ§o*:</label>
                          <input type="text" class="form-control" name="endereco" id="endereco" maxlength="50" size="50" />
                      </div>

                      <div class="form-group col-md-4 col-sm-4">
                          <label for="numero">NÃºmero*:</label>
                          <input type="text" class="form-control sonums" name="numero" id="numeroendereco" maxlength="3" size="3" />
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-12 col-sm-12">
                          <label for="enderecocomplemento">Complemento(opcional):</label>
                          <input type="text" class="form-control" name="complemento" id="complemento"maxlength="50" size="50" />
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-4 col-sm-4">
                          <label for="bairro">Bairro*:</label>
                          <input type="text" class="form-control" name="bairro" id="bairro" maxlength="25" size="25" />
                      </div>

                      <div class="form-group col-md-4 col-sm-4">
                          <label for="cidade">Cidade*:</label>
                          <input type="text" class="form-control" name="cidade" id="cidade" maxlength="25" size="25" />
                      </div>

                        <div class="form-group col-md-4 col-sm-4">
                          <label for="estado">Estado*:</label>
                            <select name="cboestado" id="cboestado" class="form-control">
                              <option value="" ></option>
                              <option value="ac">AC</option>
                              <option value="al">AL</option>
                              <option value="ap">AP</option>
                              <option value="am">AM</option>
                              <option value="ba">BA</option>
                              <option value="ce">CE</option>
                              <option value="df">DF</option>
                              <option value="es">ES</option>
                              <option value="go">GO</option>
                              <option value="ma">MA</option>
                              <option value="mt">MT</option>
                              <option value="ms">MS</option>
                              <option value="mg">MG</option>
                              <option value="pa">PA</option>
                              <option value="pb">PB</option>
                              <option value="pr">PR</option>
                              <option value="pe">PE</option>
                              <option value="pi">PI</option>
                              <option value="rj">RJ</option>
                              <option value="rn">RN</option>
                              <option value="rs">RS</option>
                              <option value="ro">RO</option>
                              <option value="rr">RR</option>
                              <option value="sc">SC</option>
                              <option value="sp">SP</option>
                              <option value="se">SE</option>
                              <option value="to">TO</option>
                            </select>
                        </div>
                      </div>

                  <div class="row">
                      <div class="form-group col-md-12 col-sm-12">
                          <label for="infreferencia">InformaÃ§Ãµes de ReferÃªncia*:</label>
                          <input type="text" class="form-control" name="inforef" maxlength="50" size="50" />
                      </div>
                  </div>
              </fieldset>

            <!-- SeparaÃ§Ã£o btn -->
            <div class="row">
                  <div class="form-group col-md-12 col-sm-12">

                  </div>
            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <input type="submit" id="btenviarcliente" value="Enviar" class="btn btn-primary" />
                    <input type="button" class="btn btn-default btnlimpar" value="Limpar" />
                    <input type="button" class="btn btn-default btnvoltar" value="Voltar" />
                </div>
            </div>

               <!-- SeparaÃ§Ã£o do Footer -->
                <div class="row">
                      <div class="form-group col-md-12 col-sm-12">

                      </div>
                </div>

			</fieldset>
		</form>

		</section>

	</section>

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright Â© PharmÃ¡cia 2017</p>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/popper/popper.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>
