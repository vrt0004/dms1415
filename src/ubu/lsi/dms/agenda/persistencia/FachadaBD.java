package ubu.lsi.dms.agenda.persistencia;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * @author alumno
 *
 */
public class FachadaBD implements FachadaPersistente 
{

private static FachadaBD intancia;
	
	private FachadaBD(){}
	
	public static FachadaBD getInstance(){
		if(intancia == null)
			intancia = new FachadaBD();
		return intancia;
	}
	
	@Override
	public void crearContacto(Contacto contacto) {
		Connection con=null;
		Statement stm= null;
		try {
			con= stm.getConnection();
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet uprs = stm.executeQuery("SELECT * FROM  Contactos");
			uprs.moveToInsertRow();
			uprs.updateInt("IdContacto", contacto.getId());
			uprs.updateString("Nombre", contacto.getNombre());
			uprs.updateString("Apellidos", contacto.getApellidos());
			uprs.updateString("Estimado", contacto.getEstimado());
			uprs.updateString("Direccion", contacto.getDireccion());
			uprs.updateString("Ciudad", contacto.getCiudad());
			uprs.updateString("EdoOProv", contacto.getEdoOProv());
			uprs.updateString("CodPostal", contacto.getCodPostal());
			uprs.updateString("Region", contacto.getRegion());
			uprs.updateString("Pais", contacto.getPais());
			uprs.updateString("NombreCompaÒia", contacto.getNombreCompaÒia());
			uprs.updateString("Cargo", contacto.getCargo());
			uprs.updateString("TelefonoTrabajo", contacto.getTelefonoTrabajo());
			uprs.updateString("ExtensionTrabajo", contacto.getExtensionTrabajo());
			uprs.updateString("TelefonoMovil", contacto.getTelefonoMovil());
			uprs.updateString("NumFax", contacto.getNumFax());
			uprs.updateString("NomCorreoElectronico",contacto.getNomCorreoElectronico());
			uprs.updateDate("FechaUltimaReunion",contacto.getFechaUltimaReunion());
			uprs.updateInt("IdTipoContacto", contacto.getIdTipoContacto());
			uprs.updateString("ReferidoPor", contacto.getReferidoPor());
			uprs.updateString("Notas", contacto.getNotas());
			uprs.insertRow();
			uprs.moveToCurrentRow();
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
			System.err.println("Error al abrir el archivo"+e);
			
			
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
	public void actualizarLlamada(int i, Llamada llamada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoContacto(int i, TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		
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
