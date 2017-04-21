<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />
<div class="container page-content">
	<div class="row">
		<div class="col-xs-12 col-md-7">
			<h2>Submeta uma idéia</h2>
			<hr/>
			<form action="${linkTo[IdeiasController].adiciona(null)}" method="post">
				<div class="form-group">	
				  <label for="ideia" class="sr-only">Digite um título para sua idéia:</label>
				  <input class="form-control" id="ideia" name="ideia.titulo" placeholder="Digite um título para sua idéia"></input>
				</div>
				<div class="form-group">	
				  <label for="ideia" class="sr-only">Descreva sua idéia:</label>
				  <textarea class="form-control" rows="5" id="ideia" name="ideia.descricao" placeholder="Descreva sua idéia"></textarea>
				</div>
				<input type="submit" value="Envie sua idéia" class="btn btn-primary btn-block"/>
			</form>
		</div>
		<div class="col-xs-12 col-md-4 offset-md-1 current-theme">
			<h3>Frase do tema atual</h3>
			<hr/>
			<p><b>Detalhamento do tema atual</b> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur iaculis augue leo, et scelerisque lorem tincidunt vel. Vivamus finibus placerat sapien, nec vehicula turpis blandit ac. Nullam euismod ac orci sed blandit.</p>
		</div>
		<div class="col-xs-12 col-md-12 ideas-list">
			<h2>Minhas Ideias</h2>
			<hr/>
			<div class="row">
				<c:forEach items="${ideia}" var="i">
	  					<div class="col-sm-6 col-md-4 col-xs-12">
	  						 <div class="card">
	     						<div class="card-block">
	     							<h3 class="card-title text-truncate">${i.titulo}</h3>
							        <p class="card-text text-truncate">${i.descricao}</p>
							        <button data-toggle="modal" data-target="#detalhe_${i.id}" class="btn btn-primary">Detalhes</button>
	     						</div>
	     					</div>
	     					<div class="modal fade" id="detalhe_${i.id}" tabindex="-1" role="dialog" aria-labelledby="detalhe_${i.id}" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">${i.titulo}</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							        ${i.descricao}
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
							      </div>
    							</div>
							  </div>
							</div>
	  					</div>
  				</c:forEach>
  				<c:if test="${ideia.size() == 0}">
  					<div class="col-md-10 offset-md-1 col-xs-12">
						<div class="alert alert-warning" role="alert">
							<h4 class="alert-heading">Sem idéias!</h4>
		  					<p>Parece que você ainda não enviu nenhuma idéia. Não perca tempo e envie sua primeira usando o campo acima.</p>
						</div>
					</div>
				</c:if>
  			</div>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />