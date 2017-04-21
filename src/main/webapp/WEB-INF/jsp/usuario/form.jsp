<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container page-content">
		<div class="row">
			<div class="col-xs-12 col-md-6">
				<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">
					<h2>Inscreva-se</h2>
					<hr />
					<div class="form-group">
					    <label for="nome">Nome:</label>
					    <input type="text" id="nome" name="usuario.nome" class="form-control" value="${usuario.nome}"/>
					    <alura:validationMessage name="usuario.nome"/>
					</div>
					<div class="form-group">
					    <label for="email">E-mail:</label>
					    <input type="text" id="email" name="usuario.email" class="form-control" value="${usuario.email}"/>
					    <alura:validationMessage name="usuario.email"/>
					</div>
					<div class="form-group">
					    <label for="login">Login:</label>
					    <input type="text" id="login" name="usuario.login" class="form-control" value="${usuario.login}"/>
					    <alura:validationMessage name="usuario.login"/>
					</div>
					<div class="form-group">
					    <label for="senha">Senha:</label>
					    <input type="password" id="senha" name="usuario.senha" class="form-control" />
					    <alura:validationMessage name="usuario.senha"/>
					</div>
					<div class="form-group">
						<div class="form-check">
						    <label class="form-check-label" for="aluno_ucsal">
						    	<input type="checkbox" id="aluno_ucsal" name="usuario.aluno" class="form-check-input" />
						    	Sou aluno UCSAL
						    </label>
						    <alura:validationMessage name="usuario.aluno"/>
						</div>
					</div>
					<div class="collapse form-group" id="matricula-div">
						<label for="matricula">Matricula:</label>
					    <input type="text" id="matricula" name="usuario.matricula" class="form-control" />
					    <alura:validationMessage name="usuario.matricula"/>
					</div>
				    <input type="submit" value="Cadastrar" class="btn btn-primary"/>
				</form>
			</div>
			<div class="col-xs-12 col-md-6">
				<h2>Lorem Ipsum</h2>
				<hr />
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sit amet purus imperdiet, finibus justo nec, faucibus dolor. Vivamus faucibus posuere felis vel vulputate. Nam volutpat mollis nunc, eget viverra nisl porttitor vitae. Proin iaculis leo non euismod finibus. Suspendisse pretium pharetra semper. Sed et ex massa. Aliquam erat volutpat. Aliquam id sapien vitae felis facilisis molestie. Fusce pharetra erat a nunc posuere placerat. Etiam aliquam varius velit, quis gravida elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
			</div>
		</div>
	</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>