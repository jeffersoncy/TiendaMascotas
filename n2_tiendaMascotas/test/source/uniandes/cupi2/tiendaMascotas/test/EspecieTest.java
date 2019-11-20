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

package uniandes.cupi2.tiendaMascotas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import uniandes.cupi2.tiendaMascotas.mundo.Especie;

/*
 * Clase usada para verificar que los métodos de la clase Especie están correctamente implementados.
 */
public class EspecieTest
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * Especie de prueba.
	 */
	private Especie especie;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/*
	 * Escenario 1: Construye una nueva especie con la siguiente información:
	 * 
	 * especie - nombre: Cacatúa Blanca, vida promedio: 85, clase: aves, precio de venta: 1.500.000, cantidad disponible: 20.
	 */
	@Before
	public void setupEscenario1( )
	{
		especie = new Especie("Cacatúa Blanca", 85, Especie.clase.AVES, 1500000, 20);
	}

	/**
     * Prueba 1: Creación de la especie con su información general.
     */
	@Test
	public void testEspecie( )
	{
		assertEquals( "Nombre no iniciado correctamente.", "Cacatúa Blanca", especie.darNombre( ) );
		assertEquals( "Vida promedio no iniciada correctamente.", 85, especie.darVidaPromedio( ) );
		assertEquals( "Clase no iniciada correctamente.", Especie.clase.AVES, especie.darClase( ) );
		assertEquals( "Precio de venta no iniciado correctamente.", (double)1500000, especie.darPrecioVenta(), 0.01);
		assertEquals( "Cantidad actual no iniciada correctamente.", 20, especie.darCantidadActual( ) );
		assertEquals( "Cantidad vendida no iniciada correctamente.", 0, especie.darCantidadVendidas() );
	}

	/**
     * Prueba 2: Obtener el nombre de la especie.
     */
	@Test
	public void testDarNombre( )
	{
		assertEquals( "El nombre esperado es Cacatúa Blanca.", "Cacatúa Blanca", especie.darNombre( ) );
	}

	/**
     * Prueba 3: Obtener la vida promedio de la especie.
     */
	@Test
	public void testDarVidaPromedio( )
	{
		assertEquals( "La vida promedio esperada es 85.", 85, especie.darVidaPromedio( ) );
	}

	/**
     * Prueba 4: Obtener la clase de la especie.
     */
	@Test
	public void testDarClase( )
	{
		assertEquals( "La clase no es la esperada.", Especie.clase.AVES, especie.darClase( ) );
	}

	/**
     * Prueba 5: Obtener el precio de venta de la especie.
     */
	@Test
	public void testDarPrecioVenta()
	{
		assertEquals("El precio de venta esperado es 1500000.0.", 1500000.0, especie.darPrecioVenta(), 0.01);
	}

	/**
     * Prueba 6: Obtener la cantidad actual de mascotas de la especie.
     */
	@Test
	public void testDarCantidadActual( )
	{
		assertEquals( "La cantidad actual de mascotas esperada es 20.", 20, especie.darCantidadActual( ) );
	}

	/**
     * Prueba 7: Obtener la cantidad de mascotas vendidas de la especie.
     */
	@Test
	public void testDarCantidadVendidas()
	{
		assertEquals("La cantidad de mascotas vendidas es 0.", 0, especie.darCantidadVendidas());
	}

	/**
     * Prueba 8: Vender una cantidad determinada de mascotas de la especie.
     * 1. Verificar que la cantidad actual disminuye.
     * 2. Verificar que la cantidad vendida aumenta.
     */
	@Test
	public void testVenderMascotas( )
	{
		especie.venderMascotas( 5 );
		// 1. Verificar que la cantidad actual disminuye.
		assertEquals( "La cantidad actual de mascotas restantes no coincide después de vender. Se esperaba una cantidad igual a 15.", 15, especie.darCantidadActual( ) );
		// 2. Verificar que la cantidad vendida aumenta.
		assertEquals("La cantidad de mascotas vendidas no corresponde después de vender. Se esperaba una cantidad igual a 5.", 5, especie.darCantidadVendidas());
		
		// Al intentar vender mas de 50, no debería permitirlo.
		especie.venderMascotas( 51 );
		assertEquals( "La cantidad actual de mascotas restantes no coincide después de vender. Se esperaba una cantidad igual a 15.", 15, especie.darCantidadActual( ) );
		assertEquals("La cantidad de mascotas vendidas no corresponde después de vender. Se esperaba una cantidad igual a 5.", 5, especie.darCantidadVendidas());
		
		
	}

	/**
     * Prueba 9: Comprar una cantidad determina de mascotas de la especie.
     */
	@Test
	public void testComprarMascotas( )
	{
		boolean resultado = especie.comprarMascotas( 50 );
		assertEquals( "La cantidad actual de las mascotas no coincide. Se esperaba una cantidad igual a 70", 70, especie.darCantidadActual( ) );
		assertEquals( "Debería permitir comprar cuando la cantidad es mayor a 5.", true, resultado);
		resultado = especie.comprarMascotas( 4 );
		assertEquals( "La cantidad actual de las mascotas no coincide. Se esperaba una cantidad igual a 70", 70, especie.darCantidadActual( ) );
		assertEquals( "No debería permitir comprar cuando la cantidad es menor a 5.", false, resultado);
	}



}