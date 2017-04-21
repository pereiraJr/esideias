<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />
<div class="container page-content">
	<div class="row">
		<div class="col-xs-12 col-md-6">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Login</th>
						<th>editar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="u">
						<tr>
							<td>${u.nome}</td>
							<td>${u.email}</td>
							<td>${u.login}</td>
							<td><a href="<c:url value="/usuario/edita?login=${u.login}"/>">Editar</a></td>
			
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />