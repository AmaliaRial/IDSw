package idsw.db.graphicInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.pojos.Simulation;
import idsw.db.pojos.Virtual_Population;


public class ViewSimulationResultFromSearchPanel extends ViewSimulationResultPanel implements ActionListener {
	public RoundedButton backButton;
	
	public ViewSimulationResultFromSearchPanel(Simulation simulation,Virtual_Population vPopulation1, GraphicAplication app,ConnectionManager conMan) {
		super(simulation, vPopulation1,app,conMan);
		this.backButton = new RoundedButton("Back", Color.decode("#09A8E4"));
		this.backButton.setPreferredSize(new Dimension(90, 30));
		this.exitButtonPanel.add(this.backButton);
	}
	
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.getContentPane().add(new ViewSimulationResultFromSearchPanel(1, 100, 10, (float) 0.1, (float) 0.1, (float) 0.8));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}