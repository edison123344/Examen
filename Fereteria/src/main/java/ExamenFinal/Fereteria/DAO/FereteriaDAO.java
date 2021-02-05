package ExamenFinal.Fereteria.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ExamenFinal.Fereteria.Modelo.Fereteria;


/**
 * clase donde se listara y actualisara los productos de la fereteria
 * @author edison
 *
 */

@Stateless
public class FereteriaDAO {
	@PersistenceContext
	private EntityManager em;
	
	  public void actualizar(Fereteria  entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Error actualizar " +e.getMessage());
	        }
	    }
	public List<Fereteria> listaProducto() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM Fereteria ",Fereteria.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
}
