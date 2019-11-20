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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando opción 1.
	 */
	private static final String OPCION_1 = "OPCION_1";

	/**
	 * Comando opción 2.
	 */
	private static final String OPCION_2 = "OPCION_2";

	/**
	 * Comando para buscar especies.
	 */
	private static final String BUSCAR_ESPECIES = "BUSCAR_ESPECIES";

	/**
	 * Comando para mostrar la especie menos vendida.
	 */
	private static final String MENOS_VENDIDA = "MENOS_VENDIDA";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazTiendaMascotas principal;

	// -----------------------------------------------------------------
	// Atributos de interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón opción 1.
	 */
	private JButton btnOpcion1;

	/**
	 * Botón opción 2.
	 */
	private JButton btnOpcion2;

	/**
	 * Botón para buscar la especie según criterios.
	 */
	private JButton btnBuscar;

	/**
	 * Botón para mostrar la especie menos vendida.
	 */
	private JButton btnMenosVendida;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del panel.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public PanelOpciones( InterfazTiendaMascotas ventanaPrincipal )
	{
		principal = ventanaPrincipal;

		setBorder( new TitledBorder( "Opciones" ) );
		setLayout( new GridLayout( 1, 2 ) );

		btnBuscar = new JButton( "Buscar especies" );
		btnBuscar.setActionCommand( BUSCAR_ESPECIES );
		btnBuscar.addActionListener( this );
		add( btnBuscar );

		btnMenosVendida = new JButton( "Especie menos vendida" );
		btnMenosVendida.setActionCommand( MENOS_VENDIDA );
		btnMenosVendida.addActionListener( this );
		add( btnMenosVendida );

		btnOpcion1 = new JButton( "Opción 1" );
		btnOpcion1.setActionCommand( OPCION_1 );
		btnOpcion1.addActionListener( this );
		add( btnOpcion1 );

		btnOpcion2 = new JButton( "Opción 2" );
		btnOpcion2.setActionCommand( OPCION_2 );
		btnOpcion2.addActionListener( this );
		add( btnOpcion2 );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
     * Manejo de los eventos de los botones.
     * @param e Evento asociado al click en un botón. e != null.
     */
	public void actionPerformed( ActionEvent e )
	{
		if( OPCION_1.equals( e.getActionCommand( ) ) )
		{
			principal.reqFuncOpcion1( );
		}
		else if( OPCION_2.equals( e.getActionCommand( ) ) )
		{
			principal.reqFuncOpcion2( );
		}
		else if( e.getActionCommand( ).equals( BUSCAR_ESPECIES ) )
		{
			principal.mostrarDialogoBuscarEspecies();
		}
		else if( e.getActionCommand( ).equals( MENOS_VENDIDA ) )
		{
			principal.darEspecieMenosVendida();
		}
	}

}
