package ubu.lsi.dms.agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hsqldb.jdbc.JDBCDataSource;

import ubu.lsi.dms.agenda.modelo.*;

public class FachadaBD implements FachadaPersistente {
	Connection con=null;
	Statement stm=null;
	PreparedStatement pstm=null;
	
	private static final String servidor = "localhost";

	private static final String usuario = "SA";

	private static final String contraseña = "";

	private static final String SGBD = "hsqldb:hsql";

	private static final String baseDeDatos = "Agenda";
	
	private static FachadaBD intancia;
	JDBCDataSource ds = new JDBCDataSource();
	
	private FachadaBD(){}
	
	public static FachadaBD getInstance(){
		if(intancia == null)
			intancia = new FachadaBD();
		return intancia;
	}
	
	private static Connection getConnection() throws SQLException {
		Connection conn = null;
		JDBCDataSource ds = new JDBCDataSource();
		ds.setDatabaseName("jdbc:" + SGBD + "://" + servidor + "/" + baseDeDatos);
		ds.setUser(usuario);
		ds.setPassword(contraseña);
		conn = ds.getConnection();
		return conn;
	}
	
	
	@Override
	public void crearContacto(Contacto contacto) {
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stm.executeQuery("SELECT * FROM  Contactos");
			rs.moveToInsertRow();
			
			rs.updateInt("IdContacto", contacto.getIdContacto());
			rs.updateString("Nombre", contacto.getNombre());
			rs.updateString("Apellidos", contacto.getApellidos());
			rs.updateString("Estimado", contacto.getEstimado());
			rs.updateString("Direccion", contacto.getDireccion());
			rs.updateString("Ciudad", contacto.getCiudad());
			rs.updateString("EdoOProv", contacto.getProv());
			rs.updateString("CodPostal", contacto.getCodPostal());
			rs.updateString("Region", contacto.getRegion());
			rs.updateString("Pais", contacto.getPais());
			rs.updateString("NombreCompañia", contacto.getNombreCompania());
			rs.updateString("Cargo", contacto.getCargo());
			rs.updateString("TelefonoTrabajo", contacto.getTelefonoTrabajo());
			rs.updateString("ExtensionTrabajo", contacto.getExtensionTrabajo());
			rs.updateString("TelefonoMovil", contacto.getTelefonoMovil());
			rs.updateString("NumFax", contacto.getNumFax());
			rs.updateString("NomCorreoElectronico",contacto.getNomCorreoElectronico());
			rs.updateString("Notas", contacto.getNotas());
			rs.updateInt("IdTipoContacto", contacto.getTipoContacto().getIdTipoContacto());
			rs.insertRow();
			rs.moveToCurrentRow();
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
			System.err.println("Error al abrir el archivo"+e);
			
			
		}
		
	}



	@Override
	public void crearLlamada(Llamada llamada) {
		String date=llamada.getFechaLlamada();
		Date FechaLlamada = java.sql.Date.valueOf(date);
		
		try{
			
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("SELECT * FROM LLAMADAS");
			rs.moveToInsertRow();
			rs.updateInt("Idllamada", llamada.getIdLlamada());
			rs.updateInt("IdContacto", llamada.getContacto().getIdContacto());
			rs.updateDate("Fechallamada", (java.sql.Date) FechaLlamada);
			rs.updateString("Asunto", llamada.getAsunto());
			rs.updateString("Notas", llamada.getNotas());
			rs.insertRow();
			rs.moveToCurrentRow();
			con.close();
			
			} catch (SQLException e) {
				e.getMessage();
				System.err.println("Error al abrir el archivo"+e);
				
				
			}
		
	}

	@Override
	public void crearTipoContacto(TipoContacto tipocontacto) {
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("SELECT * FROM TIPOSDECONTACTO");
			rs.moveToInsertRow();
			rs.updateInt("IDTIPOCONTACTO", tipocontacto.getIdTipoContacto());
			rs.updateString("TIPOCONTACTO",tipocontacto.getTipoContacto());
			rs.insertRow();
			rs.moveToCurrentRow();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error al abrir el archivo "+e);
		}
		
		
	}
	
	

	@Override
	public void actualizarContacto(int id,  Contacto contactoAc) {
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("SELECT * FROM CONTACTOS");
			while(rs.next()){
				
				if(contactoAc.getIdContacto()==rs.getInt("IDCONTACTO")){
					rs.updateInt("IDCONTACTO",id);
					rs.updateString("Nombre", contactoAc.getNombre());
					rs.updateString("Apellidos", contactoAc.getApellidos());
					rs.updateString("Estimado", contactoAc.getEstimado());
					rs.updateString("Direccion", contactoAc.getDireccion());
					rs.updateString("Ciudad", contactoAc.getCiudad());
					rs.updateString("EdoOProv", contactoAc.getProv());
					rs.updateString("CodPostal", contactoAc.getCodPostal());
					rs.updateString("Region", contactoAc.getRegion());
					rs.updateString("Pais", contactoAc.getPais());
					rs.updateString("NombreCompañia", contactoAc.getNombreCompania());
					rs.updateString("Cargo", contactoAc.getCargo());
					rs.updateString("TelefonoTrabajo", contactoAc.getTelefonoTrabajo());
					rs.updateString("ExtensionTrabajo", contactoAc.getExtensionTrabajo());
					rs.updateString("TelefonoMovil", contactoAc.getTelefonoMovil());
					rs.updateString("NumFax", contactoAc.getNumFax());
					rs.updateString("NomCorreoElectronico",contactoAc.getNomCorreoElectronico());
					rs.updateInt("IdTipoContacto", contactoAc.getTipoContacto().getIdTipoContacto());
					rs.updateString("Notas", contactoAc.getNotas());
					rs.updateRow();
					con.close();
				}
				
			}
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error al abrir el archivo "+e);
		}
		
	}

	@Override
	public void actualizarLlamada(int i, Llamada llamada) {
		String date=llamada.getFechaLlamada();
		Date FechaLlamada = java.sql.Date.valueOf(date);
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("select * from llamadas");
			while(rs.next()){
				if(llamada.getIdLlamada()==rs.getInt("IDLLAMADA")){
					
					rs.updateInt("Idllamada", i);
					rs.updateInt("IdContacto", llamada.getContacto().getIdContacto());
					rs.updateDate("Fechallamada", (java.sql.Date) FechaLlamada);
					rs.updateString("Asunto", llamada.getAsunto());
					rs.updateString("Notas", llamada.getNotas());
					rs.updateRow();
		
					con.close();
				}
			}
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error al abrir el archivo "+e);
		}
		
		
	}

	@Override
	public void actualizarTipoContacto(int id, TipoContacto tipocontacto) {
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("select * from TiposDecontacto");
			while(rs.next()){
				if(tipocontacto.getIdTipoContacto()==rs.getInt("IDTIPOCONTACTO")){
					rs.updateInt("IDTIPOCONTACTO", tipocontacto.getIdTipoContacto());
					rs.updateString("TIPOCONTACTO",tipocontacto.getTipoContacto());
					rs.updateRow();
					
					con.close();
				}
			}
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error al abrir el archivo "+e);
		}
	}

	@Override
	public List<Contacto> consultarContacto(String apellido)  {
		
		Contacto aux=null;
		TipoContacto tipoContacto=null;
		List<Contacto> resultados = new ArrayList<Contacto>();
		String sql = "SELECT * FROM CONTACTOS" + " WHERE APELLIDOS=?";
		try {
			
			con=getConnection();
			pstm=con.prepareStatement(sql);
			
				pstm.setString(1, apellido);
				ResultSet  rs=pstm.executeQuery();
				while(rs.next()){
					
					
						int IdContacto =rs.getInt(1);
						String Nombre=rs.getString(2);
						String Apellidos=rs.getString(3);
						String Estimado= rs.getString(4);
						String Direccion= rs.getString(5);
						String Ciudad= rs.getString(6);
						String EdoOProv= rs.getString(7);
						String CodPostal= rs.getString(8);
						String Region= rs.getString(9);
						String Pais= rs.getString(10);
						String NombreCompania=rs.getString(11);
						String Cargo= rs.getString(12);
						String TelefonoTrabajo= rs.getString(13);
						String ExtensionTrabajo= rs.getString(14);
						String TelefonoMovil= rs.getString(15);
						String NumFax= rs.getString(16);
						String NomCorreoElectronico=rs.getString(17);
						List<TipoContacto> tiposContacto = consultarTipoContacto();
						for(TipoContacto c: tiposContacto){
							if (c.getIdTipoContacto()==rs.getInt(18)) {
								tipoContacto=c;
							}
						}						
						String Notas=rs.getString(19);			
						
						
						rs.close();
						
					
					aux= new Contacto(IdContacto, Nombre, Apellidos, Estimado, Direccion, Ciudad, 
							EdoOProv, CodPostal, Region, Pais, NombreCompania,
							Cargo, TelefonoTrabajo, ExtensionTrabajo,TelefonoMovil, NumFax,
							NomCorreoElectronico, Notas,tipoContacto);
					
									
					resultados.add(aux);
					}
							
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultados;
		
		
	}
	@Override
	public List<Llamada> consultarLlamada(Contacto contacto) {
		List<Llamada> listaLlamadas=new ArrayList<Llamada>();
		try {
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery("SELECT * FROM LLAMADAS");
			while(rs.next()){
				if(rs.getInt(2)==contacto.getIdContacto()){
					int idLlamada = rs.getInt(1);
					String fechaLlamada = rs.getString(3);
					String asunto = rs.getString(4);
					String notas = rs.getString(5);
					Llamada llamada =new Llamada(idLlamada, contacto, fechaLlamada, asunto, notas);
					listaLlamadas.add(llamada);
				}
				
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return listaLlamadas;
	}

	@Override
	public List<TipoContacto> consultarTipoContacto(){
	
	List<TipoContacto> tiposContacto = new ArrayList<TipoContacto>();
	

	
		try {
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM TIPOSDECONTACTO");
		
		while (rs.next()) {
			
		int idTipoContacto = rs.getInt(1);		
		String tipo = rs.getString(2);
		
		TipoContacto tipoContacto = new TipoContacto(idTipoContacto,tipo);
		tipoContacto.toString();
		tiposContacto.add(tipoContacto);
		
		}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		 return tiposContacto;
		
	}

	

}
