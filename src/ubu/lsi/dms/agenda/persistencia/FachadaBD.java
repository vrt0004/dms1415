package ubu.lsi.dms.agenda.persistencia;

import ubu.lsi.dms.agenda.modelo.Contacto;

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
	public void crearContacto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearLlamada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearTipoContacto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarContacto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarLlamada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoContacto() {
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
