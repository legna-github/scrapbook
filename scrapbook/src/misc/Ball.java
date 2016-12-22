package misc;

import java.util.Random;

public class Ball {

	private int hits; 
	public Ball() {
		this.hits = new Random().nextInt(15);
	}
	
	public boolean hit() {

		this.notify();
		try {
			this.wait();
		} catch (InterruptedException e) {
			Thread.interrupted();
		}

		System.out.println(Thread.currentThread().getName());
		return --hits > 0;
	}

}
