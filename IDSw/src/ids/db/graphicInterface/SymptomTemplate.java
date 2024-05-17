package ids.db.graphicInterface;

import java.awt.*;
import javax.swing.*;
import ids.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;

public class SymptomTemplate extends JPanel{
	public JPanel northPanel;
	public JPanel centerPanel;
		public JPanel namePanel;
		public JPanel painManagementPanel;
	public JPanel buttonsPanel;
		public JPanel button1Panel;
		public JPanel button2Panel;
	public JPanel rightPanel;
	public JPanel leftPanel;
	
	public CustomJLabel titleLabel;
	public CustomJLabel nameLabel;
	public CustomJLabel PainManagemetLabel;
	public RoundedButton button1;
	public RoundedButton button2;
	public ConnectionManager conMan;
	
	
	public SymptomTemplate(){
		this.conMan = new ConnectionManager();
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(this.northPanel, BorderLayout.NORTH);
		this.titleLabel = new CustomJLabel("<html><b>TITTLE</b></html>", 20, Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		this.northPanel.add(this.titleLabel);
		
		this.centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.namePanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.namePanel);
	    this.painManagementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    this.painManagementPanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.painManagementPanel);
		this.nameLabel = new CustomJLabel("<html>Name:</html>", 15, Color.BLACK, Color.WHITE);
		this.namePanel.add(this.nameLabel);
		this.PainManagemetLabel = new CustomJLabel("<html>Pain management:</html>", 15, Color.BLACK, Color.WHITE);
		this.painManagementPanel.add(this.PainManagemetLabel);
	
		
		this.rightPanel = new JPanel();
		this.rightPanel.setPreferredSize(new Dimension(20, 20));
		this.rightPanel.setBackground(Color.WHITE);
		this.add(this.rightPanel, BorderLayout.EAST);
		
		this.leftPanel = new JPanel();
		this.leftPanel.setPreferredSize(new Dimension(20, 20));
		this.leftPanel.setBackground(Color.WHITE);
		this.add(this.leftPanel, BorderLayout.WEST);
		
		this.buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		this.buttonsPanel.setBackground(Color.WHITE);
		this.add(this.buttonsPanel, BorderLayout.SOUTH);
		this.button1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.button1Panel.setBackground(Color.WHITE);
		this.buttonsPanel.add(this.button1Panel);
		this.button1 = new RoundedButton("Button1", Color.decode("#09A8E4"));	
		this.button1.setPreferredSize(new Dimension(90, 30));
		this.button1Panel.add(this.button1);
		this.button2Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.button2Panel.setBackground(Color.WHITE);
		this.buttonsPanel.add(this.button2Panel);
		this.button2 = new RoundedButton("Button2", Color.decode("#09A8E4"));
		this.button2.setPreferredSize(new Dimension(90, 30));
		this.button2Panel.add(this.button2);
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SymptomTemplate());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
