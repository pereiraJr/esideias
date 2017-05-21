<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />
<div class="container page-content">
	<div class="row">
		<div class="col-xs-12 col-md-7">
			<hr/>
			<h1> Não avaliado</h1>
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
							        <a class="nav-link" href="<c:url value="/admin/gostei?ideia=${i.id}"/>">Gostei</a>
							    	 <a class="nav-link" href="<c:url value="/admin/naogostei?ideia=${i.id}"/>">Não Gostei</a>
							        
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
							      </div>
    							</div>
							  </div>
							</div>
	  					</div>
	  					
	  				  			</c:forEach>
	  				  						<h1> Já avaliado</h1>
	  				  			
  				<c:forEach items="${avaliado}" var="i">
			
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
  		
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />