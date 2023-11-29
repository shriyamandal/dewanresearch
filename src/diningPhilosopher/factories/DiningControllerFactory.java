package diningPhilosopher.factories;

import diningPhilosopher.controller.BasicDiningController;
import diningPhilosopher.controller.ConsoleController;

public class DiningControllerFactory {
	static ConsoleController singleton;
	public static ConsoleController  getSingleton() {
		if (singleton == null) {
			singleton = 
					new BasicDiningController();
			// new ButlerCoordinatedDiningController();

//			singleton = new BasicStringCounterController();
//			singleton = new CoordinatedStringCounterController();

		}
		return singleton;
	}

}
