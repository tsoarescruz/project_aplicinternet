package control;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Produto;
import model.persistence.ProdutoDao;
import model.persistence.UtilsBanco;

/**
 * Servlet implementation class ControleCliente
 */
//Servlet 3.0 aceita tanto com anotação quanto pelo web.xml.
@WebServlet({"/ControleProduto", "/jsp/cadproduto.html", 
		"/jsp/consultarproduto.html", "/jsp/altproduto.html", "/jsp/excluirproduto.html"})
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleProduto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); /* incluído na aula em substituição a: 
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); /* incluído na aula em substituição a: doGet(request, response);*/
	}
	
	/* método "execute" inserido na aula */
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//Pegar a URL que foi executada
			String url = request.getServletPath();
	        
			if(url.equalsIgnoreCase("/jsp/cadproduto.html")){
				cadastrar(request, response);
			}else if(url.equalsIgnoreCase("/jsp/consultarproduto.html")){
				consultar(request, response);
			}else if(url.equalsIgnoreCase("/jsp/altproduto.html")){
				alterar(request, response);
			}else if(url.equalsIgnoreCase("/jsp/excluirproduto.html")){
				excluir(request, response);				
			}else{
				response.sendRedirect("/");
			}
		}catch(Exception e){ 
			e.printStackTrace();
		}
	}

protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			/* Resgatar os dados do formulario: formProduto*/
			String descricao = request.getParameter("descrproduto");
			String categoria = request.getParameter("cbocategoria");
			String marca = request.getParameter("marca");
			String tamroupa = request.getParameter("cbotamanhoroupa");			
			String tamanhonum = request.getParameter("tamanhonum");
			if(tamanhonum.equals("")){tamanhonum = "0";} //para ajudar na conversão
			String tamanhocalcado = request.getParameter("tamanhocalcado");
			if(tamanhocalcado.equals("")){tamanhocalcado = "0";} //para ajudar na conversão
			String valor = request.getParameter("valorproduto");			
			String percdesconto = request.getParameter("percdesconto");			
			String pagtoparcelado = request.getParameter("pagtoparcelado");			
			String proddestaque = request.getParameter("proddestaque");					
			String qtdestoque = request.getParameter("qtdestoque");
			GregorianCalendar datainicomerc = UtilsBanco.converterData(request.getParameter("dataproduto"));
			String foto1 = request.getParameter("foto1");
			String foto2 = request.getParameter("foto2");
			String foto3 = request.getParameter("foto3");
			String foto4 = request.getParameter("foto4");
			
			Produto produto = new Produto();
			
			/* Hospedar os dados do Produto na Bean Produto*/
			produto.setDescricao(descricao);
			produto.setCategoriaProduto(new Integer(categoria));
			produto.setMarca(marca);
			produto.setTamroupa1(tamroupa);
			produto.setTamroupa2(new Integer(tamanhonum));
			produto.setTamCalcado(new Integer(tamanhocalcado));
			produto.setValor(new Double(UtilsBanco.prepararDouble(valor)));
			produto.setPercentualDesconto(new Double(UtilsBanco.prepararDouble(percdesconto)));
			produto.setParcelamento(pagtoparcelado);
			produto.setDestaque(proddestaque);
			produto.setQtdEstoque(new Long(qtdestoque));
			produto.setDataInicioComercializacao(datainicomerc);
			produto.setPathFoto1(foto1);			
			produto.setPathFoto2(foto2);
			produto.setPathFoto3(foto3);
			produto.setPathFoto4(foto4);
			
			/*OBS código do produto será */
				
			if(new ProdutoDao().cadastrar(produto)){
				request.setAttribute("msg", 
				"<div class='alert alert-success'>Produto cadastrado com sucesso</div>");
			}else{
				request.setAttribute("msg", 
				"<div class='alert alert-danger'>Produto já possui um cadastro no sistema</div>");
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", 
					"<div class='alert alert-danger'>Produto não cadastrado</div>");
		}finally{
			request.getRequestDispatcher("CadastrarProduto.jsp").forward(request, response);
		}
		
}

