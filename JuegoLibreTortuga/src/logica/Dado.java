package logica;
public class Dado {
	
	public static int lanzar (Corredor corredor)
	{
		int resultado =  (int) (Math.random() * corredor.getDesplazamiento()) + 1;
		return resultado;
	}
//	public static int lanzar ()
//	{
//		int resultado =  (int) (Math.random() * 6) + 1;
//		return resultado;
//	}
	
}
