<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<title>User CRUD - Listagem</title>
	</head>
	<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="CreateAndFind">Lista de Usuarios</a>
          </li>
        </ul>
        <form action="CreateAndFind" method="get" class="d-flex" role="search">
          <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o nome ou CPF" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Buscar</button>
        </form>
      </div>
    </div>
    </nav>
    <br>
    <div class="container">
      <div class="row">
        <div class="cold-md-7">
            <hr>
            <h3>Usuarios Cadastrados</h3>  
            <hr>
            
            <table class="table">
            	<thead>
	            	<tr>
	            		<th>Id</th>
	            		<th>Nome</th>
	            		<th>CPF</th>
	            		<th>Nascimento</th>
	            		<th>Situacao</th>
	            	</tr>
            	</thead>
            	<tbody>
            		<c:forEach items="${users}" var="user">
            			<tr>
            				<td>${user.id}</td>
            				<td>${user.nome}</td>
            				<td>${user.cpf}</td>
            				<td>${user.nascimento}</td>
            				<td>${user.situacao}</td>
            				<td>
            					<a href="UserDelete?id=${user.id}">Deletar</a>
            					<a href="UserUpdate?id=${user.id}">Alterar</a>
            				</td>
            			</tr>
            		</c:forEach>
            	</tbody>
            </table>
            <h5><a href="index.jsp">Voltar para o Cadastro de Usuários</a></h5>
        </div>
      </div>
    </div >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>