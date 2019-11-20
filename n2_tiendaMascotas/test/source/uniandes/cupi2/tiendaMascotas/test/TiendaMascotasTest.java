/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
import uniandes.cupi2.tiendaMascotas.mundo.Especie.clase;
import uniandes.cupi2.tiendaMascotas.mundo.TiendaMascotas;

/**
 * Clase usada para verificar que los m�todos de la clase TiendaMascotas est�n correctamente implementados.
 */
public class TiendaMascotasTest
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Tienda de mascotas de prueba.
	 */
	private TiendaMascotas tiendaMascotas;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Escenario 1: Construye una nueva tienda de mascotas con las siguientes especies.
	 * Especie1 - nombre: Cacat�a Blanca, vida promedio: 85, clase: aves, precio de venta: 1.500.000, cantidad disponible: 20.<br>
	 * Especie2 - nombre: Boa Constrictor, vida promedio: 25, clase: reptiles, precio de venta: 2.000.000, cantidad disponible: 54.<br>
	 * Especie3 - nombre: Tit� Dorado, vida promedio: 14, clase: mam�feros, precio de venta: 5.000.000, cantidad disponible: 23.<br>
	 * Especie4 - nombre: Guacamaya Blanca, vida promedio: 35, clase: aves, precio de venta: 15.000.000, cantidad disponible: 34.
	 */
	@Before
	public void setupEscenario1( )
	{
		tiendaMascotas = new TiendaMascotas( );
	}

	/**
     * Prueba 1: Creaci�n de cada una de las cuatro especies.
     */
	@Test
	public void testTiendaMascotas( )
	{
		assertNotNull( "Al crear la especie 1, esta no deber�a ser nula.", tiendaMascotas.darEspecie1());
		assertNotNull( "Al crear la especie 2, esta no deber�a ser nula.", tiendaMascotas.darEspecie2());
		assertNotNull( "Al crear la especie 3, esta no deber�a ser nula.", tiendaMascotas.darEspecie3());
		assertNotNull( "Al crear la especie 4, esta no deber�a ser nula.", tiendaMascotas.darEspecie4());

		assertEquals("El nombre de la especie1 no corresponde.", "Cacat�a Blanca", tiendaMascotas.darEspecie1().darNombre() );
		assertEquals("El nombre de la especie2 no corresponde.", "Boa Constrictor", tiendaMascotas.darEspecie2().darNombre() );
		assertEquals("El nombre de la especie3 no corresponde.", "Tit� Dorado", tiendaMascotas.darEspecie3().darNombre() );
		assertEquals("El nombre de la especie4 no corresponde.", "Guacamaya Roja", tiendaMascotas.darEspecie4().darNombre() );
		

		assertEquals("La vida promedio de la especie1 no corresponde.", 85, tiendaMascotas.darEspecie1().darVidaPromedio() );
		assertEquals("La vida promedio de la especie2 no corresponde.", 25, tiendaMascotas.darEspecie2().darVidaPromedio() );
		assertEquals("La vida promedio de la especie3 no corresponde.", 14, tiendaMascotas.darEspecie3().darVidaPromedio() );
		assertEquals("La vida promedio de la especie4 no corresponde.", 35, tiendaMascotas.darEspecie4().darVidaPromedio() );

		assertEquals("La clase de la especie1 no corresponde.", clase.AVES, tiendaMascotas.darEspecie1().darClase() );
		assertEquals("La clase de la especie2 no corresponde.", clase.REPTILES, tiendaMascotas.darEspecie2().darClase() );
		assertEquals("La clase de la especie3 no corresponde.", clase.MAMIFEROS, tiendaMascotas.darEspecie3().darClase() );
		assertEquals("La clase de la especie4 no corresponde.", clase.AVES, tiendaMascotas.darEspecie4().darClase() );
		

		assertEquals("La cantidad actual de la especie1 no corresponde.", 20, tiendaMascotas.darEspecie1().darCantidadActual() );
		assertEquals("La cantidad actual de la especie2 no corresponde.", 54, tiendaMascotas.darEspecie2().darCantidadActual() );
		assertEquals("La cantidad actual de la especie3 no corresponde.", 23, tiendaMascotas.darEspecie3().darCantidadActual() );
		assertEquals("La cantidad actual de la especie4 no corresponde.", 34, tiendaMascotas.darEspecie4().darCantidadActual() );

	}

	/**
     * Prueba 2: Vender cada una de las cuatro especies con una cantidad determinada contemplado los casos siguientes:
     * 1. Cuando la cantidad a vender es menor a la cantidad actual disponible.
     * 2. Cuando la cantidad a vender es igual a la cantidad actual disponible.
     * 3. Cuando la cantidad a vender es mayor a la cantidad actual disponible.
     * 4. Cuando la cantidad actual disponible es 0.
     */
	@Test
	public void testVenderMascotas( )
	{
		//1. Cuando la cantidad a vender es menor a la cantidad actual  disponible.

		tiendaMascotas.venderMascotas("Cacat�a Blanca", 15);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 5.", 5, tiendaMascotas.darEspecie1().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 15.", 15, tiendaMascotas.darEspecie1().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Boa Constrictor", 10);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 44.", 44, tiendaMascotas.darEspecie2().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 10.", 10, tiendaMascotas.darEspecie2().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Tit� Dorado", 8);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 15.", 15, tiendaMascotas.darEspecie3().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 8.", 8, tiendaMascotas.darEspecie3().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Guacamaya Roja", 33);
		assertEquals("La cantidad actual de mascotas disponibles debe ser .", 1, tiendaMascotas.darEspecie4().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 33.", 33, tiendaMascotas.darEspecie4().darCantidadVendidas());

		//2. Cuando la cantidad a vender es igual a la cantidad actual.
		setupEscenario1( );

		tiendaMascotas.venderMascotas("Cacat�a Blanca", 20);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie1().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 20.", 20, tiendaMascotas.darEspecie1().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Boa Constrictor", 10);
		tiendaMascotas.venderMascotas("Boa Constrictor", 44);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie2().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 54.", 54, tiendaMascotas.darEspecie2().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Tit� Dorado", 23);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie3().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 23.", 23, tiendaMascotas.darEspecie3().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Guacamaya Roja", 34);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie4().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 34.", 34, tiendaMascotas.darEspecie4().darCantidadVendidas());

		//3. Cuando la cantidad a vender es mayor a la cantidad actual.
		setupEscenario1( );

		tiendaMascotas.venderMascotas("Cacat�a Blanca", 23);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie1().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 20.", 20, tiendaMascotas.darEspecie1().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Boa Constrictor", 20);
		tiendaMascotas.venderMascotas("Boa Constrictor", 40);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie2().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 54.", 54, tiendaMascotas.darEspecie2().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Tit� Dorado", 33);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie3().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 23.", 23, tiendaMascotas.darEspecie3().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Guacamaya Roja", 40);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie4().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 34.", 34, tiendaMascotas.darEspecie4().darCantidadVendidas());

		//4. Cuando la cantidad actual es 0.
		tiendaMascotas.venderMascotas("Cacat�a Blanca", 1);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie1().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 20.", 20, tiendaMascotas.darEspecie1().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Boa Constrictor", 1);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie2().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 54.", 54, tiendaMascotas.darEspecie2().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Tit� Dorado", 1);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie3().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 23.", 23, tiendaMascotas.darEspecie3().darCantidadVendidas());
		tiendaMascotas.venderMascotas("Guacamaya Roja", 1);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 0.", 0, tiendaMascotas.darEspecie4().darCantidadActual());
		assertEquals("La cantidad de mascotas vendidas despu�s de la venta debe ser 34.", 34, tiendaMascotas.darEspecie4().darCantidadVendidas());
	}

	/**
     * Prueba 3: Comprar para cada una de las cuatro especies.
     */
	@Test
	public void testComprarMascotas( )
	{
		tiendaMascotas.comprarMascotas("Cacat�a Blanca", 10);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 30.", 30, tiendaMascotas.darEspecie1().darCantidadActual());
		tiendaMascotas.comprarMascotas("Boa Constrictor", 100);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 154.", 154, tiendaMascotas.darEspecie2().darCantidadActual());
		tiendaMascotas.comprarMascotas("Tit� Dorado", 1000);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 1023.", 1023, tiendaMascotas.darEspecie3().darCantidadActual());
		tiendaMascotas.comprarMascotas("Guacamaya Roja", 500);
		assertEquals("La cantidad actual de mascotas disponibles debe ser 534.", 534, tiendaMascotas.darEspecie4().darCantidadActual());
	}

	/**
     * Prueba 4: Buscar especies seg�n los criterios. Contemplando los siguientes casos:
     * 1. Caso cuando ninguna mascota cumple los criterios.
     * 2. Caso cuando se cumplen requisitos para cada una de las especies.
     * 3. Caso cuando se cumplen requisitos para mas de una especie.
     */
	@Test
	public void testBuscarEspecies( )
	{
		// 1. Caso cuando ninguna mascota cumple los criterios.		 
		assertEquals( "No deber�a existir ninguna mascota de acuerdo a esos criterios.", "Ninguna de las especies cumple los criterios.", tiendaMascotas.buscarEspecies(Especie.clase.REPTILES, 1, 1000) );

		// 2. Caso cuando se cumplen requisitos para cada una de las especies.
		String rta = "";
				
		rta = tiendaMascotas.buscarEspecies(Especie.clase.AVES, 90, 2000000);		
		assertTrue( "Deber�a existir Cacat�a Blanca de acuerdo a esos criterios.", rta.contains("Cacat�a Blanca") );
		
		rta = tiendaMascotas.buscarEspecies(Especie.clase.REPTILES, 30, 2000000);		
		assertTrue( "Deber�a existir Boa Constrictor de acuerdo a esos criterios.", rta.contains("Boa Constrictor") );

		rta = tiendaMascotas.buscarEspecies(Especie.clase.MAMIFEROS, 20, 6000000);		
		assertTrue( "Deber�a existir Titi Dorado de acuerdo a esos criterios.", rta.contains("Tit� Dorado") );

		rta = tiendaMascotas.buscarEspecies(Especie.clase.AVES, 40, 20000000);		
		assertTrue( "Deber�a existir Guacamaya Roja de acuerdo a esos criterios.", rta.contains("Guacamaya Roja"));
		
		// 3. Caso cuando se cumplen requisitos para mas de una especie.
		rta = tiendaMascotas.buscarEspecies(Especie.clase.AVES, 90, 20000000);
		assertTrue( "Deber�a existir Cacat�a Blanca y Guacamaya Roja de acuerdo a esos criterios.", rta.contains("Cacat�a Blanca")&&rta.contains("Guacamaya Roja") );
	}

	/**
     * Prueba 5: Buscar especie menos vendida. Contemplando los siguientes casos:
     * 1. Caso cuando al vender se obtiene un m�nimo.
     */
	@Test
	public void testDarEspecieMenosVendida( )
	{
		// 1. Caso cuando al vender se obtiene un m�nimo.
		tiendaMascotas.venderMascotas("Cacat�a Blanca", 1);
		tiendaMascotas.venderMascotas("Boa Constrictor", 2);
		tiendaMascotas.venderMascotas("Tit� Dorado", 3);
		tiendaMascotas.venderMascotas("Guacamaya Roja", 4);
		assertEquals("La especie menos vendida deber�a ser Cacat�a Blanca.", "Cacat�a Blanca" , tiendaMascotas.darEspecieMenosVendida() );
	}

	/**
     * Prueba 6: Dar monto ventas promedio. Contemplando los siguientes casos:
     * 1. Caso cuando no hay ventas.
     * 2. Caso al vender la primera especie.
     * 3. Caso al vender la segunda especie.
     * 4. Caso al vender la tercera especie.
     * 5. Caso al vender la cuarta especie.
     */
	@Test
	public void testDarMontoVentaPromedio( )
	{
		// 1. Caso cuando no hay ventas.
		assertEquals("El promedio debe ser 0.0.", 0.0, tiendaMascotas.darMontoVentaPromedio(), 0.01);

		// 2. Caso al vender la primera especie.
		tiendaMascotas.venderMascotas("Cacat�a Blanca", 10);
		assertEquals("El promedio deber�a ser 1500000.0.",1500000.0, tiendaMascotas.darMontoVentaPromedio(), 0.01);

		// 3. Caso al vender la segunda especie.
		tiendaMascotas.venderMascotas("Boa Constrictor", 10);
		assertEquals("El promedio deber�a ser 1750000.0.",1750000.0, tiendaMascotas.darMontoVentaPromedio(), 0.01);

		// 4. Caso al vender la tercera especie.
		tiendaMascotas.venderMascotas("Tit� Dorado", 10);
		assertEquals("El promedio deber�a 2833333.3.",2833333.3, tiendaMascotas.darMontoVentaPromedio(),0.1);

		// 5. Caso al vender la cuarta especie.
		tiendaMascotas.venderMascotas("Guacamaya Roja", 10);
		assertEquals("El promedio deber�a ser 5875000.0.",5875000.0, tiendaMascotas.darMontoVentaPromedio(),0.1);

	}
}