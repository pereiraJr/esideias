<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<form action="${linkTo[AdminController].autentica(null,null)}" method="post">
    <alura:validationMessage name="login_invalido"/>

    <label for="Login">Login:</label>
    <input type="text" id="Login" name="Login" class="form-control"/>
    <label for="Senha">Senha:</label>
    <input type="password" id="Senha" name="Senha" class="form-control"/>
    <input type="submit" value="Autenticar" class="btn"/>
</form>
				<a href="${linkTo[AdminController].form()}">Criar Administrador.</a>

<c:import url="/WEB-INF/jsp/footer.jsp"/>