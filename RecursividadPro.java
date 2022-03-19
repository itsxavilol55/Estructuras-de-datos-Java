package EstructurasDatos;
public class RecursividadPro 
{
	public static void main(String[] args) 
	{
		System.out.println("encontrar numero en un arreglo");
		int [] arreglo= {1,2,3,4,5,6,7,8,9};
		int resu =buscarNumero(arreglo,9,0);
		System.out.println("posicion "+resu);
		System.out.println("tabla de multiplicar de un numero");
		tabla(7,1);
		System.out.println("ingresa un nombre");
		String Nombre = Leer.dato();
		invierte(Nombre, Nombre.length()-1);
		System.out.println("\ningresa el numero");
		int num1 = Leer.datoInt();
		System.out.println("ingresa el numero con el que se va a dividir");
		int div = Leer.datoInt();
		System.out.println("resulatdo: " +dividir(num1,div));
	}
	private static int dividir(int num1, int div)
	{
		 if(div>num1){
	            return 0;
	        } else {
	            return 1 + dividir(num1-div, div);
	        }
	}
	private static void invierte(String nombre, int posicion)
	{
		if(posicion<0)return;
		System.out.print(nombre.charAt(posicion));
		posicion--;
		invierte(nombre, posicion);
	}
	private static void tabla(int num, int posicion)
	{
		if(posicion==11)return;
		System.out.printf("%4d x %5d = %5d\n",num, posicion, num *posicion);
		posicion++;
		tabla(7,posicion);
	}
	private static int buscarNumero(int[] arreglo, int num, int posicion)
	{
		if (posicion==arreglo.length)
			return -1;
		if(num==arreglo[posicion]) 
			return posicion;
		posicion++;
		return buscarNumero(arreglo,num,posicion);
	}
}
