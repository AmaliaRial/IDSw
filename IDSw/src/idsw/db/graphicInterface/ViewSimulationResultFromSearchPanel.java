package idsw.db.graphicInterface;

import javax.swing.*;
import java.awt.*;
import idsw.db.graphicInterface.components.*;


public class ViewSimulationResultFromSearchPanel extends ViewSimulationResultPanel {
	public RoundedButton backButton;
	
	public ViewSimulationResultFromSearchPanel(Integer id_simulation, Integer numberOfPeople, Integer inmunityPeriod, Float illPercentage, Float imnunePercentage, Float healthyPercentage) {
		super(id_simulation, numberOfPeople, inmunityPeriod, illPercentage, imnunePercentage, healthyPercentage);
		this.backButton = new RoundedButton("Back", Color.decode("#09A8E4"));
		this.backButton.setPreferredSize(new Dimension(90, 30));
		this.exitButtonPanel.add(this.backButton);
	}
	
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new ViewSimulationResultFromSearchPanel(1, 100, 10, (float) 0.1, (float) 0.1, (float) 0.8));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}