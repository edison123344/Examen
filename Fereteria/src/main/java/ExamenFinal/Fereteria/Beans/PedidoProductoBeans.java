package ExamenFinal.Fereteria.Beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import ExamenFinal.Fereteria.Modelo.Fereteria;
import ExamenFinal.Fereteria.Modelo.Provedor;
import ExamenFinal.Fereteria.On.GestionFereteriaON;
import ExamenFinal.Fereteria.On.GestionProvedorON;

/**
 * clase que ara la parte de listado de probedore y productos y pedido de producto 
 * @author edison
 *
 */
@Named
@SessionScoped
public class PedidoProductoBeans implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionProvedorON gestionProvedorON;
	
	@Inject
	private GestionFereteriaON gestionfereteriaON;
	private int id;//recolector
	private List<Fereteria>productos;
	
	@PostConstruct
	public void init()  {
		listaProvedores();
		
	}
	
	public List<Fereteria> getProductos() {
		return productos;
	}

	public void setProductos(List<Fereteria> productos) {
		this.productos = productos;
	}

	public String Solisitud(int id ) {
		return "Pedido?faces-redirect=true&id="+id;
	}
	public String cargarDatosEditar() throws Exception {
		if(id!=0) {
		//	polisa=asistenteON.buscar(idPoliza);
		}
		return "";
	}
	public void listaProvedores() {
		productos=gestionfereteriaON.ListaFereteria();
	}
}
