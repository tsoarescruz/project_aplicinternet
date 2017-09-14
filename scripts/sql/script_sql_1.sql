create table Cliente(
id_cliente int,
cpf_cliente varchar(15),
nome_cliente varchar(20),
telefone_cliente varchar(10),
endereco_cliente varchar(25),
sexo_cliente     varchar(10),
constraint pk_cliente primary key (id_cliente)
)

create table Produto(
id_produto int,
nome_produto varhcar(20),
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

create table registro(
id_registro int,
id_cliente int,
id_venda int,
id_entregador int,
data_registro  datetime,
constraint pk_registro primary key (id_registro),
constraint fg_registro_cliente foreign key(id_cliente) references Cliente(id_cliente),
constraint fg_registro_venda foreign key(id_venda) references Venda(id_venda),
constraint fg_registro_entregador foreign key(id_entregador) references Entregador(id_entregador)