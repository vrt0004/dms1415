package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBD implements FabricaPersistencia 
{
	FachadaBD fachadaAgenda = FachadaBD.getInstance();
	
	private static FabricaBD instancia;
	
	private FabricaBD()
	{
	}
	
	public static FabricaBD getInstance()
	{
		if (instancia == null)
		{
			instancia = new FabricaBD();
		}
		return instancia;
	}
	
	public FachadaPersistente crearFachadaPersistente()
	{
		return fachadaAgenda;
	}
}
