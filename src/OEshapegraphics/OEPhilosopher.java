package OEshapegraphics;

import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;

public class OEPhilosopher extends Locatable implements OEPhilosopherInterface {

	// needs an image

	OEShapeModel image;
	OEShapeModel body;
	OEShapeModel leftArm;
	OEShapeModel rightArm;

	public OEPhilosopher(int initX, int initY, String initImage) {
		super(initX, initY);
		image = new AnImageModel(initImage);
		body.setX(initX + image.getWidth()/2);
	}

}
