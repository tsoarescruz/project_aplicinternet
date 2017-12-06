package model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	//Gerenciar a conexao com o banco de dados
	Connection con;
	//Manipular as querys no banco de dados (executar as querys)
	PreparedStatement stmt;
	//Manipular o resultado da consulta (select)
	ResultSet rs;

	//URL de conexao com o banco
	private final String URL = "jdbc:mysql://localhost:3306/lojaonline";
	private final String USER = "root";//usuario do banco de dados
	private final String PASS = "050181";//Senha do banco
	
	protected void open()throws Exception{
		//Carregar o Driver de conexao com o mysql
		Class.forName("com.mysql.jdbc.Driver");
		//Abrir a conexao com o banco de dados
		con = DriverManager.getConnection(URL, USER, PASS);
	}
	
	protected void close()throws Exception{
		//Fechar a conexaoc om o banco
		con.close();
	}
	
}
