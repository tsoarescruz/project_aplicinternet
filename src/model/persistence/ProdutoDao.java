package model.persistence;

import java.sql.SQLException;

import model.entity.Produto;

public class ProdutoDao extends Dao{

/* Incluir o Produto */	
public boolean cadastrar(Produto p) throws Exception{
		boolean success = false;
		try{
			/* Abrir a conexão com o banco de dados*/
			open(); 
				
			/* Inserir os dados do produto na tabela PRODUTO */
			stmt = con.prepareStatement("insert into produto values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getCategoriaProduto());
			stmt.setString(3, p.getMarca());
			stmt.setString(4, p.getTamroupa1());
			stmt.setInt(5, p.getTamroupa2());
			stmt.setInt(6, p.getTamCalcado());
			stmt.setDouble(7, p.getValor());
			stmt.setDouble(8, p.getPercentualDesconto());
			stmt.setString(9, p.getParcelamento());
			stmt.setString(10, p.getDestaque());
			String data = UtilsBanco.converterDataToBanco(p.getDataInicioComercializacao());
			stmt.setString(11,data); 
			stmt.setLong(12, p.getQtdEstoque());	
			stmt.setString(13,p.getPathFoto1());
			stmt.setString(14,p.getPathFoto2());
			stmt.setString(15,p.getPathFoto3());
			stmt.setString(16,p.getPathFoto4());
						
			stmt.execute();
			success = true;
			
		}catch(SQLException e1){
			success = false;
			System.out.println("Código de Erro: " +e1.getErrorCode()+ "Mensagem de Erro =  "+e1.getMessage());
		}finally{
			close();
		}
		return success;
}

/* Consultar o Produto pelo Código */
public Produto buscarPorCodigo(Long codigo)throws Exception{
	Produto produto = null;
	try{
		open();
		
		stmt = con.prepareStatement("select * from produto where codigo = ?");
		stmt.setLong(1,codigo);
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			produto = new Produto(rs.getLong("codigo"), rs.getString("descricao"),
					rs.getInt("categoria"), rs.getString("marca"), rs.getString("tamroupa"),
					rs.getInt("ntamroupa"), rs.getInt("tamcalcado"), rs.getDouble("valor"),
					rs.getDouble("percdesconto"), rs.getString("parcelamento"), rs.getString("destaque"),
					UtilsBanco.converterDataBancoToGC(rs.getString("dtinicomerc")),
					rs.getLong("qtdestoque"), rs.getString("foto1"), rs.getString("foto2"),
					rs.getString("foto3"), rs.getString("foto4"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		close();
	}		
	return produto;
}


/* Alterar o Produto */	
public boolean alterar(Produto p) throws Exception{
		boolean success = false;
		try{
			/* Abrir a conexão com o banco de dados*/
			open(); 
		
			/* alterar os dados na tabela PRODUTO*/
			stmt = con.prepareStatement("update produto set descricao = ?, categoria = ?,"
					+ "marca = ?, tamroupa = ?, ntamroupa = ?, tamcalcado  = ?, valor  = ?, "
					+ "percdesconto = ?, parcelamento = ?, destaque = ?, dtinicomerc = ?, qtdestoque = ?,"
					+ "foto1 = ?, foto2  = ?, foto3  = ?, foto4  = ? where codigo = ?");
			
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getCategoriaProduto());
			stmt.setString(3, p.getMarca());
			stmt.setString(4, p.getTamroupa1());
			stmt.setInt(5, p.getTamroupa2());
			stmt.setInt(6, p.getTamCalcado());
			stmt.setDouble(7, p.getValor());
			stmt.setDouble(8, p.getPercentualDesconto());
			stmt.setString(9, p.getParcelamento());
			stmt.setString(10, p.getDestaque());
			stmt.setString(11,UtilsBanco.converterDataToBanco(p.getDataInicioComercializacao())); 
			stmt.setLong(12, p.getQtdEstoque());	
			stmt.setString(13,p.getPathFoto1());
			stmt.setString(14,p.getPathFoto2());
			stmt.setString(15,p.getPathFoto3());
			stmt.setString(16,p.getPathFoto4());
			stmt.setLong(17, p.getCodigo()); //COLOCAR CÓDIGO COMO UNEDIT NO FORM
						
			stmt.execute();
			success = true;
			
		}catch(SQLException e1){
			success = false;
			System.out.println("Código de Erro: " +e1.getErrorCode()+ "Mensagem de Erro =  "+e1.getMessage());
			
		}finally{
			close();
		}
		return success;
}

/* Excluir Produto */
public boolean excluir(Long codigo)throws Exception{
	boolean success = false;
	try{
		open();
		stmt = con.prepareStatement("delete from produto where codigo = ?");
		stmt.setLong(1, codigo);
		stmt.execute();
		success = true;
	}catch(SQLException e1){
		System.out.println("Código de Erro: " +e1.getErrorCode()+ "Mensagem de Erro =  "+e1.getMessage());
	}finally{
		close();
	}
	return success;
}

}
