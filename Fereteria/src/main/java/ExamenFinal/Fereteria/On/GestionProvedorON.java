package ExamenFinal.Fereteria.On;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ExamenFinal.Fereteria.DAO.ProvedorDAO;
import ExamenFinal.Fereteria.Modelo.Provedor;

/**
 * clase que visualisara el stok
 * @author edison
 *
 */
@Stateless
public class GestionProvedorON {
@Inject
private ProvedorDAO provedorDAO;

public void actualisarStok(Provedor provedor) throws Exception {
	provedorDAO.actualizar(provedor);
}
public List<Provedor> listaProvedor(){
	return provedorDAO.listaProvedor();
}
public Provedor ListarProvedorCodigo(int codigo) throws Exception{
	return provedorDAO.listar(codigo);
}
}
