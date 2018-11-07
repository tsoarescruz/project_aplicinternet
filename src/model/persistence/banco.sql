/* Roteiro
 * Falta consulta alterar e excluir cliente
 * Listar tabela com dados produto (resumo) e abrir em detalhes todos os dados
 * Falta altera��o nos dados do usu�rio/cliente
 * Falta exclus�o (como vou fazer isso?)
 * colocar senha criptografada com md5 no banco
 * 
 * Fazer o Manter produto
 * 
 * Montar a tela de pedido
 * TEMA para carrinho de compras no bootstrap
 * http://blog.neweb.co/Top-10-temas-de-inicializa%C3%A7%C3%A3o-ecommerce/?lang=pt
 * 
 * 
 * https://www.caelum.com.br/apostila-vraptor-hibernate/criando-o-carrinho-de-compras/#13-1-o-modelo-do-carrinho
 * MATERIAL muito bom : http://docente.ifrn.edu.br/fellipealeixo/disciplinas/tads-2012/desenvolvimento-de-sistemas-web
 * 
 * 
 * C�digo de banco 1062 - primary key j� existe
 * 
 * */

drop database if exists lojaonline;

create database lojaonline;

use lojaonline;

create table usuario(
	email varchar(50) primary key, 
	nome varchar(50) not null,
	senha varchar(20) not null, /*senha - colocar criptografia*/
	perfil char(3) not null, /* CLI, FUN, ADM*/ 
	dtcadastro timestamp
);
desc usuario;

create table cliente(
	cpf bigint primary key,	
	id_email varchar(50) not null, 
	dtnasc date,
	sexo enum('M','F'),
	telefone varchar(15),
	celular varchar(15),
	tpendereco int,
	cep varchar(10),
	endereco varchar(50),
	numero int,
	complemento varchar(50),
	bairro varchar(25),
	cidade varchar(25),
	estado varchar(2),		
	infref varchar(50),
	foreign key(id_email) references usuario(email)
);
desc cliente;

create table produto(
	codigo int auto_increment primary key,
	descricao varchar(100),
	categoria int,
	marca varchar(40),
	tamroupa varchar(3),
	ntamroupa int,
	tamcalcado int,
	valor double(10,2) not null,
	percdesconto double(3,1),
	parcelamento enum('S','N'),
	destaque enum('S','N'),
	dtinicomerc date,
	qtdestoque int,
	foto1 varchar(50),
	foto2 varchar(50),
	foto3 varchar(50),
	foto4 varchar(50)
);	
desc produto;