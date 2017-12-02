package persistence;

import java.sql.SQLException;
import java.util.GregorianCalendar;

import persistence.Cliente;

public class ClienteDao extends Dao{

/* 
 * Incluir o Cliente 
 */	
public boolean cadastrar(Cliente c) throws Exception{
		boolean success = false;
		try{
			/* 
			 * Abrir a conexao com o banco de dados
			 */
			open(); 
	
			/* 
			 * Retirar o auto commit 
			 */
			con.setAutoCommit(false);
	
			/* 
			 * Inserir uma parte dos dados na Tabela Cliente
			 */
			stmt = con.prepareStatement("insert into usuario values(?,?,?,?,?)");
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getSenha());
			stmt.setString(4,"CLI");
			/* 
			 * Data de Cadastro no Sistema 
			 */
			String dataCadastro = UtilsBanco.getDataHoraCorrente(); 
			stmt.setString(5,dataCadastro);
				
			stmt.execute();
			success = true;
			
			/* 
			 * Inserir a outra parte dos dados na Tabela Cliente
			 */
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
					System.out.println("Rollback efetuado na transa��o");
					con.rollback();
					success = false;
					System.out.println("Codigo de Erro: " +e1.getErrorCode()+
							"  Mensagem de Erro =  "+e1.getMessage());
				} catch(SQLException e2) {
					System.err.print("Erro na transacao!"+e2); 
				} 
			}
		}finally{
			close();
		}
		return success;
}

/* 
 * FALTAM OS METODOS ALTERAR E CONSULTAR
 */
}
