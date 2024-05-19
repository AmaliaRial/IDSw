package idsw.db.graphicInterface;

import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import idsw.db.pojos.Simulation;
import idsw.db.pojos.Virtual_Population;

public class SearchSimulationByPopulation extends SearchSimulationTemplate  {
	public SearchSimulationByPopulation(Integer Id_virtualPopulation) {
		super();
		super.titleLabel.setText("<html><b>Simulations from Population Selected</b></html>");
		List<Simulation> simulations= super.conMan.getSimulationMan().listMatchingSimulationByV_Population(Id_virtualPopulation);
		DefaultListModel<String> listModel = ListNameofV_Population(simulations);
		JList<String> lista = new JList<>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		super.list= new JScrollPane(lista);
		super.list.setPreferredSize(new Dimension(400, 200));
		super.midlePanel.add(super.list);
	}
	
	private DefaultListModel<String> ListNameofV_Population(List<Simulation> simulations){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Simulation simulation:simulations) {
			listModel.addElement("Total Population: "+simulation.getTotalPopulation()+"/ Total Infections: "
		+simulation.getTotalInfections()+"/Total Deaths: "+simulation.getTotalDeaths()+"/Total Immunity: "
		+simulation.getTotalImmunity());
		}
		return listModel;
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SearchSimulationByPopulation(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
