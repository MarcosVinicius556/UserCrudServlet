<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>User CRUD - Atualizar Usuário</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
            <h3>Atualizar Usuario</h3>  
            <hr>
            <form action="UserUpdate" method="post">
              <input value="${user.id}" name="id" disabled="disabled">
              <div class="form-floating mb-3">
                  <input value="${user.nome}" name="nome" maxlength="40" type="text" class="form-control" id="floatingInput1"> 
                  <label>Nome completo</label>
                </div>
                <div class="form-floating mb-3">
                  <input value="${user.cpf}" name="cpf" maxlength="11" type="text" class="form-control"> 
                  <label>CPF (apenas nÃºmeros)</label>
                </div>
                <div class="form-floating mb-3">
                  <input value="${user.nascimento}" name="nascimento" type="date" class="form-control" placeholder="Nascimento">
                  <label>Nascimento</label>
                </div>
                <select name="situacao" class="form-select mb-3" aria-label="Default select example">
                  <option value="Inativo" selected>-- Selecione uma opção</option>
                  <option value="Ativo">Ativo</option>
                  <option value="Inativo">Inativo</option>
                </select>
      
                <button class="btn btn-success" type="submit">Atualizar Usuario</button>
                <button class="btn btn-secondary" type="reset">Limpar
                  Formulario</button>
            </form>
            <br />
        </div>
      </div>
    </div >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>