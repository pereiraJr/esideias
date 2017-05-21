</main>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/js/jquery.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" type="text/javascript"></script>
<script type="text/javascript"> 
			
            $('#aluno_ucsal').change(function(e){
                if(e.target.checked){
                	$('#matricula-div').collapse('show')
                }else{
                	$('#matricula-div').collapse('hide')
                }
            })
            
        
</script>
</body>
</html>