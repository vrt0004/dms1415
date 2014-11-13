package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBin implements FabricaPersistencia {
	
	/*Creacion de la fachada concreta de fabrica BIN*/
	
	FachadaBin fachadaAgenda = FachadaBin.getInstance();
	
	private static FabricaBin instancia;
	
	/*Constructor privado de la fabricaBin*/
	private FabricaBin(){}
	
	/*Creacion de la instancia y regreso de la misma*/
	
	public static FabricaBin getInstance(){
		if (instancia == null)
		{
			instancia = new FabricaBin();
		}
		return instancia;
	}
	
	/*Creacion de la fahcada persistente regresando la fachada concreta*/
	public FachadaPersistente crearFachadaPersistente(){
		return fachadaAgenda;
	}
}
