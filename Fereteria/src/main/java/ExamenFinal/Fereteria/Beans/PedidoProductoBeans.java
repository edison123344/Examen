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
	private int Unidades;
	private Fereteria fereteria;
	@PostConstruct
	public void init()  {
		listaProductos();
		
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUnidades() {
		return Unidades;
	}

	public void setUnidades(int unidades) {
		Unidades = unidades;
	}

	public String cargarDatosEditar() throws Exception {
		if(id!=0) {
			
		gestionfereteriaON.datosAteriores(id);
			
		}
		return "";
	}
	public void listaProductos() {
		productos=gestionfereteriaON.ListaFereteria();
	}
	public String GuardarActualisacion() throws Exception {
		Fereteria actualisado=new Fereteria();
		Fereteria anterior = fereteria;
		anterior=gestionfereteriaON.datosAteriores(id);

		actualisado.setStok(Unidades+anterior.getStok());
	
		gestionfereteriaON.actualisarProductos(actualisado);

		return "AsitentePolizaListar";
	}
}
