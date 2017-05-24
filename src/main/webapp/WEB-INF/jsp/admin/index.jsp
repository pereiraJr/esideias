<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<div class="container page-content">
	<div class="row">
		<div class="col-xs-12 col-md-4 offset-md-4">
			<form action="${linkTo[AdminController].autentica(null,null)}" method="post">
				<h2>Acesso da banca</h2>
				<hr />
				<div class="form-group">
				    <label for="Login">Login:</label>
				    <input type="text" id="Login" name="Login" class="form-control"/>
			   	</div>
			   	<div class="form-group">
				    <label for="Senha">Senha:</label>
				    <input type="password" id="Senha" name="Senha" class="form-control"/>
				</div>
				<div class="form-group">
				    <input type="submit" value="Autenticar" class="btn"/>
				    <alura:validationMessage name="login_invalido"/>
				</div>
			</form>
			<!-- <a href="${linkTo[AdminController].form()}">Criar Administrador</a> -->
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>