package EstructurasDatos;
public class OrdenamientoVector
{
	public static void main(String[] args)
	{
		int [] vector = new int[10];  // 1 de la creacion del arreglo y 1 de la asignacion				
		for(int i = 0; i < vector.length; i++) // 1 de la asignacion de i, mas la sumatoria
		{//1 por el length y 1 por la comparacion y 2 de i++;	        // de las operaciones del for
			vector[i] = (int) (Math.random()*77); // aqui son 5
			System.out.println(vector[i]); // aqui son 2
		}// otras 2 de la comparacion al ser falso
		ordena(vector); // 1
		System.out.println();// 1
		for(int i = 0; i < vector.length; i++)
		{
			System.out.println(vector[i]);
		}
	} //operaciones elementales=== 2+1+∑¹⁰(2+2+7)+2+2+1+∑¹⁰(4+2)+2 == 180

	private static int[] ordena(int[] datos)
	{
		int aux =0;	// 1 asignacion							
		for(int i = 0; i <datos.length-1; i++ )	// 2 asignacion, 1 comparacion , 1 llamada, 
			for(int j = 0; j <datos.length-1; j++ )					// 2 operaciones
				if(datos[j]>datos[j+1])		// en el if son 4 
				{
					aux=datos[j];			// 1 de acceso, 1 asignacion
					datos[j]= datos[j+1];	// 2 de acceso, 1 asignacion, 1 de operacion
					datos[j+1]=aux;		// 1 acceso, 1 asignacion, 1 operacion
				}
		return datos;
	}//1+1+∑⁹(5+1+∑⁹(5+4+9+4)+3)+3+1 == 1869 de este segmento
}
// total de operaciones en los 2 segmentos 2049