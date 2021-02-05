package ExamenFinal.Fereteria.Beans;

import java.io.Serializable;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import ExamenFinal.Fereteria.Modelo.Provedor;

import ExamenFinal.Fereteria.On.GestionProvedorON;

/**
 * clase que ara la parte de listado de probedore y productos y pedido de producto 
 * @author edison
 *
 */
@Named
@SessionScoped
public class ProvedorBeans implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionProvedorON gestionProvedorON;
	
	
	private Provedor provedores;
	
	public Provedor getProvedores() {
		return provedores;
	}

	public void setProvedores(Provedor provedores) {
		this.provedores = provedores;
	}

	public String listaProvedor() throws Exception {
		provedores= gestionProvedorON.ListarProvedorCodigo(1);
		return"";
	}
	
}
