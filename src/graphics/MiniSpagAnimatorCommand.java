package graphics;

import bus.uigen.shapes.OEShapeModel;

public class MiniSpagAnimatorCommand implements Runnable {
	MiniSpagAnimator animatorFinal;
	OEShapeModel miniSpagFinal;

	public MiniSpagAnimatorCommand(MiniSpagAnimator miniSpagAnimatorFinal, OEShapeModel miniSpag) {
		animatorFinal = miniSpagAnimatorFinal;
		miniSpagFinal = miniSpag;
	}

	public void run() {
		animatorFinal.shrinkMiniSpag(miniSpagFinal);
	}
}