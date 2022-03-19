package EstructurasDatos;
public class LIsta <t>
{
	private nodo primero;
	private nodo ultimo;
	private int cantidad;
	public LIsta()
	{
		primero = null;
		ultimo = null;
		cantidad =0;
	}
	public void imprime()
	{
		nodo nodoAux = getPrimero();
		for (int i = 0; i < cantidad; i++)
		{
			System.out.println(nodoAux.getDato());
			nodoAux = nodoAux.getSiguiente();
		}
	}
	public void ingresarInicio(int dato)
	{
		if(vacia())
		{
			primero = new nodo(dato); 
			ultimo = primero;
		}
		else
		{
			nodo nuevo = new nodo(dato);
			nuevo.setSiguiente(primero);
			primero = nuevo;
		}
		cantidad++;
	}
	public void ingresarFinal(int dato)
	{
		if(vacia())
		{
			ultimo = new nodo(dato); 
			primero = ultimo;
		}
		else
		{
			nodo nuevo = new nodo(dato);
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
		}
		cantidad++;
	}
	public void ingresarMedio(int dato, int posci)
	{
		if(vacia())
		{
			primero = new nodo(dato); 
			ultimo = primero;
			cantidad++;
		}
		else if (posci <= cantidad)
		{
			nodo nuevoNodo = new nodo(dato);
			nodo nodoAux = getPrimero();
			for (int i = 0; i < posci-1; i++)
			{
				nodoAux = nodoAux.getSiguiente();
			}
			nodo nodoAuxSuiguiente = nodoAux.getSiguiente();
			nodoAux.setSiguiente(nuevoNodo);
			nuevoNodo.setSiguiente(nodoAuxSuiguiente);
			cantidad++;
		}
		else
			System.out.println("no se puede ingresar aqui");
	}
	public int ingresarOrden(int numero)
	{
		if(vacia())
		{
			ultimo = new nodo(numero); 
			primero = ultimo;
			cantidad++;
		}
		else
		{
			nodo nodoAux = getPrimero();
			for (int i = 0; i < cantidad; i++)
			{
				if(numero == nodoAux.getDato()) return 0;
				nodoAux = nodoAux.getSiguiente();
			}
			nodoAux = getPrimero();
			if(numero < primero.getDato())
				ingresarInicio(numero);
			else if(numero > ultimo.getDato())
				ingresarFinal(numero);
			else 
			{
				nodoAux = getPrimero();
				for (int i = 0; i < cantidad; i++)
				{
					if(numero > nodoAux.getDato() && numero < nodoAux.getSiguiente().getDato()) 
						ingresarMedio(numero, i+1);
					nodoAux = nodoAux.getSiguiente();
				}
			}
		}
		return 0;
	}
	public void quitarInicio()
	{
		if(!vacia())
		{
			nodo nodoAux = primero.getSiguiente();
			primero.setSiguiente(null);
			primero = nodoAux;
			cantidad--;
		}
		else System.out.println("no se puede quitar, no hay nada");
	}
	public void quitarfinal()
	{
		if(!vacia())
		{
			nodo nodoAux = getPrimero();
			for (int i = 0; i < cantidad-2; i++)
			{
				nodoAux = nodoAux.getSiguiente();
			}
			nodoAux.setSiguiente(null);
			cantidad--;
		}
		else System.out.println("no se puede quitar, no hay nada");
	}
	public void quitarMedio(int posci)
	{
		if(!vacia())
		{
			nodo nodoAux = getPrimero();
			if(posci ==0) 
			{
				quitarInicio();
				return;
			}
			for (int i = 0; i < posci-1; i++)
			{
				nodoAux = nodoAux.getSiguiente();
			}
			nodo nodoAuxSig = nodoAux.getSiguiente();
			nodo nodoAuxSigSig = nodoAuxSig.getSiguiente();
			nodoAuxSig.setSiguiente(null);
			nodoAux.setSiguiente(nodoAuxSigSig);
			cantidad--;
		}
		else System.out.println("no se puede quitar, no hay nada");
	}
	public int quitar(int numero)
	{
		if (!vacia())
		{
			nodo nodoAux = getPrimero();
			for (int i = 0; i < cantidad; i++)
			{
				if (numero == nodoAux.getDato())
				{
					quitarMedio(i);
					return i;
				}
				nodoAux = nodoAux.getSiguiente();
			}
		}
		else System.out.println("no se puede quitar, no hay nada");
		return 0;
		
	}
	public boolean vacia()
	{
		return cantidad == 0;
	}
	public nodo getUltimo()
	{
		return ultimo;
	}
	public nodo getPrimero()
	{
		return primero;
	}
}
