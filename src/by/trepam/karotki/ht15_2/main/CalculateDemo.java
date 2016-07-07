package by.trepam.karotki.ht15_2.main;

import java.io.IOException;

import by.trepam.karotki.ht15_2.CalculatePerformer;

public class CalculateDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		CalculatePerformer cp = new CalculatePerformer();
		cp.calculate();
		cp.saveResult();
	}

}
