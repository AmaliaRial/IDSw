package idsw.db.utilities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;

import idsw.db.pojos.Disease;
import idsw.db.utilitiesManager.StatisticsManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphUtilities implements StatisticsManager{
	
	public GraphUtilities() {
		
	}

	@Override
	public BufferedImage graphIntoImage(JFreeChart graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] imageIntoBinary(BufferedImage image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] graphIntoBinary(JFreeChart chart) {
		 // Crear un BufferedImage para almacenar la imagen del gráfico
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        
        // Renderizar el gráfico en el BufferedImage
        Graphics2D g2 = image.createGraphics();
        chart.draw(g2, new Rectangle(800, 600));
        g2.dispose();

        // Convertir la imagen a bytes en formato PNG
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error in image conversion");
        }

        return baos.toByteArray();
	}

	@Override
	public JFreeChart graphSimulation(List<Integer> illCounterData, List<Integer> deathCounterData,
			List<Integer> peopleCounterData) {
		XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries illSeries = new XYSeries("Ill Counter");
        XYSeries deathSeries = new XYSeries("Death Counter");
        XYSeries peopleSeries = new XYSeries("People Counter");

        // Add data to series
        for (int i = 0; i < illCounterData.size(); i++) {
            illSeries.add(i, illCounterData.get(i));
            deathSeries.add(i, deathCounterData.get(i));
            peopleSeries.add(i, peopleCounterData.get(i));
        }

        // Add series to dataset
        dataset.addSeries(illSeries);
        dataset.addSeries(deathSeries);
        dataset.addSeries(peopleSeries);

        JFreeChart chart = ChartFactory.createXYLineChart("Development of the Disease","Days",
        		"People",dataset,PlotOrientation.VERTICAL,true,false,false);

        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        renderer.setSeriesPaint(0, Color.GREEN); // Ill Counter - verde
        renderer.setSeriesPaint(1, Color.MAGENTA);   // Death Counter - morado
        renderer.setSeriesPaint(2, Color.ORANGE);  // People Counter - Naranja

        plot.setRenderer(renderer);
  
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setBackgroundPaint(Color.white);

        return chart;

	}

	@Override
	public BufferedImage binaryIntoImage(byte[] blob) {
		BufferedImage image = null;
        try {
            // Leer la imagen desde el arreglo de bytes
            ByteArrayInputStream bis = new ByteArrayInputStream(blob);
            image = ImageIO.read(bis);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer la imagen desde el arreglo de bytes");
        }
        return image;
	}

	@Override
	public JFreeChart graphDiseaseDevelopment(Disease disease) {
		XYSeries development = new XYSeries("Development");
		XYSeriesCollection dataset = new XYSeriesCollection();
		int incubationPeriod=disease.getIncubation_period().intValue();
		int developmentPeriod=disease.getDevelopment_period().intValue();
		int covalescencePeriod=disease.getConvalescence_period().intValue();
		int diseasePeriod= incubationPeriod+developmentPeriod+covalescencePeriod;
		
		for(int i=0;i<diseasePeriod; i++) {
			if(i==0) {
				development.add(i,0);
			}else if(i==(Math.round(diseasePeriod/2))) {
				development.add(i,2);
			}else if(i==(incubationPeriod+Math.round(developmentPeriod/2))){
				development.add(i,3);
			}else if(i==(incubationPeriod+developmentPeriod+Math.round(diseasePeriod/2))){
				development.add(i,1);
			}else if(i==diseasePeriod-1) {
				development.add(i+1,0);
			}	
		}

		dataset.addSeries(development);
		
		JFreeChart chart = ChartFactory.createXYLineChart("Development of "+disease.getNameDisease(),"Days",
	        		"feeling of sickness",dataset,PlotOrientation.VERTICAL,false,false,false);
		
		chart.getXYPlot().setRenderer(new XYSplineRenderer());
		
		ValueAxis yAxis = chart.getXYPlot().getRangeAxis();
        yAxis.setRange(0, 4);
		
		XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setBackgroundPaint(Color.white);
	
		return chart;
	}
	

}
