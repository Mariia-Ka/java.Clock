import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;


public class Clock {
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		addAFiller(pane, 5, 5);
		addALabel("Часы", pane);
		addAFiller(pane, 5, 10);
		JLabel labelTime = addALabel("", pane);
		ClockJob.startTime(labelTime);
		addAFiller(pane, 5, 100);
		JLabel labelDate = addALabel("", pane);
		ClockJob.startDate(labelDate);
		
	}
	
	private static JLabel addALabel (String text, Container cont) {
		JLabel label = new JLabel(text);
		label.setBounds(20,20,100,20);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		cont.add(label);
		return label;
	}
	private static void addAFiller (Container cont, int min, int max) {
		Dimension minSize = new Dimension(min, max);
		Dimension prefSize = new Dimension(min, max);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, max);
		cont.add(new Box.Filler(minSize, prefSize, maxSize));
	}
	
	public static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Часы");
//		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(350, 500));
		frame.setMinimumSize(new Dimension (350,500));
		frame.setMaximumSize(new Dimension (500, 500));
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

//	private static final long serialVersionUID = 1L;
		
}
