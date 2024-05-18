package ids.db.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ids.db.graphicInterface.components.RoundedButton;

public class SearchTempletePanel extends JPanel{
	public JPanel midlePanel;
	public JPanel southPanel;
		public JPanel backPanel;
		public JPanel optionButtonsPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	public JPanel northSpace;
	
	public RoundedButton backButton;
	
	public SearchTempletePanel(){
		this.setLayout(new BorderLayout());
		this.midlePanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.midlePanel.setBackground(Color.WHITE);
		this.add(midlePanel, BorderLayout.CENTER);
		this.southPanel=new JPanel(new GridLayout(1,2));
		this.southPanel.setBackground(Color.WHITE);
		this.add(southPanel, BorderLayout.SOUTH);
			this.backPanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.backPanel.setBackground(Color.WHITE);
			this.southPanel.add(backPanel);
			this.optionButtonsPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
			this.optionButtonsPanel.setBackground(Color.WHITE);
			this.southPanel.add(optionButtonsPanel);
			
		this.backButton=new RoundedButton("Back", Color.decode("#09A8E4"));
		this.backButton.setPreferredSize(new Dimension(90,30));
		this.backButton.setBackground(Color.WHITE);
		this.backPanel.add(backButton);
		
        
        this.rightSpace = new JPanel();
        this.rightSpace.setPreferredSize(new Dimension(20, 10));// Ancho de 10 píxeles
        add(rightSpace, BorderLayout.EAST);
        this.rightSpace.setBackground(Color.WHITE);
        
        this.leftSpace = new JPanel();
        this.leftSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(leftSpace, BorderLayout.WEST);
        this.leftSpace.setBackground(Color.WHITE);
        
        this.northSpace = new JPanel();
        this.northSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(northSpace, BorderLayout.NORTH);
        this.northSpace.setBackground(Color.WHITE);
		
	}
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new SearchTempletePanel ());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}
