<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container page-content">
		<div class="row">
			<div class="col-xs-12 col-md-6">
				<form action="${linkTo[LoginController].autentica(null,null)}" method="post">
					<h2>Acesse sua conta</h2>
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
					    <input type="submit" value="Autenticar" class="btn btn-primary"/>
					    <alura:validationMessage name="login_invalido"/>
					 </div>
				</form>
				<a href="${linkTo[UsuarioController].form()}">Não tem acesso? Cadastre-se aqui.</a>
			</div>
			<div class="col-xs-12 col-md-6">
				<h2>Lorem Ipsum</h2>
				<hr />
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sit amet purus imperdiet, finibus justo nec, faucibus dolor. Vivamus faucibus posuere felis vel vulputate. Nam volutpat mollis nunc, eget viverra nisl porttitor vitae. Proin iaculis leo non euismod finibus. Suspendisse pretium pharetra semper. Sed et ex massa. Aliquam erat volutpat. Aliquam id sapien vitae felis facilisis molestie. Fusce pharetra erat a nunc posuere placerat. Etiam aliquam varius velit, quis gravida elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
			</div>
		</div>
	</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>