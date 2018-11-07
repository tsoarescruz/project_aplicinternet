drop database if exists pharmacia;

create database pharmacia;

use pharmacia;

create table usuario(
email varchar(50) primary key, 
nome varchar(50) not null,
senha varchar(20) not null, /*senha - colocar criptografia*/
perfil char(3) not null, /* CLI, FUN, ADM*/ 
dtncadastro timestamp
);

create table Cliente(
cpf bigint primary key,
id_email varchar(50) not null,
nome varchar(20),
telefone varchar(15),
celular varchar(15),
dtnasc date,
cep varchar(10),
endereco varchar(50),
numero int,
complemento varchar (50),
bairro varchar(25),
cidade varchar(25),
estado varchar(2),
inf_ref varchar(50),  
sexo enum('M', 'F', 'O'),
foreign key (id_email) references usuario (email)
);

create table Produto(
codigo int auto_increment primary key,
nome varchar(20),
preco double(10,2) not null,
dtcadastro date,
dtvalidade date,
destaque enum('S','N'),
dtninicomerc date,
qtdestoque int,

constraint pk_produto primary key (codigo),
foreign key (id_email) references usuario (email),
);

create table Pedido(
id_pedido auto_increment,
cpf bigint,
preco_venda double,
dtn_pedido date,

constraint pk_venda, id_pedido primary key (id_venda),
constraint fg_venda_cliente foreign key (cpf) references Cliente(cpf)

foreign key (cpf) references usuario (cliente),
);

create table Item_venda(
id_item_venda int,
id_pedido int,
cpf int,
id_venda int,

data_venda  datetime,

constraint pk_pedido primary key (id_pedido),

constraint fk_cpf foreign key(cpf) 
references Cliente(cpf),

constraint fk_id_venda foreign key(id_venda) references Venda(id_venda),

create table Venda(
id_venda int,
id_item_venda int,
id_pedido int,
data_venda  datetime,

constraint pk_id_venda primary key (id_venda),

constraint fk_id_item_venda foreign key(id_venda) 
references Item_venda(id_item_venda),

constraint fk_id_pedido foreign key(id_pedido) 
references Pedido(id_pedido),

constraint fk_item_venda foreign key(id_venda) references Venda(id_venda),
