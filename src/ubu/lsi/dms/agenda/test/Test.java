package ubu.lsi.dms.agenda.test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import ubu.lsi.dms.agenda.modelo.*;
import ubu.lsi.dms.agenda.persistencia.*;

public class Test 
{

	public static void main (String[] args)
	{
		FabricaPersistencia agendaFactoryDB = FabricaBD.getInstance();
		FabricaPersistencia agendaFactoryBinary = FabricaBin.getInstance();
		FachadaPersistente agendaDB = agendaFactoryDB.crearFachadaPersistente();
		FachadaPersistente agendaBinary = agendaFactoryBinary.crearFachadaPersistente();

		//test(agendaDB);
		test(agendaBinary);

		System.out.println("Ok.");
	}
	
	private static void test(FachadaPersistente agenda) {
		TipoContacto tipodecontacto = new TipoContacto(1, "Conciencia");
		Contacto contacto = new Contacto(1, "Pepito", "Grillo", "Sr.", "Taller de Guepeto", "Rothemburg", "Ansbach", "09007", "Bavaria", "Alemania", "Conciencias SA", "Presidente", "947258258", "0", "652148974", "947258258", "pepitogrillo@gmail.com", "", tipodecontacto);
		Llamada llamada1 = new Llamada(1, contacto, "5/11/2014","Cumpleaños", "");
		Llamada llamada2 = new Llamada(2, contacto, "10/11/2014","Fiesta", "");
		

		List<Llamada> llamadas = new ArrayList<Llamada>();
		List<Llamada> consultaLlamadas = null;
		List<Contacto> contactos = new ArrayList<Contacto>();
		List<Contacto> consultaContactos = null;
		List<TipoContacto> tiposdecontacto = new ArrayList<TipoContacto>();
		List<TipoContacto> consultaTipos = null;

		// Inserción de datos.
		agenda.crearContacto(contacto);
		agenda.crearLlamada(llamada1);
		agenda.crearTipoContacto(tipodecontacto);

		// Actualización de datos.
		Contacto actualizacionContacto = new Contacto(1, "Guepeto", "El carpintero", "Sr.", "Taller de Guepeto", "Rothemburg", "Ansbach", "09007", "Bavaria", "Alemania", "MArionetas SA", "Presidente", "947236547", "0", "65285644", "947236547", "marionetasreales@gmail.com", "", tipodecontacto);
		Llamada actualizarllamada1 = new Llamada(1, contacto, "5/11/2014","Cumpleaños Pepito", "");
		TipoContacto actualizartipodecontacto = new TipoContacto(1, "Padre");

		agenda.actualizarContacto(1, actualizacionContacto);
		agenda.actualizarLlamada(1, actualizarllamada1);
		agenda.actualizarTipoContacto(1, actualizartipodecontacto);

		// Consulta y comprobación de datos.
		contactos.add(actualizacionContacto);
		consultaContactos = agenda.consultarContacto("El carpintero");
		assert (contactos.equals(consultaContactos));

		llamadas.add(actualizarllamada1);
		consultaLlamadas = agenda.consultarLlamada(actualizacionContacto);
		assert (consultaLlamadas.equals(llamadas));

		llamadas.add(llamada2);
		consultaLlamadas = agenda.consultarLlamada(actualizacionContacto);
		assert (consultaLlamadas.equals(llamadas));
		
		tiposdecontacto.add(actualizartipodecontacto);
		consultaTipos = agenda.consultarTipoContacto();
		assert (consultaTipos.equals(tiposdecontacto));

		System.out.println("Test completado.");
	}
}
