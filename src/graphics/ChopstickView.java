package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import diningPhilosopher.chopstick.SharedChopstick;

public class ChopstickView extends RotatingLine implements PropertyChangeListener {

	SharedChopstick originalChopstick;

	public ChopstickView(int initX, int initY, SharedChopstick chopstick) {
		super(initX, initY);
		originalChopstick = chopstick;
		originalChopstick.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// what to fire?
	}
}
