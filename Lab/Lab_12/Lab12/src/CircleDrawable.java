
public class CircleDrawable implements Drawable {
	
	private char marker;

	@Override
	public void setMarker(char marker) {
		// TODO Auto-generated method stub
		this.marker = marker;

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		// ref. Bonus1
		int x = 4;
		int y = 4;
		int r = 4;
		int layer = r * 2;
		for(int i = 0; i <= layer; i++) {
			for(int j = 0; j <= layer; j++) {
				if((i - x)*(i - x) + (j - y)*(j - y) <= r * r) {
					System.out.print(this.marker);
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
