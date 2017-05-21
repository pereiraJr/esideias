package ideias.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ideias.models.Admin;
import ideias.models.Avaliacao;
import ideias.models.Ideias;
import ideias.models.Usuario;

@RequestScoped
public class AdminDAO {
	private EntityManager manager;
	@Inject
    public AdminDAO(EntityManager manager){
        this.manager = manager;
    }
    public AdminDAO(){
    	
    }
    public void adicionar(Admin admin){
        manager.getTransaction().begin();
        manager.persist(admin);
        manager.getTransaction().commit();
    }
	public Admin buscaPorUsuario(Admin usuario) {
		String jpql = "Select a from Admin a where a = :pusuario";
		TypedQuery<Admin> query = manager.createQuery(jpql,Admin.class);
		query.setParameter("pusuario", usuario);
		return query.getSingleResult();
	}
	public List<Ideias> lista (Admin admin){
		String jpql = "Select i from Ideias i";
		TypedQuery<Ideias> createQuery = manager.createQuery(jpql,Ideias.class);

			return createQuery.getResultList();
	}
	public List<Ideias> listaJaavaliado (Admin admin){
		String jpql = "Select i from Ideias i join fetch i.avaliacao join i.avaliacao a  join a.admin admin where admin= :pAdmin";
		TypedQuery<Ideias> createQuery = manager.createQuery(jpql,Ideias.class);
		createQuery.setParameter("pAdmin", admin);
			return createQuery.getResultList();
	}
		public Admin usuarioPorLogineSenha(String login,String Senha){
	String jpql = "Select a from Admin a where a.login= :plogin and a.senha= :pSenha";
	TypedQuery<Admin> query = manager.createQuery(jpql,Admin.class);
	query.setParameter("pSenha",Senha);
	query.setParameter("plogin",login);
		return query.getSingleResult();
	}
		public void criarAvaliacao(Avaliacao avaliacao) {
			 manager.getTransaction().begin();
		        manager.persist(avaliacao);
		        manager.getTransaction().commit();
		    	
		}

}
