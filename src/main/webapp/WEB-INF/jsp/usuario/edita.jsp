<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<div class="container page-content">
	<div class="row">
		<div class="col-xs-12 col-md-6">
			<form method="POST" action="${linkTo[UsuarioController].atualiza(null,null)}">
				<h2>Edite seus dados</h2>
				<hr />
				<div class="form-group">
					<label id="nome">Nome:</label>
					<input id ="nome" type="text" value="${u.nome}" name="nome" class="form-control"/>
				</div>
				<div class="form-group">
				    <label for="email">E-mail:</label>
				    <input type="text" id="email" name="usuario.email" class="form-control" value="${u.email}"/>
				    <alura:validationMessage name="usuario.email"/>
				</div>
				<div class="form-group">
				    <label for="login">Login:</label>
				    <input type="text" id="login" name="usuario.login" class="form-control" value="${u.login}"/>
				    <alura:validationMessage name="usuario.login"/>
				</div>
				<div class="form-group">
					<label id="senha">Nova Senha</label>
					<input type="password" value="" name="senha" class="form-control"/>
				</div>
				<c:if test="${u.isAluno()}">
				<div class="form-group">
					<label for="matricula">Matricula:</label>
				    <input type="text" id="matricula" value="${u.matricula}" name="usuario.matricula" class="form-control" />
				    <alura:validationMessage name="usuario.matricula"/>
				</div>
				</c:if>
				<button type="submit" name="_method" value="PUT" class="btn btn-primary">Atualizar</button>
			</form>
       	</div>
     </div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>