package idsw.db.graphicInterface;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import idsw.db.graphicInterface.components.ImagePanel;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.panelsSwichingInterface.PanelSwitchingInterface;
import idsw.db.pojos.User;

public class GraphicAplication extends JFrame implements PanelSwitchingInterface{
	
	private ArrayList<JPanel> allPanels;
	private ConnectionManager conMan;
	private JPAUserManager jpaConMan;
	private User user;
	
	private LogInPanel logInPanel;
	private ChooseUserSignInPanel chooseUserSignInPanel;
	//private SignInPanelDoctor signInPanelDoctor;
	private SignInPanelPatient signInPanelPatient;
	//private SignInPanelResearcher signInPanelResearcher;
	
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
	//private CreateDiseasePanel createDiseasePanel;
	private ViewDiseasePanel viewDiseasePanel;
	//private UpdateDiseasePanel  updateDiseasePanel;	
	
	private ResearcherSymptomSearchPanel researcherSymptomSearchPanel;
	private Create_SymptomPanel create_SymptomPanel;
	//private UpdateSymptomPanel updateSymptomPanel;
	private ReadResearcher_SymptomPanel readResearcher_SymptomPanel;
	private ReadResearcher2_SymptomsPanel readResearcher2_SymptomPanel;
	private ReadPatientDoctor_SymptomPanel readPatientDoctor_SymptomPanel;
	
	private ResearcherTreatmentSearchPanel researcherTreatmentSearchPanel;
	private Create_TreatmentPanel create_TreatmentPanel;
	//private Update_Treatmentpanel update_TreatmentPanel ;
	private ReadResearcher_TreatmentPanel readResearcher_TreatmentPanel;
	private ReadResearcher2_TreatmentPanel readResearcher2_TreatmentPanel;
	private ReadPatientDoctor_TreatmentPanel readPatientDoctor_TreatmentPanel;
	
	private LogOutPanel logOutPanel;
	private UpdateAcountPanel updateAcountPanel;
	
	private CreateSearchSimulationOptionPanel createSearchSimulationOptionPanel;
	private SearchPopulationFromDiseaseSimulationPanel searchPopulationFromDiseaseSimulationPanel;
	private SearchSimulationByPopulation searchSimulationByPopulation;
	private CreateSimulationPanel createSimulationPanel;
	private ViewSimulationResultPanel viewSimulationResultPanel;
	private ViewSimulationResultFromSearchPanel viewSimulationResultFromSearchPanel;
	
	private SearchDiseaseOptionPanel searchDiseaseOptionPanel;
	private DeleteVerificationPanel deleteVerificationPanel;
	private GeneralDiseaseSearchPanel generalDiseaseSearchPanel;
	private SearchOptionPanel searchOptionPanel;
	
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
        
        this.chooseUserSignInPanel=new ChooseUserSignInPanel(this.jpaConMan,this);
        this.allPanels.add(this.chooseUserSignInPanel);
        
        //this.signInPanelDoctor=new SignInPanelDoctor(this.jpaConMan,this);
        //this.allPanels.add(this.signInPanelDoctor);
        
        this.signInPanelPatient=new SignInPanelPatient(this.jpaConMan,this);
        this.allPanels.add(this.signInPanelPatient);
        
        //this.signInPanelResearcher=new SignInPanelPatient(this.jpaConMan,this);
        //this.allPanels.add(this.signInPanelResearcher);
        
        this.homePanelDoctor=new HomePanelDoctor(this.jpaConMan,this);
        this.allPanels.add(this.homePanelDoctor);
     
        
       // this.homePanelPatient=new HomePanelPatient(this.jpaConMan,this,this.conMan);
        this.allPanels.add(this.homePanelPatient);
        
        this.homePanelResearcher=new HomePanelResearcher(this.jpaConMan,this,this.conMan);
        this.allPanels.add(this.homePanelResearcher);
        
        
        //this.medicalRecordPanel=new MedicalRecordPanel(this.jpaConMan,this);
        //this.allPanels.add(this.medicalRecordPanel);
        
        this.medicalRecordForDoctorPanel=new MedicalRecordForDoctorPanel(null,this.conMan);
        this.allPanels.add(this.medicalRecordForDoctorPanel);
        
        this.searchPatientPanel=new SearchPatientPanel(this.conMan,this);
        this.allPanels.add(this.searchPatientPanel);
        
