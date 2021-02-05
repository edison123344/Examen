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
	/**
	 * actualisa el estoc que tiene  el probedor 
	 * @param entity
	 * @throws Exception
	 */
	  public void actualizar(Provedor  entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Error actualizar " +e.getMessage());
	        }
	    }
	  /**
	   * listaa los probedores disponibles
	   * @return
	   */
	public List<Provedor> listaProvedor() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM provedor ",Provedor.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
	/**
	 * lista el provedor dependiendo el id provedor
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Provedor listar(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Provedor.class, id);
		} catch (Exception e) {
			throw new Exception("Erro listar provedor" + e.getMessage());
		}
	}
}
