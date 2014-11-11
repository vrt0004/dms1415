package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;

/**
 * Clase de entidad con la información de TipodeContacto
 * @author Carlos López
 *
 */
@SuppressWarnings("serial")
public class TipoContacto implements Serializable{
	/**
	 * 
	 */
	
	private int idTipoContacto;
	private String TipoContacto;
	
	
	public TipoContacto(int idTipoContacto, String tipoContacto) {
		super();
		this.idTipoContacto = idTipoContacto;
		TipoContacto = tipoContacto;
	}


	public String getTipoContacto() {
		return TipoContacto;
	}


	public void setTipoContacto(String tipoContacto) {
		TipoContacto = tipoContacto;
	}


	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}


	public int getIdTipoContacto() {
		return idTipoContacto;
	}


	@Override
	public String toString() {
		return "TipoContacto [idTipoContacto=" + idTipoContacto
				+ ", TipoContacto=" + TipoContacto + "]";
	}
	
	
	

}