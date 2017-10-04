drop database if exists lojaonline;


create database lojaonline;

use lojaonline;

create table usuario(
email varchar(50) primary key,
nome_cliente varchar(20) not null,
senha varchar (20) not null,
perfil char(3) not null,
datcadastro timestamp
)

//desc usuario;

create table Cliente(
cpf bigint primary key,
id_email varchar(50) not null,
nome varchar(20),
telefone varchar(15),
celular varchar(15),
dtnnasc date,
endereco varchar(50),
numero int,
complemento varchar (50),
bairro varchar(25),
cidade varchar(25),
estado varchar(2),
inf_ref varchar(50),  
sexo enum('M', 'F', 'O'),
dtnascimento date,
foreign key (id_email) references usuario (email))

create table Produto(
codigo int auto_increment primary key,
descricao varchar(100),
categoria int,
marca varchar(40),
nome varhcar(20),
preco float,
constraint pk_produto primary key (id_produto)
)

create table Entregador(
id_entregador int,
cpf_entregador varchar(15),
nome_entregador varchar(20),
disponivel tinyint,
constraint pk_entregador primary key(id_entregador)
)

create table Venda(
id_venda int,
id_cliente int,
preco_venda float,
constraint pk_venda primary key (id_venda),
constraint fg_venda_cliente foreign key (id_cliente) references Cliente(id_cliente)
)

create table iten_venda(
id_registro int,
id_cliente int,
id_venda int,
id_entregador int,
data_registro  datetime,
constraint pk_registro primary key (id_registro),
constraint fg_registro_cliente foreign key(id_cliente) references Cliente(id_cliente),
constraint fg_registro_venda foreign key(id_venda) references Venda(id_venda),
constraint fg_registro_entregador foreign key(id_entregador) references Entregador(id_entregador)
