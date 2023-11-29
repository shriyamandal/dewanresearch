package graphics;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.OEShapeModel;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "X", "Y", "Angle", "Radius", "PropertyChangeListeners" })
@EditablePropertyNames({ "X", "Y", "Angle", "Radius" })

public class ChopstickLine extends Locatable implements ChopstickLineInterface {

	OEShapeModel chopstickNew;

	public ChopstickLine(int x, int y) {
		super(x, y);
		chopstickNew = new ALineModel();
		chopstickNew.setX(400);
		chopstickNew.setY(400);
		chopstickNew.setRadius(60);
		chopstickNew.setColor(Color.CYAN);
	}

	@Override
	public void setAngle(int newAngle) {
		double oldAngle = chopstickNew.getAngle();
		chopstickNew.setAngle(newAngle);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldAngle, newAngle));
	}

	@Override
	public void setX(int newX) {
		int oldX = chopstickNew.getX();
		chopstickNew.setX(newX);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldX, newX));
	}

	@Override
	public void setY(int newY) {
		int oldY = chopstickNew.getY();
		chopstickNew.setX(newY);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY, newY));
	}

	@Override
	public void setRadius(int newRadius) {
		double oldRadius = chopstickNew.getRadius();
		chopstickNew.setRadius(newRadius);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Radius", oldRadius, newRadius));
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListen) {
		propertySupport.addListen(newListen);
	}

	@Override
	@Visible(false)
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.generateList();
	}

}
