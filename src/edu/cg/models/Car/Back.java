package edu.cg.models.Car;

import java.util.LinkedList;
import java.util.List;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import edu.cg.algebra.Point;
import edu.cg.models.BoundingSphere;
import edu.cg.models.IIntersectable;
import edu.cg.models.IRenderable;
import edu.cg.models.SkewedBox;

public class Back implements IRenderable, IIntersectable {
	private SkewedBox baseBox = new SkewedBox(Specification.B_BASE_LENGTH, Specification.B_BASE_HEIGHT,
			Specification.B_BASE_HEIGHT, Specification.B_BASE_DEPTH, Specification.B_BASE_DEPTH);
	private SkewedBox backBox = new SkewedBox(Specification.B_LENGTH, Specification.B_HEIGHT_1,
			Specification.B_HEIGHT_2, Specification.B_DEPTH_1, Specification.B_DEPTH_2);
	private PairOfWheels wheels = new PairOfWheels();
	private Spolier spoiler = new Spolier();

	@Override
	public void render(GL2 gl) {
		gl.glPushMatrix();
		Materials.SetBlackMetalMaterial(gl);
		gl.glTranslated(Specification.B_LENGTH / 2.0 - Specification.B_BASE_LENGTH / 2.0, 0.0, 0.0);
		baseBox.render(gl);
		Materials.SetRedMetalMaterial(gl);
		gl.glTranslated(-1.0 * (Specification.B_LENGTH / 2.0 - Specification.B_BASE_LENGTH / 2.0),
				Specification.B_BASE_HEIGHT, 0.0);
		backBox.render(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslated(-Specification.B_LENGTH / 2.0 + Specification.TIRE_RADIUS, 0.5 * Specification.TIRE_RADIUS,
				0.0);
		wheels.render(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslated(-Specification.B_LENGTH / 2.0 + 0.5 * Specification.S_LENGTH,
				0.5 * (Specification.B_HEIGHT_1 + Specification.B_HEIGHT_2), 0.0);
		spoiler.render(gl);
		gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
		float[] exhaustPipeColor = {0,6,230};
		Materials.SetMetalMaterial(gl, exhaustPipeColor);
		gl.glTranslated(-0.025,-0.1,-0.1);
		GLU glu = new GLU();
		GLUquadric quad = glu.gluNewQuadric();
		glu.gluCylinder(quad,0.02,0.02,0.1,10,10);
		gl.glTranslated(0.08,0.0,0);
		glu.gluCylinder(quad,0.02,0.02,0.1,10,10);
		gl.glPopMatrix();


	}

	@Override
	public void init(GL2 gl) {

	}

	@Override
	public List<BoundingSphere> getBoundingSpheres() {
		// TODO: Return a list of bounding spheres the list structure is as follow:
		// s1
		// where:
		// s1 - sphere bounding the car front
		LinkedList<BoundingSphere> res = new LinkedList<BoundingSphere>();
		Point temp = new Point(-0.44, 0.056, 0.0);
		BoundingSphere s1 = new BoundingSphere(0.42, temp);
		s1.setSphereColore3d(0,0,255);
		res.add(s1);
		return res;
	}

}
