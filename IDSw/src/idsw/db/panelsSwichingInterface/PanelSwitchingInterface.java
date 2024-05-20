package idsw.db.panelsSwichingInterface;

import idsw.db.graphicInterface.CreateSearchSimulationOptionPanel;
import idsw.db.graphicInterface.ResearcherTreatmentSearchPanel;

public interface PanelSwitchingInterface {
	public void fromLogInPanelToChooseUserSignInPanel();
	public void fromLogInPanelToHomePanelDoctor();
	public void fromLogInPanelToHomePanelResearcher();
	public void fromLogInPanelToHomePanelPatient();
	
	public void fromChooseUserSignInPanelToLogInPanel();
	public void fromChooseUserSignInToSingInPanelDoctor();
	public void fromChooseUserSignInToSingInPanelPatient();
	public void fromChooseUserSignInToSingInPanelResearcher();
	
	public void fromSingInPanelDoctorToChooseUserSignInPanel();
	public void fromSingInPanelDoctorToHomePanelDoctor();
	
	public void fromSingInPanelReasearcherToChooseUserSignInPanel();
	public void fromSingInPanelResearcherToHomePanelResearcher();
	
	public void fromSingInPanelPatientToChooseUserSignInPanel();
	public void fromSingInPanelPatientToHomePanelPatient();
	
	public void fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(Integer id_treatment);
	public void fromHomePanelDoctorToSearchPatientPanel();
	public void fromHomePanelDoctorToSearchDiseaseOptionPanel();
	public void fromHomePanelDoctorToLogOutPanel();
	
	
	public void fromHomePanelPatientToViewDiagnosisPanel(Integer id_dignosis);
	public void fromHomePanelPatientToMedicalRecordPanel();
	public void fromHomePanelPatientToSearchDiseaseOptionPanel();
	public void fromHomePanelPatientToLogOutPanel();
	
	public void fromHomePanelResearcherToViewSimulationResultPanel(Integer id_simulation);
	public void fromHomePanelResearcherToCreateSearchSimulationOptionPanel();
	public void fromHomePanelResearcherToResearcherTreatmentSearchPanel();
	public void fromHomePanelResearcherToResearcherSymptomSearchPanel();
	public void fromHomePanelResearcherToSearchDiseaseOptionPanel();
	public void fromHomePanelResearcherToLogOutPanel();
	
	public void fromSearchPatientPanelToMedicalRecordForDoctorPanel(Integer id_patient);
	public void fromSearchPatientPanelToHomePanelDoctor();
	
	public void fromMedicalRecordPanelToViewDiagnosisPanel();
	public void fromMedicalRecordPanelToHomePanelPatient();
	
	public void fromMedicalRecordForDoctorPanelToViewDiagnosisPanelForDoctor();
	public void fromMedicalRecordForDoctorPanelToHomePanelDoctor();
	public void fromMedicalRecordForDoctorPanelToUpdateDiagnosisPanel();
	public void fromMedicalRecordForDoctorPanelToCreateDiagnosispanel();
	public void fromMedicalRecordForDoctorPanelToDeleteVerificationPanel();
	
	public void fromDeleteVerificationPanelToMedicalRecordForDoctorPanel();
	
	public void fromCreateDiagnosisPanelToMedicalRecordForDoctorPanel();
	public void fromCreateDiagnosisPanelToViewDiagnosisPanelForDoctor();
	
	public void fromModifyDiagnosisPanelToMedicalRecordForDoctorPanel();
	public void fromModifyDiagnosisPanelToViewDiagnosisPanelForDoctor();
	
	public void fromViewDiagnosisPanelForDoctorToMedicalRecordForDoctorPanel();
	public void fromViewDiagnosisPanelForDoctorToModifyDiagnosisPanel();
	
	public void fromSearchDiseaseOptionPanelToGeneralDiseaseSearchPanel();
	public void fromSearchDiseaseOptionPanelToReasearcherDiseaseSearchPanel();
	public void fromSearchDiseaseOptionPanelToGeneralSymptomSearchPanel();
	
	public void fromReasearcherDiseaseSearchPanelToDeleteVerificationPanel();
	public void fromReasearcherDiseaseSearchPanelToCreateDiseasePanel();
	public void fromReasearcherDiseaseSearchPanelToModifyDiseasePanel();
	public void fromReasearcherDiseaseSearchPanelToHomePanelResearcher();
	public void fromReasearcherDiseaseSearchPanelToViewDiseasePanelForReasearcher();
	
	public void fromGeneralDiseaseSearchPanelToViewDiseasePanel();
	public void fromGeneralDiseaseSearchPanelToHomePanelDoctor();
	public void fromGeneralDiseaseSearchPanelToHomePanelPatient();
	
	public void fromViewDiseasePanelToGeneralDiseaseSearchPanel();
	
	public void fromDeleteVerificationPanelToSearchDiseaseOptionPanel();
	
	public void fromCreateDiseasePanelToSearchDiseaseOptionPanel();
	public void fromCreateDiseasePanelToViewDiseasePanelForReasearcher();
	
	public void fromModifyDiseasePanelToSearchDiseaseOptionPanel();
	public void fromModifyDiseasePanelToViewDiseasePanelForResearcher();
	
