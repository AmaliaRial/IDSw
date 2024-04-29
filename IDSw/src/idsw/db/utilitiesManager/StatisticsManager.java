package idsw.db.utilitiesManager;
import java.util.List;

import org.jfree.chart.JFreeChart;
import java.awt.image.BufferedImage;

public interface StatisticsManager {
	public JFreeChart sraphicSimulation(List<Integer> illCounterData, List<Integer> deathCounterData, List<Integer> peopleCounterData);
	public BufferedImage graphIntoImage(JFreeChart graph);
	public byte[] imageIntoBinary(BufferedImage image);
	public byte[]  graphIntoBinary(JFreeChart graph);
}