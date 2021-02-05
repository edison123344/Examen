package ExamenFinal.Fereteria.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ExamenFinal.Fereteria.Modelo.Provedor;

@Stateless
public class ProvedorDAO {
	@PersistenceContext
	private EntityManager em;
	
	  public void actualizar(Provedor  entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Error actualizar " +e.getMessage());
	        }
	    }
	public List<Provedor> listaProvedor() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM provedor ",Provedor.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
	public Provedor listar(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Provedor.class, id);
		} catch (Exception e) {
			throw new Exception("Erro listar provedor" + e.getMessage());
		}
	}
}
