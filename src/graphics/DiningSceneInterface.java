
package graphics;
import java.beans.PropertyChangeListener;

import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;

public interface DiningSceneInterface extends PropertyChangeListener {

	public OEShapeModel getTable();

	public OEShapeModel getSpaghetti();

	public OEShapeModel getMiniSpag1();

	public OEShapeModel getMiniSpag2();

	public OEShapeModel getMiniSpag3();

	public OEShapeModel getMiniSpag4();

	public OEShapeModel getMiniSpag5();

	public OEShapeModel getChopstick1();

	public OEShapeModel getChopstick2();

	public OEShapeModel getChopstick4();

	public OEShapeModel getChopstick3();

	public OEShapeModel getChopstick5();

	public PhilosopherAvatarOEShapeInterface getPhilosopher1();

	public PhilosopherAvatarOEShapeInterface getPhilosopher2();

	public PhilosopherAvatarOEShapeInterface getPhilosopher3();

	public PhilosopherAvatarOEShapeInterface getPhilosopher4();

	public PhilosopherAvatarOEShapeInterface getPhilosopher5();

	boolean preInitNumberOfPhilosophers();

	void initNumberOfPhilosophers(int aNumberOfPhilosophers);

	void nextCourseTime(int newVal);

	boolean preNextCourseTime();

	public OEShapeModel getVisionLine();

	public OEShapeModel getVisionLine2();

	public OEShapeModel getTableLeg1();

	public OEShapeModel getTableLeg2();

	OEShapeModel getEmptySpag1();

	OEShapeModel getEmptySpag2();

	OEShapeModel getEmptySpag3();

	OEShapeModel getEmptySpag4();

	OEShapeModel getEmptySpag5();

	public void pickUpLeftChopstick(AnImageModel head);

	public void pickUpLeftChopstickString(String philosopher);

	public void pickUpRightChopstick(AnImageModel head);

	public void pickUpRightChopstickString(String philosopher);

	public void putDownLeftChopstick(AnImageModel head);

	public void putDownLeftChopstickString(String philosopher);

	public void putDownRightChopstick(AnImageModel head);

	public void putDownRightChopstickString(String philosopher);

	public RotatingLineInterface getChopstickLine1();

	public RotatingLineInterface getChopstickLine2();

	public RotatingLineInterface getChopstickLine3();

	public RotatingLineInterface getChopstickLine4();

	public RotatingLineInterface getChopstickLine5();
	
}

