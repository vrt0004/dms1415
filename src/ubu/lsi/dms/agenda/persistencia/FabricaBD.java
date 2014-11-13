package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBD implements FabricaPersistencia{
	
	/*Creacion de la fachada concreta de BD*/
	
	FachadaBD fachadaAgenda = FachadaBD.getInstance();
	
	private static FabricaBD instancia;
	
	/*Constructor privado*/
	private FabricaBD(){}
	
	/*Creacion de instancia y return de la misma*/
	
	public static FabricaBD getInstance(){
		if (instancia == null){
			instancia = new FabricaBD();
		}
		return instancia;
	}
	
	/*Metodo de creacion de fachada persistente*/
	
	@Override
	public FachadaPersistente crearFachadaPersistente(){
		return fachadaAgenda;
	}
}
