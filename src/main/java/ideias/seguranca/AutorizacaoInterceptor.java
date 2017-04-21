package ideias.seguranca;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import ideias.controllers.LoginController;
import ideias.controllers.Open;

@Intercepts
public class AutorizacaoInterceptor {
    private ControllerMethod controllerMethod;
    private UsuarioLogado usuarioLogado;
    private Result result;
    public AutorizacaoInterceptor(){
    	this(null,null,null);
    }
    @Inject
    public AutorizacaoInterceptor(ControllerMethod controllerMethod, UsuarioLogado usuarioLogado, Result result){
        this.controllerMethod = controllerMethod;
        this.usuarioLogado = usuarioLogado;
        this.result = result;
    }
    
    @Accepts
    public boolean accepts(){
        return !controllerMethod.containsAnnotation(Open.class);
    }
    @AroundCall
    public void intercept(SimpleInterceptorStack stack){
        if(usuarioLogado.isLogado()){
            stack.next();
        }else{
            result.redirectTo(LoginController.class).form();
        }
    }
}