package ideias.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import ideias.daos.AdminDAO;
import ideias.daos.IdeiaDAO;
import ideias.models.Admin;
import ideias.models.Avaliacao;
import ideias.models.Ideias;
import ideias.seguranca.AdminLogado;
import ideias.seguranca.UsuarioLogado;

@Controller
public class AdminController {

	private AdminDAO dao;
	private AdminLogado logado;
	private Result result;
	private Validator validator;
	private IdeiaDAO ideiaDAO;
	private Avaliacao avaliacao;

	public AdminController() {
		this(null, null, null, null, null, null);
	}

	@Inject
	public AdminController(Avaliacao avaliacao, AdminLogado logado, AdminDAO dao, Result result, Validator validator,
			IdeiaDAO ideiaDAO) {
		this.dao = dao;
		this.result = result;
		this.avaliacao = avaliacao;
		this.validator = validator;
		this.logado = logado;
		this.ideiaDAO = ideiaDAO;
	}

	@Open
	@Path("/admin")
	public void index() {

	}
	@ideias.controllers.Admin
	@Open
	public void lista() {
		List<Ideias> retorno = new ArrayList<>();
		List<Ideias> ideias = dao.lista(logado.getAdmin());
		List<Ideias> avaliado = dao.listaJaavaliado(logado.getAdmin());
		boolean existe = false;
		for (Ideias i : ideias) {
			existe = avaliado.contains(i);
			if (!existe) {
				retorno.add(i);
			}
		}

		result.include("ideia", retorno);
		result.include("avaliado", avaliado);
	}
	@ideias.controllers.Admin
	@Get
	@Open
	public void gostei(Integer ideia) {
		Ideias retorno = ideiaDAO.buscaPorID(ideia);
		avaliacao.setIdeias(retorno);

		avaliacao.setAdmin(logado.getAdmin());
		avaliacao.setGostou(true);
		retorno.getAvaliacao().add(avaliacao);
		ideiaDAO.atualiza(retorno);
		dao.criarAvaliacao(avaliacao);
		result.redirectTo(this).lista();
	}
	@ideias.controllers.Admin
	@Get
	@Open
	public void naogostei(Integer ideia) {

		Ideias retorno = ideiaDAO.buscaPorID(ideia);

		avaliacao.setAdmin(logado.getAdmin());
		avaliacao.setGostou(false);
		retorno.getAvaliacao().add(avaliacao);

		ideiaDAO.adiciona(retorno);
		result.redirectTo(this).lista();
	}

	@Open

	public void form() {

	}

	@IncludeParameters
	@Post
	@Open
	public void adiciona(@Valid Admin admin) {
		validator.onErrorRedirectTo(this).form();
		dao.adicionar(admin);
		logado.fazlogin(admin);
		result.redirectTo(this).index();

	}
	
	@Open
	public void autentica(String Login, String Senha) {
		Admin usuario = null;
		try {
			usuario = dao.usuarioPorLogineSenha(Login, Senha);
		} catch (NoResultException e) {
			validator.add(new SimpleMessage("login_invalido", "Login ou senha invalidos"));
			validator.onErrorForwardTo(this).form();
		}
		logado.fazlogin(usuario);
		result.redirectTo(this).lista();
	}

}
