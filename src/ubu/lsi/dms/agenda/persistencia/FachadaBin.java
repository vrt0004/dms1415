package ubu.lsi.dms.agenda.persistencia;

import java.io.*;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public class FachadaBin implements FachadaPersistente 
{
	private static FachadaBin instancia;
	
	private FachadaBin(){}
	
	public static FachadaBin getInstance(){
		if(instancia == null)
			instancia = new FachadaBin();
		return instancia;
	}

	@Override
	public void crearContacto(Contacto contacto) 
	{
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binary\\contactos.dat"));
			out.writeObject(contacto);
			out.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
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
	public void actualizarLlamada(int id, Llamada llamada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoContacto(int id, TipoContacto tipoContacto) {
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
