package graphics;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

@PropertyNames({ "StringShape", "Chopstick", "ZIndex", "Width", "Height", "X", "Y", "PropertyChangeListeners" })
@EditablePropertyNames({ "ZIndex", "Width", "Height", "X", "Y" })

// java reference, to chopstick that Dewan created, need to lock chopstick and make sure that no one else gets the chopstick
// see diningPhilosopher.chopstick
// for each chopstick view, need a lock object
// need to do setx, sety only after we have locked

public class Chopstick extends BoundedShape implements ChopstickInterface {

	StringShapeInterface stringShape;
	ChopstickImageInterface chopstick;
	boolean isLocked;

	public Chopstick(ChopstickImage chopstickImage) {
		super(0, 0, 0, 0);
		chopstick = chopstickImage;
		stringShape = new StringShape(chopstickImage.getX() + 20, chopstickImage.getY(), "");
		isLocked = false;
	}

	@Override
	public synchronized void lock() {
		if (isLocked) {
			try {
				this.wait();
				isLocked = true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void unlock() {
		// call only when locked
		isLocked = false;
		this.notify();
	}

	@Override
	public ChopstickImageInterface getChopstick() {
		return chopstick;
	}

	@Override
	public StringShapeInterface getStringShape() {
		return stringShape;
	}

	@Override
	public void moveTo(int x, int y) {
		((Locatable) chopstick).setX(x);
		((Locatable) chopstick).setY(y);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
