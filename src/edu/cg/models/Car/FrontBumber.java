package edu.cg.models.Car;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import edu.cg.models.IRenderable;
import edu.cg.models.SkewedBox;

public class FrontBumber implements IRenderable {
	// TODO: Add fields as you like (and methods if you think they are necessary).
	private SkewedBox bumperWing1 = new SkewedBox(Specification.F_BUMPER_LENGTH, Specification.F_BUMPER_WINGS_HEIGHT_1,
			Specification.F_BUMPER_WINGS_HEIGHT_2, Specification.F_BUMPER_WINGS_DEPTH, Specification.F_BUMPER_WINGS_DEPTH);
	private SkewedBox bumperWing2 = new SkewedBox(Specification.F_BUMPER_LENGTH, Specification.F_BUMPER_WINGS_HEIGHT_1,
			Specification.F_BUMPER_WINGS_HEIGHT_2, Specification.F_BUMPER_WINGS_DEPTH, Specification.F_BUMPER_WINGS_DEPTH);
	private SkewedBox bumperBox = new SkewedBox(Specification.F_BUMPER_LENGTH, Specification.F_BUMPER_HEIGHT_1,Specification.F_BUMPER_HEIGHT_2, Specification.F_BUMPER_DEPTH, Specification.F_BUMPER_DEPTH);
	@Override
	public void render(GL2 gl) {
		// TODO: Render the front bumper relative to it's local coordinate system.
		// Remember the dimensions of the bumper, this is important when you
		// combine the bumper with the hood.
		gl.glPushMatrix();
		double bumpLength = Specification.F_BUMPER_LENGTH;
		// Render hood - Use Red Material.
		float[] green = {0,255,2};
		Materials.SetMetalMaterial(gl,green);
		gl.glTranslated(-bumpLength / 2.0 + Specification.F_BUMPER_LENGTH/2 + Specification.TIRE_RADIUS*2 + 0.02, -0.03, 0.02 - Specification.PAIR_OF_WHEELS_ROD_DEPTH/2 - Specification.TIRE_DEPTH / 2 );
		bumperWing1.render(gl);
		gl.glTranslated(-bumpLength / 2.0 + Specification.F_BUMPER_LENGTH / 2.0, 0, Specification.PAIR_OF_WHEELS_ROD_DEPTH + Specification.TIRE_DEPTH - 0.02);
		bumperWing2.render(gl);
		gl.glTranslated(0, 0, -Specification.PAIR_OF_WHEELS_ROD_DEPTH/2 -Specification.TIRE_DEPTH/2 +0.01);
		bumperBox.render(gl);

		gl.glPopMatrix();
	}

	@Override
	public void init(GL2 gl) {
	}

	@Override
	public String toString() {
		return "FrontBumper";
	}

}
