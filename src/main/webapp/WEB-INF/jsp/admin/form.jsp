<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container page-content">
		<div class="row">
			<div class="col-xs-12 col-md-6">
				<form action="${linkTo[AdminController].adiciona(null)}" method="post">
					<h2>Cadastro banca</h2>
					<hr />
					<div class="form-group">
					    <label for="nome">Nome:</label>
					    <input type="text" id="nome" name="admin.nome" class="form-control" value="${usuario.nome}"/>
					    <alura:validationMessage name="admin.nome"/>
					</div>
					<div class="form-group">
					    <label for="email">E-mail:</label>
					    <input type="text" id="email" name="admin.email" class="form-control" value="${usuario.email}"/>
					    <alura:validationMessage name="admin.email"/>
					</div>
					<div class="form-group">
					    <label for="login">Login:</label>
					    <input type="text" id="login" name="admin.login" class="form-control" value="${usuario.login}"/>
					    <alura:validationMessage name="admin.login"/>
					</div>
					<div class="form-group">
					    <label for="senha">Senha:</label>
					    <input type="password" id="senha" name="admin.senha" class="form-control" />
					    <alura:validationMessage name="admin.senha"/>
					</div>
					    <input type="submit" value="Cadastrar" class="btn btn-primary"/>
				</form>
			</div>
			</div>
	</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>