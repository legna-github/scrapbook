package misc;

public class PingPong implements Runnable {

	private final Ball ball;
	private final String name;

	public PingPong(String name, Ball ball) {
		super();
		this.ball = ball;
		this.name = name;
	}

	@Override
	public void run() {
		boolean keepgoing = true;
		while(keepgoing) {
			synchronized (ball) {
				keepgoing = ball.hit();
			}
		}
		System.out.println(name + " Won!!!!");
	}

}
