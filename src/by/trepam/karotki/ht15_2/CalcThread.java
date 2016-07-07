package by.trepam.karotki.ht15_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalcThread implements Runnable {
	private String fileName;
	private CalculatePerformer cp;

	public CalcThread(String path, CalculatePerformer cp) {
		fileName = path;
		this.cp = cp;
	}

	@Override
	public void run() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// exception
		}

		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		int action = Integer.valueOf(s1);
		String[] secLine = s2.split(" ");
		double[] value = new double[secLine.length];
		for (int i = 0; i < secLine.length; i++) {
			value[i] = Double.valueOf(secLine[i]);
		}

		double result = 0;
		switch (action) {
		case 1:
			for (double i : value) {
				result += i;
			}
			break;
		case 2:
			result = 1;
			for (double i : value) {
				result *= i;
			}
			break;
		case 3:
			for (double i : value) {
				result += Math.pow(i, 2);
			}
		}

		cp.append(result);

	}

}
