package EstructurasDatos;
public class cola <t>
{
	private static int primero;
	private static int ultimo;
	private t cola[];
	private static int valorMax;
	@SuppressWarnings("unchecked")
	public cola(int total)
	{
		primero = -1;
		ultimo = -1;
		valorMax = total -1;
		cola = (t[]) new Object[total];
	}
	public int ingresar(t dato)
	{
		if (estado() || primero != 0 && ultimo == valorMax)
		{
			if (primero == -1)primero=0;
			if (primero != 0 && ultimo == valorMax) ultimo =-1;
			ultimo++;
			cola[ultimo] = dato;
			return 1;
		}
		System.out.println("la cola esta llena");
		return 0;
	}
	public int quitar()
	{
		if (!estado() || primero >-1)
		{
			if(primero == ultimo && (primero >-1 || ultimo >-1))
			{
				System.out.println("la cola se ha quedado vacia");
				cola[primero]= null;
				primero = -1;
				ultimo = -1;
				return 1;
			}
			if(primero == valorMax)
			{
				primero =0;
				return 1;
			}
			cola[primero]= null;
			primero++;
			return 1;
		}
		System.out.println("la cola esta vacia");
		return 0;
	}
	public int imprime()
	{
		if (estado() || primero >-1)
		{
			for (int i = 0; i <= valorMax; i++)
			{
				if(cola[i]==null) continue;
				System.out.println(cola[i]);
			}
			return 1;
		}
		System.out.println("la cola esta vacia");
		return 0;
	}
	public boolean estado() // true se puede ingresar, false no se puede
	{
		if(primero !=1)
			return !((primero == 0 && ultimo == valorMax) || (ultimo == primero-1));
		else 
			return primero == -1;
	}
}
