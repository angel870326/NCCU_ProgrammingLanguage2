
public class TriangleDrawable implements Drawable {

	private char marker;
	
	@Override
	public void setMarker(char marker) {
		// TODO Auto-generated method stub
		this.marker = marker;

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		// ref. Lab5
		int layer = 4;
		for(int i = 1; i <= layer; i++) {
			for(int j = 1; j <= layer - i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= 2*i - 1; k++) {
				System.out.print(this.marker);
			}
			System.out.println();
		}



	}

}
