import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JLabel;

public class ClockJob {
	static String strTime;
	
	public static String getTime() {
		return strTime;
	}
	
	public static void startTime(JLabel label) { 
		Thread clock1 = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				while (true) {
					LocalTime timeNow = LocalTime.now();
					int hour = timeNow.getHour();
			        int minute = timeNow.getMinute();
			        int second = timeNow.getSecond();
			        label.setText(String.format("%s:%s:%s", hour, minute, second));
			        strTime = String.format("%s:%s:%s", hour, minute, second);
			        
//			        time.setText(second + " секунд");
//			        time.setText("" + i);
//			        i++;
//			        System.out.println("поток работает");
			        Thread.sleep(1000);
				}
			} catch (InterruptedException e) {				
			}			
		}		
	});
	clock1.start();
    }
	
	public static void startDate(JLabel label) {
		Thread clock2 = new Thread (new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						LocalDate dateToday = LocalDate.now();
						int year = dateToday.getYear();
						String month = dateToday.getMonth().toString();
						int dayOfMonth = dateToday.getDayOfMonth();
						label.setText
						(String.format("%s год, месяц %s, %s число", year, month, dayOfMonth));
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		});
		clock2.start();
	}
}
	
