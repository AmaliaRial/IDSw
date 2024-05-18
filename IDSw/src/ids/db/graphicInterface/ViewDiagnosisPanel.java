package idsw.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import ids.db.graphicInterface.components.CustomJLabel;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Treatment;

public class ViewDiagnosisPanel extends DiagnosisTemplatePanel{
	public CustomJLabel viewNameLabel;
	public CustomJLabel viewDateLabel;
	public CustomJLabel viewcommentSectionLabel;
	public JScrollPane treatmentList;
	
	public ViewDiagnosisPanel(Integer id_Diagnosis) {
		super();
		Diagnosis diagnosis= super.conMan.getDiagnosisMan().getDiagnosis(id_Diagnosis);
		super.titleLabel.setText("<html><b>"+diagnosis.getNameDiagnosis()+"</b></html>");
		this.viewNameLabel= new CustomJLabel(diagnosis.getDisease().getNameDisease(), 15, Color.BLACK, Color.WHITE);
		super.nameDiseasePanel.add(viewNameLabel);
		this.viewDateLabel= new CustomJLabel((diagnosis.getLocalDate()).toString(), 15, Color.BLACK, Color.WHITE);
		super.datePanel.add(viewDateLabel);
		this.viewcommentSectionLabel=new CustomJLabel(diagnosis.getComment_section(), 15, Color.BLACK, Color.WHITE);
		super.comentSectionPanel.add(viewcommentSectionLabel);
		
		List<Treatment> treatments= this.conMan.getTreatmentMan().getTreatmentsByDiagnosis(diagnosis);
		DefaultListModel<String> listModel = ListNameofTreatments(treatments);
		JList<String> lista = new JList<>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.treatmentList= new JScrollPane(lista);
		this.treatmentList.setPreferredSize(new Dimension(400, 200));
		this.treatmentsPanel.add(treatmentList);
		
		super.backCalceButton.setButtonText("BACK");
		
	}
	
	private DefaultListModel<String> ListNameofTreatments(List<Treatment> treatments){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Treatment treatment:treatments) {
			listModel.addElement(treatment.getNameTreatment());
		}
		return listModel;
	}
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ViewDiagnosisPanel(2));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
