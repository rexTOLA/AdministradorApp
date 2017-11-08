
/**
 * Clase Main del proyecto
 * Ventana con el panel main donde van a ir el resto de los paneles
 * @author rexTOLA
 *
 */
import javax.swing.*;

import rutas.VentanaPath;
import rutas.Programa;
import rutas.VentanaAPP;

import java.awt.*;
import java.io.LineNumberInputStream;

public class VentanaMain extends JFrame{
	DefaultListModel listModel = new DefaultListModel();
	JList lista = new JList(listModel);

	public VentanaMain(){

		//Inicialización
		javax.swing.border.Border compound, raisedbevel, loweredbevel;
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);	//lineas de separación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(475, 900);
		setResizable(false);
		setLocationRelativeTo(null);

		//Creación de Componentes y contenedores
		JButton bAniadirAPP = new JButton("Añadir Programa");		//Boton para añadir APP
		JButton bAniadirRuta = new JButton("Añadir Ruta");			//Boton para añadir Ruta
		JButton bEjecutar = new JButton("Ejecutar");				//Boton para ejecutar
		JButton bEliminar = new JButton("Eliminar");				//Boton para eliminar
		JPanel pBotonera1 = new JPanel();							//Panel para el boton
		JPanel pBotonera2 = new JPanel();
		JPanel pLista = new JPanel(new BorderLayout());				//Panel para la lista de programas
		pLista.setPreferredSize(new Dimension(475, 900));			//Dimensiones del panel
		pLista.setBorder(compound);
		JScrollPane listaScroller = new JScrollPane(lista);

		//Layout
		getContentPane().setLayout(new BorderLayout());

		//Asignación de componentes y contenedores
		getContentPane().add(pLista, BorderLayout.WEST);
		pBotonera1.add(bAniadirAPP);
		pBotonera1.add(bAniadirRuta);
		pBotonera2.add(bEjecutar);
		pBotonera2.add(bEliminar);
		pLista.add(pBotonera1, BorderLayout.NORTH);
		pLista.add(pBotonera2, BorderLayout.SOUTH);
		pLista.add(listaScroller);


		bAniadirAPP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bAniadirAPPActionPerformed(evt);
			}
		});

		bAniadirRuta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bAniadirRutaActionPerformed(evt);
			}
		});

		bEjecutar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bEjecutaractionPerformed(evt, lista);
			}
		});
		
		bEliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bEliminarActionPerformed(evt);
			}
		});

	}

	private void bAniadirAPPActionPerformed(java.awt.event.ActionEvent evt){
		VentanaAPP vr = new VentanaAPP(listModel);
		vr.main(null);
		vr.setVisible(true);
		
	}

	private void bAniadirRutaActionPerformed(java.awt.event.ActionEvent evt){
		VentanaPath vp = new VentanaPath(listModel);
		vp.main(null);
		vp.setVisible(true);
	}

	private void bEjecutaractionPerformed(java.awt.event.ActionEvent evt, JList lista){
		Runtime r = Runtime.getRuntime();
		Process p = null;
		String ruta = ((Programa) lista.getSelectedValue()).getPath();
		System.out.println(ruta);

		try{
			p = r.exec(ruta);				
			System.out.println(p);
			
		}catch (Exception e) {
			System.out.println(p);
			System.out.println("Error al ejecutar");
		}

	}
	
	private void bEliminarActionPerformed(java.awt.event.ActionEvent evt){
		lista.getModel(); 
		int index = lista.getSelectedIndex();
		listModel.remove( index );
	}


	public static void main(String[] args) {
		JFrame f = new VentanaMain();
		f.setVisible(true);
	}
}
