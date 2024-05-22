package idsw.db.graphicInterface.components;

import javax.swing.*;
import java.sql.Date;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateInputPanel extends JPanel {
    private JComboBox<Integer> dayComboBox;
    private JComboBox<Integer> monthComboBox;
    private JComboBox<Integer> yearComboBox;

    public DateInputPanel() {
        // Configuración del formato de fecha
        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) {
            days[i] = i+1;
        }

        Integer[] months = new Integer[12];
        for (int i = 0; i < 12; i++) {
            months[i] = i+1;
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer[] years = new Integer[100];
        for (int i = 0; i < 100; i++) {
            years[i] = currentYear - i;
        }

        dayComboBox = new JComboBox<>(days);
        monthComboBox = new JComboBox<>(months);
        yearComboBox = new JComboBox<>(years);

        // Diseñ
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);
        add(new CustomJLabel("Day:", 15, Color.BLACK, Color.WHITE));
        add(dayComboBox);
        add(new CustomJLabel("Month:", 15, Color.BLACK, Color.WHITE));
        add(monthComboBox);
        add(new CustomJLabel("Year:", 15, Color.BLACK, Color.WHITE));
        add(yearComboBox);
    }

    // Método para obtener la fecha seleccionada como un objeto Date
    public Date getDate() throws ParseException {
    	Integer selectedDay = (Integer) dayComboBox.getSelectedItem();
        Integer selectedMonth = (Integer) monthComboBox.getSelectedItem();
        Integer  selectedYear = (Integer) yearComboBox.getSelectedItem();

        String dateString = selectedYear + "-" + selectedMonth + "-" +selectedDay;

        return  Date.valueOf(dateString);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Input Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DateInputPanel dateInputPanel = new DateInputPanel();
        frame.add(dateInputPanel);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            try {
                Date selectedDate = dateInputPanel.getDate();
                JOptionPane.showMessageDialog(frame, "Selected Date: " + selectedDate);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        });
        frame.add(submitButton, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
        
    }
}
