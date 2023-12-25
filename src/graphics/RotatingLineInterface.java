package graphics;

import java.awt.Color;
import java.awt.Stroke;
import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.LINE_PATTERN)

public interface RotatingLineInterface extends PropertyListenerRegisterer {

	public int getWidth();

	public int getX();

	public int getY();

	public void setX(int newX);

	public void setY(int newY);

	public int getHeight();

	public double getRadius();

	public void setRadius(double newRadius);

	public double getAngle();

	public void setAngle(double newAngle);

	public void rotate(int units);

	public boolean getUse();

	public void setUse(boolean use);

	public void addPropertyChangeListener(PropertyChangeListener newListen);

	List<PropertyChangeListener> getPropertyChangeListeners();

	void setStroke(float stroke);

	Stroke getStroke();

	public void setColor(int color);

	Color getColor();

	public void lock();

	public void unlock();

}
