<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Produto</title>
</head>
<body>
<nav class="navbar navbar-light bg-light" >
  	<a class="navbar-brand" href="homeLista.jsp">Gerenciador de Produtos</a>
  	 <a class="nav-item nav-link" href="homeLista.jsp">Voltar a Listagem de Produtos</a>
	</nav>	

<form action="controller.do" method="post">
	<div class="alert alert-dark" role="alert">
  	${requestScope.mensagem}
	</div>
	
	<input type="hidden" name="command" value="CadastrarProduto"> 
  <div class="container-sm">
    <div class="col">
     <label>Código Produto</label>
      <input class="form-control" type="number"  name="id" placeholder="Código">
    </div>
    <div class="col">
     <label>Nome Produto</label>
      <input type="text" class="form-control" name="nome" placeholder="nome">
    </div>
     <div class="col">
      <label>Descrição do Produto</label>
      <input type="text" class="form-control" name="descricao" placeholder="Descrição">
    </div>
     <div class="col">
      <label>Valor do Produto</label>
      <input type="number" class="form-control"  step="0.1" name="valor"  placeholder="Valor">
    </div>
     <div class="col">
      <label>Quantidade do Produto</label>
      <input type="text" class="form-control"  name="estoque" placeholder="Quantidade">
    </div>
    
   <button class="btn btn-dark btn-block" type="submit">Cadastrar Produto</button>
    
  </div>
</form>


</body>
</html>