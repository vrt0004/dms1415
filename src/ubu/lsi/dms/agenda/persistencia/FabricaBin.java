package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBin implements FabricaPersistencia 
{
	FachadaBin fachadaAgenda = FachadaBin.getInstance();
	
	private static FabricaBin instancia;
	
	private FabricaBin()
	{
	}
	
	public static FabricaBin getInstance()
	{
		if (instancia == null)
		{
			instancia = new FabricaBin();
		}
		return instancia;
	}
	
	public FachadaPersistente crearFachadaPersistente()
	{
		return fachadaAgenda;
	}
}
