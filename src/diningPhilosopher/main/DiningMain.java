package diningPhilosopher.main;

import bus.uigen.ObjectEditor;
import diningPhilosopher.factories.DiningControllerFactory;
import diningPhilosopher.factories.SceneFactory;

public class DiningMain {


	public static void main(String[] args) {
		// ShapeObjectAdapter.setUseTreeIndexForZIndex(false);
		ObjectEditor.confirmSelectedMethodParameters(false);
		SceneFactory.getSingleton();

		DiningControllerFactory.getSingleton().processInput();

	}
	
}
