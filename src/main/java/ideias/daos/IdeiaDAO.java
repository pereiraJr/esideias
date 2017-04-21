package ideias.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ideias.models.Ideias;
import ideias.models.Usuario;
@RequestScoped
public class IdeiaDAO {
	 private EntityManager manager;
	    
	    @Inject
	    public IdeiaDAO(EntityManager manager){
	        this.manager = manager;
	    }
	    public IdeiaDAO(){
	    	
	    }
	    public void adiciona(Ideias ideia){
	        manager.getTransaction().begin();
	        manager.persist(ideia);
	        manager.getTransaction().commit();
	    }
		public List<Ideias> buscaPorUsuario(Usuario usuario) {
			String jpql = "Select i from Ideias i where i.usuario = :pusuario";
			TypedQuery<Ideias> query = manager.createQuery(jpql,Ideias.class);
			query.setParameter("pusuario", usuario);
			return query.getResultList();
		}
	   
}
