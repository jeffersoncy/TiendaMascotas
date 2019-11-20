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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uniandes.cupi2.tiendaMascotas.mundo.Especie;
import uniandes.cupi2.tiendaMascotas.mundo.Especie.clase;

/**
 * Dialogo que muestra las opciones para buscar especies por criterios.
 */
@SuppressWarnings("serial")
public class DialogoBuscarEspecies extends JDialog implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para realizar la búsqueda.
	 */
	public static final String ACEPTAR = "ACEPTAR";

	/**
	 * Comando para cancelar la búsqueda.
	 */
	public static final String CANCELAR = "CANCELAR";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta para mostrar la clase animal.
	 */
	private JLabel lblClase;

	/**
	 * Etiqueta para mostrar la vida promedio.
	 */
	private JLabel lblVidaPromedio;

	/**
	 * Etiqueta para mostrar el precio de venta.
	 */
	private JLabel lblPrecio;

	/**
	 * Combo que permite seleccionar la clase animal.
	 */
	private JComboBox comboClase;

	/**
	 * Cuadro de texto para escribir el precio máximo.
	 */
	private JTextField txtPrecioVentaMax;

	/**
	 * Cuadro de texto para escribir la vida promedio máxima.
	 */
	private JTextField txtVidaPromedioMax;

	/**
	 * Botón para aceptar.
	 */
	private JButton btnAceptar;

	/**
	 * Botón para cancelar.
	 */
	private JButton btnCancelar;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazTiendaMascotas principal;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del diálogo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoBuscarEspecies( InterfazTiendaMascotas ventanaPrincipal )
	{
		principal = ventanaPrincipal;
		setTitle( "Buscar especies" );
		setLocationRelativeTo( principal );

		lblClase = new JLabel( "Clase: " );
		lblVidaPromedio = new JLabel( "Vida promedio (max): " );
		lblPrecio = new JLabel( "Precio (max): " );
		comboClase = new JComboBox( );
		txtPrecioVentaMax = new JTextField( );
		txtVidaPromedioMax = new JTextField( );
		btnAceptar = new JButton( "Aceptar" );
		btnAceptar.addActionListener( this );
		btnAceptar.setActionCommand( ACEPTAR );
		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.addActionListener( this );
		btnCancelar.setActionCommand( CANCELAR );

		comboClase.addItem( "Mamíferos" );
		comboClase.addItem( "Reptiles" );
		comboClase.addItem( "Aves" );

		setLayout( new GridLayout( 4, 2 ) );
		add( lblClase );
		add( comboClase );
		add( lblVidaPromedio );
		add( txtVidaPromedioMax );
		add( lblPrecio );
		add( txtPrecioVentaMax );
		add( btnAceptar );
		add( btnCancelar );


		setResizable( false );
		pack( );
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
     * Manejo de los eventos de los botones.
     * @param e Evento asociado al click en un botón. e != null.
     */
	public void actionPerformed( ActionEvent e )
	{
		String accion = e.getActionCommand( );
		if( accion.equals( ACEPTAR ) )
		{
			try
			{
				String strVidaPromedio = txtVidaPromedioMax.getText( );
				int vidaPromedioMax = Integer.parseInt( strVidaPromedio );
				String clase = ( String )comboClase.getSelectedItem( );
				clase claseAnimal= null;
				if(clase.equals("Mamíferos" ))
				{
					claseAnimal=Especie.clase.MAMIFEROS;
				}
				else if(clase.equals("Reptiles"))
				{
					claseAnimal=Especie.clase.REPTILES;
				}
				else if(clase.equals("Aves"))
				{
					claseAnimal=Especie.clase.AVES;
				}


				if( vidaPromedioMax < 0 )
				{
					JOptionPane.showMessageDialog( this, "Debe ingresar una vida promedio válida", "Error", JOptionPane.ERROR_MESSAGE );
				}
				else
				{
					String strPrecio = txtPrecioVentaMax.getText( );
					int precioVentaMax = Integer.parseInt( strPrecio );
					if( precioVentaMax <= 0 )
					{
						JOptionPane.showMessageDialog( this, "Debe ingresar un precio válido", "Error", JOptionPane.ERROR_MESSAGE );
					}
					else
					{
						principal.buscarEspecies(claseAnimal, vidaPromedioMax, precioVentaMax);
						dispose();
					}
				}
			}
			catch( NumberFormatException e1 )
			{
				JOptionPane.showMessageDialog( this, "Ha ocurrido un error con los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
		else if( accion.equals( CANCELAR ) )
		{
			dispose();
		}
	}


}