        //this.createDiagnosisPanel=new CreateDiagnosisPanel();
        this.allPanels.add(this.createDiagnosisPanel);
        
        //TODO ADD viewDiagnosisPanelForDoctor
        
        this.searchDiseaseOptionPanel=new SearchDiseaseOptionPanel();
        this.allPanels.add(this.searchDiseaseOptionPanel);
        
        this.researcherSymptomSearchPanel=new ResearcherSymptomSearchPanel();
        this.allPanels.add(this.researcherSymptomSearchPanel);
        
        this.viewDiseasePanel=new ViewDiseasePanel(null, this.conMan,this.jpaConMan, this);
        this.allPanels.add(this.viewDiseasePanel);
        
        this.logOutPanel=new LogOutPanel(null,this.jpaConMan,this);
        this.allPanels.add(this.logOutPanel);
        
        this.createSearchSimulationOptionPanel=new CreateSearchSimulationOptionPanel();
        this.allPanels.add(this.createSearchSimulationOptionPanel);
        
        this.generalDiseaseSearchPanel=new GeneralDiseaseSearchPanel();
        this.allPanels.add(this.generalDiseaseSearchPanel);
        
        //this.createSimulationPanel=new CreateSimulationPanel();
        this.allPanels.add(this.createSimulationPanel);
        
