package ubu.lsi.dms.agenda.persistencia;

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
	public void consultarContacto(String apellido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultarLlamada(Contacto contacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultarTipoContacto() {
		// TODO Auto-generated method stub
		
	}
}
