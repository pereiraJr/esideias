package ideias.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ideias.models.Usuario;

@RequestScoped
public class UsuarioDAO {
	private EntityManager manager;

	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	public UsuarioDAO() {

	}

	public void adicionar(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}

	public List<Usuario> lista() {
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	public Usuario autenticarLogineSenha(String login, String senha) {
		String jpql = "select u from Usuario u where u.senha=:pSenha and u.login=:pLogin";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("pSenha", senha);
		query.setParameter("pLogin", login);

		return query.getSingleResult();
	}

	public Usuario usuarioPorLogin(String login) {
		String jpql = "Select u from Usuario u where u.login= :plogin";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("plogin", login);
		return query.getSingleResult();
	}

	public void editar(Usuario u, Usuario usuario) {
		Usuario merge = manager.merge(u);
		merge.setNome(usuario.getNome());
		merge.setSenha(usuario.getSenha());
		manager.getTransaction().begin();
		manager.persist(merge);
		manager.getTransaction().commit();
	}
	
	
}