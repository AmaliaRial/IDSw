package idsw.db.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;

public class SearchSimulationTemplate extends SearchTempletePanel {
	public CustomJLabel titleLabel;
	public JScrollPane list;
	public JPanel northPanel;
	public ConnectionManager conMan;
	
	public SearchSimulationTemplate() {
		super();
		this.conMan= new ConnectionManager();
		this.titleLabel= new CustomJLabel("<html><b>TITLE</b></html>",30,Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		super.northSpace.add(titleLabel);
		super.remove(super.northSpace);
		this.northPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		super.add(northPanel,BorderLayout.NORTH);
		this.northPanel.add(titleLabel);
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SearchSimulationTemplate());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
