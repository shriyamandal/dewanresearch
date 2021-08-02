package diningPhilosopher.executor;

import counterIncrementer.coordinated.CoordinatedCounterIncrementorsExecutor;
import counterIncrementer.threads.ConcurrentCounterIncrementersExecutor;
import diningPhilosopher.concurrent.ConcurrentDiningExecutor;
import diningPhilosopher.coordinated.CoordinatedDiningExecutor;

public class DiningExecutorFactory {
	static DiningExecutor singleton;
	public static DiningExecutor getSingleton() {
		if (singleton == null) {
			singleton = 
//					new SequentialDiningExecutor();
//			        new ConcurrentDiningExecutor();
					new CoordinatedDiningExecutor();

		}
		return singleton;
		
	}
}
