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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.tiendaMascotas.mundo.Especie;
import uniandes.cupi2.tiendaMascotas.mundo.Especie.clase;

/**
 * Panel para mostrar la información de una especie.
 */
@SuppressWarnings("serial")
public class PanelEspecie extends JPanel implements ActionListener
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para vender mascotas de la especie.
	 */
	private static final String VENDER = "Vender";

	/**
	 * Comando para comprar mascotas de la especie.
	 */
	private static final String COMPRAR = "Comprar";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazTiendaMascotas principal;

	/**
	 * Nombre de la especie.
	 */
	private String nombreEspecie;

	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta con la clase de la especie.
	 */
	private JLabel lblClase;

	/**
	 * Etiqueta con la imagen de la especie.
	 */
	private JLabel lblImagen;

	/**
	 * Etiqueta con la vida promedio de la especie.
	 */
	private JLabel lblVidaPromedio;

	/**
	 * Etiqueta con el precio de la especie.
	 */
	private JLabel lblPrecio;

	/**
	 * Etiqueta con la cantidad disponible de mascotas de la especie.
	 */
	private JLabel lblCantidadActual;

	/**
	 * Etiqueta con la cantidad vendida de mascotas de la especie.
	 */
	private JLabel lblCantidadVendidas;

	/**
	 * Campo de texto con la clase de la especie.
	 */
	private JTextField txtClase;

	/**
	 * Campo de texto con la vida promedio de la especie.
	 */
	private JTextField txtVidaPromedio;

	/**
	 * Campo de texto con el precio de la especie.
	 */
	private JTextField txtPrecio;

	/**
	 * Campo de texto con la cantidad disponible de mascotas de la especie.
	 */
	private JTextField txtCantidadActual;

	/**
	 * Campo de texto con la cantidad vendida de mascotas de la especie.
	 */
	private JTextField txtCantidadVendidas;

	/**
	 * Botón para comprar mascotas de la especie.
	 */
	private JButton btnComprar;

	/**
	 * Botón para vender mascotas de la especie.
	 */
	private JButton btnVender;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del panel.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 * @param nNombreEspecie El nombre de la especie.
	 */
	public PanelEspecie( InterfazTiendaMascotas ventanaPrincipal, String nNombreEspecie )
	{
		nombreEspecie = nNombreEspecie;
		principal = ventanaPrincipal;
		setBorder( new TitledBorder( nombreEspecie ) );
		setLayout( new BorderLayout( ) );

		String nombreImagen="nada";
		if(nNombreEspecie.equals("Cacatúa Blanca"))
		{
			nombreImagen="Cacatua";
		}
		else if(nNombreEspecie.equals("Boa Constrictor"))
		{
			nombreImagen="Boa";
		}
		else if(nNombreEspecie.equals("Tití Dorado"))
		{
			nombreImagen="Titi";
		}
		else if(nNombreEspecie.equals("Guacamaya Roja"))
		{
			nombreImagen="Guacamaya";
		}

		// Etiqueta para la imagen
		ImageIcon icono = new ImageIcon( "data/"+nombreImagen+".jpg" );
		lblImagen = new JLabel( "" );
		lblImagen.setIcon( icono );
		lblImagen.setBorder( new TitledBorder( "" ) );

		// Etiqueta para el nombre
		lblClase = new JLabel( "  Clase" );
		lblClase.setForeground( Color.BLUE );

		// Etiqueta cantidad
		lblVidaPromedio = new JLabel( "  Vida promedio" );
		lblVidaPromedio.setForeground( Color.BLUE );

		// Etiqueta precio
		lblPrecio = new JLabel( "  Precio" );
		lblPrecio.setForeground( Color.BLUE );

		// Etiqueta cantidad actual
		lblCantidadActual = new JLabel( "  Disponibles" );
		lblCantidadActual.setForeground( Color.BLUE );

		// Etiqueta cantidad actual
		lblCantidadVendidas = new JLabel( "  Vendidas" );
		lblCantidadVendidas.setForeground( Color.BLUE );

		// Campo para el nombre
		txtClase = new JTextField( );
		txtClase.setEditable( false );
		txtClase.setHorizontalAlignment(JTextField.CENTER);

		// Campo para la cantidad
		txtVidaPromedio = new JTextField( );
		txtVidaPromedio.setEditable( false );
		txtVidaPromedio.setHorizontalAlignment(JTextField.CENTER);

		// Campo para precio
		txtPrecio = new JTextField( );
		txtPrecio.setEditable( false );
		txtPrecio.setHorizontalAlignment(JTextField.CENTER);

		// Campo para cantidad actual
		txtCantidadActual = new JTextField( );
		txtCantidadActual.setEditable( false );
		txtCantidadActual.setHorizontalAlignment(JTextField.CENTER);;

		// Campo para cantidad vendidas
		txtCantidadVendidas = new JTextField( );
		txtCantidadVendidas.setEditable( false );
		txtCantidadVendidas.setHorizontalAlignment(JTextField.CENTER);

		// Botón hacer pedido
		btnComprar = new JButton( COMPRAR );
		btnComprar.setPreferredSize( new Dimension( 150, 25 ) );
		btnComprar.setActionCommand( COMPRAR );
		btnComprar.addActionListener( this );
		btnComprar.setEnabled( true );

		btnVender = new JButton( VENDER );
		btnVender.setPreferredSize( new Dimension( 150, 25 ) );
		btnVender.setActionCommand( VENDER );
		btnVender.addActionListener( this );
		btnVender.setEnabled( true );

		// Organización
		JPanel infoEspecie= new JPanel();
		infoEspecie.setLayout(new BorderLayout());
		infoEspecie.add(lblImagen,BorderLayout.WEST);

		JPanel panelMedio=new JPanel();
		panelMedio.setLayout(new GridLayout(5,2));
		panelMedio.add(lblVidaPromedio);
		panelMedio.add(txtVidaPromedio);
		panelMedio.add(lblClase);
		panelMedio.add(txtClase);
		panelMedio.add(lblPrecio);
		panelMedio.add(txtPrecio);
		panelMedio.add(lblCantidadActual);
		panelMedio.add(txtCantidadActual);
		panelMedio.add(lblCantidadVendidas);
		panelMedio.add(txtCantidadVendidas);

		infoEspecie.add(panelMedio, BorderLayout.CENTER);

		add(infoEspecie,BorderLayout.CENTER);

		JPanel panelBotones= new JPanel();
		panelBotones.setLayout(new GridLayout(1,2));
		panelBotones.add(btnComprar);
		panelBotones.add(btnVender);

		add(panelBotones,BorderLayout.SOUTH);

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Actualiza la información de la especie.
	 * @param pEspecie Especie que contiene la información a ser actualizada. pEspecie != null.
	 */
	public void actualizar( Especie pEspecie )
	{
		if( pEspecie != null )
		{
			String clase="Ninguna";
			clase claseAnimal=pEspecie.darClase();
			if(claseAnimal==Especie.clase.MAMIFEROS)
			{
				clase="Mamiferos";
			}
			else if(claseAnimal==Especie.clase.REPTILES)
			{
				clase="Reptiles";
			}
			else if(claseAnimal==Especie.clase.AVES)
			{
				clase="Aves";
			}

			txtClase.setText( clase );
			txtVidaPromedio.setText( "" + pEspecie.darVidaPromedio( ) );
			txtPrecio.setText( "" + formatearValor( pEspecie.darPrecioVenta() ) );
			txtCantidadActual.setText( "" + pEspecie.darCantidadActual( ) );
			txtCantidadVendidas.setText(""+pEspecie.darCantidadVendidas());
			lblImagen.setEnabled( true );
			btnVender.setEnabled( true );
		}
		else
		{
			txtVidaPromedio.setText( "N/A" );
			txtPrecio.setText( "N/A" );
			txtClase.setText( "N/A" );
			txtCantidadActual.setText( "N/A" );
			lblImagen.setEnabled( false );
			btnVender.setEnabled( false );
		}

	}

	/**
	 * Formatea un valor numérico para presentar en la interfaz. <br>
	 * @param valor El valor numérico a ser formateado.
	 * @return Cadena con el valor formateado con puntos y signos.
	 */
	private String formatearValor( double valor )
	{
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( "$ ###,###" );
		df.setMinimumFractionDigits( 0 );
		return df.format( valor );
	}


	/**
	 * Manejo de los eventos de los botones.
	 * @param e Evento asociado al click en un botón. e != null.
	 */
	public void actionPerformed( ActionEvent e )
	{
		String accion = e.getActionCommand( );
		if( accion.equals( VENDER ) )
		{
			String strCantidad = JOptionPane.showInputDialog( principal, "Ingrese la cantidad que desea vender", "Venta de mascotas", JOptionPane.INFORMATION_MESSAGE );

			if(strCantidad != null)
			{
				try
				{
					int cantidad = Integer.parseInt( strCantidad );
					if( cantidad < 0 )
					{
						JOptionPane.showMessageDialog( principal, "La cantidad que desea vender es inválida", "Error", JOptionPane.ERROR_MESSAGE );
					}
					else
					{
						principal.venderMascotas( nombreEspecie, cantidad );
					}
				}
				catch( NumberFormatException e1 )
				{
					JOptionPane.showMessageDialog( principal, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE );
				}
			}
		}
		else if( accion.equals( COMPRAR ) )
		{
			String strCantidad = JOptionPane.showInputDialog( principal, "Ingrese la cantidad que desea comprar", "Compra de mascotas", JOptionPane.INFORMATION_MESSAGE );

			if(strCantidad != null)
			{
				try
				{
					int cantidad = Integer.parseInt( strCantidad );
					if( cantidad < 0 )
					{
						JOptionPane.showMessageDialog( principal, "La cantidad que desea comprar es inválida", "Error", JOptionPane.ERROR_MESSAGE );
					}
					else
					{
						principal.comprarMascotas( nombreEspecie, cantidad );
					}
				}
				catch( NumberFormatException e1 )
				{
					JOptionPane.showMessageDialog( principal, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE );
				}
			}

		}
	}


}