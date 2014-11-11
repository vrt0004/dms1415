package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;
import java.util.Date;
/**
 * Clase de entidad con la información de Llamada
 * @author Carlos López
 *
 */
@SuppressWarnings("serial")
public class Llamada implements Serializable{
	
	 private int idLlamada;
	 private Contacto contacto;
	 private String fechaLlamada ;
	 private String asunto,notas;
	 
	 

	public Llamada(int idLlamada, Contacto contacto, String fechaLlamada,
			String asunto, String notas) {
		super();
		this.idLlamada = idLlamada;
		this.contacto = contacto;
		this.fechaLlamada = fechaLlamada;
		this.asunto = asunto;
		this.notas = notas;
	}
	
	
	public String getFechaLlamada() {
		return fechaLlamada;
	}


	public void setFechaLlamada(String fechaLlamada) {
		this.fechaLlamada = fechaLlamada;
	}


	public String getAsunto() {
		return asunto;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public String getNotas() {
		return notas;
	}


	public void setNotas(String notas) {
		this.notas = notas;
	}


	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}


	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}


	public Contacto getContacto() {
		return contacto;
	}

	public int getIdLlamada() {
		return idLlamada;
	}

	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", contacto=" + contacto
				+ ", fechaLlamada=" + fechaLlamada + ", asunto=" + asunto
				+ ", notas=" + notas + "]";
	}

	 
	 
	   
	

}