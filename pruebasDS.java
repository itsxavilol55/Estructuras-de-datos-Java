package EstructurasDatos;
public class pruebasDS
{
	public static void main(String[] args)
	{
//		try 
//		{	//15,20,30,18,25,28,26,24,27,40,35,38,31,34,9,11,5,7,6,13,12,10 gt                       
			Arbol arbol1 = new Arbol();
			arbol1.vacia();
			arbol1.insertar(15);
			arbol1.insertar(20);
			arbol1.insertar(30);
			arbol1.insertar(18);
			arbol1.insertar(25);
			arbol1.insertar(28);
			arbol1.insertar(26);
			arbol1.insertar(24);
			arbol1.insertar(27);
			arbol1.insertar(40);
			arbol1.insertar(35);
			arbol1.insertar(38);
			arbol1.insertar(31);
			arbol1.insertar(34);
			arbol1.insertar(9);
			arbol1.insertar(11);
			arbol1.insertar(5);
			arbol1.insertar(7);
			arbol1.insertar(6);
			arbol1.insertar(13);
			arbol1.insertar(12);
			arbol1.insertar(10);
			System.out.println("total: "+arbol1.total(arbol1.getRaiz()));
			arbol1.borrar(30);
			arbol1.borrar(35);
			arbol1.borrar(15);
			arbol1.borrar(11);
			arbol1.borrar(20);
			arbol1.borrar(6);
			arbol1.borrar(10);
			arbol1.vaciar();
			System.out.println("inorden");
			arbol1.inorden(arbol1.getRaiz());
			System.out.println();
			System.out.println("posorden");
			arbol1.postorden(arbol1.getRaiz());
			System.out.println();
			System.out.println("preorden");
			arbol1.preorden(arbol1.getRaiz());
			System.out.println("total: "+arbol1.total(arbol1.getRaiz()));
			//System.out.println("mayor de menores"+arbol1.mayorDeMenores(arbol1.getRaiz().getDerecho().getDerecho()).getDato());
			//System.out.println("menor de mayores"+arbol1.menorDeMayores(arbol1.getRaiz().getDerecho().getDerecho()).getDato());
//		} catch (Exception exception)
//		{
//			System.out.println("ocurrio un error o no se encontro el elemento");
//		}
	}
}

