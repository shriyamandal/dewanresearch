package graphics;

import util.misc.ThreadSupport;

public class ChopstickAnimator implements ChopstickAnimatorInterface {
	
	public synchronized void animateChopstickToHand(RotatingLineInterface cstick, int x, int y) {

		System.out.println(Thread.currentThread() + "getting lock for cstick" + cstick);
		cstick.lock();
		System.out.println(Thread.currentThread() + "cstick  locked");

		// System.out.println(cstick.getX() + "," + cstick.getY());
		// System.out.println(Thread.currentThread());

		int difference_x = Math.abs(cstick.getX() - x);
		int difference_y = Math.abs(cstick.getY() - y);
		
		int step = 5;

		int times_to_x = Math.floorDiv(difference_x, step);
		int times_to_y = Math.floorDiv(difference_y, step);

		int sleepTime = 100;

		int remainder_y = y % step;
		int remainder_x = x % step;

		int ySign = 1;
		int xSign = 1;

		if (cstick.getY() > y) {
			ySign = -1;
		}

		if (cstick.getX() > x) {
			xSign = -1;
		}

		int loop_times = Math.min(times_to_x, times_to_y);
		System.out.println(Thread.currentThread() + "starting loop");

		for (int i = 0; i < loop_times; i++) {
			cstick.setX(cstick.getX() + (xSign * step));
			cstick.setY(cstick.getY() + (ySign * step));

			ThreadSupport.sleep(sleepTime);
		}

		for (int i = 0; i < times_to_x - loop_times; i++) {
			cstick.setX(cstick.getX() + (xSign * step));
			ThreadSupport.sleep(sleepTime);
		}

		for (int i = 0; i < times_to_y - loop_times; i++) {
			cstick.setY(cstick.getY() + (ySign * step));
			ThreadSupport.sleep(sleepTime);
		}

		cstick.setY(cstick.getY() + (ySign * remainder_y));

		cstick.setX(cstick.getX() + (xSign * remainder_x));

		cstick.unlock();
		System.out.println(Thread.currentThread() + " cstick unlocked, ended loop");

		}
		}