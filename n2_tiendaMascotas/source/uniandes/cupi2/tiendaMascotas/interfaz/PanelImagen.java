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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen de la tienda de mascotas.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{
	// ------------------------------------------------------------
	// Atributos de interfaz
	// ------------------------------------------------------------

	/**
     * Etiqueta con la imagen de la tienda de mascotas.
     */
	private JLabel etiquetaImagen;

	// ------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------

	/**
     * Constructor del panel.
     */
	public PanelImagen( )
	{
		setBackground( Color.WHITE );
		setLayout( new BorderLayout( ) );

		// Etiqueta de Imagen
		ImageIcon icono = new ImageIcon( "data/titulo.png" );
		etiquetaImagen = new JLabel( "" );

		etiquetaImagen.setIcon( icono );
		add( etiquetaImagen, BorderLayout.CENTER );

	}
}
