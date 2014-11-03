package ubu.lsi.dms.agenda.persistencia;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public interface FachadaPersistente 
{
	public void crearContacto(Contacto contacto);
	public void crearLlamada(Llamada llamada);
	public void crearTipoContacto(TipoContacto tipoContacto);
	
	public void actualizarContacto(int id, Contacto contacto);
	public void actualizarLlamada(int id, Llamada llamada);
	public void actualizarTipoContacto(int id, TipoContacto tipoContacto);

	public void consultarContacto(String apellido);
	public void consultarLlamada(Contacto contacto);
	public void consultarTipoContacto();
}
