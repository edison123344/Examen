package ExamenFinal.Fereteria.Modelo;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * etructura del provedor
 * @author edison
 *
 */
@Entity(name = "Provedor")
@Table (name = "Provedor")
public class Provedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombreProbedor;
	private String nombreProducto;
	private int Stok;
	@OneToOne
	@JoinColumn(name="`FK_fereteria`")
	private  Fereteria fereteria;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreProbedor() {
		return nombreProbedor;
	}
	public void setNombreProbedor(String nombreProbedor) {
		this.nombreProbedor = nombreProbedor;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getStok() {
		return Stok;
	}
	public void setStok(int stok) {
		Stok = stok;
	}
	public Fereteria getFereteria() {
		return fereteria;
	}
	public void setFereteria(Fereteria fereteria) {
		this.fereteria = fereteria;
	}
	
}
