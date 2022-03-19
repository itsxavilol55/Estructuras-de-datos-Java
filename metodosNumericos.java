package EstructurasDatos;
public class metodosNumericos
{
	public static void main(String[] args)
	{
		System.out.println("Metodos Numericos 9am a 10am");
		System.out.println("Instituto tecnologico de culiacan");
		System.out.println("Ing en sistemas computacionales");
		System.out.println("Javier Eduardo Lopez Ontiveros");
		System.out.println("raices de una ecuacion");
		System.out.println("Este programa ejecuta el proceso de cálculo de "
				+ "\nRaíces de una ecuación utilizando diversosmétodos");
		
		Object opcion;
		do 
		{
			System.out.println("\nQue metodo quieres realizar??");
			System.out.println("\n1.-Método de la Secante"
				+ "\n2.-Método de Newton Raphson"
				+ "\nOtro caracter.-F I N");
			opcion = Leer.dato();
			if(opcion.equals("1"))
			{
				MetodoSecante();
			}
			else if(opcion.equals("2"))
			{
				MetodoNewton();
			}
		} while(opcion.equals("1") || opcion.equals("2"));
		System.out.println("se ha salio del programa");
		System.exit(0);
	}

	private static void MetodoNewton()
	{
		System.out.println("\nMetodo de Newton Rapson");
		System.out.println("ingresa el valor de x1");
		double x1 = Leer.datoInt();
		System.out.println("ingresa el valor del error");
		double error = Leer.datoDouble();
		System.out.println("ingresa el limite de calculos a realizar");
		int calculos = Leer.datoInt();
		System.out.printf("%4s %10s %10s %10s %10s %10s \n","N","x1","f(x1)","f´(x1)","x2","f(x2)");
		for (int i = 0; i < calculos; i++)
		{
			double f1 = calcularFuncion(x1);
			double fd1 = calcularDerivada(x1);
			double x2 = x1 -(f1/fd1);
			double f2 = calcularFuncion(x2);
			System.out.printf("%4d %10f %10f %10f %10f %10f\n",(i+1),x1, f1,fd1,x2, f2);
			if (Math.abs(f2) < error)
			{
				System.out.printf("el valor de la raiz es: %10f\n", x2);
				return;
			}
			x1=x2;
		}
		System.out.println("no se encontro la solucion");
	}

	private static void MetodoSecante()
	{
		System.out.println("\nMetodo de la secante");
		System.out.println("ingresa el valor de x1");
		double x1 = Leer.datoInt();
		System.out.println("ingresa el valor de x2");
		double x2 = Leer.datoInt();
		System.out.println("ingresa el valor del error");
		double error = Leer.datoDouble();
		System.out.println("ingresa el limite de calculos a realizar");
		int calculos = Leer.datoInt();
		System.out.printf("%4s %13s %13s %13s %13s %13s %13s\n","N","x1","f(x1)","x2", "f(x2)","x3","f(x3)");
		for (int i = 0; i < calculos; i++)
		{
			double f1 = calcularFuncion(x1);
			double f2 = calcularFuncion(x2);
			double x3 = x1 - (((x1 - x2) * f1) / (f1 - f2));
			double f3 = calcularFuncion(x3);
			System.out.printf("%4d %13f %13f %13f %13f %13f %13f\n",(i+1),x1, f1,x2, f2, x3, f3);
			if (Math.abs(f3) < error)
			{
				System.out.printf("el valor de la raiz es: %10f\n", x3);
				return;
			}
			x1 = x2;
			x2 = x3;
		}
		System.out.println("no se encontro la solucion");
	}

	private static double calcularFuncion(double xValor)
	{
		return -0.000234*(Math.pow((xValor-80), 2))+1.5;
	}//-0.000234(x-80)2+1.5
	private static double calcularDerivada(double xValor)
	{
		return -2*(0.000234*xValor)+160*(0.000234);
	}
}
