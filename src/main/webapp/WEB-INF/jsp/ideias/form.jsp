<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<form action="${linkTo[IdeiasController].adiciona(null)}" method="post">
<div class="form-group">

  <label for="ideia">Crie sua ideia:</label>
  <textarea class="form-control" rows="5" id="ideia" name="ideia.ideia"></textarea>
     <input type="submit" value="Criar ideia" class="btn"/>
</div>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp"/>