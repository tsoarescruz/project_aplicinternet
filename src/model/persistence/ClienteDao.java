package model.persistence;

import java.sql.SQLException;
import java.util.GregorianCalendar;

import model.entity.Cliente;

public class ClienteDao extends Dao{

/* Incluir o Cliente */	
public boolean cadastrar(Cliente c) throws Exception{
		boolean success = false;
		try{
			/* Abrir a conexão com o banco de dados*/
			open(); 
	
			/* Retirar o auto commit */
			con.setAutoCommit(false);
	
			/* Inserir uma parte dos dados na Tabela USUARIO*/
			stmt = con.prepareStatement("insert into usuario values(?,?,?,?,?)");
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getSenha());
			stmt.setString(4,"CLI");
			/* Data do Cadastramento no Sistema */
			String dataCadastro = UtilsBanco.getDataHoraCorrente(); 
			stmt.setString(5,dataCadastro);
				
			stmt.execute();
			success = true;
			
			/* Inserir a outra parte dos dados na Tabela CLIENTE*/
			stmt = con.prepareStatement("insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setLong(1,c.getCpf());
			stmt.setString(2, c.getEmail());
			//String data = UtilsBanco.ConverterDataToBanco(c.getDtNasc());
			stmt.setString(3,UtilsBanco.converterDataToBanco(c.getDtNasc()));
			stmt.setString(4, c.getSexo());
			stmt.setString(5, c.getTelefone());
			stmt.setString(6, c.getCelular());
			stmt.setInt(7, c.getTpEndereco());
			stmt.setString(8, c.getCep());
			stmt.setString(9, c.getEndereco());
			stmt.setInt(10, c.getNumero());
			stmt.setString(11, c.getComplemento());
			stmt.setString(12, c.getBairro());
			stmt.setString(13, c.getCidade());	
			stmt.setString(14, c.getEstado());
			stmt.setString(15, c.getInfref());			
			stmt.execute();
			success = true;
			con.commit();
			
		}catch(SQLException e1){
			if (con != null){
				try { 
					System.out.println("Rollback efetuado na transação");
					con.rollback();
					success = false;
					System.out.println("Código de Erro: " +e1.getErrorCode()+
							"  Mensagem de Erro =  "+e1.getMessage());
				} catch(SQLException e2) {
					System.err.print("Erro na transação!"+e2); 
				} 
			}
		}finally{
			close();
		}
		return success;
}

/* Consultar o cliente pelo CPF */
public Cliente buscarPorCpf(Long cpf)throws Exception{
	Cliente cliente = null;
	try{
		open();
		
		//Junçao das tabelas Usuário e Cliente
		stmt = con.prepareStatement("select * from usuario,cliente "
				+ "where cliente.cpf = ? and usuario.email = cliente.id_email" );
		stmt.setLong(1,cpf);
		rs = stmt.executeQuery();
		if(rs.next()){
			
			cliente = new Cliente(rs.getString("email"),rs.getString("nome"),
					rs.getString("senha"),rs.getString("perfil"),
					UtilsBanco.converterTSBancoToGC(rs.getTimestamp("dtcadastro")),
					rs.getLong("cpf"), UtilsBanco.converterDataBancoToGC(rs.getString("dtnasc")), 
					rs.getString("sexo"), rs.getString("telefone"), rs.getString("celular"),
					rs.getInt("tpendereco"), rs.getString("cep"), rs.getString("endereco"),
					rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"),
					rs.getString("cidade"), rs.getString("estado"),rs.getString("infref"));	
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		close();
	}		
	return cliente;
}


/* Alterar o Cliente */	
public boolean alterar(Cliente c) throws Exception{
		boolean success = false;
		try{
			/* Abrir a conexão com o banco de dados*/
			open(); 
	
			/* Retirar o auto commit */
			con.setAutoCommit(false);
			
			/* Alterar os dados na Tabela USUARIO*/
			stmt = con.prepareStatement("update usuario set nome = ?,senha = ?,"
					+ "perfil = ?,dtcadastro = ? where email = ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getSenha());
			stmt.setString(3,"CLI");
			/* Data do Cadastramento no Sistema */
			String dataCadastro = UtilsBanco.getDataHoraCorrente(); 
			stmt.setString(4,dataCadastro);
			stmt.setString(5, c.getEmail());
			
			stmt.execute();
			success = true;
			
			/* Inserir a outra parte dos dados na Tabela CLIENTE*/
			stmt = con.prepareStatement("update cliente set cpf = ?, dtnasc = ?,"
					+ "sexo = ?, telefone = ?, celular = ?, tpendereco = ?, cep = ?, endereco = ?,"
					+ "numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, infref = ?"
					+ "where id_email = ?");
			
			stmt.setLong(1,c.getCpf());			
			stmt.setString(2,UtilsBanco.converterDataToBanco(c.getDtNasc()));
			stmt.setString(3, c.getSexo());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getCelular());
			stmt.setInt(6, c.getTpEndereco());
			stmt.setString(7, c.getCep());
			stmt.setString(8, c.getEndereco());
			stmt.setInt(9, c.getNumero());
			stmt.setString(10, c.getComplemento());
			stmt.setString(11, c.getBairro());
			stmt.setString(12, c.getCidade());	
			stmt.setString(13, c.getEstado());
			stmt.setString(14, c.getInfref());			
			stmt.setString(15, c.getEmail());
			stmt.execute();
			success = true;
			con.commit();
			
		}catch(SQLException e1){
			if (con != null){
				try { 
					System.out.println("Rollback efetuado na transação");
					con.rollback();
					success = false;
					System.out.println("Código de Erro: " +e1.getErrorCode()+
							"  Mensagem de Erro =  "+e1.getMessage());
				} catch(SQLException e2) {
					System.err.print("Erro na transação!"+e2); 
				} 
			}
		}finally{
			close();
		}
		return success;
}

}
