package EstructurasDatos;
public class MetodosOrdenamientoBusqueda
{
	public static void main(String[] args)
	{
		int vector[]= {7,5,3,9,1,8,6,4,2,0};
		int vectorA[]= {1,3,5,7,9};
		int vectorB[]= {2,4,6,8,10};
		int vectorM[]= {1,2,3,4,5,6,7,8,9};
		int vectorHash[] = {12,32,56,28,7,98,44,37,50,63};
		System.out.println("Que metodo se quiere realizar?\n");
		System.out.println("Métodos de ordenamiento\r\n"
				+ "Algoritmos de ordenamiento internos. \r\n"
				+ "1 Burbuja. \r\n"
				+ "2 Quicksort. \r\n"
				+ "3 Radix. \r\n\n"
				+ "Algoritmos de ordenamiento externos. \r\n"
				+ "4 Intercalación. \r\n"
				+ "5 Mezcla Natural\r\n\n"
				+ "Métodos de búsqueda\r\n"
				+ "6 Búsqueda secuencial. \r\n"
				+ "7 Búsqueda binaria. \r\n"
				+ "8 Búsqueda por funciones de HASH");
		int num = Leer.datoInt();
		switch (num)
		{
			case 1: burbuja(vector); break;
			case 2: quicksort(vector,0,vector.length-1); imprime(vector); break;
			case 3: radix(vector); break;
			case 4: intercalacion(vectorA, vectorB); break;
			case 5: mezclaNatural(vector); break;
			case 6: System.out.println(busquedaSecuencial(vectorA,7)); break;
			case 7: System.out.println(busquedaBinaria(vectorM, 2)); break;
			case 8: System.out.println(busquedaHash(vectorHash,44));break;
			default: System.out.println("no se econtro la opcion"); break;
		}
	}
	private static void burbuja(int[] vector)
	{
		int aux=0;
		for (int i = 0; i < vector.length-1; i++)
			for (int j = 0; j < vector.length-1; j++)
				if(vector[j]>vector[j+1])
				{
					aux = vector[j];
					vector[j]=vector[j+1];
					vector[j+1]=aux;
				}
		imprime(vector);
	}
	private static void quicksort(int vector[], int izq, int der)
	{
		int pivote = vector[izq];
		int i = izq,j = der,aux=0; 
		while (i < j)
		{                                   
			while (vector[i] <= pivote && i < j)
				i++; 
			while (vector[j] > pivote)
				j--; 
			if (i < j)
			{                       
				aux = vector[i]; 
				vector[i] = vector[j];
				vector[j] = aux;
			}
		}
		vector[izq] = vector[j];                                    
		vector[j] = pivote; 
		if (izq < j - 1)
			quicksort(vector, izq, j - 1); 
		if (j + 1 < der)
			quicksort(vector, j + 1, der); 
	}
	private static void radix(int[] vector)
	{
		int[][] bucket = new int[10][vector.length];
		int[] bucketOfElement = new int[10];
		int max = 0;
		for (int i = 0; i < vector.length; i++)
			if (vector[i] > max)
				max = vector[i];
		int maxLength = (max + "").length();
		for (int m = 0, n = 1; m < maxLength; m++, n *= 10)
			for (int i = 0; i < vector.length; i++)
			{
				int digit = vector[i] / n % 10;
				bucket[digit][bucketOfElement[digit]] = vector[i];
				bucketOfElement[digit]++;
			}
			int index = 0;
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < bucketOfElement[j]; k++)
				{
					vector[index] = bucket[j][k];
					index++;
				}
				bucketOfElement[j] = 0;
			}
		imprime(vector);
	}
	private static void intercalacion(int[] vectorA, int[] vectorB)
	{
		int i, k, j;
		int vectorC[] = new int[vectorA.length + vectorB.length];
		for (i = j = k = 0; i < vectorA.length && j < vectorB.length; k++)
			if(vectorA[i]<vectorB[j])
			{
				vectorC[k]=vectorA[i];
				i++;
			}
			else
			{
				vectorC[k]=vectorB[j];
				j++;
			}
		for(;i<vectorA.length; i++, k++)
			vectorC[k]= vectorA[i];
		for(;j<vectorB.length; j++, k++)
			vectorC[k]= vectorB[j];
		imprime(vectorC);
	}
	private static int[] mezclaDirecta(int[] vectorM)
	{
		int i,j,k;
		if(vectorM.length>1)
		{
			int totalIzq=vectorM.length/2;
			int totalDer = vectorM.length - totalIzq;
			int vectorIzq[]= new int [totalIzq];
			int vectorDer[]= new int [totalDer];
			for (i = 0; i < totalIzq; i++)
				vectorIzq[i]= vectorM[i];
			for (i = totalIzq; i < totalIzq+totalDer; i++)
				vectorDer[i-totalIzq] = vectorM[i];
			vectorIzq = mezclaDirecta(vectorIzq);
			vectorDer = mezclaDirecta(vectorDer);
			i=j=k=0;
			while(vectorIzq.length!= j && vectorDer.length!=k)
				if(vectorIzq[j]<vectorDer[k])
				{
					vectorM[i]= vectorIzq[j];
					i++;
					j++;
				}
				else
				{
					vectorM[i]= vectorDer[k];
					i++;
					k++;
				}
			while(vectorIzq.length!=j) 
			{
				vectorM[i] =vectorIzq[j];
				i++;
				j++;
			}
			while(vectorDer.length!=k) 
			{
				vectorM[i] =vectorDer[k];
				i++;
				k++;
			}
		}
		return vectorM;
	}
	private static void mezclaNatural(int[] vectorM)
	{
		int izquierda =0, izq =0, derecho = vectorM.length-1, der=derecho;
		boolean ordenado= false;
		do 
		{
			ordenado = true;
			izquierda=0;
			while(izq<derecho)
			{
				izq = izquierda;
				while(izq < derecho && vectorM[izq]<=vectorM[izq+1])
					izq++;
				der = izq+1;
				while(der==derecho-1 || der <derecho && vectorM[der]<= vectorM[der+1])
					der++;
				if(der<= derecho) 
				{
					mezclaDirecta(vectorM);
					ordenado=false;
				}
				izquierda=izq;
			}
		}while(!ordenado);
		imprime(vectorM);
	}
	private static int busquedaSecuencial(int[] vector, int dato)
	{
		boolean encontrado= false;
		for (int j = 0; j < vector.length && encontrado==false; j++)
			if(dato==vector[j])
			{
				encontrado=true;
				return j;
			}
		return -1;
	}
	private static int busquedaBinaria(int[] vector, int dato)
	{
		int primero = 0,valorCentro=0,centro=0;
		int ultimo = vector.length - 1;
		while(primero<=ultimo)
		{
			centro = (primero + ultimo)/2;
			valorCentro= vector[centro];
			if(dato== valorCentro)
			{
				return centro;
			}
			else if(dato<valorCentro)
				ultimo = centro-1;
			else
				primero = centro+1;
		}
		return -1;
	}
	private static int busquedaHash(int[] vector, int dato)
	{
		int modulo = vector.length-1,clave=0;
		int indice = dato%modulo;
		int claves[]= new int [vector.length];
		for (int i = 0; i < vector.length; i++)
		{
			clave = vector[i]%modulo;
			while(claves[clave]!=0)
			{
				clave++;
				if(clave==claves.length) clave=0;
			}
			claves[clave]=vector[i];
		}
		for (int i = 0; i < claves.length; i++)
			if(dato==claves[indice]) return indice;
			else 
			{
				indice++;
				if(indice==claves.length)indice=0;
			}
		return -1;
	}
	private static void imprime(int[] vector)
	{
		System.out.println("Vector:");
		for (int i : vector)
			System.out.println(i);
	}
}