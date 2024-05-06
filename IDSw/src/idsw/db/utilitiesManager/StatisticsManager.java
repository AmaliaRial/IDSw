package idsw.db.utilitiesManager;
import java.util.List;

import org.jfree.chart.JFreeChart;

import idsw.db.pojos.Disease;

import java.awt.image.BufferedImage;

public interface StatisticsManager {
	public JFreeChart graphSimulation(List<Integer> illCounterData, List<Integer> deathCounterData, List<Integer> peopleCounterData);
	public BufferedImage graphIntoImage(JFreeChart graph);
	public byte[] imageIntoBinary(BufferedImage image);
	public byte[]  graphIntoBinary(JFreeChart graph);
	public BufferedImage binaryIntoImage(byte[] bits);
	public JFreeChart graphDiseaseDevelopment(Disease disease);
}