package ExamenFinal.Fereteria.On;
/**
 * clase que controla el pedido y actualisasion de los pedidos 
 * @author edison
 *
 */

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ExamenFinal.Fereteria.DAO.FereteriaDAO;
import ExamenFinal.Fereteria.Modelo.Fereteria;

@Stateless
public class GestionFereteriaON {
	@Inject
	private FereteriaDAO fereteriaDAO;

	public void actualisarProductos(Fereteria fereteria) throws Exception {
		fereteriaDAO.actualizar(fereteria);
	}

	public List<Fereteria>ListaFereteria(){
		return fereteriaDAO.listaProducto();
	}

}
