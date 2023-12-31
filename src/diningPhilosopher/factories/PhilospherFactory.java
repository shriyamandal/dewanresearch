
package diningPhilosopher.factories;

import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.coordinated.NoDeadlockCoordinatedPhilosopher;
import diningPhilosopher.philosopher.Philosopher;

public class PhilospherFactory {
	static Philosopher[] philosophers;

	static Philosopher createPhilosopher(int anId, Chopstick aLeftChopstick, Chopstick aRightChopstick) {
		return new 
//				BasicPhilosopher(anId, aLeftChopstick, aRightChopstick);
//				PollingPhilosopher(anId,aLeftChopstick, aRightChopstick);
		NoDeadlockCoordinatedPhilosopher(anId, aLeftChopstick, aRightChopstick);

//				ButlerCoordinatedPhilosopher(anId, aLeftChopstick, aRightChopstick);
	}

	public static Philosopher[] createPhilosophers(Chopstick[] aChopsticks) {
		philosophers = new Philosopher[aChopsticks.length];		
		for (int anId = 0; anId < philosophers.length; anId++) {			
			philosophers[anId] = createPhilosopher(anId, aChopsticks[anId], aChopsticks[(anId + 1) % aChopsticks.length]);
		}
		return philosophers;
	}
	public static Philosopher[] getPhilosophers() {
		return philosophers;
	}

}