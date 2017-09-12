<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="container page-content">

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Data</th>
				<th>Nota</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ideiasTab}" var="i">
				<tr>
					<td>${i.id}</td>
					<td>${i.titulo}</td>
					<td>${i.date}</td>
					<td>${i.nota}</td>
					<c:if test="${vota}">
						<td><a
							href="<c:url value="/admin/votar?ideia=${i.id}&nota=3"/>"><button>3</button></a>
							<a href="<c:url value="/admin/votar?ideia=${i.id}&nota=5"/>"><button>5</button></a>
							<a href="<c:url value="/admin/votar?ideia=${i.id}&nota=7"/>"><button>7</button></a>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<c:if test="${!vota}"> Você atingiu sem limite de votos </c:if>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Data</th>
				<th>Nota</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${avaliadoTab}" var="i">
				<tr>
					<td>${i.id}</td>
					<td>${i.titulo}</td>
					<td>${i.date}</td>
					<td>${i.nota}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />
