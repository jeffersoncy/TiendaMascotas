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

import uniandes.cupi2.tiendaMascotas.mundo.Especie.clase;

/**
 * Clase que representa la tienda de mascotas.
 */
public class TiendaMascotas
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Especie número 1.
	 */
	private Especie especie1;

	/**
	 * Especie número 2.
	 */
	private Especie especie2;

	/**
	 * Especie número 3.
	 */
	private Especie especie3;

	/**
	 * Especie número 4.
	 */
	private Especie especie4;


	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea las especies que estan en venta en la tienda con la siguiente información:.<br>
	 * Especie1 - nombre: Cacatúa Blanca, vida promedio: 85, clase: aves, precio de venta: 1.500.000, cantidad disponible: 20.<br>
	 * Especie2 - nombre: Boa Constrictor, vida promedio: 25, clase: reptiles, precio de venta: 2.000.000, cantidad disponible: 54.<br>
	 * Especie3 - nombre: Tití Dorado, vida promedio: 14, clase: mamíferos, precio de venta: 5.000.000, cantidad disponible: 23.<br>
	 * Especie4 - nombre: Guacamaya Roja, vida promedio: 35, clase: aves, precio de venta: 15.000.000, cantidad disponible: 34.
	 */
	public TiendaMascotas( )
	{
		especie1 = new Especie("Cacatúa Blanca", 85, Especie.clase.AVES, 1500000, 20);
		especie2 = new Especie("Boa Constrictor", 25, Especie.clase.REPTILES, 2000000, 54);
		especie3 = new Especie("Tití Dorado", 14, Especie.clase.MAMIFEROS, 5000000, 23);
		especie4 = new Especie("Guacamaya Roja", 35, Especie.clase.AVES, 15000000, 34);
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve la especie número 1.
	 * @return Especie 1.
	 */
	public Especie darEspecie1()
	{
		return especie1;
	}

	/**
	 * Devuelve la especie número 2.
	 * @return Especie 2.
	 */
	public Especie darEspecie2()
	{
		return especie2;
	}

	/**
	 * Devuelve la especie número 3.
	 * @return Especie 3.
	 */
	public Especie darEspecie3()
	{
		return especie3;
	}

	/**
	 * Devuelve la especie número 4.
	 * @return Especie 4.
	 */
	public Especie darEspecie4()
	{
		return especie4;
	}

	/**
	 * Vende una cantidad de mascotas de una especie.
	 * <b>post: </b> Se vendió una cantidad de mascotas para una especie determinada según los parametros dados.
	 * @param pNombreEspecie Nombre de la especie de la cual se quieren vender mascotas. pNombreEspecie != null && pNombreEspecie != "".
	 * @param pCantidad Cantidad de mascotas que van a ser vendidas. pCantidad > 0.
	 * @return Cantidad de mascotas de la especie vendidas, -1 si no se pudo realizar la venta.
	 */
	public int venderMascotas( String pNombreEspecie, int pCantidad )
	{
		 int varTotal = -1;
         if((pNombreEspecie != null && pNombreEspecie != "") && pCantidad > 0)
         {
             if(pNombreEspecie == especie1.darNombre())
             {
            	 varTotal = especie1.darCantidadActual();
            	 especie1.venderMascotas(pCantidad);
            	 varTotal = varTotal - especie1.darCantidadActual();
             }
             else if (pNombreEspecie == especie2.darNombre())
             {
            	 varTotal = especie2.darCantidadActual();
            	 especie2.venderMascotas(pCantidad);
            	 varTotal = varTotal - especie2.darCantidadActual();
             }
             else if (pNombreEspecie == especie3.darNombre())
             {
            	 varTotal = especie3.darCantidadActual();
            	 especie3.venderMascotas(pCantidad);
            	 varTotal = varTotal - especie3.darCantidadActual();
             }
             else if (pNombreEspecie == especie4.darNombre())
             {
            	 varTotal = especie4.darCantidadActual();
            	 especie4.venderMascotas(pCantidad);
            	 varTotal = varTotal - especie4.darCantidadActual();
             }
         }
         return varTotal;
		//TODO Parte2 PuntoA: Completar el método según la documentación dada.
	}

	/**
	 * Compra una cantidad de mascotas de una especie determinada.
	 * <b>post: </b> Se compró una cantidad de mascotas para una especie determinada según los parámetros dados.
	 * @param pNombreEspecie Nombre de la especie de la cual se quieren comprar mascotas. pNombreEspecie != null && pNombreEspecie != "".
	 * @param pCantidad Cantidad de mascotas que van a ser compradas. pCantidad > 0.
	 * @return True si pudo realizar la compra, false si no se pudo realizar la comprar porque pCantidad es menor al mínimo.
	 */
	public boolean comprarMascotas( String pNombreEspecie, int pCantidad )
	{
		boolean varMensaje = false;
        if((pNombreEspecie != null && pNombreEspecie != "") && pCantidad > 0)
        {
            if(pNombreEspecie == especie1.darNombre())
            {
                varMensaje = especie1.comprarMascotas(pCantidad);
            }
            else if (pNombreEspecie == especie2.darNombre())
            {
                varMensaje = especie2.comprarMascotas(pCantidad);
            }
            else if (pNombreEspecie == especie3.darNombre())
            {
                varMensaje = especie3.comprarMascotas(pCantidad);
            }
            else if (pNombreEspecie == especie4.darNombre())
            {
                varMensaje = especie4.comprarMascotas(pCantidad);
            }
        }
        return varMensaje;
		//TODO Parte2 PuntoB: Completar el método según la documentación dada.
	}

	/**
	 * Busca las especies de acuerdo a tres criterios dados por parámetro: clase de la especie, vida promedio máxima de la especie y precio de venta máximo de la especie.
	 * @param pClaseEspecie Clase a la cual pertenece la especie. pClaseEspecie == Especie.AVES || pClaseEspecie == Especie.REPTILES || pClaseEspecie == Especie.MAMIFEROS.
	 * @param pVidaPromedioMax Vida promedio máxima que puede tener la especie. pVidaPromedioMax > 0.
	 * @param pPrecioVentaMax Precio de venta máximo que puede tener la especie. pPrecioVentaMax > 0.
	 * @return Mensaje con el nombre de las especies que cumplen los criterios establecidos. Los nombres las especies deben estar separados por comas. 
	 *         En caso de no encontrar especies se debe retornar el siguiente mensaje: "Ninguna de las especies cumple los criterios."
	 */
	public String buscarEspecies( clase pClaseEspecie, int pVidaPromedioMax, double pPrecioVentaMax )
	{
		String especieDada = "";
        if(pClaseEspecie != null && pVidaPromedioMax > 0 && pPrecioVentaMax >0)
        {
            if(pClaseEspecie == especie1.darClase() && pVidaPromedioMax >= especie1.darVidaPromedio() && pPrecioVentaMax >= especie1.darPrecioVenta())
            {
                especieDada = especie1.darNombre()+", ";
            }
            else if (pClaseEspecie == especie2.darClase() && pVidaPromedioMax >= especie2.darVidaPromedio() && pPrecioVentaMax >= especie2.darPrecioVenta())
            {
                especieDada = especieDada + especie2.darNombre()+", ";
            }
            else if (pClaseEspecie == especie3.darClase() && pVidaPromedioMax >= especie3.darVidaPromedio() && pPrecioVentaMax >= especie3.darPrecioVenta())
            {
                especieDada = especieDada + especie3.darNombre()+", ";
            }
            else if (pClaseEspecie == especie4.darClase() && pVidaPromedioMax >= especie4.darVidaPromedio() && pPrecioVentaMax >= especie4.darPrecioVenta())
            {
                especieDada = especieDada + especie4.darNombre();
            }
            else
            {
                especieDada = "Ninguna de las especies cumple los criterios";
            }
        }
        else 
        {
             especieDada = "Ninguna de las especies cumple los criterios";
        }
        return especieDada;
		//TODO Parte2 PuntoC: Completar el método según la documentación dada.
	}

	/**
	 * Informa cual de todas las especies es la que tiene menos mascotas vendidas. 
	 * @return Nombre de la especie con menor cantidad de unidades vendidas. Si hay dos con la misma cantidad mínima, retorna cualquiera.
	 */
	public String darEspecieMenosVendida( )
	{
        Especie especieAux = especie1;
        
        if(especie1.darCantidadVendidas() < especie2.darCantidadVendidas())
        {
            especieAux = especie1;
        }
        else
        {
            especieAux = especie2;
        }
        if(especieAux.darCantidadVendidas() > especie3.darCantidadVendidas())
        {
            especieAux = especie3;
        }
        if(especieAux.darCantidadVendidas() > especie4.darCantidadVendidas())
        {
            especieAux = especie4;
        }
        return especieAux.darNombre();
		//TODO Parte2 PuntoD: Completar el método según la documentación dada.
	}

	/**
	 * Calcula el monto de venta promedio de la tienda. Esto es: el monto total de ventas de toda la tienda dividido por la cantidad total de mascotas vendidas de todas las especies.
	 * @return Monto de venta promedio.
	 */
	public double darMontoVentaPromedio()
	{
		
		double cantidadTotalVentas = 0;
        double montoTotalEsp1 = 0;
        double montoTotalEsp2 = 0;
        double montoTotalEsp3 = 0;
        double montoTotalEsp4 = 0;
        double montoTotalVentas = 0;
        
        if(especie1.darCantidadVendidas() != 0 || especie2.darCantidadVendidas() != 0 || especie3.darCantidadVendidas()!= 0 || especie4.darCantidadVendidas() != 0)
        {
        	montoTotalEsp1 =  especie1.darCantidadVendidas() * especie1.darPrecioVenta();
        	montoTotalEsp2 =  especie2.darCantidadVendidas() * especie2.darPrecioVenta();
        	montoTotalEsp3 =  especie3.darCantidadVendidas() * especie3.darPrecioVenta();
        	montoTotalEsp4 =  especie4.darCantidadVendidas() * especie4.darPrecioVenta();
        	montoTotalVentas = montoTotalEsp1 + montoTotalEsp2 + montoTotalEsp3 + montoTotalEsp4;
        	cantidadTotalVentas = especie1.darCantidadVendidas()+especie2.darCantidadVendidas()+especie3.darCantidadVendidas()+especie4.darCantidadVendidas();
        	return montoTotalVentas / cantidadTotalVentas;
        }
        else
        {
        	return 0;
        }
        	
		//TODO Parte2 PuntoE: Completar el método según la documentación dada.
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 * @return Respuesta1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1.";
	}

	/**
	 * Método para la extensión 2.
	 * @return respuesta2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2.";
	}
}