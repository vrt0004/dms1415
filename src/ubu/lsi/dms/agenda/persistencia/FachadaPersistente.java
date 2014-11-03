package ubu.lsi.dms.agenda.persistencia;

import ubu.lsi.dms.agenda.modelo.Contacto;

/**
 * @author alumno
 *
 */
public interface FachadaPersistente 
{
	public void crearContacto();
	public void crearLlamada();
	public void crearTipoContacto();
	
	public void actualizarContacto();
	public void actualizarLlamada();
	public void actualizarTipoContacto();

	public void consultarContacto(String apellido);
	public void consultarLlamada(Contacto contacto);
	public void consultarTipoContacto();
}
