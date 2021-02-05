package ExamenFinal.Fereteria.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ExamenFinal.Fereteria.Modelo.Fereteria;
import ExamenFinal.Fereteria.Modelo.Provedor;


/**
 * clase donde se listara y actualisara los productos de la fereteria
 * @author edison
 *
 */

@Stateless
public class FereteriaDAO {
	@PersistenceContext
	private EntityManager em;
	/**\
	 * actualiza el estok de los productos de la fereteria
	 * @param entity
	 * @throws Exception
	 */
	  public void actualizar(Fereteria  entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Error actualizar " +e.getMessage());
	        }
	    }
	  /**
	   * lista los datos aser actualizados
	   * @param id
	   * @return
	   * @throws Exception
	   */
	  public Fereteria listarAnterior(int id) throws Exception {
			try {
				System.out.println("Estamos aca");
				return em.find(Fereteria.class, id);
			} catch (Exception e) {
				throw new Exception("Erro listar provedor" + e.getMessage());
			}
		}
	  /**
	   * lista todos los productos de fereteria
	   * @return
	   */
	public List<Fereteria> listaProducto() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM Fereteria ",Fereteria.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
}
