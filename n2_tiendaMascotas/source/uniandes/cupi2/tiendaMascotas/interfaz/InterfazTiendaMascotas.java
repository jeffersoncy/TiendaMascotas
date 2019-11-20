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

package uniandes.cupi2.tiendaMascotas.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.tiendaMascotas.mundo.Especie;
import uniandes.cupi2.tiendaMascotas.mundo.TiendaMascotas;
import uniandes.cupi2.tiendaMascotas.mundo.Especie.clase;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazTiendaMascotas extends JFrame
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Clase principal del mundo.
	 */
	private TiendaMascotas tiendaMascotas;

	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	/**
	 * Panel con la información del monto de ventas.
	 */
	private PanelPromedio panelPromedio;

	/**
	 * Panel con las opciones de búsqueda y las extensiones.
	 */
	private PanelOpciones panelOpciones;

	/**
	 * Panel con la imagen de la tienda de mascotas.
	 */
	private PanelImagen panelImagen;

	/**
	 * Panel con la información de la Cacatúa Blanca.
	 */
	private PanelEspecie panelCacatuaBlanca;

	/**
	 * Panel con la información de la Boa Constrictor.
	 */
	private PanelEspecie panelBoaConstrictor;

	/**
	 * Panel con la información del Tití Dorado.
	 */
	private PanelEspecie panelTitiDorado;

	/**
	 * Panel con la información de la Guacamaya Roja.
	 */
	private PanelEspecie panelGuacamayaRoja;


	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
     * Constructor de la interfaz <br>
     */
	public InterfazTiendaMascotas( )
	{
		// Crea el mundo.
		tiendaMascotas = new TiendaMascotas( );
		
		// Organiza la ventana.
		setLayout( new BorderLayout( ) );
		setSize( 736, 630 );
		setTitle( "Tienda de Mascotas" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		setLocationRelativeTo( null );
		setResizable( false );

		// Crea los páneles.
		JPanel panelContenedor = new JPanel( );
		panelContenedor.setLayout( new BorderLayout( ) );

		panelPromedio = new PanelPromedio(  );
		panelContenedor.add( panelPromedio, BorderLayout.NORTH );

		JPanel panelCentral = new JPanel( );
		panelCentral.setLayout( new GridLayout( 2, 2 ) );
		panelContenedor.add( panelCentral, BorderLayout.CENTER );

		panelImagen = new PanelImagen( );
		add( panelImagen, BorderLayout.NORTH );

		panelCacatuaBlanca = new PanelEspecie( this, "Cacatúa Blanca" );
		panelCentral.add( panelCacatuaBlanca );

		panelBoaConstrictor = new PanelEspecie( this, "Boa Constrictor" );
		panelCentral.add( panelBoaConstrictor );

		panelTitiDorado = new PanelEspecie( this, "Tití Dorado" );
		panelCentral.add( panelTitiDorado );

		panelGuacamayaRoja = new PanelEspecie( this, "Guacamaya Roja" );
		panelCentral.add( panelGuacamayaRoja );

		add( panelContenedor, BorderLayout.CENTER );

		panelOpciones = new PanelOpciones( this );
		add( panelOpciones, BorderLayout.SOUTH );

		actualizar( );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Intenta vender una cantidad determinada de mascotas de una especie determinada e informa cuantas fueron vendidas.
	 * <b>post: </b> Se actualiza la información de todas las especies y el promedio.
	 * @param nombreEspecie Nombre de la especie que se vende.
	 * @param cantidad Cantidad de mascotas vendidas de la especie.
	 */
	public void venderMascotas( String nombreEspecie, int cantidad )
	{
		int vendidas= tiendaMascotas.venderMascotas(nombreEspecie, cantidad);

		if(vendidas>0)
		{
			JOptionPane.showMessageDialog( this, "Se vendieron "+vendidas+" unidades.", "Venta", JOptionPane.INFORMATION_MESSAGE );
		}
		else if(vendidas ==-1)
		{
			JOptionPane.showMessageDialog( this, "No se puede vender la mascota ya que la cantidad es mayor al máximo.", "Error", JOptionPane.ERROR_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog( this, "No se puede vender la mascota ya que no hay unidades disponibles.", "Error", JOptionPane.ERROR_MESSAGE );
		}
		actualizar( );
	}

	/**
	 * Compra una cantidad determinada de mascotas de una especie determinada.
	 * <b>post: </b> Se actualiza la información de todas las especies y el promedio.
	 * @param nombreEspecie Nombre de la especie que se compra.
	 * @param cantidad Cantidad de mascotas compradas de la especie. 
	 */
	public void comprarMascotas( String nombreEspecie, int cantidad )
	{
		
		boolean rta= tiendaMascotas.comprarMascotas( nombreEspecie, cantidad );
		if(rta==false)
		{
			JOptionPane.showMessageDialog( this, "No se puede comprar la mascota ya que la cantidad es menor al mínimo.", "Error", JOptionPane.ERROR_MESSAGE );
			
		}
		actualizar( );
	}

	/**
	 * Busca las especies de acuerdo a tres criterios dados por parámetro: clase de la especie, vida promedio máxima de la especie y precio de venta máximo de la especie.
	 * @param claseAnimal Clase a la cual pertenece la especie. claseEspecie == Especie.AVES || claseEspecie == Especie.REPTILES || claseEspecie == Especie.MAMIFEROS.
	 * @param vidaPromedioMax Vida promedio máxima que puede tener la especie. vidaPromedioMax > 0.
	 * @param precioVentaMax Precio de venta máximo que puede tener la especie. precioVentaMax > 0.
	 */
	public void buscarEspecies(clase claseAnimal, int vidaPromedioMax, int precioVentaMax)
	{
		String especies=tiendaMascotas.buscarEspecies(claseAnimal, vidaPromedioMax, precioVentaMax);
		JOptionPane.showMessageDialog( this, "Las especies que cumplen con los criterios son: " + especies, "Buscar especies", JOptionPane.INFORMATION_MESSAGE );

	}

	/**
	 * Informa cual de todas las especies es la que tiene menos mascotas vendidas. 
	 * <b>post: </b> Se informa la especie que tiene menos mascotas vendidas.
	 */
	public void darEspecieMenosVendida( )
	{
		JOptionPane.showMessageDialog( this, "La especie menos vendida es: " + tiendaMascotas.darEspecieMenosVendida( ), "Especie menos vendida", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
     * Actualiza la información en la interfaz. <br>
     * <b>post: </b> Se actualiza la información de todas las especies y el promedio.
     */
	private void actualizar( )
	{
		panelCacatuaBlanca.actualizar( tiendaMascotas.darEspecie1() );
		panelBoaConstrictor.actualizar(tiendaMascotas.darEspecie2());
		panelTitiDorado.actualizar( tiendaMascotas.darEspecie3() );
		panelGuacamayaRoja.actualizar( tiendaMascotas.darEspecie4() );
		panelPromedio.actualizar(tiendaMascotas.darMontoVentaPromedio());
	}

	
	/**
     * Muestra el diálogo para ingresar los criterios de busqueda al buscar especies. 
     */	
	public void mostrarDialogoBuscarEspecies()
	{
		DialogoBuscarEspecies dialogo = new DialogoBuscarEspecies( this );
		dialogo.setVisible( true );
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 */
	public void reqFuncOpcion1( )
	{
		String resultado = tiendaMascotas.metodo1( );
		actualizar();
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método para la extensión 2.
	 */
	public void reqFuncOpcion2( )
	{
		String resultado = tiendaMascotas.metodo2( );
		actualizar();
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------

	/**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args Argumentos del llamado. No se requiere ninguno.
     */
	public static void main( String[] args )
	{
		InterfazTiendaMascotas interfaz = new InterfazTiendaMascotas( );
		interfaz.setVisible( true );
	}
}