package idsw.db.graphicInterface;

import javax.swing.*;

import ids.db.graphicInterface.components.*;

import java.awt.*;

public class SearchPatientPanel extends JPanel{
	public JPanel northPanel;
	public JPanel centerPanel;
	public JPanel southPanel;
	public JPanel rightPanel;
	public JPanel leftPanel;
	
	public CustomJLabel searchLabel;
	public JTextField searchField;
	public CircularIconButton searchButton;
	
	public SearchPatientPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(this.northPanel, BorderLayout.NORTH);
		this.searchLabel = new CustomJLabel("<html><b>SEARCH FOR A PATIENT</b></html>", 20, Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		this.northPanel.add(this.searchLabel);
		
		this.centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.searchField = new JTextField(20);
		this.searchField.setFont(new Font("Arial", Font.PLAIN, 20));
		this.centerPanel.add(this.searchField);
		this.searchButton = new CircularIconButton(new ImageIcon("./src/ids/db/graphicInterface/components/Search_Icon.png"));
		this.searchButton.setPreferredSize(new Dimension(30, 30));
		this.centerPanel.add(this.searchButton);
		
		
		this.southPanel = new JPanel();
		this.southPanel.setPreferredSize(new Dimension(20, 20));
		this.southPanel.setBackground(Color.WHITE);
		this.add(this.southPanel, BorderLayout.SOUTH);
		this.rightPanel = new JPanel();
		this.rightPanel.setPreferredSize(new Dimension(20, 20));
		this.rightPanel.setBackground(Color.WHITE);
		this.southPanel.add(this.rightPanel);
		this.leftPanel = new JPanel();
		this.leftPanel.setPreferredSize(new Dimension(20, 20));
		this.leftPanel.setBackground(Color.WHITE);
		this.southPanel.add(this.leftPanel);
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SearchPatientPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