/* Consultar os dados de um Produto */
protected void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		/* Pegar o código digitado na tela */			
		Long codigo = new Long(request.getParameter("codconsulta"));
		
		/* Manter no campo codconsulta o valor buscado */
		request.setAttribute("codconsulta", codigo);
		
		/* Instanciar a classe DaoProduto */
		ProdutoDao pd = new ProdutoDao();
		
		/* Acionar o método da classe Dao Produto que retorna os dados de um produto a 
		 * partir do seu código*/
		Produto produto = pd.buscarPorCodigo(codigo);
	
		if(produto == null){ //produto não encontrado
			request.setAttribute("msg", "<div class='alert alert-warning'>Produto "
					+ " nao existente</div>");
			request.getRequestDispatcher("ConsultarProduto.jsp").forward(request, response);
		}else{
			request.setAttribute("p", produto);
			request.setAttribute("op", "C"); //operação = consulta
			request.getRequestDispatcher("CadastrarProduto.jsp").forward(request, response);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
}

protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		
		/* Resgatar os dados do formulario: formProduto*/
		String codigo = request.getParameter("codproduto");
		String descricao = request.getParameter("descrproduto");
		String categoria = request.getParameter("cbocategoria");
		String marca = request.getParameter("marca");
		String tamroupa = request.getParameter("cbotamanhoroupa");
		
		String tamanhonum = request.getParameter("tamanhonum");
		if(tamanhonum.equals("")){tamanhonum = "0";} //para ajudar na conversão
		String tamanhocalcado = request.getParameter("tamanhocalcado");
		if(tamanhocalcado.equals("")){tamanhocalcado = "0";} //para ajudar na conversão
		String valor = request.getParameter("valorproduto");
		String percdesconto = request.getParameter("percdesconto");			
		String pagtoparcelado = request.getParameter("pagtoparcelado");			
		String proddestaque = request.getParameter("proddestaque");					
		String qtdestoque = request.getParameter("qtdestoque");
		GregorianCalendar datainicomerc = UtilsBanco.converterData(request.getParameter("dataproduto"));
		String foto1 = request.getParameter("foto1");
		String foto2 = request.getParameter("foto2");
		String foto3 = request.getParameter("foto3");
		String foto4 = request.getParameter("foto4");
		
		Produto produto = new Produto();
		
		/* Hospedar os dados do Produto na Bean Produto*/
		produto.setCodigo(new Long(codigo));
		produto.setDescricao(descricao);
		produto.setCategoriaProduto(new Integer(categoria));
		produto.setMarca(marca);
		produto.setTamroupa1(tamroupa);
		produto.setTamroupa2(new Integer(tamanhonum));
		produto.setTamCalcado(new Integer(tamanhocalcado));
		produto.setValor(new Double(UtilsBanco.prepararDouble(valor)));
		produto.setPercentualDesconto(new Double(UtilsBanco.prepararDouble(percdesconto)));
		produto.setParcelamento(pagtoparcelado);
		produto.setDestaque(proddestaque);
		produto.setQtdEstoque(new Long(qtdestoque));
		produto.setDataInicioComercializacao(datainicomerc);
		produto.setPathFoto1(foto1);			
		produto.setPathFoto2(foto2);
		produto.setPathFoto3(foto3);
		produto.setPathFoto4(foto4);
		
		if(new ProdutoDao().alterar(produto)){
			request.setAttribute("msg", 
			"<div class='alert alert-success'>Produto alterado com sucesso</div>");
			/*Setar os dados no request para parmanecer com as informações na tela após o update*/
			request.setAttribute("p", produto);
			request.setAttribute("op", "C");
		}else{
			request.setAttribute("msg", 
			"<div class='alert alert-danger'>Erro ao alterar o produto.</div>");
		}
	}catch(Exception e){
		e.printStackTrace();
		request.setAttribute("msg", 
				"<div class='alert alert-danger'>Produto não cadastrado</div>");
	}finally{
		request.getRequestDispatcher("ConsultarProduto.jsp").forward(request, response);
	}
	
}

/* Listar Produtos */

/* Excluir Produto*/
protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		Long codigo = new Long(request.getParameter("codigo"));
		ProdutoDao pd = new ProdutoDao();
		Produto p = pd.buscarPorCodigo(codigo);
		
		if(p == null){
			request.setAttribute("msg", "<div class='alert alert-warning'>Produto "
					+ " não encontrado</div>");
		}else{
			if(pd.excluir(codigo)){
				request.setAttribute("msg", "<div class='alert alert-success'>Produto "
						+ " excluído com sucesso!</div>");
			}else{
				request.setAttribute("msg", "<div class='alert alert-danger'>Produto "
						+ " não excluido</div>");
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		request.getRequestDispatcher("ConsultarProduto.jsp").forward(request, response);
	}
}
	
}
