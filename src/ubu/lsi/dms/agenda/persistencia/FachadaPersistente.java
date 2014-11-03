package ubu.lsi.dms.agenda.persistencia;

import java.util.List;

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

	public List<Contacto> consultarContacto(String apellido);
	public List<Llamada> consultarLlamada(Contacto contacto);
	public List<TipoContacto> consultarTipoContacto();
}
