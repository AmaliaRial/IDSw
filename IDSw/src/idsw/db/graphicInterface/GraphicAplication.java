package idsw.db.graphicInterface;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import idsw.db.graphicInterface.components.ImagePanel;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;

public class GraphicAplication extends JFrame{
	
	private ArrayList<JPanel> allPanels;
	private ConnectionManager conMan;
	private JPAUserManager jpaConMan;
	
	private LogInPanel logInPanel;
	private ChooseUserSignInPanel chooseUserSignInPanel;
	private SignInPanelDoctor signInPanelDoctor;
	private SignInPanelPatient signInPanelPatient;
	private SignInPanelResearcher signInPanelResearcher;
	
	private HomePanelDoctor homePanelDoctor;
	private HomePanelPatient homePanelPatient;
	private HomePanelResearcher homePanelResearcher;
	
	private MedicalRecordPanel medicalRecordPanel;
	private MedicalRecordForDoctorPanel medicalRecordForDoctorPanel; 
	private SearchPatientPanel searchPatientPanel;
	private CreateDiagnosisPanel createDiagnosisPanel;
	private UpdateDiagnosisPanel updateDiagnosisPanel;
	private ViewDiagnosisPanel viewDiagnosisPanel;
	
	private ResearcherDiseaseSearchPanel researcherDiseaseSearchPanel;
	private CreateDiseasePanel createDiseasePanel;
	private ViewDiseasePanel viewDiseasePanel;
	private UpdateDiseasePanel  updateDiseasePanel;	
	
	private ResearcherSymptomSearchPanel researcherSymptomSearchPanel;
	private Create_SymptomPanel create_SymptomPanel;
	private UpdateSymptomPanel updateSymptomPanel;
	private ReadResearcher_SymptomPanel readResearcher_SymptomPanel;
	private ReadResearcher2_SymptomsPanel readResearcher2_SymptomsPanel;
	private ReadPatientDoctor_SymptomPanel readPatientDoctor_SymptomPanel;
	
	private ResearcherTreatmentSearchPanel researcherTreatmentSearchPanel;
	private Create_TreatmentPanel create_TreatmentPanel;
	private Update_Treatmentpanel update_Treatmentpanel ;
	private ReadResearcher_TreatmentPanel readResearcher_TreatmentPanel;
	private ReadResearcher2_TreatmentPanel readResearcher2_TreatmentPanel;
	private ReadPatientDoctor_TreatmentPanel readPatientDoctor_TreatmentPanel;
	
	private LogOutPanel logOutPanel;
	private UpdateAcountPanel updateAcountPanel;
	
	private CreateSearchSimulationOptionPanel createSearchSimulationOptionPanel;
	private SearchPopulationFromDiseaseSimulationPanel searchPopulationFromDiseaseSimulationPanel;
	private SearchSimulationByPopulation searchSimulationByPopulation;
	private CreateSimulationPanel sreateSimulationPanel;
	private ViewSimulationResultPanel viewSimulationResultPanel;
	private ViewSimulationResultFromSearchPanel viewSimulationResultFromSearchPanel;
	
	private SearchDiseaseOptionPanel searchDiseaseOptionPanel;
	private DeleteVerificationPanel deleteVerificationPanel;
	private GeneralDiseaseSearchPanel generalDiseaseSearchPanel;
	
	public  GraphicAplication() {
		this.conMan = new ConnectionManager(); 
		this.jpaConMan= new JPAUserManager();
		this.allPanels = new ArrayList<JPanel>(); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
      
        this.logInPanel=new LogInPanel(this.jpaConMan,this);
        this.getContentPane().add(this.logInPanel);
        this.allPanels.add(this.logInPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        
        this.chooseUserSignInPanel=new ChooseUserSignInPanel();
        this.allPanels.add(this.chooseUserSignInPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        
     
        
	
	}
	
	private void setAllPanelsVisibilityOff() {
		for (JPanel jPanel : allPanels) {
			if(jPanel.isVisible()) {
				jPanel.setVisible(false);
			}
		}
	}
	
	
	public void fromLogInPanelToChooseUserSignInPanel() {
		setAllPanelsVisibilityOff();
		this.chooseUserSignInPanel.setVisible(true);
		this.getContentPane().add(this.chooseUserSignInPanel);
	}
	
	public static void main(String[] args) {
		GraphicAplication aplication= new GraphicAplication();
	}
	

}
