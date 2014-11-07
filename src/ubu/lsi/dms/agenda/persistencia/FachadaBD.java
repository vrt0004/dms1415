package ubu.lsi.dms.agenda.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import org.hsqldb.jdbc.JDBCDataSource;

import ubu.lsi.dms.agenda.modelo.*;

public class FachadaBD implements FachadaAgenda {
	Connection con=null;
	Statement stm=null;
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
			rs.updateInt("IdContacto", contacto.getId());
			rs.updateString("Nombre", contacto.getNombre());
			rs.updateString("Apellidos", contacto.getApellidos());
			rs.updateString("Estimado", contacto.getEstimado());
			rs.updateString("Direccion", contacto.getDireccion());
			rs.updateString("Ciudad", contacto.getCiudad());
			rs.updateString("EdoOProv", contacto.getEdoOProv());
			rs.updateString("CodPostal", contacto.getCodPostal());
			rs.updateString("Region", contacto.getRegion());
			rs.updateString("Pais", contacto.getPais());
			rs.updateString("NombreCompania", contacto.getNombreCompañia());
			rs.updateString("Cargo", contacto.getCargo());
			rs.updateString("TelefonoTrabajo", contacto.getTelefonoTrabajo());
			rs.updateString("ExtensionTrabajo", contacto.getExtensionTrabajo());
			rs.updateString("TelefonoMovil", contacto.getTelefonoMovil());
			rs.updateString("NumFax", contacto.getNumFax());
			rs.updateString("NomCorreoElectronico",contacto.getNomCorreoElectronico());
			rs.updateDate("FechaUltimaReunion",contacto.getFechaUltimaReunion());
			rs.updateInt("IdTipoContacto", contacto.getIdTipoContacto());
			rs.updateString("ReferidoPor", contacto.getReferidoPor());
			rs.updateString("Notas", contacto.getNotas());
			rs.insertRow();
			rs.moveToCurrentRow();
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
			System.err.println("Error al abrir el archivo"+e);
			
			
		}
		
	}

	@Override
	public void crearLlamada(Llamada llamada) {

		
		try{
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("SELECT * FROM LLAMADAS");
			rs.moveToInsertRow();
			rs.updateInt("Idllamada", llamada.getIdLlamada());
			rs.updateInt("IdContacto", llamada.getContactoId());
			rs.updateDate("Fechallamada", llamada.getFechaLlamada());
			rs.updateTime("HoraLlamada", llamada.getHoraLlamada());
			rs.updateString("Asunto", llamada.getAsunto());
			rs.updateString("Notas", llamada.getNota());
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
			rs.updateInt("IDTIPOCONTACTO", tipocontacto.getIdTipoDeContacto());
			rs.updateString("TIPOCONTACTO",tipocontacto.getTipoDeConctacto());
			rs.insertRow();
			rs.moveToCurrentRow();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error al abrir el archivo "+e);
		}
		
		
	}

	@Override
	public void actualizarContacto(int id, Contacto contacto) {
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("SELECT * FROM CONTACTOS");
			while(rs.next()){
				
				if(contactoAc.getId()==rs.getInt("IDCONTACTO")){
					rs.updateInt("IDCONTACTO",contactoAc.getId());
					rs.updateString("Nombre", contactoAc.getNombre());
					rs.updateString("Apellidos", contactoAc.getApellidos());
					rs.updateString("Estimado", contactoAc.getEstimado());
					rs.updateString("Direccion", contactoAc.getDireccion());
					rs.updateString("Ciudad", contactoAc.getCiudad());
					rs.updateString("EdoOProv", contactoAc.getEdoOProv());
					rs.updateString("CodPostal", contactoAc.getCodPostal());
					rs.updateString("Region", contactoAc.getRegion());
					rs.updateString("Pais", contactoAc.getPais());
					rs.updateString("NombreCompania", contactoAc.getNombreCompañia());
					rs.updateString("Cargo", contactoAc.getCargo());
					rs.updateString("TelefonoTrabajo", contactoAc.getTelefonoTrabajo());
					rs.updateString("ExtensionTrabajo", contactoAc.getExtensionTrabajo());
					rs.updateString("TelefonoMovil", contactoAc.getTelefonoMovil());
					rs.updateString("NumFax", contactoAc.getNumFax());
					rs.updateString("NomCorreoElectronico",contactoAc.getNomCorreoElectronico());
					rs.updateDate("FechaUltimaReunion",contactoAc.getFechaUltimaReunion());
					rs.updateInt("IdTipoContacto", contactoAc.getIdTipoContacto());
					rs.updateString("ReferidoPor", contactoAc.getReferidoPor());
					rs.updateString("Notas", contactoAc.getNotas());
					rs.updateRow();
				}
				
			}
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error al abrir el archivo "+e);
		}
		
		
	}


	@Override
	public void actualizarLlamada(int i, Llamada llamada) {
		try {
			con=getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("select * from llamadas");
			while(rs.next()){
				if(llamada.getIdLlamada()==rs.getInt("IDLLAMADA")){
					
					rs.updateInt("Idllamada", i);
					rs.updateInt("IdContacto", llamada.getContactoId());
					rs.updateDate("Fechallamada", llamada.getFechaLlamada());
					rs.updateTime("HoraLlamada", llamada.getHoraLlamada());
					rs.updateString("Asunto", llamada.getAsunto());
					rs.updateString("Notas", llamada.getNota());
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
				if(tipocontacto.getIdTipoDeContacto()==rs.getInt("IDTIPOCONTACTO")){
					
					rs.updateInt("IDTIPOCONTACTO", id);
					rs.updateString("TIPOCONTACTO",tipocontacto.getTipoDeConctacto());
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
	public List<Contacto> consultarContacto(String apellido) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Llamada> consultarLlamada(Contacto contacto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoContacto> consultarTipoContacto() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
