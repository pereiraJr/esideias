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
			<c:forEach items="${ideiasOrd}" var="i">
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