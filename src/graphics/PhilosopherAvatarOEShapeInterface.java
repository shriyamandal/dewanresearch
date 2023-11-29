package graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.models.PropertyListenerRegisterer;

public interface PhilosopherAvatarOEShapeInterface extends PropertyListenerRegisterer {

	public OEShapeModel getHead();

	public OEShapeModel getBody();

	public boolean getWaiting();

	public void setWaiting(boolean waitStatus);

	public FlexibleTextShape getStringShape();

	public boolean getFed();

	public void setFed(boolean fedStatus);

	public OEShapeModel getVisionLine1();

	public OEShapeModel getVisionLine2();

	public void move(int x, int y);

	public void addPropertyChangeListener(RotatingLineInterface rotatingLine, PropertyChangeListener propertySupport);

	public void addPropertyChangeListener(PropertyChangeListener arg0);

	public List<PropertyChangeListener> getPropertyChangeListeners();

	public OEShapeModel getRightArm();

	public OEShapeModel getLeftArm();

	public OEShapeModel getLeftLeg();

	public OEShapeModel getRightLeg();
}
