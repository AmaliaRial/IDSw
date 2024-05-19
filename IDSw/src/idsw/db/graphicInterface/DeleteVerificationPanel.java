package idsw.db.graphicInterface;

import javax.swing.*;
import java.awt.*;
import idsw.db.graphicInterface.components.*;

public class DeleteVerificationPanel extends JPanel{
	public JPanel titlePanel;
	public JPanel centerPanel;
	public JPanel noButtonPanel;
	public JPanel yesButtonPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	public JPanel southSpace;
	public CustomJLabel title;
	public RoundedButton noButton;
	public RoundedButton yesButton;
	
	public DeleteVerificationPanel() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.titlePanel.setBackground(Color.decode("#A5E0F1"));
		this.add(titlePanel, BorderLayout.NORTH);
		this.title = new CustomJLabel("<html><b>Do you want to delete the items selected?</b></html>", 20, Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		this.titlePanel.add(this.title);
		this.centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.noButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.noButtonPanel.setBackground(Color.WHITE);
		this.centerPanel.add(this.noButtonPanel);
		this.yesButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.yesButtonPanel.setBackground(Color.WHITE);
		this.centerPanel.add(this.yesButtonPanel);
		this.noButton = new RoundedButton("No", Color.decode("#09A8E4"));
		this.noButton.setPreferredSize(new Dimension(90, 30));
		this.noButtonPanel.add(this.noButton);
		this.yesButton = new RoundedButton("Yes", Color.decode("#09A8E4"));
		this.yesButton.setPreferredSize(new Dimension(90, 30));
		this.yesButtonPanel.add(this.yesButton);
		
		this.southSpace = new JPanel();
		this.southSpace.setPreferredSize(new Dimension(10, 10));
		this.southSpace.setBackground(Color.WHITE);
		this.add(this.southSpace, BorderLayout.SOUTH);
	
		
		this.rightSpace = new JPanel();
		this.rightSpace.setPreferredSize(new Dimension(10, 10));
		this.rightSpace.setBackground(Color.WHITE);
		this.add(this.rightSpace, BorderLayout.EAST);
		
		this.leftSpace = new JPanel();
		this.leftSpace.setPreferredSize(new Dimension(10, 10));
		this.leftSpace.setBackground(Color.WHITE);
		this.add(this.leftSpace, BorderLayout.WEST);
		
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DeleteVerificationPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}