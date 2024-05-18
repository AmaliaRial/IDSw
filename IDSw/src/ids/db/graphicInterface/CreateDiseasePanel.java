package idsw.db.graphicInterface;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateDiseasePanel extends CreateUpdate_DiseasePanel{
	public JTextField diseaseNameTextField;
	public JTextField mortalityRateTextField;
	public JTextField infectiousRateTextField;
	public JTextField incuvationPeriodTextField;
	public JTextField developmentPeriodTextField;
	public JTextField convalencesePeriodTextField;
	public JTextField commentSectionTextField;
	
	public CreateDiseasePanel(){
		super();
		this.diseaseNameTextField= new JTextField(20);
		super.namePanel.add(new JLabel());
		super.namePanel.add(this.diseaseNameTextField);
		this.mortalityRateTextField= new JTextField(20);
		super.mortalityPanel.add(new JLabel());
		super.mortalityPanel.add(this.mortalityRateTextField);
		this.infectiousRateTextField= new JTextField(20);
		super.infectiousPanel.add(new JLabel());
		super.infectiousPanel.add(this.infectiousRateTextField);
		this.incuvationPeriodTextField= new JTextField(20);
		super.incuvationPeriotPanel.add(new JLabel());
		super.incuvationPeriotPanel.add(this.incuvationPeriodTextField);
		this.developmentPeriodTextField= new JTextField(20);
		super.developmentPeriotPanel.add(new JLabel());super.developmentPeriotPanel.add(new JLabel());
		super.developmentPeriotPanel.add(this.developmentPeriodTextField);
		this.convalencesePeriodTextField= new JTextField(20);
		super.convalescensePeriotPanel.add(new JLabel());super.convalescensePeriotPanel.add(new JLabel());
		super.convalescensePeriotPanel.add(this.convalencesePeriodTextField);
		this.commentSectionTextField= new JTextField(20);
		super.commentSectionPanel.add(new JLabel());
		super.commentSectionPanel.add(this.commentSectionTextField);

	}
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new CreateDiseasePanel());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	

}
