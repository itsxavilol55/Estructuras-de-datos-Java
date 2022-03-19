package EstructurasDatos;
public class nodo 
{
	private nodo siguiente;
	private int matricula;
	private String Nombre;
	private int edad;
	private String genero;
	private int Calificacion;
	public nodo(int dato)
	{
		matricula = dato;
		setSiguiente(null);
	}
	public nodo getSiguiente()
	{
		return siguiente;
	}
	public int getDato()
	{
		return matricula;
	}
	public void setSiguiente(nodo siguiente)
	{
		this.siguiente = siguiente;
	}
}
