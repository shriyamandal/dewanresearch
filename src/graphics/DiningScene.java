package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.beans.PropertyChangeEvent;

import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.AnOvalModel;
import bus.uigen.shapes.OEShapeModel;
import diningPhilosopher.main.DiningUtil;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class DiningScene implements DiningSceneInterface {

	OEShapeModel table;

	OEShapeModel spaghetti;
	OEShapeModel miniSpag1;
	OEShapeModel miniSpag2;
	OEShapeModel miniSpag3;
	OEShapeModel miniSpag4;
	OEShapeModel miniSpag5;

	OEShapeModel emptySpag1;
	OEShapeModel emptySpag2;
	OEShapeModel emptySpag3;
	OEShapeModel emptySpag4;
	OEShapeModel emptySpag5;

	OEShapeModel chopstick1;
	OEShapeModel chopstick2;
	OEShapeModel chopstick3;
	OEShapeModel chopstick4;
	OEShapeModel chopstick5;
	OEShapeModel visionLine;
	OEShapeModel visionLine2;

	OEShapeModel tableLeg1;
	OEShapeModel tableLeg2;

	// have a chopstick animator for each chopstick


	RotatingLineInterface chopstickLine1;
	RotatingLineInterface chopstickLine2;
	RotatingLineInterface chopstickLine3;
	RotatingLineInterface chopstickLine4;
	RotatingLineInterface chopstickLine5;

	PhilosopherAvatarOEShapeInterface philosopher1;
	PhilosopherAvatarOEShapeInterface philosopher2;
	PhilosopherAvatarOEShapeInterface philosopher3;
	PhilosopherAvatarOEShapeInterface philosopher4;
	PhilosopherAvatarOEShapeInterface philosopher5;

	PhilosopherAvatarOEShapeInterface pollingphilosopher1;
	PhilosopherAvatarOEShapeInterface pollingphilosopher2;
	PhilosopherAvatarOEShapeInterface pollingphilosopher3;
	PhilosopherAvatarOEShapeInterface pollingphilosopher4;
	PhilosopherAvatarOEShapeInterface pollingphilosopher5;

	// mini spag animators!
	MiniSpagAnimator miniSpagAnimator1 = new MiniSpagAnimator();
	MiniSpagAnimator miniSpagAnimator2 = new MiniSpagAnimator();
	MiniSpagAnimator miniSpagAnimator3 = new MiniSpagAnimator();
	MiniSpagAnimator miniSpagAnimator4 = new MiniSpagAnimator();
	MiniSpagAnimator miniSpagAnimator5 = new MiniSpagAnimator();

	final static int CHOPSTICK_GREEN = 438583;
	final static int CHOPSTICK_BLUE = 880808;

	int CHOPSTICK1_X = 460 + 20;
	int CHOPSTICK1_Y = 400;
	int CHOPSTICK2_X = 590 + 60;
	int CHOPSTICK2_Y = 425;
	int CHOPSTICK3_X = 610 + 120;
	int CHOPSTICK3_Y = 300 - 10;
	int CHOPSTICK4_X = 540 + 30;
	int CHOPSTICK4_Y = 220;
	int CHOPSTICK5_X = 425;
	int CHOPSTICK5_Y = 290;

	final int SPAG_X = 550;
	final static int SPAG_Y = 300;
	final static int MINISPAG1_X = 425;
	final static int MINISPAG1_Y = 350;
	final static int MINISPAG2_X = 550;
	final static int MINISPAG2_Y = 440;
	final static int MINISPAG3_X = 720;
	final static int MINISPAG3_Y = 360;
	final static int MINISPAG4_X = 660;
	final static int MINISPAG4_Y = 245;
	final static int MINISPAG5_X = 475 - 10 + 25;
	final static int MINISPAG5_Y = 240 - 10 - 5;

	final static int PHILOSOPHER1_X = 345;
	final static int PHILOSOPHER1_Y = 340;
	final static int PHILOSOPHER2_X = 540;
	final static int PHILOSOPHER2_Y = 500;


	final static int PHILOSOPHER3_X = 798;
	final static int PHILOSOPHER3_Y = 380;
	final static int PHILOSOPHER4_X = 720;
	final static int PHILOSOPHER4_Y = 130;
	final static int PHILOSOPHER5_X = 420 + 50;
	final static int PHILOSOPHER5_Y = 115 - 20;

	protected int numberOfPhilosophers = -1;

	boolean philOneLeft = false;
	boolean philOneRight = false;
	boolean philTwoLeft = false;
	boolean philTwoRight = false;
	boolean philThreeLeft = false;
	boolean philThreeRight = false;
	boolean philFourLeft = false;
	boolean philFourRight = false;
	boolean philFiveLeft = false;
	boolean philFiveRight = false;

	boolean philOneFed = false;
	boolean philTwoFed = false;
	boolean philThreeFed = false;
	boolean philFourFed = false;
	boolean philFiveFed = false;

	final static int PHIL_1_LEFT = 100;
	final static int PHIL_1_RIGHT = 45;
	final static int PHIL_2_LEFT = 110;
	final static int PHIL_2_RIGHT = 50;
	final static int PHIL_3_LEFT = 34;
	final static int PHIL_3_RIGHT = 200;
	final static int PHIL_4_LEFT = 95;
	final static int PHIL_4_RIGHT = 103;
	final static int PHIL_5_LEFT = 95;
	final static int PHIL_5_RIGHT = 103;

	final static String PHILOSOPHER_1_IMAGE = "images/socrates.png";
	final static String PHILOSOPHER_2_IMAGE = "images/backheadphil1.png";
	final static String PHILOSOPHER_3_IMAGE = "images/archimedes.png";
	final static String PHILOSOPHER_4_IMAGE = "images/aristotle.png";
	final static String PHILOSOPHER_5_IMAGE = "images/hippocrates2.png";

	// Use this to control whether it's waiting or polling
	boolean waitingPhilosopher = false;
	boolean pollingPhilosopher = false;

	public DiningScene() {
		visionLine = new ALineModel();
		visionLine.setX(10);
		visionLine.setY(10);
		visionLine.setRadius(0);
		visionLine.setAngle(10);
		visionLine2 = new ALineModel();
		visionLine2.setX(10);
		visionLine2.setY(10);
		visionLine2.setRadius(0);
		visionLine2.setAngle(10);

		philosopher1 = new PhilosopherAvatarOEShape(PHILOSOPHER_1_IMAGE, PHILOSOPHER1_X, PHILOSOPHER1_Y - 10);
		philosopher2 = new PhilosopherAvatarOEShape(PHILOSOPHER_2_IMAGE, PHILOSOPHER2_X + 20, PHILOSOPHER2_Y - 50);
		philosopher3 = new PhilosopherAvatarOEShape(PHILOSOPHER_3_IMAGE, PHILOSOPHER3_X - 20, PHILOSOPHER3_Y - 40);
		philosopher4 = new PhilosopherAvatarOEShape(PHILOSOPHER_4_IMAGE, PHILOSOPHER4_X - 35, PHILOSOPHER4_Y - 20);
		philosopher5 = new PhilosopherAvatarOEShape(PHILOSOPHER_5_IMAGE, PHILOSOPHER5_X + 10, PHILOSOPHER5_Y);

		// change the color of the chppsticks...
		chopstickLine1 = new RotatingLine(CHOPSTICK1_X + 30, CHOPSTICK1_Y + 45);
		CHOPSTICK1_X += 30;
		CHOPSTICK1_Y += 45;
		chopstickLine1.setRadius(60);
		chopstickLine1.setColor(CHOPSTICK_BLUE);
		chopstickLine1.setAngle(philosopher1.getLeftArm().getAngle() + 90 + 15);
		chopstickLine1.setAngle(7 * (Math.PI) / 4);

		chopstickLine2 = new RotatingLine(CHOPSTICK2_X + 40, CHOPSTICK2_Y + 25);
		CHOPSTICK2_X += 40;
		CHOPSTICK2_Y += 25;
		chopstickLine2.setRadius(60);
		chopstickLine2.setColor(CHOPSTICK_BLUE);
		chopstickLine2.setAngle(philosopher2.getLeftArm().getAngle() + 90 - 15);
		chopstickLine2.setAngle(5 * (Math.PI) / 4);

		chopstickLine3 = new RotatingLine(CHOPSTICK3_X + 20, CHOPSTICK3_Y + 50);
		CHOPSTICK3_X += 20;
		CHOPSTICK3_Y += 50;
		chopstickLine3.setRadius(60);
		chopstickLine3.setColor(CHOPSTICK_BLUE);
		chopstickLine3.setAngle(philosopher3.getLeftArm().getAngle() + 90);
		// chopstickLine3.setAngle(5 * (Math.PI) / 4);
		chopstickLine3.setAngle(4 * (Math.PI) / 4);

		chopstickLine4 = new RotatingLine(CHOPSTICK4_X + 30, CHOPSTICK4_Y + 5);
		CHOPSTICK4_X += 35;
		CHOPSTICK4_Y += 15;
		chopstickLine4.setRadius(60);
		chopstickLine4.setColor(CHOPSTICK_BLUE);
		chopstickLine4.setAngle(philosopher4.getLeftArm().getAngle() + 90);
		// chopstickLine4.setAngle(3 * (Math.PI) / 4);
		chopstickLine4.setAngle(2 * (Math.PI) / 4);

		chopstickLine5 = new RotatingLine(CHOPSTICK5_X + 75, CHOPSTICK5_Y + 45);
		CHOPSTICK5_X += 75;
		CHOPSTICK5_Y += 45;
		chopstickLine5.setRadius(60);
		chopstickLine5.setColor(CHOPSTICK_BLUE);
		chopstickLine5.setAngle(philosopher5.getLeftArm().getAngle() + 90);
		// chopstickLine5.setAngle(3 * (Math.PI) / 4);
		chopstickLine5.setAngle(4 * (Math.PI) / 4);

		table = new AnOvalModel();
		table.setX(400);
		table.setY(200);
		table.setWidth(400);
		table.setHeight(300);
		tableLeg1 = new ALineModel();
		tableLeg1.setX(450);
		tableLeg1.setY(450);
		tableLeg1.setRadius(70);
		tableLeg1.setAngle(Math.PI / 32 * 16);
		// need to rotate by 16
		tableLeg2 = new ALineModel();
		tableLeg2.setX(750);
		tableLeg2.setY(450);
		tableLeg2.setRadius(70);
		tableLeg2.setAngle(Math.PI / 32 * 16);
		table.setColor(Color.DARK_GRAY);
		table.setFilled(true);
		// tableLeg1.setStroke(10f);
		// tableLeg2.setStroke(10f);

		tableLeg1.setStroke(new BasicStroke(10f));
		tableLeg2.setStroke(new BasicStroke(10f));

		philosopher1.getLeftArm().setAngle(PHIL_1_LEFT);
		philosopher1.getRightArm().setAngle(PHIL_1_RIGHT);
		philosopher2.getLeftArm().setAngle(PHIL_2_LEFT);
		philosopher2.getRightArm().setAngle(PHIL_2_RIGHT);
		philosopher3.getLeftArm().setAngle(PHIL_3_LEFT);
		philosopher3.getRightArm().setAngle(PHIL_3_RIGHT);
		philosopher4.getLeftArm().setAngle(PHIL_4_LEFT);
		philosopher4.getRightArm().setAngle(PHIL_4_RIGHT);
		philosopher5.getLeftArm().setAngle(PHIL_5_LEFT);
		philosopher5.getRightArm().setAngle(PHIL_5_RIGHT);

		// hide legs for phil 4 and 5
		philosopher4.getLeftLeg().setRadius(0);
		philosopher4.getRightLeg().setRadius(0);
		philosopher5.getLeftLeg().setRadius(0);
		philosopher5.getRightLeg().setRadius(0);

		spaghetti = new AnImageModel("images/spag.png");
		spaghetti.setX(SPAG_X);
		spaghetti.setY(SPAG_Y);
		miniSpag1 = new AnImageModel("images/minispag.png");
		miniSpag1.setX(MINISPAG1_X - 5);
		miniSpag1.setY(MINISPAG1_Y + 18);
		miniSpag2 = new AnImageModel("images/minispag.png");
		miniSpag2.setX(MINISPAG2_X + 25);
		miniSpag2.setY(MINISPAG2_Y);
		miniSpag3 = new AnImageModel("images/minispag.png");
		miniSpag3.setX(MINISPAG3_X);
		miniSpag3.setY(MINISPAG3_Y + 5);
		miniSpag4 = new AnImageModel("images/minispag.png");
		miniSpag4.setX(MINISPAG4_X + 5);
		miniSpag4.setY(MINISPAG4_Y - 8);
		miniSpag5 = new AnImageModel("images/minispag.png");
		miniSpag5.setX(MINISPAG5_X);
		miniSpag5.setY(MINISPAG5_Y);
		chopstick1 = new AnImageModel("images/chopsticks.png");
		chopstick1.setX(CHOPSTICK1_X);
		chopstick1.setY(CHOPSTICK1_Y);
		chopstick2 = new AnImageModel("images/chopsticks.png");
		chopstick2.setX(CHOPSTICK2_X);
		chopstick2.setY(CHOPSTICK2_Y);
		chopstick3 = new AnImageModel("images/chopsticks.png");
		chopstick3.setX(CHOPSTICK3_X);
		chopstick3.setY(CHOPSTICK3_Y);
		chopstick4 = new AnImageModel("images/chopsticks.png");
		chopstick4.setX(CHOPSTICK4_X);
		chopstick4.setY(CHOPSTICK4_Y);
		chopstick5 = new AnImageModel("images/chopsticks.png");
		chopstick5.setX(CHOPSTICK5_X);
		chopstick5.setY(CHOPSTICK5_Y);


		chopstick1.setRadius(0);
		chopstick2.setRadius(0);
		chopstick3.setRadius(0);
		chopstick4.setRadius(0);
		chopstick5.setRadius(0);

		emptySpag1 = new AnImageModel("images/emptyplate.png");
		emptySpag1.setX(MINISPAG1_X);
		emptySpag1.setY(MINISPAG1_Y);
		emptySpag1.setHeight(0);
		emptySpag1.setWidth(0);
		emptySpag2 = new AnImageModel("images/emptyplate.png");
		emptySpag2.setX(MINISPAG2_X);
		emptySpag2.setY(MINISPAG2_Y);
		emptySpag2.setHeight(0);
		emptySpag2.setWidth(0);
		emptySpag3 = new AnImageModel("images/emptyplate.png");
		emptySpag3.setX(MINISPAG3_X);
		emptySpag3.setY(MINISPAG3_Y);
		emptySpag3.setHeight(0);
		emptySpag3.setWidth(0);
		emptySpag4 = new AnImageModel("images/emptyplate.png");
		emptySpag4.setX(MINISPAG4_X);
		emptySpag4.setY(MINISPAG4_Y);
		emptySpag4.setHeight(0);
		emptySpag4.setWidth(0);
		emptySpag5 = new AnImageModel("images/emptyplate.png");
		emptySpag5.setX(MINISPAG5_X);
		emptySpag5.setY(MINISPAG5_Y);
		emptySpag5.setHeight(0);
		emptySpag5.setWidth(0);

		chopstick1.setZIndex(1);
		chopstick2.setZIndex(2);
		chopstick3.setZIndex(3);
		chopstick4.setZIndex(4);
		chopstick5.setZIndex(5);
		spaghetti.setZIndex(6);
		miniSpag1.setZIndex(7);
		emptySpag1.setZIndex(71);
		miniSpag2.setZIndex(8);
		emptySpag2.setZIndex(81);
		miniSpag3.setZIndex(82);
		emptySpag3.setZIndex(83);
		miniSpag4.setZIndex(10);
		emptySpag4.setZIndex(11);
		miniSpag5.setZIndex(20);
		emptySpag5.setZIndex(21);
		table.setZIndex(90);



		// test out here, use height and width!n
		// chopstickLine5.setAngle((7 * Math.PI) / 4);



	}

	@Override
	public OEShapeModel getTable() {
		return table;
	}

	@Override
	public OEShapeModel getSpaghetti() {
		return spaghetti;
	}

	@Override
	public OEShapeModel getMiniSpag1() {
		return miniSpag1;
	}

	@Override
	public OEShapeModel getMiniSpag2() {
		return miniSpag2;
	}

	@Override
	public OEShapeModel getMiniSpag3() {
		return miniSpag3;
	}

	@Override
	public OEShapeModel getMiniSpag4() {
		return miniSpag4;
	}

	@Override
	public OEShapeModel getMiniSpag5() {
		return miniSpag5;
	}

	@Override
	public OEShapeModel getChopstick1() {
		return chopstick1;
	}

	@Override
	public OEShapeModel getChopstick2() {
		return chopstick2;
	}

	@Override
	public OEShapeModel getChopstick4() {
		return chopstick4;
	}

	@Override
	public OEShapeModel getChopstick3() {
		return chopstick3;
	}

	@Override
	public OEShapeModel getChopstick5() {
		return chopstick5;
	}

	@Override
	public OEShapeModel getEmptySpag1() {
		return emptySpag1;
	}

	@Override
	public OEShapeModel getEmptySpag2() {
		return emptySpag2;
	}

	@Override
	public OEShapeModel getEmptySpag3() {
		return emptySpag3;
	}

	@Override
	public OEShapeModel getEmptySpag4() {
		return emptySpag4;
	}

	@Override
	public OEShapeModel getEmptySpag5() {
		return emptySpag5;
	}

	@Override
	public PhilosopherAvatarOEShapeInterface getPhilosopher1() {
		return philosopher1;
	}

	@Override
	public PhilosopherAvatarOEShapeInterface getPhilosopher2() {
		return philosopher2;
	}

	@Override
	public PhilosopherAvatarOEShapeInterface getPhilosopher3() {
		return philosopher3;
	}

	@Override
	public PhilosopherAvatarOEShapeInterface getPhilosopher4() {
		return philosopher4;
	}

	@Override
	public PhilosopherAvatarOEShapeInterface getPhilosopher5() {
		return philosopher5;
	}

	@Override
	public OEShapeModel getTableLeg1() {
		return tableLeg1;
	}

	@Override
	public OEShapeModel getTableLeg2() {
		return tableLeg2;
	}

	@Override
	public void initNumberOfPhilosophers(int aNumberOfPhilosophers) {
		DiningUtil.setNumberOfPhilosophers(aNumberOfPhilosophers);
		numberOfPhilosophers = aNumberOfPhilosophers;
	}

	@Override
	public void nextCourseTime(int newVal) {
		DiningUtil.setNewCourseTime(newVal);
	}

	@Override
	public boolean preNextCourseTime() {
		return numberOfPhilosophers != -1;
	}

	@Override
	public boolean preInitNumberOfPhilosophers() {
		return numberOfPhilosophers == -1;
	}

	@Override
	public OEShapeModel getVisionLine() {
		return visionLine;
	}

	@Override
	public OEShapeModel getVisionLine2() {
		return visionLine2;
	}

	@Override
	public RotatingLineInterface getChopstickLine1() {
		return chopstickLine1;
	}

	@Override
	public RotatingLineInterface getChopstickLine2() {
		return chopstickLine2;
	}

	@Override
	public RotatingLineInterface getChopstickLine3() {
		return chopstickLine3;
	}

	@Override
	public RotatingLineInterface getChopstickLine4() {
		return chopstickLine4;
	}

	@Override
	public RotatingLineInterface getChopstickLine5() {
		return chopstickLine5;
	}


	public double chopstickAngle() {
		return 0.0;

	}

	public double distanceBtwnTwoPoints(int oneX, int oneY, int twoX, int twoY) {
		int a = Math.abs(oneX - twoX);
		int b = Math.abs(oneY - twoY);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return c;
	}

	public double angleBtwnTwoPoints(int oneX, int oneY, int twoX, int twoY) {
		double hyp = distanceBtwnTwoPoints(oneX, oneY, twoX, twoY);
		double angle = Math.sin(oneY - twoY / hyp);
		System.out.println(angle);
		return angle;
	}

	public double findChopstickX(OEShapeModel oeShapeModel) {
		// have the arm x and y, and we know its length is 40
		int startX = oeShapeModel.getX();
		double angle = oeShapeModel.getAngle();
		double length = oeShapeModel.getRadius();
		// adj is the x!
		double adj = length * Math.cos(angle);
		return adj;
	}

	public double findChopstickY(OEShapeModel oeShapeModel) {
		// have the arm x and y, and we know its length is 40
		double adj = findChopstickX(oeShapeModel);
		double step1 = (adj * adj) + 1600;
		double step2 = Math.sqrt(step1);

		return step2;
	}

	@Override
	public synchronized void pickUpLeftChopstick(AnImageModel head) {
		int newX = 0;
		int newY = 0;
		if (head.getImageFileName() == PHILOSOPHER_1_IMAGE) {
			newX = philosopher1.getLeftArm().getWidth() + philosopher1.getLeftArm().getX();
			newY = philosopher1.getLeftArm().getHeight() + philosopher1.getLeftArm().getY();
			animateChopstick(chopstickLine5, newX + 36, newY - 38);
			// animateChopstick(chopstickLine5, newX, newY);
			chopstickLine5.setAngle(3 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_2_IMAGE) {
			newX = philosopher2.getLeftArm().getWidth() + philosopher2.getLeftArm().getX();
			newY = philosopher2.getLeftArm().getHeight() + philosopher2.getLeftArm().getY();
			animateChopstick(chopstickLine1, newX, newY);
		} else if (head.getImageFileName() == PHILOSOPHER_3_IMAGE) {
			newX = philosopher3.getLeftArm().getWidth() + philosopher3.getLeftArm().getX();
			newY = philosopher3.getLeftArm().getHeight() + philosopher3.getLeftArm().getY();
			animateChopstick(chopstickLine2, newX, newY);
		} else if (head.getImageFileName() == PHILOSOPHER_4_IMAGE) {
			newX = philosopher4.getLeftArm().getWidth() + philosopher4.getLeftArm().getX();
			newY = philosopher4.getLeftArm().getHeight() + philosopher4.getLeftArm().getY();
			animateChopstick(chopstickLine3, newX, newY);
			// need to fix chopstickline3 angle!
			chopstickLine3.setAngle((3 * Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_5_IMAGE) {
			newX = philosopher5.getLeftArm().getWidth() + philosopher5.getLeftArm().getX();
			newY = philosopher5.getLeftArm().getHeight() + philosopher5.getLeftArm().getY();
			animateChopstick(chopstickLine4, newX, newY);
		}
	}

	@Override
	public synchronized void pickUpLeftChopstickString(String philosopher) {
		int newX = 0;
		int newY = 0;
		if (philosopher == "Philosopher 1") {
			newX = philosopher1.getLeftArm().getWidth() + philosopher1.getLeftArm().getX();
			newY = philosopher1.getLeftArm().getHeight() + philosopher1.getLeftArm().getY();
			System.out.println("P1 picks up C5");
			animateChopstick(chopstickLine5, newX + 36, newY - 38);
			// animateChopstick(chopstickLine5, newX, newY);
			chopstickLine5.setAngle(3 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 2") {
			newX = philosopher2.getLeftArm().getWidth() + philosopher2.getLeftArm().getX();
			newY = philosopher2.getLeftArm().getHeight() + philosopher2.getLeftArm().getY();
			System.out.println("P2 picks up C1");
			animateChopstick(chopstickLine1, newX, newY);
		} else if (philosopher == "Philosopher 3") {
			newX = philosopher3.getLeftArm().getWidth() + philosopher3.getLeftArm().getX();
			newY = philosopher3.getLeftArm().getHeight() + philosopher3.getLeftArm().getY();
			System.out.println("P3 picks up C2");
			animateChopstick(chopstickLine2, newX, newY);
		} else if (philosopher == "Philosopher 4") {
			newX = philosopher4.getLeftArm().getWidth() + philosopher4.getLeftArm().getX();
			newY = philosopher4.getLeftArm().getHeight() + philosopher4.getLeftArm().getY();
			System.out.println("P4 picks up C3");
			animateChopstick(chopstickLine3, newX, newY);
			// need to fix chopstickline3 angle!
			chopstickLine3.setAngle((3 * Math.PI) / 4);
		} else if (philosopher == "Philosopher 5") {
			newX = philosopher5.getLeftArm().getWidth() + philosopher5.getLeftArm().getX();
			newY = philosopher5.getLeftArm().getHeight() + philosopher5.getLeftArm().getY();
			System.out.println("P5 picks up C4");
			animateChopstick(chopstickLine4, newX, newY);

		}
	}

	@Override
	public synchronized void pickUpRightChopstick(AnImageModel head) {
		int newX = 0;
		int newY = 0;
		if (head.getImageFileName() == PHILOSOPHER_1_IMAGE) {
			newX = philosopher1.getRightArm().getWidth() + philosopher1.getRightArm().getX();
			newY = philosopher1.getRightArm().getHeight() + philosopher1.getRightArm().getY();
			animateChopstick(chopstickLine1, newX, newY);
		} else if (head.getImageFileName() == PHILOSOPHER_2_IMAGE) {
			newX = philosopher2.getRightArm().getWidth() + philosopher2.getRightArm().getX();
			newY = philosopher2.getRightArm().getHeight() + philosopher2.getRightArm().getY();
			animateChopstick(chopstickLine2, newX, newY);
		} else if (head.getImageFileName() == PHILOSOPHER_3_IMAGE) {
			newX = philosopher3.getRightArm().getWidth() + philosopher3.getRightArm().getX();
			newY = philosopher3.getRightArm().getHeight() + philosopher3.getRightArm().getY();
			animateChopstick(chopstickLine3, newX, newY);
		} else if (head.getImageFileName() == PHILOSOPHER_4_IMAGE) {
			newX = philosopher4.getRightArm().getWidth() + philosopher4.getRightArm().getX();
			newY = philosopher4.getRightArm().getHeight() + philosopher4.getRightArm().getY();
			animateChopstick(chopstickLine4, newX, newY);
		} else if (head.getImageFileName() == PHILOSOPHER_5_IMAGE) {
			newX = philosopher5.getRightArm().getWidth() + philosopher5.getRightArm().getX();
			newY = philosopher5.getRightArm().getHeight() + philosopher5.getRightArm().getY();
			animateChopstick(chopstickLine5, newX, newY);
			chopstickLine5.setAngle(1 * (Math.PI) / 4);
		}
	}

	@Override
	public synchronized void pickUpRightChopstickString(String philosopher) {
		int newX = 0;
		int newY = 0;
		if (philosopher == "Philosopher 1"){
			newX = philosopher1.getRightArm().getWidth() + philosopher1.getRightArm().getX();
			newY = philosopher1.getRightArm().getHeight() + philosopher1.getRightArm().getY();
			System.out.println("P1 picks up C1");
			animateChopstick(chopstickLine1, newX, newY);
		} else if (philosopher == "Philosopher 2") {
			newX = philosopher2.getRightArm().getWidth() + philosopher2.getRightArm().getX();
			newY = philosopher2.getRightArm().getHeight() + philosopher2.getRightArm().getY();
			System.out.println("P2 picks up C2");
			animateChopstick(chopstickLine2, newX, newY);
		} else if (philosopher == "Philosopher 3") {
			newX = philosopher3.getRightArm().getWidth() + philosopher3.getRightArm().getX();
			newY = philosopher3.getRightArm().getHeight() + philosopher3.getRightArm().getY();
			System.out.println("P3 picks up C3");
			animateChopstick(chopstickLine3, newX, newY);
		} else if (philosopher == "Philosopher 4") {
			newX = philosopher4.getRightArm().getWidth() + philosopher4.getRightArm().getX();
			newY = philosopher4.getRightArm().getHeight() + philosopher4.getRightArm().getY();
			System.out.println("P4 picks up C4");
			animateChopstick(chopstickLine4, newX, newY);
		} else if (philosopher == "Philosopher 5") {
			newX = philosopher5.getRightArm().getWidth() + philosopher5.getRightArm().getX();
			newY = philosopher5.getRightArm().getHeight() + philosopher5.getRightArm().getY();
			System.out.println("P5 picks up C5");
			animateChopstick(chopstickLine5, newX, newY);
			chopstickLine5.setAngle(1 * (Math.PI) / 4);
		}
	}

	public void checkIfEating() {

	}

	public synchronized void animateMiniSpag(OEShapeModel miniSpag) {
		Thread miniSpagThread = new Thread(new MiniSpagAnimatorCommand(miniSpagAnimator1, miniSpag));
		miniSpagThread.start();
	}

	public synchronized void animateChopstickFromUI(RotatingLineInterface chopstick, int finalX, int finalY) {
		ChopstickAnimator animator = new ChopstickAnimator();

		Thread chopstickThread = new Thread(new ChopstickAnimatorCommand(animator, chopstick, finalX, finalY));
		System.out.println("Created a chopstickThread" + chopstickThread);
			chopstickThread.start();
			System.out.println("Thread:" + Thread.currentThread() + " has started " + chopstickThread);
		}

	public synchronized void animateChopstickFromPhilosopher(RotatingLineInterface chopstick, int finalX, int finalY) {
		ChopstickAnimator animator = new ChopstickAnimator();
		ChopstickAnimatorCommand command = new ChopstickAnimatorCommand(animator, chopstick, finalX, finalY);
		command.run();

		System.out.println("Philosopher Thread has finished animation");
	}

	public synchronized void animateChopstick(RotatingLineInterface chopstick, int finalX, int finalY) {
		String threadName = Thread.currentThread().getName();
		if (threadName.contains("Philosopher")) {
			animateChopstickFromPhilosopher(chopstick, finalX, finalY);
		} else {
			animateChopstickFromUI(chopstick, finalX, finalY);
		}
	}



	@Override
	public synchronized void putDownLeftChopstick(AnImageModel head) {
		if (head.getImageFileName() == PHILOSOPHER_1_IMAGE) {
			animateChopstick(chopstickLine5, CHOPSTICK5_X, CHOPSTICK5_Y);
			chopstickLine5.setAngle(4 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_2_IMAGE) {
			animateChopstick(chopstickLine1, CHOPSTICK1_X, CHOPSTICK1_Y);
			chopstickLine1.setAngle(7 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_3_IMAGE) {
			animateChopstick(chopstickLine2, CHOPSTICK2_X, CHOPSTICK2_Y);
			chopstickLine2.setAngle(5 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_4_IMAGE) {
			animateChopstick(chopstickLine3, CHOPSTICK3_X, CHOPSTICK3_Y);
			chopstickLine3.setAngle(4 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_5_IMAGE) {
			animateChopstick(chopstickLine4, CHOPSTICK4_X, CHOPSTICK4_Y);
			chopstickLine4.setAngle(2 * (Math.PI) / 4);
		}
	}

	@Override
	public synchronized void putDownLeftChopstickString(String philosopher) {
		if (philosopher == "Philosopher 1") {
			System.out.println("P1 puts down C5");
			animateChopstick(chopstickLine5, CHOPSTICK5_X, CHOPSTICK5_Y);
			chopstickLine5.setAngle((Math.PI));
		} else if (philosopher == "Philosopher 2") {
			System.out.println("P2 puts down C1");
			animateChopstick(chopstickLine1, CHOPSTICK1_X, CHOPSTICK1_Y);
			chopstickLine1.setAngle(7 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 3") {
			System.out.println("P3 puts down C2");
			animateChopstick(chopstickLine2, CHOPSTICK2_X, CHOPSTICK2_Y);
			chopstickLine2.setAngle(5 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 4") {
			System.out.println("P4 puts down C3");
			animateChopstick(chopstickLine3, CHOPSTICK3_X, CHOPSTICK3_Y);
			chopstickLine3.setAngle(4 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 5") {
			System.out.println("P5 puts down C4");
			animateChopstick(chopstickLine4, CHOPSTICK4_X, CHOPSTICK4_Y);
			chopstickLine4.setAngle(2 * (Math.PI) / 4);
		}
	}

	@Override
	public synchronized void putDownRightChopstick(AnImageModel head) {
		if (head.getImageFileName() == PHILOSOPHER_1_IMAGE) {
			animateChopstick(chopstickLine1, CHOPSTICK1_X, CHOPSTICK1_Y);
			chopstickLine1.setAngle(7 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_2_IMAGE) {
			animateChopstick(chopstickLine2, CHOPSTICK2_X, CHOPSTICK2_Y);
			chopstickLine2.setAngle(5 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_3_IMAGE) {
			animateChopstick(chopstickLine3, CHOPSTICK3_X, CHOPSTICK3_Y);
			chopstickLine3.setAngle(4 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_4_IMAGE) {
			animateChopstick(chopstickLine4, CHOPSTICK4_X, CHOPSTICK4_Y);
			chopstickLine4.setAngle(2 * (Math.PI) / 4);
		} else if (head.getImageFileName() == PHILOSOPHER_5_IMAGE) {
			animateChopstick(chopstickLine5, CHOPSTICK5_X, CHOPSTICK5_Y);
			chopstickLine5.setAngle((Math.PI));
		}
	}

	@Override
	public synchronized void putDownRightChopstickString(String philosopher) {
		if (philosopher == "Philosopher 1") {
			System.out.println("P1 puts down C1");
			animateChopstick(chopstickLine1, CHOPSTICK1_X, CHOPSTICK1_Y);
			chopstickLine1.setAngle(7 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 2") {
			System.out.println("P2 puts down C2");
			animateChopstick(chopstickLine2, CHOPSTICK2_X, CHOPSTICK2_Y);
			chopstickLine2.setAngle(5 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 3") {
			System.out.println("P3 puts down C3");
			animateChopstick(chopstickLine3, CHOPSTICK3_X, CHOPSTICK3_Y);
			chopstickLine3.setAngle(4 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 4") {
			System.out.println("P4 puts down C4");
			animateChopstick(chopstickLine4, CHOPSTICK4_X, CHOPSTICK4_Y);
			chopstickLine4.setAngle(2 * (Math.PI) / 4);
		} else if (philosopher == "Philosopher 5") {
			System.out.println("P5 puts down C5");
			animateChopstick(chopstickLine5, CHOPSTICK5_X, CHOPSTICK5_Y);
			chopstickLine5.setAngle(4 * (Math.PI) / 4);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource().toString().equals("Philosopher 0")) {
			if (evt.getPropertyName().toString().equals("WithLeftChopstick") &  
					evt.getNewValue().toString().equals("true")) {
				pickUpLeftChopstickString("Philosopher 1");
				philOneLeft = true;
				if (philOneLeft && philOneRight) {
					philOneFed = true;
					philosopher1.getStringShape().setText("I am eating!");
					philosopher1.getLeftArm().setAngle(PHIL_1_LEFT);
					philosopher1.getRightArm().setAngle(PHIL_1_RIGHT);
					System.out.print("P1 is eating");
				}
		}
			if (evt.getPropertyName().toString().equals("WithRightChopstick")
					& evt.getNewValue().toString().equals("true")) {
				philOneRight = true;
				pickUpRightChopstickString("Philosopher 1");
				if (philOneLeft && philOneRight) {
					philOneFed = true;
					philosopher1.getStringShape().setText("I am eating!");
					philosopher1.getLeftArm().setAngle(PHIL_1_LEFT);
					philosopher1.getRightArm().setAngle(PHIL_1_RIGHT);
					System.out.print("P1 is eating");
				}
			}
			if (evt.getPropertyName().toString().equals("WithLeftChopstick")
					& evt.getNewValue().toString().equals("false")) {
				putDownLeftChopstickString("Philosopher 1");
				philosopher1.getStringShape().setText("Almost done!");

			}
			if (evt.getPropertyName().toString().equals("WithRightChopstick")
					& evt.getNewValue().toString().equals("false")) {
				putDownRightChopstickString("Philosopher 1");
				philosopher1.getStringShape().setText("Almost done!");
			}

		if (evt.getSource().toString().equals("Philosopher 0")) {
			if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
				philOneFed = true;
				philOneLeft = false;
				philOneRight = false;
				philosopher1.getStringShape().setText("I am fed");
				miniSpag1.setWidth(0);
				miniSpag1.setHeight(0);
				emptySpag1.setWidth(45);
				emptySpag1.setHeight(37);
				System.out.print("P1 is finished eating");
			}
		}
	}
		if (evt.getSource().toString().equals("Philosopher 1")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") &  
			evt.getNewValue().toString().equals("true")) {
		philTwoLeft = true;
		pickUpLeftChopstickString("Philosopher 2");
		if (philTwoLeft && philTwoRight) {
			philTwoFed = true;
			philosopher2.getStringShape().setText("I am eating!");
			philosopher2.getLeftArm().setAngle(PHIL_2_LEFT);
			philosopher2.getRightArm().setAngle(PHIL_2_RIGHT);
			System.out.print("P2 is eating");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick")
			& evt.getNewValue().toString().equals("true")) {
		philTwoRight = true;
		pickUpRightChopstickString("Philosopher 2");
		if (philTwoLeft && philTwoRight) {
			philTwoFed = true;
			philosopher2.getStringShape().setText("I am eating!");
			philosopher2.getLeftArm().setAngle(PHIL_2_LEFT);
			philosopher2.getRightArm().setAngle(PHIL_2_RIGHT);
			System.out.print("P2 is eating");
		}
	}
		if (evt.getPropertyName().toString().equals("WithLeftChopstick")
				& evt.getNewValue().toString().equals("false")) {
			putDownLeftChopstickString("Philosopher 2");
			philosopher2.getStringShape().setText("Almost done!");
		}
		if (evt.getPropertyName().toString().equals("WithRightChopstick")
				& evt.getNewValue().toString().equals("false")) {
			putDownRightChopstickString("Philosopher 2");
			philosopher2.getStringShape().setText("Almost done!");

	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philTwoFed = true;
		philTwoLeft = false;
		philTwoRight = false;
		philosopher2.getStringShape().setText("I am fed");
		miniSpag2.setWidth(0);
		miniSpag2.setHeight(0);
		emptySpag2.setWidth(45);
		emptySpag2.setHeight(37);
		System.out.print("P2 is finished eating");
	}
}
if (evt.getSource().toString().equals("Philosopher 2")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		philThreeLeft = true;
		pickUpLeftChopstickString("Philosopher 3");
		if (philThreeRight && philThreeLeft) {
			philThreeFed = true;
			philosopher3.getStringShape().setText("I am eating!");
			philosopher3.getLeftArm().setAngle(PHIL_3_LEFT);
			philosopher3.getRightArm().setAngle(PHIL_3_RIGHT);
			System.out.print("P3 is eating");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		philThreeRight = true;
		pickUpRightChopstickString("Philosopher 3");
		if (philThreeRight && philThreeLeft) {
			philThreeFed = true;
			philosopher3.getStringShape().setText("I am eating!");
			philosopher3.getLeftArm().setAngle(PHIL_3_LEFT);
			philosopher3.getRightArm().setAngle(PHIL_3_RIGHT);
			System.out.print("P3 is eating");
		}
	}
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("false")) {
		putDownLeftChopstickString("Philosopher 3");
		philosopher3.getStringShape().setText("Almost done!");
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("false")) {
		putDownRightChopstickString("Philosopher 3");
		philosopher3.getStringShape().setText("Almost done!");
	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philThreeFed = true;
		philThreeLeft = false;
		philThreeRight = false;
		philosopher3.getStringShape().setText("I am fed");
		miniSpag3.setWidth(0);
		miniSpag3.setHeight(0);
		emptySpag3.setWidth(45);
		emptySpag3.setHeight(37);
		System.out.print("P3 is finished eating");
	}
}
if (evt.getSource().toString().equals("Philosopher 3")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		philFourLeft = true;
		pickUpLeftChopstickString("Philosopher 4");
		if (philFourRight && philFourLeft) {
			philFourFed = true;
			philosopher4.getStringShape().setText("I am eating!");
			philosopher4.getLeftArm().setAngle(PHIL_4_LEFT);
			philosopher4.getRightArm().setAngle(PHIL_4_RIGHT);
			System.out.print("P4 is eating");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		philFourRight = true;
		pickUpRightChopstickString("Philosopher 4");
		if (philFourRight && philFourLeft) {
			philFourFed = true;
			philosopher4.getStringShape().setText("I am eating!");
			philosopher4.getLeftArm().setAngle(PHIL_4_LEFT);
			philosopher4.getRightArm().setAngle(PHIL_4_RIGHT);
			System.out.print("P4 is eating");
		}
	}
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("false")) {
		putDownLeftChopstickString("Philosopher 4");
		philosopher4.getStringShape().setText("Almost done!");

	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("false")) {
		putDownRightChopstickString("Philosopher 4");
		philosopher4.getStringShape().setText("Almost done!!");

	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philFourFed = true;
		philFourLeft = false;
		philFourRight = false;
		philosopher4.getStringShape().setText("I am fed");
		miniSpag4.setWidth(0);
		miniSpag4.setHeight(0);
		emptySpag4.setWidth(45);
		emptySpag4.setHeight(37);
		System.out.print("P4 is finished eating");
	}
}
if (evt.getSource().toString().equals("Philosopher 4")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		philFiveLeft = true;
		pickUpLeftChopstickString("Philosopher 5");
		if (philFiveRight && philFiveLeft) {
			philFiveFed = true;
			philosopher5.getStringShape().setText("I am eating!");
			philosopher5.getLeftArm().setAngle(PHIL_5_LEFT);
			philosopher5.getRightArm().setAngle(PHIL_5_RIGHT);
			System.out.print("P5 is eating");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		philFiveRight = true;
		pickUpRightChopstickString("Philosopher 5");

		if (philFiveLeft && philFiveRight) {
			philFiveFed = true;
			philosopher5.getStringShape().setText("I am eating!");
			philosopher5.getLeftArm().setAngle(PHIL_5_LEFT);
			philosopher5.getRightArm().setAngle(PHIL_5_RIGHT);
			System.out.print("P5 is eating");
		}
		}

		if (evt.getPropertyName().toString().equals("WithLeftChopstick")
				& evt.getNewValue().toString().equals("false")) {
			putDownLeftChopstickString("Philosopher 5");
			philosopher5.getStringShape().setText("Almost done!");
		}
		if (evt.getPropertyName().toString().equals("WithRightChopstick")
				& evt.getNewValue().toString().equals("false")) {
			putDownRightChopstickString("Philosopher 5");
			philosopher5.getStringShape().setText("Almost done!");
		}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philFiveFed = true;
		philFiveRight = false;
		philFiveLeft = false;
		philosopher5.getStringShape().setText("I am fed");
		miniSpag5.setWidth(0);
		miniSpag5.setHeight(0);
		emptySpag5.setWidth(45);
		emptySpag5.setHeight(37);
		System.out.print("P5 is finished eating");
	}
}
if (pollingPhilosopher) {
	if (evt.getSource().toString().equals("Chopstick 0")) {
		if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
			// keep looking at chopstick
			if (!philOneFed) {
				philosopher1.getLeftArm().setAngle(60);
				System.out.println("P1 is looking at C1");
				// have thread sleep
			}
			if (!philTwoFed) {
				philosopher2.getLeftArm().setAngle(60);
				System.out.println("P2 is looking at C1");
			}
		}
		if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("false")) {
			// if the philosopher is fed, they do not want to look at the chopstick!
			if (!philOneFed) {
				philosopher1.getLeftArm().setAngle(PHIL_1_LEFT);
				System.out.println("P1 is not looking at C1");
			}
			if (!philTwoFed) {
				philosopher2.getLeftArm().setAngle(PHIL_2_LEFT);
				System.out.println("P2 is not looking at C1");
			}
		}
	}

}
if (waitingPhilosopher) {
	if (evt.getSource().toString().equals("Chopstick 0")) {
		if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
			// if the philosopher is fed, they do not want to look at the chopstick!
			if (!philOneFed) {
				philosopher1.getLeftArm().setAngle(60);
				System.out.println("P1 is looking at C1");
			}
			if (!philTwoFed) {
				philosopher2.getLeftArm().setAngle(60);
				System.out.println("P2 is looking at C1");
			}
		}
		if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("false")) {
		// if the philosopher is fed, they do not want to look at the chopstick!
		if (!philOneFed) {
			philosopher1.getLeftArm().setAngle(PHIL_1_LEFT);
			System.out.println("P1 is not looking at C1");
		}
		if (!philTwoFed) {
			philosopher2.getLeftArm().setAngle(PHIL_2_LEFT);
			System.out.println("P2 is not looking at C1");
		}
	}
	}
if (evt.getSource().toString().equals("Chopstick 1")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		if (!philThreeFed) {
			philosopher3.getRightArm().setAngle(60);
			System.out.println("P3 is looking at C2");
		}
		if (!philTwoFed) {
			philosopher2.getRightArm().setAngle(150);
			System.out.println("P2 is looking at C2");
		}
	}
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("false")) {
		// if the philosopher is fed, they do not want to look at the chopstick!
		if (!philThreeFed) {
			philosopher3.getRightArm().setAngle(PHIL_3_RIGHT);
			System.out.println("P3 is not looking at C2");
		}
		if (!philTwoFed) {
			philosopher2.getRightArm().setAngle(PHIL_2_LEFT);
			System.out.println("P2 is not looking at C2");
		}
	}
}
if (evt.getSource().toString().equals("Chopstick 2")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		if (!philThreeFed) {
			philosopher3.getLeftArm().setAngle(150);
			System.out.println("P3 is looking at C3");
		}
		if (!philFourFed) {
			philosopher4.getRightArm().setAngle(150);
			System.out.println("P4 is looking at C3");
		}

}
if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("false")) {
	if (!philThreeFed) {
		philosopher3.getLeftArm().setAngle(PHIL_3_LEFT);
		System.out.println("P3 is not looking at C3");
	}
	if (!philFourFed) {
		philosopher4.getRightArm().setAngle(PHIL_4_RIGHT);
		System.out.println("P4 is not looking at C3");
	}

}
}
if (evt.getSource().toString().equals("Chopstick 3")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		if (!philFourFed) {
			philosopher4.getLeftArm().setAngle(60);
			System.out.println("P4 is looking at C4");
		}
		if (!philFiveFed) {
			philosopher5.getRightArm().setAngle(150);
			System.out.println("P5 is looking at C4");
		}
}
if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("false")) {
	if (!philFourFed) {
		philosopher4.getLeftArm().setAngle(PHIL_4_LEFT);
		System.out.println("P4 is not looking at C4");
	}
	if (!philFiveFed) {
		philosopher5.getRightArm().setAngle(PHIL_5_RIGHT);
		System.out.println("P5 is not looking at C4");
	}
}
}
if (evt.getSource().toString().equals("Chopstick 4")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		if (!philOneFed) {
			philosopher1.getRightArm().setAngle(150);
			System.out.println("P1 is looking at C5");
		}
		if (!philFiveFed) {
			philosopher5.getLeftArm().setAngle(60);
			System.out.println("P5 is looking at C5");
		}
	}
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("false")) {
		if (!philOneFed) {
			philosopher1.getRightArm().setAngle(PHIL_1_RIGHT);
			System.out.println("P1 is not looking at C5");
		}
		if (!philFiveFed) {
			philosopher5.getLeftArm().setAngle(PHIL_5_LEFT);
			System.out.println("P5 is not looking at C5");
		}
	}
}
}
}
}