        //this.viewSimulationResultPanel=new ViewSimulationResultPanel(null, null, this.conMan,this);
        this.allPanels.add(this.viewSimulationResultPanel);

	
	}
	
	private void setAllPanelsVisibilityOff() {
		for (JPanel jPanel : allPanels) {
			if(jPanel.isVisible()) {
				jPanel.setVisible(false);
			}
		}
	}

	@Override
	public void fromLogInPanelToChooseUserSignInPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogInPanelToHomePanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogInPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogInPanelToHomePanelPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromChooseUserSignInPanelToLogInPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromChooseUserSignInToSingInPanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromChooseUserSignInToSingInPanelPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromChooseUserSignInToSingInPanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSingInPanelDoctorToChooseUserSignInPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSingInPanelDoctorToHomePanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSingInPanelReasearcherToChooseUserSignInPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSingInPanelResearcherToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSingInPanelPatientToChooseUserSignInPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSingInPanelPatientToHomePanelPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(Integer id_treatment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelDoctorToSearchPatientPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelDoctorToSearchDiseaseOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelDoctorToLogOutPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelPatientToViewDiagnosisPanel(Integer id_dignosis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelPatientToMedicalRecordPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelPatientToSearchDiseaseOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelPatientToLogOutPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelResearcherToViewSimulationResultPanel(Integer id_simulation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelResearcherToCreateSearchSimulationOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelResearcherToResearcherTreatmentSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelResearcherToResearcherSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelResearcherToSearchDiseaseOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromHomePanelResearcherToLogOutPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchPatientPanelToMedicalRecordForDoctorPanel(Integer id_patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchPatientPanelToHomePanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordPanelToViewDiagnosisPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordPanelToHomePanelPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToViewDiagnosisPanelForDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToHomePanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToUpdateDiagnosisPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToCreateDiagnosispanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToDeleteVerificationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromDeleteVerificationPanelToMedicalRecordForDoctorPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateDiagnosisPanelToMedicalRecordForDoctorPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateDiagnosisPanelToViewDiagnosisPanelForDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromModifyDiagnosisPanelToMedicalRecordForDoctorPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromModifyDiagnosisPanelToViewDiagnosisPanelForDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewDiagnosisPanelForDoctorToMedicalRecordForDoctorPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewDiagnosisPanelForDoctorToModifyDiagnosisPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchDiseaseOptionPanelToGeneralDiseaseSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchDiseaseOptionPanelToReasearcherDiseaseSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchDiseaseOptionPanelToGeneralSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToDeleteVerificationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToCreateDiseasePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToModifyDiseasePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToViewDiseasePanelForReasearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToViewDiseasePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToHomePanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToHomePanelPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewDiseasePanelToGeneralDiseaseSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromDeleteVerificationPanelToSearchDiseaseOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateDiseasePanelToSearchDiseaseOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateDiseasePanelToViewDiseasePanelForReasearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromModifyDiseasePanelToSearchDiseaseOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromModifyDiseasePanelToViewDiseasePanelForResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewDiseasePanelForResearcherToReasearcherDiseaseSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewDiseasePanelForResearcherToModifyDiseasePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogOutPanelToUpdateAcountPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogOutPanelToLogInPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogOutPanelToOUT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogOutPanelToHomePanelDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogOutPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromLogOutPanelToHomePanelPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromUpdateAcountPanelToLogOutPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToDeleteVerificationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToCreate_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToUpdate_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToReadReasearcher2_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromDeleteVerificationPanelToReasearcherTreatmentSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToDeleteVerificationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToCreate_SymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToUpdateSymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToReadReasearcher2_SymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromDeleteVerificationPanelToReasearcherSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromUpdate_TreatmentPanelToReasearcherTreatmentSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromUpdate_TreatmentPanelToReadResearcher_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreate_TreatmentPanelToReasearcherTreatmentSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreate_TreatmentPanelToReadResearcher_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher_TreatmentPanelToUpdate_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher_TreatmentPanelToReasearcherTreatmentSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToReasearcherTreatmentSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToDeleteVerificationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToUpdate_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiagnosisPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiagnosisPanelForDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiseasePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiseasePanelForResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromDeleteVerificationPanelToReadReasearcher2_TreatmentPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromUpdateSymptomPanelToReasearcherSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromUpdateSymptomPanelToReadResearcher_SymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreate_SymptomPanelToReasearcherSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreate_SymptomPanelToReadResearcher_SymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher_SymptomPanelToUpdateSymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher_SymptomPanelToReasearcherSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToReasearcherSymptomSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToDeleteVerificationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToUpdateSymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiagnosisPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiagnosisPanelForDoctor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiseasePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiseasePanelForResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromDeleteVerificationPanelToReadReasearcher2_SymptomPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateSearchSimulationOptionPanelToSearchOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToSearchPopulationFromDiseaseSimulationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToCreateSimulationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchPopulationFromDiseaseSimulationPanelToSearchSimulationByPopulation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchPopulationFromDiseaseSimulationPanelToGeneralDiseaseSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchSimulationByPopulationToViewSimulationResultFromSearchPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromSearchSimulationByPopulationToSearchPopulationFromDiseaseSimulationPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewSimulationResultFromSearchPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewSimulationResultFromSearchPanelToSearchSimulationByPopulation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateSimulationPanelToSearchOptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromCreateSimulationPanelToViewSimulationResultPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromViewSimulationResultPanelToHomePanelResearcher() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/*
	public static void main(String[] args) {
		GraphicAplication aplication= new GraphicAplication();
	}
	
	

	@Override
	public void fromLogInPanelToChooseUserSignInPanel() {
		setAllPanelsVisibilityOff();
		this.chooseUserSignInPanel.setVisible(true);
		this.getContentPane().add(this.chooseUserSignInPanel);
        this.pack();
	}  

	@Override
	public void fromLogInPanelToHomePanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.homePanelDoctor.setVisible(true);
	    this.getContentPane().add(this.homePanelDoctor);
	    this.pack();
	}

	@Override
	public void fromLogInPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromLogInPanelToHomePanelPatient() {
	    setAllPanelsVisibilityOff();
	    this.homePanelPatient.setVisible(true);
	    this.getContentPane().add(this.homePanelPatient);
	    this.pack();
	}

	@Override
	public void fromChooseUserSignInPanelToLogInPanel() {
	    setAllPanelsVisibilityOff();
	    this.logInPanel.setVisible(true);
	    this.getContentPane().add(this.logInPanel);
	    this.pack();
	}

	@Override
	public void fromChooseUserSignInToSingInPanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.signInPanelDoctor.setVisible(true);
	    this.getContentPane().add(this.signInPanelDoctor);
	    this.pack();
	}

	@Override
	public void fromChooseUserSignInToSingInPanelPatient() {
	    setAllPanelsVisibilityOff();
	    this.signInPanelPatient=new SignInPanelPatient(this.jpaConMan,this);
	    this.signInPanelPatient.setVisible(true);
	    this.getContentPane().add(this.signInPanelPatient);
	    this.pack();
	}

	@Override
	public void fromChooseUserSignInToSingInPanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.signInPanelResearcher.setVisible(true);
	    this.getContentPane().add(this.signInPanelResearcher);
	    this.pack();
	}

	@Override
	public void fromSingInPanelDoctorToChooseUserSignInPanel() {
	    setAllPanelsVisibilityOff();
	    this.chooseUserSignInPanel.setVisible(true);
	    this.getContentPane().add(this.chooseUserSignInPanel);
	    this.pack();
	}

	@Override
	public void fromSingInPanelDoctorToHomePanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.homePanelDoctor.setVisible(true);
	    this.getContentPane().add(this.homePanelDoctor);
	    this.pack();
	}

	@Override
	public void fromSingInPanelReasearcherToChooseUserSignInPanel() {
	    setAllPanelsVisibilityOff();
	    this.chooseUserSignInPanel.setVisible(true);
	    this.getContentPane().add(this.chooseUserSignInPanel);
	    this.pack();
	}

	@Override
	public void fromSingInPanelResearcherToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromSingInPanelPatientToChooseUserSignInPanel() {
	    setAllPanelsVisibilityOff();
	    this.chooseUserSignInPanel.setVisible(true);
	    this.getContentPane().add(this.chooseUserSignInPanel);
	    this.pack();
	}

	@Override
	public void fromSingInPanelPatientToHomePanelPatient() {
	    setAllPanelsVisibilityOff();
	    //this.homePanelPatient=new HomePanelPatient(this.jpaConMan,this,this.conMan);
	    this.homePanelPatient.setVisible(true);
	    this.getContentPane().add(this.homePanelPatient);
	    this.pack();
	    this.setLocationRelativeTo(null);
	}

	@Override
	public void fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(Integer id_treatment) {
	    setAllPanelsVisibilityOff();
	    //this.readPatientDoctor_TreatmentPanel=new ReadPatientDoctor_TreatmentPanel(id_treatment);
	    this.readPatientDoctor_TreatmentPanel.setVisible(true);	
	    this.getContentPane().add(this.readPatientDoctor_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelDoctorToSearchPatientPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchPatientPanel.setVisible(true);
	    this.getContentPane().add(this.searchPatientPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelDoctorToSearchDiseaseOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchDiseaseOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchDiseaseOptionPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelDoctorToLogOutPanel() {
	    setAllPanelsVisibilityOff();
	    this.logOutPanel.setVisible(true);
	    this.getContentPane().add(this.logOutPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelPatientToViewDiagnosisPanel(Integer id_diagnosis) {
	    setAllPanelsVisibilityOff();
	    this.viewDiagnosisPanel=new ViewDiagnosisPanel(id_diagnosis, this.conMan,this, this.jpaConMan);
	    this.viewDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelPatientToMedicalRecordPanel() {
	    setAllPanelsVisibilityOff();
	    this.medicalRecordPanel.setVisible(true);
	    this.getContentPane().add(this.medicalRecordPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelPatientToSearchDiseaseOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchDiseaseOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchDiseaseOptionPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelPatientToLogOutPanel() {
	    setAllPanelsVisibilityOff();
	    this.logOutPanel.setVisible(true);
	    this.getContentPane().add(this.logOutPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelResearcherToViewSimulationResultPanel(Integer id_simulation) {
	    setAllPanelsVisibilityOff();
	    //TODO correhir tabla de simulation
	    //this.viewSimulationResultPane=new ViewSimulationResultFromSearchPanel(id_simulation);
	    this.viewSimulationResultPanel.setVisible(true);
	    this.getContentPane().add(this.viewSimulationResultPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelResearcherToCreateSearchSimulationOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.createSearchSimulationOptionPanel.setVisible(true);
	    this.getContentPane().add(this.createSearchSimulationOptionPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelResearcherToResearcherTreatmentSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherTreatmentSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherTreatmentSearchPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelResearcherToResearcherSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherSymptomSearchPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelResearcherToSearchDiseaseOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchDiseaseOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchDiseaseOptionPanel);
	    this.pack();
	}

	@Override
	public void fromHomePanelResearcherToLogOutPanel() {
	    setAllPanelsVisibilityOff();
	    this.logOutPanel.setVisible(true);
	    this.getContentPane().add(this.logOutPanel);
	    this.pack();
	}

	@Override
	public void fromSearchPatientPanelToMedicalRecordForDoctorPanel(Integer id_patient) {
	    setAllPanelsVisibilityOff();
	    this.medicalRecordForDoctorPanel=new MedicalRecordForDoctorPanel(id_patient, this.conMan);
	    this.medicalRecordForDoctorPanel.setVisible(true);
	    this.getContentPane().add(this.medicalRecordForDoctorPanel);
	    this.pack();
	}

	@Override
	public void fromSearchPatientPanelToHomePanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.homePanelDoctor.setVisible(true);
	    this.getContentPane().add(this.homePanelDoctor);
	    this.pack();
	}

	@Override
	public void fromMedicalRecordPanelToViewDiagnosisPanel() {
	    setAllPanelsVisibilityOff();
	    this.viewDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromMedicalRecordPanelToHomePanelPatient() {
	    setAllPanelsVisibilityOff();
	    this.homePanelPatient.setVisible(true);
	    this.getContentPane().add(this.homePanelPatient);
	    this.pack();
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToViewDiagnosisPanelForDoctor() {
		//TODO crear panel viewDiagnosisPanelForDoctor
	    setAllPanelsVisibilityOff();
	    this.viewDiagnosisPanelForDoctor.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanelForDoctor);
	    this.pack();
	    
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToHomePanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.homePanelDoctor.setVisible(true);
	    this.getContentPane().add(this.homePanelDoctor);
	    this.pack();
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToUpdateDiagnosisPanel() {
	    setAllPanelsVisibilityOff();
	    this.updateDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.updateDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToCreateDiagnosispanel() {
	    setAllPanelsVisibilityOff();
	    this.createDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.createDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromMedicalRecordForDoctorPanelToDeleteVerificationPanel() {
	    setAllPanelsVisibilityOff();
	    this.deleteVerificationPanel.setVisible(true);
	    this.getContentPane().add(this.deleteVerificationPanel);
	    this.pack();
	}

	@Override
	public void fromDeleteVerificationPanelToMedicalRecordForDoctorPanel() {
	    setAllPanelsVisibilityOff();
	    this.medicalRecordForDoctorPanel.setVisible(true);
	    this.getContentPane().add(this.medicalRecordForDoctorPanel);
	    this.pack();
	}

	@Override
	public void fromCreateDiagnosisPanelToMedicalRecordForDoctorPanel() {
	    setAllPanelsVisibilityOff();
	    this.medicalRecordForDoctorPanel.setVisible(true);
	    this.getContentPane().add(this.medicalRecordForDoctorPanel);
	    this.pack();
	}

	@Override
	public void fromCreateDiagnosisPanelToViewDiagnosisPanelForDoctor() {
	    setAllPanelsVisibilityOff();
	    TODO create viewDiagnosisPanelForDoctor
	    this.viewDiagnosisPanelForDoctor.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanelForDoctor);
	    this.pack();
	    
	}

	@Override
	public void fromModifyDiagnosisPanelToMedicalRecordForDoctorPanel() {
	    setAllPanelsVisibilityOff();
	    this.medicalRecordForDoctorPanel.setVisible(true);
	    this.getContentPane().add(this.medicalRecordForDoctorPanel);
	    this.pack();
	}

	@Override
	public void fromModifyDiagnosisPanelToViewDiagnosisPanelForDoctor() {
	    setAllPanelsVisibilityOff();
	    TODO Create viewDiagnosisPanelForDoctor
	    this.viewDiagnosisPanelForDoctor.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanelForDoctor);
	    this.pack();
	    
	}

	@Override
	public void fromViewDiagnosisPanelForDoctorToMedicalRecordForDoctorPanel() {
	    setAllPanelsVisibilityOff();
	    this.medicalRecordForDoctorPanel.setVisible(true);
	    this.getContentPane().add(this.medicalRecordForDoctorPanel);
	    this.pack();
	}

	@Override
	public void fromViewDiagnosisPanelForDoctorToModifyDiagnosisPanel() {
	    setAllPanelsVisibilityOff();
	    this.updateDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.updateDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromSearchDiseaseOptionPanelToGeneralDiseaseSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.generalDiseaseSearchPanel.setVisible(true);
	    this.getContentPane().add(this.generalDiseaseSearchPanel);
	    this.pack();
	}

	@Override
	public void fromSearchDiseaseOptionPanelToReasearcherDiseaseSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherDiseaseSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherDiseaseSearchPanel);
	    this.pack();
	}

	@Override
	public void fromSearchDiseaseOptionPanelToGeneralSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    TODO create generalSymptomSearchPanel
	    this.generalSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.generalSymptomSearchPanel);
	    this.pack();
	    
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToDeleteVerificationPanel() {
	    setAllPanelsVisibilityOff();
	    this.deleteVerificationPanel.setVisible(true);
	    this.getContentPane().add(this.deleteVerificationPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToCreateDiseasePanel() {
	    setAllPanelsVisibilityOff();
	    //this.createDiseasePanel.setVisible(true);
	    //this.getContentPane().add(this.createDiseasePanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToModifyDiseasePanel() {
	    setAllPanelsVisibilityOff();
	    //this.updateDiseasePanel.setVisible(true);
	    //this.getContentPane().add(this.updateDiseasePanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromReasearcherDiseaseSearchPanelToViewDiseasePanelForReasearcher() {
	    setAllPanelsVisibilityOff();
	    TODO create viewDiseasePanelForReasearcher
	    this.viewDiseasePanelForReasearcher.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanelForReasearcher);
	    this.pack();
	    
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToViewDiseasePanel() {
	    setAllPanelsVisibilityOff();
	    this.viewDiseasePanel.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanel);
	    this.pack();
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToHomePanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.homePanelDoctor.setVisible(true);
	    this.getContentPane().add(this.homePanelDoctor);
	    this.pack();
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToHomePanelPatient() {
	    setAllPanelsVisibilityOff();
	    this.homePanelPatient.setVisible(true);
	    this.getContentPane().add(this.homePanelPatient);
	    this.pack();
	}

	@Override
	public void fromDeleteVerificationPanelToSearchDiseaseOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchDiseaseOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchDiseaseOptionPanel);
	    this.pack();
	}

	@Override
	public void fromCreateDiseasePanelToSearchDiseaseOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchDiseaseOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchDiseaseOptionPanel);
	    this.pack();
	}

	@Override
	public void fromCreateDiseasePanelToViewDiseasePanelForReasearcher() {
	    setAllPanelsVisibilityOff();
	    TODO Create viewDiseasePanelForReasearcher
	    this.viewDiseasePanelForReasearcher.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanelForReasearcher);
	    this.pack();
	    
	}

	@Override
	public void fromModifyDiseasePanelToSearchDiseaseOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchDiseaseOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchDiseaseOptionPanel);
	    this.pack();
	}

	@Override
	public void fromModifyDiseasePanelToViewDiseasePanelForResearcher() {
	    setAllPanelsVisibilityOff();
	    TODO Create viewDiseasePanelForResearcher
	    this.viewDiseasePanelForResearcher.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanelForResearcher);
	    this.pack();
	    
	}

	@Override
	public void fromViewDiseasePanelForResearcherToReasearcherDiseaseSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherDiseaseSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherDiseaseSearchPanel);
	    this.pack();
	}

	@Override
	public void fromViewDiseasePanelForResearcherToModifyDiseasePanel() {
	    setAllPanelsVisibilityOff();
	    //this.updateDiseasePanel.setVisible(true);
	    //this.getContentPane().add(this.updateDiseasePanel);
	    this.pack();
	}

	@Override
	public void fromLogOutPanelToUpdateAcountPanel() {
	    setAllPanelsVisibilityOff();
	    this.updateAcountPanel.setVisible(true);
	    this.getContentPane().add(this.updateAcountPanel);
	    this.pack();
	}

	@Override
	public void fromLogOutPanelToLogInPanel() {
	    setAllPanelsVisibilityOff();
	    this.logInPanel.setVisible(true);
	    this.getContentPane().add(this.logInPanel);
	    this.pack();
	}

	@Override
	public void fromLogOutPanelToOUT() {
	    setAllPanelsVisibilityOff();
	    this.conMan.close();
	    this.dispose();
	}

	@Override
	public void fromLogOutPanelToHomePanelDoctor() {
	    setAllPanelsVisibilityOff();
	    this.homePanelDoctor.setVisible(true);
	    this.getContentPane().add(this.homePanelDoctor);
	    this.pack();
	}

	@Override
	public void fromLogOutPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromLogOutPanelToHomePanelPatient() {
	    setAllPanelsVisibilityOff();
	    this.homePanelPatient.setVisible(true);
	    this.getContentPane().add(this.homePanelPatient);
	    this.pack();
	}

	@Override
	public void fromUpdateAcountPanelToLogOutPanel() {
	    setAllPanelsVisibilityOff();
	    this.logOutPanel.setVisible(true);
	    this.getContentPane().add(this.logOutPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToDeleteVerificationPanel() {
	    setAllPanelsVisibilityOff();
	    this.deleteVerificationPanel.setVisible(true);
	    this.getContentPane().add(this.deleteVerificationPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToCreate_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.create_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.create_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToUpdate_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.update_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.update_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherTreatmentSearchPanelToReadReasearcher2_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher2_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher2_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromDeleteVerificationPanelToReasearcherTreatmentSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherTreatmentSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherTreatmentSearchPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToDeleteVerificationPanel() {
	    setAllPanelsVisibilityOff();
	    this.deleteVerificationPanel.setVisible(true);
	    this.getContentPane().add(this.deleteVerificationPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToCreate_SymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.create_SymptomPanel.setVisible(true);
	    this.getContentPane().add(this.create_SymptomPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToUpdateSymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.updateSymptomPanel.setVisible(true);
	    this.getContentPane().add(this.updateSymptomPanel);
	    this.pack();
	}

	@Override
	public void fromReasearcherSymptomSearchPanelToReadReasearcher2_SymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher2_SymptomPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher2_SymptomPanel);
	    this.pack();
	}

	@Override
	public void fromDeleteVerificationPanelToReasearcherSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherSymptomSearchPanel);
	    this.pack();
	}

	@Override
	public void fromUpdate_TreatmentPanelToReasearcherTreatmentSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherTreatmentSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherTreatmentSearchPanel);
	    this.pack();
	}

	@Override
	public void fromUpdate_TreatmentPanelToReadResearcher_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromCreate_TreatmentPanelToReasearcherTreatmentSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherTreatmentSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherTreatmentSearchPanel);
	    this.pack();
	}

	@Override
	public void fromCreate_TreatmentPanelToReadResearcher_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher_TreatmentPanelToUpdate_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.update_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.update_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher_TreatmentPanelToReasearcherTreatmentSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherTreatmentSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherTreatmentSearchPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToReasearcherTreatmentSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherTreatmentSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherTreatmentSearchPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToDeleteVerificationPanel() {
	    setAllPanelsVisibilityOff();
	    this.deleteVerificationPanel.setVisible(true);
	    this.getContentPane().add(this.deleteVerificationPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToUpdate_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.update_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.update_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiagnosisPanel() {
	    setAllPanelsVisibilityOff();
	    this.viewDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiagnosisPanelForDoctor() {
	    setAllPanelsVisibilityOff();
	    TODO create
	    this.viewDiagnosisPanelForDoctor.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanelForDoctor);
	    this.pack();
	    
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiseasePanel() {
	    setAllPanelsVisibilityOff();
	    this.viewDiseasePanel.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_TreatmentPanelToViewDiseasePanelForResearcher() {
	    setAllPanelsVisibilityOff();
	    TODO create viewDiseasePanelForResearcher
	    this.viewDiseasePanelForResearcher.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanelForResearcher);
	    this.pack();
	    
	}

	@Override
	public void fromDeleteVerificationPanelToReadReasearcher2_TreatmentPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher2_TreatmentPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher2_TreatmentPanel);
	    this.pack();
	}

	@Override
	public void fromUpdateSymptomPanelToReasearcherSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherSymptomSearchPanel);
	    this.pack();
	}

	@Override
	public void fromUpdateSymptomPanelToReadResearcher_SymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher_SymptomPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher_SymptomPanel);
	    this.pack();
	}

	@Override
	public void fromCreate_SymptomPanelToReasearcherSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherSymptomSearchPanel);
	    this.pack();
	}

	@Override
	public void fromCreate_SymptomPanelToReadResearcher_SymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher_SymptomPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher_SymptomPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher_SymptomPanelToUpdateSymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.updateSymptomPanel.setVisible(true);
	    this.getContentPane().add(this.updateSymptomPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher_SymptomPanelToReasearcherSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherSymptomSearchPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToReasearcherSymptomSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.researcherSymptomSearchPanel.setVisible(true);
	    this.getContentPane().add(this.researcherSymptomSearchPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToDeleteVerificationPanel() {
	    setAllPanelsVisibilityOff();
	    this.deleteVerificationPanel.setVisible(true);
	    this.getContentPane().add(this.deleteVerificationPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToUpdateSymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.updateSymptomPanel.setVisible(true);
	    this.getContentPane().add(this.updateSymptomPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiagnosisPanel() {
	    setAllPanelsVisibilityOff();
	    this.viewDiagnosisPanel.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiagnosisPanelForDoctor() {
		TODO
	    setAllPanelsVisibilityOff();
	    this.viewDiagnosisPanelForDoctor.setVisible(true);
	    this.getContentPane().add(this.viewDiagnosisPanelForDoctor);
	    this.pack();
	    
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiseasePanel() {
	    setAllPanelsVisibilityOff();
	    this.viewDiseasePanel.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanel);
	    this.pack();
	}

	@Override
	public void fromReadReasearcher2_SymptomPanelToViewDiseasePanelForResearcher() {
		TODO create viewDiseasePanelForResearcher
	    setAllPanelsVisibilityOff();
	    this.viewDiseasePanelForResearcher.setVisible(true);
	    this.getContentPane().add(this.viewDiseasePanelForResearcher);
	    this.pack();
	    
	}

	@Override
	public void fromDeleteVerificationPanelToReadReasearcher2_SymptomPanel() {
	    setAllPanelsVisibilityOff();
	    this.readResearcher2_SymptomPanel.setVisible(true);
	    this.getContentPane().add(this.readResearcher2_SymptomPanel);
	    this.pack();
	}

	@Override
	public void fromCreateSearchSimulationOptionPanelToSearchOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchOptionPanel);
	    this.pack();
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToSearchPopulationFromDiseaseSimulationPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchPopulationFromDiseaseSimulationPanel.setVisible(true);
	    this.getContentPane().add(this.searchPopulationFromDiseaseSimulationPanel);
	    this.pack();
	}

	@Override
	public void fromGeneralDiseaseSearchPanelToCreateSimulationPanel() {
	    setAllPanelsVisibilityOff();
	    this.createSimulationPanel.setVisible(true);
	    this.getContentPane().add(this.createSimulationPanel);
	    this.pack();
	}

	@Override
	public void fromSearchPopulationFromDiseaseSimulationPanelToSearchSimulationByPopulation() {
	    setAllPanelsVisibilityOff();
	    this.searchSimulationByPopulation.setVisible(true);
	    this.getContentPane().add(this.searchSimulationByPopulation);
	    this.pack();
	}

	@Override
	public void fromSearchPopulationFromDiseaseSimulationPanelToGeneralDiseaseSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.generalDiseaseSearchPanel.setVisible(true);
	    this.getContentPane().add(this.generalDiseaseSearchPanel);
	    this.pack();
	}

	@Override
	public void fromSearchSimulationByPopulationToViewSimulationResultFromSearchPanel() {
	    setAllPanelsVisibilityOff();
	    this.viewSimulationResultFromSearchPanel.setVisible(true);
	    this.getContentPane().add(this.viewSimulationResultFromSearchPanel);
	    this.pack();
	}

	@Override
	public void fromSearchSimulationByPopulationToSearchPopulationFromDiseaseSimulationPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchPopulationFromDiseaseSimulationPanel.setVisible(true);
	    this.getContentPane().add(this.searchPopulationFromDiseaseSimulationPanel);
	    this.pack();
	}

	@Override
	public void fromViewSimulationResultFromSearchPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromViewSimulationResultFromSearchPanelToSearchSimulationByPopulation() {
	    setAllPanelsVisibilityOff();
	    this.searchSimulationByPopulation.setVisible(true);
	    this.getContentPane().add(this.searchSimulationByPopulation);
	    this.pack();
	}

	@Override
	public void fromCreateSimulationPanelToSearchOptionPanel() {
	    setAllPanelsVisibilityOff();
	    this.searchOptionPanel.setVisible(true);
	    this.getContentPane().add(this.searchOptionPanel);
	    this.pack();
	}

	@Override
	public void fromCreateSimulationPanelToViewSimulationResultPanel() {
	    setAllPanelsVisibilityOff();
	    this.viewSimulationResultPanel.setVisible(true);
	    this.getContentPane().add(this.viewSimulationResultPanel);
	    this.pack();
	}

	@Override
	public void fromViewSimulationResultPanelToHomePanelResearcher() {
	    setAllPanelsVisibilityOff();
	    this.homePanelResearcher.setVisible(true);
	    this.getContentPane().add(this.homePanelResearcher);
	    this.pack();
	}

	@Override
	public void fromViewDiseasePanelToGeneralDiseaseSearchPanel() {
		setAllPanelsVisibilityOff();
	    this.generalDiseaseSearchPanel.setVisible(true);
	    this.getContentPane().add(this.generalDiseaseSearchPanel);
	    this.pack();
		
	}
*/
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user=user;
	}
	

}


