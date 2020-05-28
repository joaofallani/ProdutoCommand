<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>    
<%@ page import="model.Produto"%>
<%@ page import="service.ProdutoService"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
<meta charset="utf-8">
<title>Editar Produto</title>
</head>
<body>
<nav class="navbar navbar-light bg-light" >
  	<a class="navbar-brand" href="homeLista.jsp">Gerenciador de Produtos</a>
  	 <a class="nav-item nav-link" href="addProduto.jsp">Cadastrar Produto</a>
	</nav>	
	
	<%
	Produto p = new Produto();
	ProdutoService produtoService = new ProdutoService(); 
	int id = Integer.parseInt(request.getParameter("id"));	
	p = produtoService.buscarProduto(id);	
	%>

<form action="controller.do" method="post">
	<div class="alert alert-dark" role="alert">
  	${requestScope.mensagem}
	</div>
	<input type="hidden" name="command" value="AlterarProduto"> 
  <div class="form-group">
    <div class="col">
     <label>Código Produto</label>
      <input class="form-control" type="number"  name="id" placeholder="ID Produto"  value= <%=p.getId()%>>
    </div>
    <div class="col">
     <label>Nome Produto</label>
      <input type="text" class="form-control" name="nome" placeholder="nome"  value= <%=p.getNomeProduto()%>>
    </div>
     <div class="col">
      <label>Descrição do Produto</label>
      <input type="text" class="form-control" name="descricao" placeholder="Descrição"  value= <%= p.getDescricao() %>>
    </div>
     <div class="col">
      <label>Valor do Produto</label>
      <input type="number" class="form-control"  step="0.1" name="valor"  placeholder="Valor"  value= <%=p.getPreco()%>>
    </div>
     <div class="col">
      <label>Quantidade do Produto</label>
      <input type="text" class="form-control"  name="estoque" placeholder="Quantidade"  value= <%= p.getEstoque() %>>
    </div>
    
   <button class="btn btn-dark btn-block" type="submit">Editar Produto</button>
    
  </div>
</form>


</body>
</html>