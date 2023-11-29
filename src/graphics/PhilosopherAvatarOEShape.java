package graphics;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.util.List;

import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AStringModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


@PropertyNames({ "Head", "RightArm", "LeftArm", "RightLeg", "LeftLeg", "X", "Y", "Body", "Waiting",
		"PropertyChangeListeners",
		"Fed", "StringShape",
		"VisionLine1", "VisionLine2" })
@EditablePropertyNames({ "Waiting", "X", "Y", "Fed" })

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class PhilosopherAvatarOEShape extends Locatable implements PhilosopherAvatarOEShapeInterface {

	final static int OFFSET = 100;
	final static int MINOR_OFFSET = 10;
	final static int LEFT_ROTATE = 24;
	final static int RIGHT_ROTATE = 8;
	final static int BODY_ROTATE = 16;
	final static int BODY_RADIUS = 60;
	final static int BODY_ANGLE = 0;
	final static int DIVIDER = 2;
	final static int ARM_RADIUS = 40;

	final static int INITIAL_RADIUS = 40;
	final static int INITIAL_ANGLE1 = 0;
	final static int INITIAL_ANGLE2 = 0;
	final static int START_X = 100;
	final static int START_Y = 100;

	OEShapeModel head;
	OEShapeModel leftArm;
	OEShapeModel rightArm;
	OEShapeModel body;
	FlexibleTextShape stringShape;
	OEShapeModel leftLeg;
	OEShapeModel rightLeg;

	boolean waiting;
	boolean raisedHand;
	boolean isFed;

	OEShapeModel visionLine1;
	OEShapeModel visionLine2;

	public PhilosopherAvatarOEShape(String avatarHead, int initX, int initY) {
		super(initY, initY);
		head = new AnImageModel(avatarHead);
		head.setX(initX);
		head.setY(initY);
		visionLine1 = new ALineModel();
		visionLine2 = new ALineModel();
		visionLine1.setColor(Color.white);
		visionLine2.setColor(Color.white);
		visionLine1.setRadius(60);
		visionLine2.setRadius(60);
		body = new ALineModel();
		body.setX(head.getX() + 33);
		body.setY(head.getY() + 64);
		body.setRadius(BODY_RADIUS);
		body.setAngle(Math.PI / 2);
		body.setColor(Color.WHITE);
		stringShape = new AStringModel("Waiting to eat!");
		stringShape.setColor(Color.WHITE);
		stringShape.setX(head.getX() + 70);
		stringShape.setY(head.getY() - MINOR_OFFSET);
		leftArm = new ALineModel();
		leftArm.setX(body.getX());
		leftArm.setY(body.getY() + 20);
		leftArm.setAngle(LEFT_ROTATE);
		leftArm.setColor(Color.WHITE);
		leftArm.setRadius(ARM_RADIUS);
		rightArm = new ALineModel();
		rightArm.setX(body.getX());
		rightArm.setY(body.getY() + 20);
		rightArm.setAngle(RIGHT_ROTATE);
		rightArm.setColor(Color.WHITE);
		rightArm.setRadius(ARM_RADIUS);
		leftLeg = new ALineModel();
		leftLeg.setX(body.getX());
		leftLeg.setY(body.getY() + BODY_RADIUS);
		leftLeg.setColor(Color.WHITE);
		leftLeg.setRadius(ARM_RADIUS);
		leftLeg.setAngle(95);
		rightLeg = new ALineModel();
		rightLeg.setX(body.getX());
		rightLeg.setY(body.getY() + BODY_RADIUS);
		rightLeg.setColor(Color.WHITE);
		rightLeg.setRadius(ARM_RADIUS);
		rightLeg.setAngle(103);

		waiting = false;
		raisedHand = false;
		isFed = false;
	}

	@Override
	public OEShapeModel getHead() {
		return head;
	}

	@Override
	public OEShapeModel getBody() {
		return body;
	}

	@Override
	public OEShapeModel getLeftArm() {
		return leftArm;
	}

	@Override
	public OEShapeModel getRightArm() {
		return rightArm;
	}

	@Override
	public OEShapeModel getLeftLeg() {
		return leftLeg;
	}

	@Override
	public OEShapeModel getRightLeg() {
		return rightLeg;
	}

	@Override
	public boolean getWaiting() {
		return waiting;
	}

	@Override
	public void setWaiting(boolean waitStatus) {
		waiting = waitStatus;
	}
	
	@Override
	public FlexibleTextShape getStringShape() {
		return stringShape;
	}

	@Override
	public boolean getFed() {
		return isFed;
	}

	@Override
	public void setFed(boolean fedStatus) {
		isFed = fedStatus;
	}

	@Override
	public OEShapeModel getVisionLine1() {
		return visionLine1;
	}

	@Override
	public OEShapeModel getVisionLine2() {
		return visionLine2;
	}

	@Override
	public void move(int x, int y) {
		head.setX(head.getX() + x);
		head.setY(head.getY() + y);
		body.setX(body.getX() + x);
		body.setY(body.getY() + y);
	}

	@Override
	public void addPropertyChangeListener(RotatingLineInterface rotatingLine, PropertyChangeListener propertySupport) {
		rotatingLine.addPropertyChangeListener(propertySupport);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.generateList();
	}

}
