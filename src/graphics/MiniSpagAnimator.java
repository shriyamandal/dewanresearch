package graphics;

import bus.uigen.shapes.OEShapeModel;
import util.misc.ThreadSupport;

public class MiniSpagAnimator implements MiniSpagAnimatorInterface {

	public synchronized void shrinkMiniSpag(OEShapeModel miniSpag) {

		// 45 width, 37 height
		int lastHeight = miniSpag.getHeight();
		int lastWidth = miniSpag.getWidth();

		for (int i = 0; i < 15; i++) {
			miniSpag.setHeight(lastHeight - 2);
			miniSpag.setWidth(lastWidth - 3);
			ThreadSupport.sleep(100);
			lastHeight = miniSpag.getHeight();
			lastWidth = miniSpag.getWidth();
			System.out.println(lastHeight + "," + lastWidth);
		}
		// miniSpag.setHeight(0);
		// miniSpag.setWidth(0);
	}
}
