package ubu.lsi.dms.agenda.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
/**
 * @author alumno
 *
 */

public class FachadaBin implements FachadaPersistente {
	
	/*Secccion de variables
	 * Variables privadas para la clase
	 */
	private static FachadaBin instancia;

	/*Constructor privado*/
	private FachadaBin(){}
	
	/*Creacion de la instancia de fachada Binaria*/
	public static FachadaBin getInstance(){
		if(instancia == null)
			instancia = new FachadaBin();
		return instancia;
	}
	
	/*Creacion del metodo de la fabrica abastracta de crearContacto*/

	public void crearContacto(Contacto contacto) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binario\\contactos.dat"));
			out.writeObject(contacto);
			out.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*Creacion del metodo de la fabrica abastracta de crearLlamda*/
	
	public void crearLlamada(Llamada llamada) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binario\\llamadas.dat"));
			out.writeObject(llamada);
			out.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*Creacion del metodo de la fabrica abastracta de crearTipoContacto*/
	
	public void crearTipoContacto(TipoContacto tipoContacto){
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binario\\tiposContacto.dat"));
			out.writeObject(tipoContacto);
			out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*Creacion del metodo de la fabrica abastracta de actualizarContacto*/
	
	public void actualizarContacto(int id, Contacto contacto) {
		Contacto aux = null;
		List<Contacto> resultados = new ArrayList<Contacto>();
		try {
			FileInputStream lector = new FileInputStream(".\\res\\binario\\contactos.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) {
				aux = (Contacto) in.readObject();
				resultados.add(aux);
			}
			in.close();

			for (Contacto x : resultados) {
				if (x.getIdContacto() == contacto.getIdContacto()){
					this.crearContacto(contacto);
				}else {
					this.crearContacto(x);
				}
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*Creacion del metodo de la fabrica abastracta de actualizarLlama*/

	public void actualizarLlamada(int id, Llamada llamada) {
		Llamada aux = null;
		List<Llamada> resultados = new ArrayList<Llamada>();
		try {
			FileInputStream lector = new FileInputStream(".\\res\\binario\\llamadas.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) {
				aux = (Llamada) in.readObject();
				resultados.add(aux);
			}
			in.close();

			for (Llamada x : resultados) {
				if (x.getIdLlamada() == llamada.getIdLlamada()) {
					this.crearLlamada(llamada);
				} else {
					this.crearLlamada(x);
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	/*Creacion del metodo de la fabrica abastracta de actualizarTipoContacto*/

	public void actualizarTipoContacto(int id, TipoContacto tipoContacto){
		TipoContacto aux = null;
		List<TipoContacto> resultados = new ArrayList<TipoContacto>();
		try {
			FileInputStream lector = new FileInputStream(".\\res\\binario\\tiposContacto.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) {
				aux = (TipoContacto) in.readObject();
				resultados.add(aux);
			}
			in.close();

			for (TipoContacto x : resultados) {
				if (x.getIdTipoContacto() == tipoContacto.getIdTipoContacto()) {
					this.crearTipoContacto(tipoContacto);
				}else {
					this.crearTipoContacto(x);
				}
			}

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*Creacion del metodo de la fabrica abastracta de consultarContacto*/
	
	public List<Contacto> consultarContacto(String apellido) {
		Contacto aux = null;
		List<Contacto> resultados = new ArrayList<Contacto>();
		List<Contacto> contactosLeidos = new ArrayList<Contacto>();
		try {
			FileInputStream Lector = new FileInputStream(".\\res\\binario\\contactos.dat");
			ObjectInputStream in = new ObjectInputStream(Lector);
			while (Lector.available() > 0) {
				aux = (Contacto) in.readObject();
				if (aux.getApellidos().contains(apellido)){
					resultados.add(aux);
				}
				contactosLeidos.add(aux);
			}
			in.close();
			for (Contacto x : contactosLeidos) {
				this.crearContacto(x);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultados;
	}

	/*Creacion del metodo de la fabrica abastracta de consultarLlamda*/

	public List<Llamada> consultarLlamada(Contacto contacto){
		Llamada aux = null;
		List<Llamada> resultados = new ArrayList<Llamada>();
		List<Llamada> llamadasLeidas = new ArrayList<Llamada>();
		try {
			FileInputStream lector = new FileInputStream(".\\res\\binario\\llamadas.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) {
				aux = (Llamada) in.readObject();
				if (aux.getContacto().equals(contacto)) {
					resultados.add(aux);
				}
				llamadasLeidas.add(aux);
			}
			in.close();
			for (Llamada x : llamadasLeidas) {
				this.crearLlamada(x);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultados;
	}
	
	/*Creacion del metodo de la fabrica abastracta de consultarTipoContacto*/

	public List<TipoContacto> consultarTipoContacto() {
		TipoContacto aux = null;
		List<TipoContacto> tipoContactoLeidos = new ArrayList<TipoContacto>();
		try {
			FileInputStream lector = new FileInputStream(".\\res\\binario\\tiposContacto.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) {
				aux = (TipoContacto) in.readObject();
				tipoContactoLeidos.add(aux);
			}
			in.close();
			for (TipoContacto x : tipoContactoLeidos) {
				this.crearTipoContacto(x);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tipoContactoLeidos;
	}
}
