package ubu.lsi.dms.agenda.persistencia;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public class FachadaBD implements FachadaPersistente 
{

private static FachadaBD intancia;
	
	private FachadaBD(){}
	
	public static FachadaBD getInstance(){
		if(intancia == null)
			intancia = new FachadaBD();
		return intancia;
	}
	
	@Override
	public void crearContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearTipoContacto(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarContacto(int id, Contacto contacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarLlamada(int i, Llamada llamada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoContacto(int i, TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contacto> consultarContacto(String apellido) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Llamada> consultarLlamada(Contacto contacto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoContacto> consultarTipoContacto() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
