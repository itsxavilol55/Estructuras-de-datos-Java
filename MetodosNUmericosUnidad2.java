package EstructurasDatos;
import java.util.ArrayList;
public class MetodosNUmericosUnidad2
{
	static String conceptos [];
	static String unidad, pregunta;
	public static void main(String[] args)
	{
		System.out.println("Metodos Numericos 9am a 10am");
		System.out.println("Instituto tecnologico de culiacan");
		System.out.println("Ing en sistemas computacionales");
		System.out.println("Javier Eduardo Lopez Ontiveros\n");
		System.out.println("solucion a un sistema de ecuaciones");
		System.out.println("Este programa ejecuta el proceso de cálculo de "
				+ "\nsolucion de un sistema de ecuaciones utilizando diversos métodos");
		System.out.println("Cual es la pregunta del problema");
		pregunta = Leer.dato();
		System.out.println("¿cuantas ecuaciones son?");
		int ecua = Leer.datoInt();
		System.out.println("¿cuantas incongnitas son?");
		int inco = Leer.datoInt();
		System.out.println("cual es la unidad a utilizar");
		unidad = Leer.dato();
		conceptos = new String[ecua];
		for (int i = 0; i <ecua; i++)
		{
			System.out.println("cual es el concepto de la incognita x"+(i+1));
			conceptos[i]= Leer.dato();
		}
		Object opcion;
		do
		{
			System.out.println("\nQue metodo quieres realizar??");
			System.out.println(
					"\n1.-Método de Gauss Jordan" + "\n2.-Método de Gauss Seidel" + "\nOtro caracter.-F I N");
			opcion = Leer.dato();
			double[][] Matriz = new double[ecua][inco + 1];
			try
			{
				if (opcion.equals("1"))
				{
					Matriz = ingresarEcuaciones(ecua, inco);
					MetodoJordan(Matriz, ecua, inco);
				} else if (opcion.equals("2"))
				{
					Matriz = ingresarEcuaciones(ecua, inco);
					MetodoSeidel(Matriz, ecua, inco);
				}
			} catch (Exception e)
			{
				System.out.println("ocurrio un error" + e);
			}
		} while (opcion.equals("1") || opcion.equals("2"));
		System.out.println("se ha salio del programa");
		System.exit(0);
	}
	private static double[][] ingresarEcuaciones(int ecua, int inco)
	{
		double[][] MatrizEcu = new double[ecua][inco + 1]; //  filas,  columnas
		for (int i = 0; i < ecua; i++)
		{
			System.out.println("ingrese la ecuacion " + (i + 1));
			System.out.println("ejemplo de ingreso: 2x + 5x + 7x = 12");
			String ecuacion = Leer.dato();
			ecuacion = ecuacion.replace(" ", "");
			String[] partes = ecuacion.split("x=", 2);
			MatrizEcu[i][inco] = Double.parseDouble(partes[1]);
			String numeros[] = partes[0].split("x+");
			for (int j = 0; j < inco; j++)
			{
				if (numeros[j].contains("-"))
				{
					numeros[j] = numeros[j].replace("-", "");
					MatrizEcu[i][j] = (-1) * Double.parseDouble(numeros[j]);
				} else
					MatrizEcu[i][j] = Double.parseDouble(numeros[j]);
			}
		}
		return MatrizEcu;
	}
	private static void MetodoSeidel(double[][] matriz, int ecua, int inco)
	{
		System.out.println("ingresa el valor del error");
		double error = Leer.datoDouble();
		System.out.println("ingresa el limite de calculos a realizar");
		int calculos = Leer.datoInt();
		System.out.println("Metodos Numericos 9am a 10am");
		System.out.println("Instituto tecnologico de culiacan\n");
		System.out.println("Ing en sistemas computacionales");
		System.out.println("Javier Eduardo Lopez Ontiveros\n");
		System.out.println("Metodo de Gauss Seidel");
		System.out.println("pregunta:" + pregunta);
		System.out.println("matriz original");
		int sumaDiag =0;
		ArrayList<Integer> numeros = new ArrayList<>();
		for (int i = 0; i < ecua; i++) //calcula la suma de diagonal del la matriz original
			sumaDiag += Math.abs(matriz[i][i]);
		double mayor =0;
		int sumaMayor=0;
		for (int i = 0; i < ecua; i++)// busca la mayor suma posible de la diagonal
		{
			mayor = Math.abs(matriz[0][i]);
			for (int j = 0; j < ecua; j++)
			{
				if(Math.abs(matriz[j][i])>mayor)
					mayor=Math.abs(matriz[j][i]);
			}
			sumaMayor+= mayor;
		}
		int num =0;
		System.out.println("matriz original");
		imprimeMatriz(matriz, ecua, inco);
		double[][] MatrizAux = new double[ecua][inco + 1];
		for (int k = 0; k < ecua; k++)
		{
			for (int i = 0; i < ecua; i++)//genera el orden en el que se van a acomodar las nuevas filas de la matriz
			{
				num = (int) (Math.random() * ecua);
				if (numeros.contains(num))
				{
					i--;
					continue;
				}
				numeros.add(num);
			}
			for (int i = 0; i < ecua; i++)// re ordena las filas para buscar la convergencia
				for (int j = 0; j <= ecua; j++)
					MatrizAux[numeros.get(i)][j] = matriz[i][j];
			int sumaDiagAux=0;
			for (int i = 0; i < ecua; i++) //calcula una nueva suma de la diagonal con el nuevo orden
				sumaDiagAux += Math.abs(MatrizAux[i][i]);
			if(sumaDiagAux==sumaMayor) // en caso de encontrar la suma mayor se termina el ciclo for principal
				k=4;
			else
				k--;
			numeros.clear();
		}
		System.out.println("matriz ya con la convergencia");
		imprimeMatriz(MatrizAux, ecua, inco);
		double[][] despejes = new double[ecua][inco + 1];
		for (int i = 0; i < ecua; i++)
		{
			despejes[i][0]= MatrizAux[i][ecua];
			despejes[i][ecua]= MatrizAux[i][i];
			MatrizAux[i][i]= 0;
		}
		for (int i = 0; i < ecua; i++)
		{
			int aux=1;
			for (int k = 0; k < ecua; k++)
			{
				if(MatrizAux[i][k]!=0)
				{
					despejes[i][aux]= -MatrizAux[i][k];
					aux++;
				}
			}
		}
		double incognitasNuevas[]= new double[ecua];
		System.out.printf("%4s ","No.");
		for (int i = 0; i < conceptos.length; i++)
			System.out.printf("%12s ",conceptos[i]);
		System.out.printf("%12s\n","error");
		for (int i = 0; i < calculos; i++)
		{
			double incognitas[]= new double[ecua];
			double errorAbs=0;
			for (int j = 0; j < ecua; j++)
			{
				int aux =0;
				for (int k = 0; k < ecua; k++)
				{
					if (k == 0)
						incognitas[j] = despejes[j][0];
					else
					{
						if(j == 0)
						{
							incognitas[j] = incognitas[j] + (despejes[j][k] * incognitasNuevas[aux+1]);
						}
						else if(aux!=j)
						{
							incognitas[j] = incognitas[j] + (despejes[j][k] * incognitasNuevas[aux]);
						}
						else
							k--;
						aux++;	
					}
				}
				incognitas[j]/=despejes[j][ecua];
				errorAbs += Math.abs(incognitas[j])-Math.abs(incognitasNuevas[j]);
				incognitasNuevas[j]=incognitas[j];
			}
			System.out.printf("%4d",(i+1));
			for (int j = 0; j < ecua; j++)
				System.out.printf("|%11.6f|",incognitas[j]);
			System.out.printf("|%11.6f|",errorAbs);
			System.out.println();
			if (Math.abs(errorAbs) < error)
			{
				System.out.println("se encontro la sulucion");
				for (int j = 0; j < conceptos.length; j++)
					System.out.printf("%12s: |%8.3f| %4s\n",conceptos[j],incognitas[j],unidad);
				return;
			}
		}
		System.out.println("no se encontro la solucion");
	}//8,4-2
	private static void MetodoJordan(double[][] matriz, int ecua, int inco)
	{
		double[][] nuevaMatriz = new double[ecua][inco + 1];
		System.out.println("Metodos Numericos 9am a 10am");
		System.out.println("Instituto tecnologico de culiacan\n");
		System.out.println("Ing en sistemas computacionales");
		System.out.println("Javier Eduardo Lopez Ontiveros\n");
		System.out.println("Metodo de Gauss Jordan");
		System.out.println("pregunta:" + pregunta);
		System.out.println("matriz original");
		imprimeMatriz(matriz, ecua, inco);
		double num1;
		double num2;
		for (int k = 0; k < ecua; k++)// hacer 0 abajo de la diagonal
		{
			num1 = matriz[k][k];
			for (int j = k+1; j < ecua; j++)
			{
				num2 = matriz[j][k];
				for (int i = 0; i <= inco; i++)
				{
					double suma1 = -1 * (num1 * matriz[j][i]);
					double suma2 = num2 * matriz[k][i];
					nuevaMatriz[k][i] = matriz[k][i];
					nuevaMatriz[j][i] = suma2 + suma1;
				}
			}
			for (int j = 0; j < ecua; j++)// cambio de la nueva matriz a la matriz
				for (int i = 0; i <= inco; i++)
					matriz [j][i]= nuevaMatriz[j][i];
		}
		for (int k = ecua-1; k > 0; k--) // hacer 0 arriba de la diagonal
		{
			num1 = matriz[k][k];
			for (int j = k-1; j >= 0; j--)
			{
				num2 = matriz[j][k];
				for (int i = 0; i <= inco; i++)
				{
					double suma1 = -1 * (num1 * matriz[j][i]);
					double suma2 = num2 * matriz[k][i];
					nuevaMatriz[k][i] = matriz[k][i];
					nuevaMatriz[j][i] = suma2 + suma1;
				}
			}
			for (int j = 0; j < ecua; j++)
				for (int i = 0; i <= inco; i++)
					matriz [j][i]= nuevaMatriz[j][i];
		}
		System.out.println("matriz transformada");
		for (int i = 0; i < ecua; i++)
		{
			matriz[i][ecua]= matriz[i][ecua]/matriz[i][i];
			matriz[i][i] = matriz[i][i]/matriz[i][i];
		}
		imprimeMatriz(matriz, ecua, inco);
		for (int i = 0; i < ecua; i++)
			System.out.printf("%12s: |%8.6f| %12s\n",conceptos[i],matriz[i][ecua],unidad);
	}
	private static void imprimeMatriz(double[][] matriz, int ecua, int inco)
	{
		for (int i = 0; i < inco; i++)
			System.out.printf("%10s", "x" + (i + 1));
		System.out.println();
		for (int i = 0; i < ecua; i++)
		{
			for (int j = 0; j <= inco; j++)
				System.out.printf("|%10.6f|", matriz[i][j]);
			System.out.println();
		}
	}
}/////////////
