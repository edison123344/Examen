package ExamenFinal.Fereteria.Services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ExamenFinal.Fereteria.DAO.ProvedorDAO;
import ExamenFinal.Fereteria.Modelo.Provedor;
import ExamenFinal.Fereteria.On.GestionProvedorON;


/**
 * clase que listara el contenido de los provedores
 * @author edison
 *
 */
@Path("Provedores")
public class ProvedoresREST {
	private GestionProvedorON gestionProvedorON;
	/**
	 * lista el producurto del provedor segun su clave
	 * @param codigo
	 * @return
	 * @throws Exception 
	 */
	 @GET
	    @Path("listarPrvedores")
	    @Produces("application/json")
	    public Provedor listarSaldo(@QueryParam("Codigo") int codigo) throws Exception {
	    	return gestionProvedorON.ListarProvedorCodigo(codigo);
	    }
}
