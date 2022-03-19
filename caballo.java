package EstructurasDatos;
import uno.montura;
//javier eduardo lopez ontiveros 
//9am a 10pm
//examen tercer parcial 
//DR Clemente Garcia Gerardo
public class caballo
{
	private int noPaseos;
	private boolean estaMontado;
	private boolean tieneMontura;
	private montura monturaCab;
	private float KmRecorridos;
	public caballo() // el caballo se crea sin montura y despues se le pone
	{
		noPaseos = 0;
		estaMontado= false;
		tieneMontura = false;
	}
	public boolean ponerMontura(montura mon1) // quise usar los 3 tipos de validacion
	{							// de los diferentes metodos
		monturaCab = mon1; // aqui se inicia la montura del caballo con los valores de la mon1 que viene como parametro
		if(tieneMontura || monturaCab.isEstaPuesta())  return false;
		monturaCab.setEstaPuesta(true);
		tieneMontura = true;
		return true;
		// se manda el true o false dependiendo de lo que sea y lo compara en la apl en un if 
		// y imprime depenidiendo el resulatdo
	}
	public String montar()
	{
		if(!tieneMontura || estaMontado)
			return "no se puede montar al caballo";
		estaMontado = true;
		return "si se pudo montar al caballo";
		// se imprime directamente el resultado en la apl con un print 
		// dependiendo de que condicion se cumpla 
	}
	public void darPaseo() // en este se valida directamente en el metodo y imprime sin necesidad 
	{ 			// de escribir algo mas en la aplicacion y se puede usar con una gran cantidad
				// de caballos haciendolo mas facil
		if(!estaMontado)
		{
			System.out.println("no se puede dar un paseo no hay nadie");
			return; // este return es para que al no cumplirse la condicion, el metodo acabe
				//y asi no llegar a realizar otra accion
		}
		if(noPaseos>= monturaCab.getPaseosDisponibles()  || monturaCab.getNivelAjuste() == 0 )
		{
			System.out.println(" no se puede dar un paseo, ajusta la montura");
			return;
		}
		noPaseos++;
		KmRecorridos = (float) ((Math.random()*16)+5);
		System.out.println("se pudo dar un paseo de "+ KmRecorridos);
		return;
	}
	public boolean ajustarMon(int nivel)
	{
		if(!estaMontado || nivel > 3 || nivel < 0) // solo se valida que este montado porque para que este montado
			return false;			// debe tener montura puesta
		if(nivel == 1)
			monturaCab.setPaseosDisponibles(10);
		if(nivel == 2)
			monturaCab.setPaseosDisponibles(15);

		if(nivel == 3)
			monturaCab.setPaseosDisponibles(25);
		monturaCab.setNivelAjuste(nivel);
		return true;
	}
	public String bajarCaballo()
	{
		if(!estaMontado) return"no se pudo bajar no esta montado";
		estaMontado = false;
		return "si se pudo bajar correctamente";
	}
	public void quitarMontura()
	{
		if(estaMontado || !tieneMontura) 
		{
			System.out.println("no se puede quitar la montura");
			return;
		}
		tieneMontura= false;
		monturaCab.setEstaPuesta(false);
		monturaCab.setEstaDesinfectada(true);
		System.out.println("se pudo quitar la montura");
		return;
	}
}// linea final 