package graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.models.PropertyListenerRegisterer;

public interface ChopstickLineInterface extends PropertyListenerRegisterer {

	public void setAngle(int newAngle);

	public void setX(int newX);

	public void setY(int newY);

	public void setRadius(int newRadius);

	public void addPropertyChangeListener(PropertyChangeListener newListen);

	public List<PropertyChangeListener> getPropertyChangeListeners();
}
