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
public class FachadaBin implements FachadaPersistente 
{
	private static FachadaBin instancia;
	
	private FachadaBin(){}
	
	public static FachadaBin getInstance(){
		if(instancia == null)
			instancia = new FachadaBin();
		return instancia;
	}

	public void crearContacto(Contacto contacto) 
	{
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binary\\contactos.dat"));
			out.writeObject(contacto);
			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	public void crearLlamada(Llamada llamada) 
	{
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binary\\llamadas.dat"));
			out.writeObject(llamada);
			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	public void crearTipoContacto(TipoContacto tipoContacto)
	{
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream(".\\res\\binary\\tiposContacto.dat"));
			out.writeObject(tipoContacto);
			out.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	public void actualizarContacto(int id, Contacto contacto) 
	{
		Contacto aux = null;
		List<Contacto> resultados = new ArrayList<Contacto>();
		try 
		{
			FileInputStream lector = new FileInputStream(".\\res\\binary\\contactos.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) 
			{
				aux = (Contacto) in.readObject();
				resultados.add(aux);
			}
			in.close();

			for (Contacto x : resultados) 
			{
				if (x.getIdContacto() == contacto.getIdContacto()) 
				{
					this.crearContacto(contacto);
				}
				else 
				{
					this.crearContacto(x);
				}
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}


	public void actualizarLlamada(int id, Llamada llamada) 
	{
		Llamada aux = null;
		List<Llamada> resultados = new ArrayList<Llamada>();
		try 
		{
			FileInputStream lector = new FileInputStream(".\\res\\binary\\llamadas.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) 
			{
				aux = (Llamada) in.readObject();
				resultados.add(aux);
			}
			in.close();

			for (Llamada x : resultados) 
			{
				if (x.getIdLlamada() == llamada.getIdLlamada()) 
				{
					this.crearLlamada(llamada);
				} 
				else 
				{
					this.crearLlamada(x);
				}
			}

		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}


	public void actualizarTipoContacto(int id, TipoContacto tipoContacto) 
	{
		TipoContacto aux = null;
		List<TipoContacto> resultados = new ArrayList<TipoContacto>();
		try 
		{
			FileInputStream lector = new FileInputStream(".\\res\\binary\\tiposContacto.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) 
			{
				aux = (TipoContacto) in.readObject();
				resultados.add(aux);
			}
			in.close();

			for (TipoContacto x : resultados) 
			{
				if (x.getIdTipoContacto() == tipoContacto.getIdTipoContacto()) 
				{
					this.crearTipoContacto(tipoContacto);
				}
				else 
				{
					this.crearTipoContacto(x);
				}
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}


	public List<Contacto> consultarContacto(String apellido) 
	{
		Contacto aux = null;
		List<Contacto> resultados = new ArrayList<Contacto>();
		List<Contacto> contactosLeidos = new ArrayList<Contacto>();
		try 
		{
			FileInputStream Lector = new FileInputStream(".\\res\\binary\\contactos.dat");
			ObjectInputStream in = new ObjectInputStream(Lector);
			while (Lector.available() > 0) 
			{
				aux = (Contacto) in.readObject();
				if (aux.getApellidos().contains(apellido))
				{
					resultados.add(aux);
				}
				contactosLeidos.add(aux);
			}
			in.close();
			for (Contacto x : contactosLeidos) 
			{
				this.crearContacto(x);
			}

		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return resultados;
	}


	public List<Llamada> consultarLlamada(Contacto contacto)
	{
		Llamada aux = null;
		List<Llamada> resultados = new ArrayList<Llamada>();
		List<Llamada> llamadasLeidas = new ArrayList<Llamada>();
		try 
		{
			FileInputStream lector = new FileInputStream(".\\res\\binary\\llamadas.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) 
			{
				aux = (Llamada) in.readObject();
				if (aux.getContacto().equals(contacto)) 
				{
					resultados.add(aux);
				}
				llamadasLeidas.add(aux);
			}
			in.close();
			for (Llamada x : llamadasLeidas) 
			{
				this.crearLlamada(x);
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		return resultados;
	}


	public List<TipoContacto> consultarTipoContacto() 
	{
		TipoContacto aux = null;
		List<TipoContacto> tipoContactoLeidos = new ArrayList<TipoContacto>();
		try 
		{
			FileInputStream lector = new FileInputStream(".\\res\\binary\\llamadas.dat");
			ObjectInputStream in = new ObjectInputStream(lector);
			while (lector.available() > 0) 
			{
				aux = (TipoContacto) in.readObject();
				System.out.println(aux.toString());
				tipoContactoLeidos.add(aux);
			}
			in.close();
			for (TipoContacto x : tipoContactoLeidos) 
			{
				this.crearTipoContacto(x);
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return tipoContactoLeidos;
	}
}
