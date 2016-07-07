package by.trepam.karotki.ht15_2;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class CalculatePerformer {
	private final static String DIR = "src";
	private final static String IN_MASK = "in";
	private final static String OUTPUT="out.dat";
	private double result;

	public void calculate() throws InterruptedException {
		File fileInDir = new File(DIR);
		String[] files = fileInDir.list(new FilenameFilter() {

			public boolean accept(File fileInDir, String name) {

				return name.startsWith(IN_MASK);
			}

		});

		Thread[] threads = new Thread[files.length];

		for (int i = 0; i < files.length; i++) {
			threads[i] = new Thread(new CalcThread(DIR + "\\" + files[i],this));
			threads[i].start();
		}
		try {
			for (int i = 0; i < files.length; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			throw new InterruptedException("Thread was interrupted");
		}
		
	}
	
	public synchronized void append(double value){
		result+=value;
	}
	
	public void saveResult(){
		FileWriter fw = null;
		try {
			fw = new FileWriter(DIR+"\\"+OUTPUT);
			fw.append(String.valueOf(result));
			fw.flush();
		} catch (IOException e) {
			//exception
		}
		finally{
			try{
				fw.close();
			}catch(IOException e){
				//exception
			}
		}
		
	}
}
