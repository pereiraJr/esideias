package ideias.seguranca;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import ideias.controllers.Admin;
import ideias.controllers.AdminController;
@Intercepts
public class AdminInterceptor {
    private ControllerMethod controllerMethod;
    private AdminLogado usuarioLogado;
    private Result result;
    public AdminInterceptor(){
    	this(null,null,null);
    }
    @Inject
    public AdminInterceptor(ControllerMethod controllerMethod, AdminLogado usuarioLogado, Result result){
        this.controllerMethod = controllerMethod;
        this.usuarioLogado = usuarioLogado;
        this.result = result;
    }
    
    @Accepts
    public boolean accepts(){
        return controllerMethod.containsAnnotation(Admin.class);
    }
    @AroundCall
    public void intercept(SimpleInterceptorStack stack){
        if(usuarioLogado.isLogado()){
            stack.next();
        }else{
            result.redirectTo(AdminController.class).form();
        }
    }
}

