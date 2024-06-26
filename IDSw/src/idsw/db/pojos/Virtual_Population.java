package idsw.db.pojos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import idsw.db.jdbc.*;
import idsw.db.utilities.GraphUtilities;

public class Virtual_Population implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = 5867685344047960434L;
		private Integer idVirtual_population;
		private Integer initial_population; 
		private Float p_infected;
		private Float p_healthy;
		private Float p_immune;
		private Integer immunity_period; //From disease
		private Disease disease;
		private List<Virtual_Person> virtual_people;
		
		public Virtual_Population(Integer idVirtual_population2, Integer initial_population2, Float p_infected2, Float p_healthy2, Float p_immune2, Integer immunity_period2, Disease disease2) {
			this.idVirtual_population=idVirtual_population2;
			this.initial_population=initial_population2;
			this.p_infected= p_infected2;
			this.p_healthy=  p_healthy2;
			this.p_immune= p_immune2;
			this.immunity_period= immunity_period2;
			this.disease =disease2;
			
			this.virtual_people = new ArrayList<Virtual_Person>();
		}
		
		public Virtual_Population(Integer initial_population2, Float p_infected2, Float p_healthy2, Float p_immune2, Integer immunity_period2, Disease disease2) {
			this.initial_population=initial_population2;
			this.p_infected= p_infected2;
			this.p_healthy=  p_healthy2;
			this.p_immune= p_immune2;
			this.immunity_period= immunity_period2;
			this.disease =disease2;
			
			this.virtual_people = new ArrayList<Virtual_Person>();
		}
		
		public Virtual_Population() {
			//TODO HACE FALTA PONER TOdO COMO NULL?
		}

		public Integer getIdVirtual_population() {
			return idVirtual_population;
		}

		public void setIdVirtual_population(Integer idVirtual_population) {
			this.idVirtual_population = idVirtual_population;
		}

		public Integer getInitial_population() {
			return initial_population;
		}

		public void setInitial_population(Integer initial_population) {
			this.initial_population = initial_population;
		}

		public Float getP_infected() {
			return p_infected;
		}

		public void setP_infected(Float p_infected) {
			this.p_infected = p_infected;
		}

		public Float getP_healthy() {
			return p_healthy;
		}

		public void setP_healthy(Float p_healthy) {
			this.p_healthy = p_healthy;
		}

		public Float getP_immune() {
			return p_immune;
		}

		public void setP_immune(Float p_immune) {
			this.p_immune = p_immune;
		}

		public Integer getImmunity_period() {
			return immunity_period;
		}

		public void setImmunity_period(Integer immunity_period) {
			this.immunity_period = immunity_period;
		}

		public Disease getDisease() {
			return disease;
		}

		public void setDisease(Disease disease) {
			this.disease = disease;
		}

		public List<Virtual_Person> getVirtual_people() {
			return virtual_people;
		}

		public void setVirtual_people(List<Virtual_Person> virtual_people) {
			this.virtual_people = virtual_people;
		}
		
		

		@Override
		public int hashCode() {
			return Objects.hash(idVirtual_population);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Virtual_Population other = (Virtual_Population) obj;
			return Objects.equals(idVirtual_population, other.idVirtual_population);
		}

		@Override
		public String toString() {
			return "Virtual_Population [Id="+idVirtual_population+" Initial_population=" + initial_population + ", % of infected=" + p_infected
					+ ", % of healthy=" + p_healthy + ", % of immune=" + p_immune + ", immunity_period=" + immunity_period
					+ ", virtual_people=" + virtual_people+"]";
		}
		
		public static void main(String args[]) {
			Disease disease= new Disease();
			disease.setIncubation_period((float) 5);
			disease.setDevelopment_period((float) 10);
			disease.setConvalescence_period((float) 14);
			disease.setNameDisease("COVID_19");
			disease.setMortality_rate((float) 1.5);
			disease.setInfectious_rate((float)2.5);
			ConnectionManager conMan= new ConnectionManager();
			Virtual_Population populationTest= new Virtual_Population(10000,(float) 5,(float) 90,(float) 5, 24, disease);
			conMan.getVirtualPopulationMan().fillPopulation(populationTest);
			System.out.println(populationTest);
			Simulation simulationTest=conMan.getSimulationMan().createSimulation(populationTest);
			System.out.println(simulationTest);
			
			GraphUtilities utilGraph= new GraphUtilities();
			BufferedImage chartSimulationImage= utilGraph.binaryIntoImage(simulationTest.getSimulationGraph());
			
			showImage(chartSimulationImage);
		}
		
		public static void showImage(BufferedImage image) {
	        // Crear una ventana Swing
	        JFrame frame = new JFrame("Imagen");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Crear un panel para mostrar la imagen
	        JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                // Dibujar la imagen en el panel
	                g.drawImage(image, 0, 0, null);
	            }

	            @Override
	            public Dimension getPreferredSize() {
	                // Establecer el tamaño del panel según el tamaño de la imagen
	                return new Dimension(image.getWidth(), image.getHeight());
	            }
	        };

	        // Añadir el panel a la ventana
	        frame.getContentPane().add(panel);

	        // Ajustar el tamaño de la ventana automáticamente
	        frame.pack();

	        // Mostrar la ventana
	        frame.setVisible(true);
	    }
		
}
