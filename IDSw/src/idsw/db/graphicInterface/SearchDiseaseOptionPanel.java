package idsw.db.graphicInterface;

import javax.swing.*;

import idsw.db.graphicInterface.components.*;

import java.awt.*;


public class SearchDiseaseOptionPanel extends JPanel{
	public JPanel northPanel;
	public JPanel centerPanel;
	public JPanel southPanel;
	public JPanel rightPanel;
	public JPanel leftPanel;
	
	public CustomJLabel titleLabel;
	public RoundedButton bySymmtomButton;
	public RoundedButton byNameButton;
	
	public SearchDiseaseOptionPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.titleLabel = new CustomJLabel("<html><b>SEARCH A DISEASE</b></html>", 20, Color.decode("#09A8E4"), Color.WHITE);
		this.centerPanel.add(this.titleLabel);
		this.bySymmtomButton = new RoundedButton("By Symptom", Color.decode("#09A8E4"));
		this.bySymmtomButton.setPreferredSize(new Dimension(120, 30));
		this.centerPanel.add(this.bySymmtomButton);
		this.byNameButton = new RoundedButton("By Name", Color.decode("#09A8E4"));
		this.byNameButton.setPreferredSize(new Dimension(120, 30));
		this.centerPanel.add(this.byNameButton);
		
		
		this.southPanel = new JPanel();
		this.southPanel.setPreferredSize(new Dimension(20, 20));
		this.southPanel.setBackground(Color.WHITE);
		this.add(this.southPanel, BorderLayout.SOUTH);
		this.rightPanel = new JPanel();
		this.rightPanel.setPreferredSize(new Dimension(20, 20));
		this.rightPanel.setBackground(Color.WHITE);
		this.add(this.rightPanel, BorderLayout.EAST);
		this.leftPanel = new JPanel();
		this.leftPanel.setPreferredSize(new Dimension(20, 20));
		this.leftPanel.setBackground(Color.WHITE);
		this.add(this.leftPanel, BorderLayout.WEST);
		
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SearchDiseaseOptionPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
