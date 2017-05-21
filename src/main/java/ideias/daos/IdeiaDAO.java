package ideias.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ideias.models.Avaliacao;
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
	    public Ideias buscaPorID(Integer id){
	    	TypedQuery<Ideias> createQuery = manager.createQuery("Select i from Ideias i where i.id=:pId",Ideias.class);
	    	createQuery.setParameter("pId", id);
	    	return createQuery.getSingleResult();
	    }
	    public void adiciona(Ideias ideia){
	        manager.getTransaction().begin();
	        manager.persist(ideia);
	        manager.getTransaction().commit();
	    }
	    public void atualiza(Ideias ideia){
	    manager.persist(ideia);
	    }
		public List<Ideias> buscaPorUsuario(Usuario usuario) {
			String jpql = "Select i from Ideias i where i.usuario = :pusuario";
			TypedQuery<Ideias> query = manager.createQuery(jpql,Ideias.class);
			query.setParameter("pusuario", usuario);
			return query.getResultList();
		}
		public List<Ideias> lista (){
			String jpql = "Select i from Ideias i ";
			TypedQuery<Ideias> createQuery = manager.createQuery(jpql,Ideias.class);
		
				return createQuery.getResultList();
		}
	   
}
