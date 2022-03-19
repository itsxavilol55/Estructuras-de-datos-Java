package EstructurasDatos;
class pila<t>
{
	private static int indice = -1;
	private t pila[];
	private static int valorMax;
	@SuppressWarnings("unchecked")
	public pila(int total)
	{
		valorMax = total - 1;
		pila = (t[]) new Object[total];
	}
	public int push(t dato)
	{
		if (indice != valorMax)
		{
			indice++;
			pila[indice] = dato;
			return 1;
		}
		System.out.println("la pila esta llena");
		return 0;
	}
	public Object quitar()
	{
		if (indice != -1)
		{
			indice--;
			return pila[indice+1];
		}
		System.out.println("la pila esta vacia");
		return -1;
	}
	public void estado()
	{
		if(indice == valorMax) 
			System.out.println("la pila esta llena");
		else if (indice == -1)
			System.out.println("la pila esta vacia");
		else 
			System.out.printf("la pila tiene%3d  elemntos\n", indice+1);
	}
	public int imprime()
	{
		if (indice != -1)
		{
			for (int i = indice; i >= 0; i--)
			{
				System.out.println(pila[i]);
			}
			return 1;
		}
		System.out.println("la pila esta vacia");
		return 0;
	}
}
