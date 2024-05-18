package idsw.db.graphicInterface;

import java.awt.*;
import javax.swing.*;

import idsw.db.graphicInterface.components.*;


public class CreateSimulationPanel extends SymptomTemplate {
	public JPanel northPanel;
	public JPanel centerPanel;
		public JPanel numberPeoplePanel;
		public JPanel inmunityPanel;
		public JPanel illPercentagePanel;
		public JPanel inmunePercentagePanel;
	public JPanel buttonsPanel;
		public JPanel button1Panel;
		public JPanel button2Panel;
	public JPanel rightPanel;
	public JPanel leftPanel;
	
	public CustomJLabel titleLabel;
	public CustomJLabel numberPeopleLabel;
	public CustomJLabel inmunityLabel;
	public CustomJLabel illPercentageLabel;
	public CustomJLabel inmunePercentageLabel;
	public RoundedButton button1;
	public RoundedButton button2;
	
	public JTextField numberPeopleField;
	public JTextField inmunityField;
	public JTextField illPercentageField;
	public JTextField inmunePercentageField;
	
	
	public CreateSimulationPanel(){
	
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(this.northPanel, BorderLayout.NORTH);
		this.titleLabel = new CustomJLabel("<html><b>INSERT PARAMETERS</b></html>", 20, Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		this.northPanel.add(this.titleLabel);
		
		this.centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.numberPeoplePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.numberPeoplePanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.numberPeoplePanel);
	    this.inmunityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    this.inmunityPanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.inmunityPanel);
		this.illPercentagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.illPercentagePanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.illPercentagePanel);
	    this.inmunePercentagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.inmunePercentagePanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.inmunePercentagePanel);
	    this.numberPeopleLabel = new CustomJLabel("<html>Number of People:</html>", 15, Color.BLACK, Color.WHITE);
		this.numberPeoplePanel.add(this.numberPeopleLabel);
		this.inmunityLabel = new CustomJLabel("<html>Inmunity Period:</html>", 15, Color.BLACK, Color.WHITE);
		this.inmunityPanel.add(this.inmunityLabel);
		this.illPercentageLabel = new CustomJLabel("<html>Ill Percentage:</html>", 15, Color.BLACK, Color.WHITE);
		this.illPercentagePanel.add(this.illPercentageLabel);
		this.inmunePercentageLabel = new CustomJLabel("<html>Inmune Percentage:</html>", 15, Color.BLACK, Color.WHITE);
		this.inmunePercentagePanel.add(this.inmunePercentageLabel);
		this.numberPeopleField = new JTextField(20);
		this.numberPeoplePanel.add(this.numberPeopleField);
		this.inmunityField = new JTextField(20);
		this.inmunityPanel.add(this.inmunityField);
		this.illPercentageField = new JTextField(20);
		this.illPercentagePanel.add(this.illPercentageField);
		this.inmunePercentageField = new JTextField(20);
		this.inmunePercentagePanel.add(this.inmunePercentageField);
		
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
		this.button1 = new RoundedButton("Cancel", Color.decode("#09A8E4"));	
		this.button1.setPreferredSize(new Dimension(90, 30));
		this.button1Panel.add(this.button1);
		this.button2Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.button2Panel.setBackground(Color.WHITE);
		this.buttonsPanel.add(this.button2Panel);
		this.button2 = new RoundedButton("Create simulation", Color.decode("#09A8E4"));
		this.button2.setPreferredSize(new Dimension(120, 30));
		this.button2Panel.add(this.button2);
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CreateSimulationPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
