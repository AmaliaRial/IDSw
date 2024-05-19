package idsw.db.graphicInterface;
import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import idsw.db.pojos.Disease;
import idsw.db.pojos.Treatment;
import idsw.db.pojos.Virtual_Population;

public class SearchPopulationFromDiseaseSimulationPanel extends SearchSimulationTemplate {
	
	public SearchPopulationFromDiseaseSimulationPanel(Integer id_disease) {
		
		super();
		Disease disease= super.conMan.getDiseaseMan().getDisease(id_disease);
		super.titleLabel.setText("<html><b>Populations of "+disease.getNameDisease()+" Simulation</b></html>");
		List<Virtual_Population> vPopulations= super.conMan.getVirtualPopulationMan().listMatchingV_PopulationByDiseasease(id_disease);
		DefaultListModel<String> listModel = ListNameofV_Population(vPopulations);
		JList<String> lista = new JList<>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		super.list= new JScrollPane(lista);
		super.list.setPreferredSize(new Dimension(400, 200));
		super.midlePanel.add(super.list);
	}
	
	private DefaultListModel<String> ListNameofV_Population(List<Virtual_Population> vPopulations){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Virtual_Population vPopulation:vPopulations) {
			listModel.addElement("Disease: "+vPopulation.getDisease().getNameDisease()+" /Initial population: "
		+vPopulation.getInitial_population()+" /Immunity Period: "+vPopulation.getImmunity_period()
		+" /Healthy Percentage: "+vPopulation.getP_healthy()+" /Immune Percentage: "+vPopulation.getP_immune()
		+" /Ill Percentage: "+vPopulation.getP_infected());
		}
		return listModel;
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SearchPopulationFromDiseaseSimulationPanel(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