	public void fromViewDiseasePanelForResearcherToReasearcherDiseaseSearchPanel();
	public void fromViewDiseasePanelForResearcherToModifyDiseasePanel();
	
	public void fromLogOutPanelToUpdateAcountPanel();
	public void fromLogOutPanelToLogInPanel();
	public void fromLogOutPanelToOUT();
	public void fromLogOutPanelToHomePanelDoctor();
	public void fromLogOutPanelToHomePanelResearcher();
	public void fromLogOutPanelToHomePanelPatient();
	
	public void fromUpdateAcountPanelToLogOutPanel();
	
	public void  fromReasearcherTreatmentSearchPanelToHomePanelResearcher();
	public void  fromReasearcherTreatmentSearchPanelToDeleteVerificationPanel();
	public void  fromReasearcherTreatmentSearchPanelToCreate_TreatmentPanel();
	public void  fromReasearcherTreatmentSearchPanelToUpdate_TreatmentPanel();
	public void  fromReasearcherTreatmentSearchPanelToReadReasearcher2_TreatmentPanel();

	
	
	public void fromDeleteVerificationPanelToReasearcherTreatmentSearchPanel();
	
	public void fromReasearcherSymptomSearchPanelToHomePanelResearcher();
	public void fromReasearcherSymptomSearchPanelToDeleteVerificationPanel();
	public void fromReasearcherSymptomSearchPanelToCreate_SymptomPanel();
	public void fromReasearcherSymptomSearchPanelToUpdateSymptomPanel();
	public void fromReasearcherSymptomSearchPanelToReadReasearcher2_SymptomPanel();


	public void fromDeleteVerificationPanelToReasearcherSymptomSearchPanel();

	public void fromUpdate_TreatmentPanelToReasearcherTreatmentSearchPanel();
	public void fromUpdate_TreatmentPanelToReadResearcher_TreatmentPanel();
	
	public void fromCreate_TreatmentPanelToReasearcherTreatmentSearchPanel();
	public void fromCreate_TreatmentPanelToReadResearcher_TreatmentPanel();
	
	public void fromReadReasearcher_TreatmentPanelToUpdate_TreatmentPanel();
	public void fromReadReasearcher_TreatmentPanelToReasearcherTreatmentSearchPanel();
	
	public void fromReadReasearcher2_TreatmentPanelToReasearcherTreatmentSearchPanel();
	public void fromReadReasearcher2_TreatmentPanelToDeleteVerificationPanel();
	public void fromReadReasearcher2_TreatmentPanelToUpdate_TreatmentPanel();
	public void fromReadReasearcher2_TreatmentPanelToViewDiagnosisPanel();
	public void fromReadReasearcher2_TreatmentPanelToViewDiagnosisPanelForDoctor();
	public void fromReadReasearcher2_TreatmentPanelToViewDiseasePanel();
	public void fromReadReasearcher2_TreatmentPanelToViewDiseasePanelForResearcher();

	public void fromDeleteVerificationPanelToReadReasearcher2_TreatmentPanel();
	
	public void fromUpdateSymptomPanelToReasearcherSymptomSearchPanel();
	public void fromUpdateSymptomPanelToReadResearcher_SymptomPanel();

	public void fromCreate_SymptomPanelToReasearcherSymptomSearchPanel();
	public void fromCreate_SymptomPanelToReadResearcher_SymptomPanel();

	public void fromReadReasearcher_SymptomPanelToUpdateSymptomPanel();
	public void fromReadReasearcher_SymptomPanelToReasearcherSymptomSearchPanel();

	public void fromReadReasearcher2_SymptomPanelToReasearcherSymptomSearchPanel();
	public void fromReadReasearcher2_SymptomPanelToDeleteVerificationPanel();
	public void fromReadReasearcher2_SymptomPanelToUpdateSymptomPanel();
	public void fromReadReasearcher2_SymptomPanelToViewDiagnosisPanel();
	public void fromReadReasearcher2_SymptomPanelToViewDiagnosisPanelForDoctor();
	public void fromReadReasearcher2_SymptomPanelToViewDiseasePanel();
	public void fromReadReasearcher2_SymptomPanelToViewDiseasePanelForResearcher();

	public void fromDeleteVerificationPanelToReadReasearcher2_SymptomPanel();
	
	public void fromCreateSearchSimulationOptionPanelToSearchOptionPanel();
	
	public void fromGeneralDiseaseSearchPanelToSearchPopulationFromDiseaseSimulationPanel();
	public void fromGeneralDiseaseSearchPanelToCreateSimulationPanel();

	public void fromSearchPopulationFromDiseaseSimulationPanelToSearchSimulationByPopulation();
	public void fromSearchPopulationFromDiseaseSimulationPanelToGeneralDiseaseSearchPanel();
	
	public void fromSearchSimulationByPopulationToViewSimulationResultFromSearchPanel();
	public void fromSearchSimulationByPopulationToSearchPopulationFromDiseaseSimulationPanel();
	
	public void fromViewSimulationResultFromSearchPanelToHomePanelResearcher();
	public void fromViewSimulationResultFromSearchPanelToSearchSimulationByPopulation();
	
	public void fromCreateSimulationPanelToSearchOptionPanel();
	public void fromCreateSimulationPanelToViewSimulationResultPanel();
	
	public void fromViewSimulationResultPanelToHomePanelResearcher();


	

	
	
	
}
