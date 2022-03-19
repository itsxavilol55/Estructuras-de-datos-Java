package EstructurasDatos;
public class MetoodoTrapecios
{
	public static void main(String[] args)
	{
		System.out.println("Metodos Numericos 9am a 10am");
		System.out.println("Instituto tecnologico de culiacan");
		System.out.println("Ing en sistemas computacionales");
		System.out.println("Javier Eduardo Lopez Ontiveros\n");
		System.out.println("solucion a un sistema de ecuaciones");
		System.out.println("Este programa ejecuta el proceso de cálculo de "
				+ "\nsolucion de integrales con el metodo de los trapecios");
		double valorReal= 34814.54482, diferencia=90909090;
		//double valorReal= 7.1722, diferencia=90909090;
		System.out.println("cual es la pregunta del problema?");
		String pregunta = Leer.dato();
		System.out.println("ingresa el limite inferior(menor)");// A
		double valorA = Leer.datoInt();
		double aux = valorA;
		System.out.println("ingresa el limite superior(mayor)");// B
		double valorB = Leer.datoInt();
		System.out.println("ingresa el valor del error");
		float error = Leer.datoFloat();
		int trapecios=4;
		System.out.println("pregunta:" + pregunta);
		while (Math.abs(diferencia)>error)
		{
			trapecios *= 2;
			valorA=aux;
			double ancho = (valorB - valorA) / trapecios;
			double area = 0,areaTotal=0;
			System.out.printf(" %4s  %8s  %8s  %9s  %9s  %9s\n","N","A","A+H","f(A)","f(A+H)","Area");
			for (int i = 0; i < trapecios; i++)
			{
				double ah = ancho + valorA;
				area = (ancho/2) * (funcion(valorA) + funcion(ah));
				System.out.printf("|%4d |%8.4f |%8.4f |%9.5f |%9.5f |%9.5f|\n",(i+1), valorA,ah,funcion(valorA),funcion(ah),area);
				valorA = ah;
				areaTotal+=area;
			}
			diferencia = areaTotal-valorReal;
			System.out.println("Area total: "+areaTotal);
			System.out.println("error del area: "+diferencia);
		}
	}
	private static float funcion(double x)
	{
		//return (float) (2 + Math.sin(2*Math.sqrt(x)));
		return (float) (Math.pow(x,3)- Math.sin(x+1));
	}
}