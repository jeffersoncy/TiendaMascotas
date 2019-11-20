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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel para mostrar la información del monto de ventas promedio.
 */
@SuppressWarnings("serial")
public class PanelPromedio extends JPanel
{  
	// -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

	/**
	 * Campo de texto para el monto de ventas promedio.
	 */
	private JTextField txtPromedio;

	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	/**
     * Constructor del panel
     */
	public PanelPromedio( )
	{   
		setLayout( new GridLayout( 1, 2 ) );
		setBorder( new TitledBorder( "" ) );

		JLabel labPromedio = new JLabel( "Venta promedio" );
		labPromedio.setForeground( Color.GREEN.darker( ) );
		labPromedio.setFont( new Font( "Tahoma", Font.BOLD, 20 ) );
		add( labPromedio );

		txtPromedio = new JTextField("0");
		txtPromedio.setHorizontalAlignment(JTextField.CENTER);
		txtPromedio.setEditable( false );
		txtPromedio.setFont( new Font( "Tahoma", Font.BOLD, 20 ) );
		add( txtPromedio );

	}

	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	/**
     * Actualiza la información del monto de ventas promedio.
     * @param pPromedio Valor del monto de ventas promedio. pPromedio >= 0.
     */
	public void actualizar( double pPromedio )
	{
		txtPromedio.setText( formatearValor( pPromedio ) );
	}

	/**
     * Formatea un valor numérico para presentar en la interfaz. <br>
     * @param valor El valor numérico a ser formateado.
     * @return Cadena con el valor formateado con puntos y signos.
     */
	public final static String formatearValor( double valor )
	{
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( "$ ###,###.##" );
		df.setMinimumFractionDigits( 2 );
		return df.format( valor );
	}
}
