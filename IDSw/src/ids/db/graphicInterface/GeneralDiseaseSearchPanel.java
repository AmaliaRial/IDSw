package idsw.db.graphicInterface;

import javax.swing.JFrame;

import ids.db.graphicInterface.components.BuscadorTextoDisease;

public class GeneralDiseaseSearchPanel extends SearchTempletePanel {
	public BuscadorTextoDisease searchDiseasePanel;
	
	public GeneralDiseaseSearchPanel() {
		super();
		this.searchDiseasePanel=new BuscadorTextoDisease();
		super.midlePanel.add(this.searchDiseasePanel);
	}
	
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new GeneralDiseaseSearchPanel());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}
