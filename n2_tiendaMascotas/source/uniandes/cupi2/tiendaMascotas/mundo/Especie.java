/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_tiendaMascotas
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.tiendaMascotas.mundo;

/**
 * Clase que representa una especie animal
 */
public class Especie
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para la cantidad máxima de venta.
	 */
	//TODO Parte1 PuntoA: Declarar la constante CANT_MAX_VENTA con valor 50. 
	 public final static int CANT_MAX_VENTA = 50;

	/**
	 * Constante para la cantidad mínima de compra.
	 */
	//TODO Parte1 PuntoB: Declarar la constante CANT_MIN_COMPRA con valor 5.
	public final static int CANT_MIN_COMPRA = 5;


	/**
	 * Enumeración para representar las posibles clases de una especie.
	 */
	 
	public enum clase
		{
			AVES, REPTILES, MAMIFEROS;
		}
	//TODO Parte1 PuntoC: Declarar la enum Clase con los posibles valores: AVES, REPTILES, MAMIFEROS.

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre de la especie.
	 */
	private String nombre;

	/**
	 * Vida promedio de la especie.
	 */
	private int vidaPromedio;

	/**
	 * Clase de la especie.
	 */
	private clase clase;

	/**
	 * Precio de venta de la especie.
	 */
	private double precioVenta;

	/**
	 * Cantidad de mascotas de la especie disponibles.
	 */
	private int cantidadActual;

	/**
	 * Cantidad de mascotas de la especie que han sido vendidas.
	 */
	private int cantidadVendidas;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva especie con los parámetro indicados.<br>
	 * <b>post: </b> Se construyó una especie con los parámetros especificados y unidades vendidas en 0.
	 * @param pNombre Nombre de la especie. pNombre != null && !pNombre.equals("").
	 * @param pVidaPromedio Vida promedio de la especie. pVidaPromedio > 0.
	 * @param pClase Clase a la que pertenece la especie. pClase == AVES || pClase == MAMIFEROS || pClase == REPTILES.
	 * @param pPrecioVenta Precio de venta de una mascota de la especie. pPrecioVenta > 0.
	 * @param pCantidadActual Cantidad de mascotas de la especie con las que cuenta la tienda. pCantidadActual >= 0.
	 * 
	 */
	public Especie( String pNombre, int pVidaPromedio, clase pClase, double pPrecioVenta, int pCantidadActual )
	{
		nombre = pNombre;
		vidaPromedio = pVidaPromedio;
		clase = pClase;
		precioVenta=pPrecioVenta;
		cantidadActual = pCantidadActual;
		cantidadVendidas=0;
	}

	/**
	 * Devuelve el nombre de la especie.
	 * @return Nombre de la especie.
	 */
	public String darNombre( )
	{
		return nombre;
	}

	/**
	 * Devuelve la vida promedio de la especie.
	 * @return Vida promedio de la especie.
	 */
	public int darVidaPromedio( )
	{
		return vidaPromedio;
	}

	/**
	 * Devuelve la clase de la especie.
	 * @return Clase a la que pertenece la especie.
	 */
	public clase darClase( )
	{
		return clase;
	}

	/**
	 * Devuelve el precio de venta de la especie.
	 * @return Precio de venta de la especie.
	 */
	public double darPrecioVenta()
	{
		return precioVenta;
	}

	/**
	 * Devuelve la cantidad de mascotas de la especie disponibles.
	 * @return Cantidad de mascotas de la especie disponibles.
	 */
	public int darCantidadActual( )
	{
		return cantidadActual;
	}

	/**
	 * Devuelve la cantidad de mascotas de la especie que han sido vendidas.
	 * @return Cantidad de mascotas de la especie vendidas.
	 */
	public int darCantidadVendidas()
	{
		return cantidadVendidas;
	}

	/**
	 * Vende una cantidad determinada de mascotas de la especie. Si la cantidad a vender es mayor a la cantidad disponible y no supera el máximo permitido, 
		se venden todas 
	 * las mascotas disponibles de la especia en la tienda.
	 * <b>post: </b> Se incrementó el número de mascotas vendidas con el valor del parámetro, en caso que las unidades disponibles sean suficientes. 
	 * Si el valor dado por parámetro es mayor al máximo permitido, no se realiza la venta. 
	 * Si el valor dado por parámetro es mayor a las unidades disponibles, pero menor al máximo permitido, el número de mascotas se incrementó con la cantidad 
	   de mascotas disponibles. Se decrementó la cantidad actual de mascotas 
	 * con el número de mascotas efectivamente vendidas.
	 * @param pCantidad Cantidad de mascotas que van a ser vendidas. pCantidad > 0.
	 * @return Cantidad de mascotas de la especie vendidas, -1 si no se pudo realizar la venta porque pCantidad es mayor al máximo.
	 */
	public int venderMascotas( int pCantidad )
	{
		if(pCantidad <= cantidadActual && pCantidad > 0)
		{
			cantidadVendidas = cantidadVendidas + pCantidad;
			cantidadActual = cantidadActual - pCantidad;
		}
		else if(pCantidad > cantidadActual && pCantidad < CANT_MAX_VENTA)
		{
			cantidadVendidas = cantidadVendidas + cantidadActual;
			cantidadActual = 0;
			
		}
		else
		{
			return -1;
		}
		return cantidadVendidas;
		//TODO Parte1 PuntoD: Completar el método según la documentación dada.
	}

	/**
	 * Compra una cantidad determinada de mascotas de la especie.
	 * @param pCantidad Cantidad de mascotas que van a ser compradas. pCantidad > 0.
	 * @return True si pudo realizar la compra, false en caso que pCantidad sea menor al mínimo.
	 */
	public boolean comprarMascotas( int pCantidad )
	{
		if(pCantidad > CANT_MIN_COMPRA)
		{
			cantidadActual = cantidadActual + pCantidad;
			return true;
		}
		else
		{
			return false;
		}
		//TODO Parte1 PuntoE: Completar el método según la documentación dada.
	}
}
