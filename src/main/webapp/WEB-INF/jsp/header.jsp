<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value='/css/bootstrap/bootstrap.min.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
<link href="<c:url value='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ideias</title>
</head>
<body>
	<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#top-nav-bar" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
  		</button>
	    <a class="navbar-brand" href="#">ESIdeias</a>
		<div class="collapse navbar-collapse" id="top-nav-bar">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="${linkTo[IndexController].index()}">Home</a></li>
				
				<c:if test="${usuarioLogado.logado}">
				<li class="nav-item"><a class="nav-link" href="${linkTo[IdeiasController].lista()}">Minhas Ideias</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/usuario/edita?login=${usuarioLogado.getLoginAtivo()}"/>">Meus dados</a></li>
				<li class="nav-item"><a class="nav-link" href="${linkTo[LoginController].desloga()}">Sair</a></li>
				</c:if>
				<c:if test="${!usuarioLogado.logado}">
					<li class="nav-item"><a class="nav-link" href="${linkTo[LoginController].form()}">Acessar conta</a></li>
					<li class="nav-item"><a class="nav-link" href="${linkTo[UsuarioController].form()}">Cadastro</a></li>
				</c:if>
			</ul>
		</div>

	</nav>
	<main> <!-- conteudo -->