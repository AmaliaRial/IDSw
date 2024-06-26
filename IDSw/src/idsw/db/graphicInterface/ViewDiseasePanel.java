package idsw.db.graphicInterface;

import idsw.db.jdbc.*;
import idsw.db.jpa.JPAUserManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.PlaceholderTextField;
import idsw.db.graphicInterface.components.RoundedButton;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Role;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;
import idsw.db.pojos.User;
import idsw.db.utilities.GraphUtilities;

public class ViewDiseasePanel extends DiseaseTempletePanel implements ActionListener{
	
	public CustomJLabel causeLabel;
	public CustomJLabel mortalityRateLabel;
	public CustomJLabel infectiousRateLabel;
	public CustomJLabel incuvationPeriodLabel;
	public CustomJLabel developmentPeriodLabel;
	public CustomJLabel convalencesePeriodLabel;
	public CustomJLabel commentSectionLabel;
	public JScrollPane treatmentList;
	public JScrollPane symptomList;
	public ChartPanel developmentChart;
	
	public ViewDiseasePanel(Integer id_Disease, ConnectionManager conMan,JPAUserManager jpaConMan, GraphicAplication app){
		super(conMan,jpaConMan,app);
		super.namePanel.remove(super.nameLabel);
		Disease disease= super.conMan.getDiseaseMan().getDisease(id_Disease);
		super.titleLabel.setText("<html><b>"+disease.getNameDisease()+"</b></html>");
		this.causeLabel= new CustomJLabel(disease.getCause().toString(), 15, Color.BLACK, Color.WHITE);
		super.causeDiseasePanel.add(causeLabel);
		this.mortalityRateLabel= new CustomJLabel((disease.getMortality_rate()).toString(), 15, Color.BLACK, Color.WHITE);
		super.mortalityPanel.add(mortalityRateLabel);
		this.infectiousRateLabel=new CustomJLabel(disease.getInfectious_rate().toString(), 15, Color.BLACK, Color.WHITE);
		super.infectiousPanel.add(infectiousRateLabel);
		this.incuvationPeriodLabel= new CustomJLabel(disease.getIncubation_period().toString(), 15, Color.BLACK, Color.WHITE);
		super.incuvationPeriotPanel.add(incuvationPeriodLabel);
		this.developmentPeriodLabel= new CustomJLabel(disease.getDevelopment_period().toString(), 15, Color.BLACK, Color.WHITE);
		super.developmentPeriotPanel.add(developmentPeriodLabel);
		this.convalencesePeriodLabel=new CustomJLabel(disease.getConvalescence_period().toString(), 15, Color.BLACK, Color.WHITE);
		super.convalescensePeriotPanel.add(convalencesePeriodLabel);
		this.commentSectionLabel=new CustomJLabel(disease.getComment_section(), 15, Color.BLACK, Color.WHITE);
		super.commentSectionPanel.add(commentSectionLabel);
		super.backCancelButton.addActionListener(this);
		
		List<Symptom> simptoms= this.conMan.getSymptomMan().getSymptomsByDisease(disease);
		DefaultListModel<String> listModel = ListNameofSymptoms(simptoms);
		JList<String> lista = new JList<>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.symptomList= new JScrollPane(lista);
		this.symptomList.setPreferredSize(new Dimension(400, 200));
		this.symptomsPanel.add(symptomList);
		
		List<Treatment> treatments= this.conMan.getTreatmentMan().getTreatmentsByDisease(disease);
		listModel = ListNameofTreatments(treatments);
		lista = new JList<>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.treatmentList= new JScrollPane(lista);
		this.treatmentList.setPreferredSize(new Dimension(400, 200));
		this.treatmentsPanel.add(treatmentList);
		
		GraphUtilities utilGraph= new GraphUtilities();
		JFreeChart developmentJChart=utilGraph.graphDiseaseDevelopment(disease);
		this.developmentChart= new ChartPanel(developmentJChart);
		this.developmentChart.setPreferredSize(new Dimension(460,305));
		super.developmentGraphPanel.add(this.developmentChart);
		
		
		super.backCancelButton.setButtonText("BACK");
	}
	
	private DefaultListModel<String> ListNameofTreatments(List<Treatment> treatments){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Treatment treatment:treatments) {
			listModel.addElement(treatment.getNameTreatment());
		}
		return listModel;
	}
	
	private DefaultListModel<String> ListNameofSymptoms(List<Symptom> symptoms){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Symptom symptom:symptoms) {
			listModel.addElement(symptom.getNameSymptom());
		}
		return listModel;
	}
	
	 public void actionPerformed(ActionEvent e) {
			if(e.getSource()==this.backCancelButton) {
			this.app.fromViewDiseasePanelToGeneralDiseaseSearchPanel();}			
			}
		
	
	
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.getContentPane().add(new ViewDiseasePanel(2));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}
