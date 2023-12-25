package graphics;

public class ChopstickAnimatorCommand implements Runnable {
	ChopstickAnimator animatorFinal;
	int xFinal;
	int yFinal;
	RotatingLineInterface chopstickFinal;
	
	public ChopstickAnimatorCommand(ChopstickAnimator chopstickAnimator, RotatingLineInterface cstick, int x, int y) {
		animatorFinal = chopstickAnimator;
		xFinal = x;
		yFinal = y;
		chopstickFinal = cstick;
	}
	
	public void run() {
		animatorFinal.animateChopstickToHand(chopstickFinal, xFinal, yFinal);
	}
}