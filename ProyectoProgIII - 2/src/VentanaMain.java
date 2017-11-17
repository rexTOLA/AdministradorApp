
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
	DefaultListModel listModelApp = new DefaultListModel();
	JList listaApp = new JList(listModelApp);
	DefaultListModel listModelRuta = new DefaultListModel();
	JList listaRuta = new JList(listModelRuta);

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
		JButton bEjecutarApp = new JButton("Ejecutar");				//Boton para ejecutar App
		JButton bEliminarApp = new JButton("Eliminar");				//Boton para eliminar App
		JButton bAniadirRuta = new JButton("Añadir Ruta");			//Boton para añadir Ruta
		JButton bEjecutarRuta = new JButton("Ejecutar");			//Boton para ejecutar Ruta
		JButton bEliminarRuta = new JButton("Eliminar");			//Boton para eliminar Ruta
		
		JPanel pBotonera1 = new JPanel();							//Panel para el boton
		JPanel pBotonera2 = new JPanel();
		JPanel pListaApp = new JPanel(new BorderLayout());				//Panel para la lista de programas
		pListaApp.setPreferredSize(new Dimension(475, 425));			//Dimensiones del panel
		pListaApp.setBorder(compound);
		JPanel pListaRuta = new JPanel(new BorderLayout());
		pListaRuta.setPreferredSize(new Dimension(475, 425));			//Dimensiones del panel
		pListaRuta.setBorder(compound);
		
		JScrollPane listaScrollerApp = new JScrollPane(listaApp);
		JScrollPane listaScrollerRuta = new JScrollPane(listaRuta);

		//Layout
		getContentPane().setLayout(new BorderLayout());

		//Asignación de componentes y contenedores
		getContentPane().add(pListaApp, BorderLayout.NORTH);
		getContentPane().add(pListaRuta, BorderLayout.SOUTH);
		pBotonera1.add(bAniadirAPP);
		pBotonera1.add(bEjecutarApp);
		pBotonera1.add(bEliminarApp);
		pBotonera2.add(bAniadirRuta);
		pBotonera2.add(bEjecutarRuta);
		pBotonera2.add(bEliminarRuta);
		pListaApp.add(pBotonera1, BorderLayout.NORTH);
		pListaRuta.add(pBotonera2, BorderLayout.NORTH);
		pListaApp.add(listaScrollerApp);
		pListaRuta.add(listaScrollerRuta);


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

		bEjecutarApp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bEjecutaractionPerformed(evt, listaApp);
			}
		});
		
		bEliminarApp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bEliminarActionPerformedApp(evt);
			}
		});
		
		bEjecutarRuta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bEjecutaractionPerformed(evt, listaRuta);
			}
		});
		
		bEliminarRuta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bEliminarActionPerformedRuta(evt);
			}
		});

	}

	private void bAniadirAPPActionPerformed(java.awt.event.ActionEvent evt){
		VentanaAPP vr = new VentanaAPP(listModelApp);
		vr.main(null);
		vr.setVisible(true);
		
	}

	private void bAniadirRutaActionPerformed(java.awt.event.ActionEvent evt){
		VentanaPath vp = new VentanaPath(listModelRuta);
		vp.main(null);
		vp.setVisible(true);
	}

	private void bEjecutaractionPerformed(java.awt.event.ActionEvent evt, JList listaApp){
		Runtime r = Runtime.getRuntime();
		Process p = null;
		String ruta = ((Programa) listaApp.getSelectedValue()).getPath();
		System.out.println(ruta);

		try{
			p = r.exec(ruta);				
			System.out.println(p);
			
		}catch (Exception e) {
			System.out.println(p);
			System.out.println("Error al ejecutar");
		}

	}
	
	private void bEliminarActionPerformedApp(java.awt.event.ActionEvent evt){
		listaApp.getModel(); 
		int indexApp = listaApp.getSelectedIndex();
		listModelApp.remove(indexApp);
	}

	private void bEliminarActionPerformedRuta(java.awt.event.ActionEvent evt){
		listaRuta.getModel(); 
		int indexRuta = listaRuta.getSelectedIndex();
		listModelRuta.remove(indexRuta);

	}
	
	public static void main(String[] args) {
		JFrame f = new VentanaMain();
		f.setVisible(true);
	}
}
