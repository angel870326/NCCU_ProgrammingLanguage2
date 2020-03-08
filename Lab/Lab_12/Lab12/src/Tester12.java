
public class Tester12 {

	public static void main(String[] args) {

		// Rectangle
		System.out.println("Rectangle: \n");
		RectangleDrawable rectangleDrawable = new RectangleDrawable();
		rectangleDrawable.setMarker('$');
		rectangleDrawable.draw();
		
		// Triangle
		System.out.println("\nTriangle: \n");
		TriangleDrawable triangleDrawable = new TriangleDrawable();
		triangleDrawable.setMarker('$');
		triangleDrawable.draw();	
		
		// Circle
		System.out.println("\nCircle: \n");
		CircleDrawable circleDrawable = new CircleDrawable();
		circleDrawable.setMarker('$');
		circleDrawable.draw();

	}

}
