public class MethodChaining {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();

		System.out.println(rect1);
		//This is a 0.0x0.0 Rectangle

		System.out.println(rect2.setWidth(5).setHeight(2));
		//This is a 5.0x2.0 Rectangle
	}

	public static class Rectangle {
		private static final double DEFAULT_WIDTH = 0;
		private static final double DEFAULT_HEIGHT = 0;

		private double width;
		private double height;

		public Rectangle() {
			height = DEFAULT_WIDTH;
			width = DEFAULT_HEIGHT;
		}

		public Rectangle setWidth(double width) {
			this.width = width;
			return this;
		}

		public Rectangle setHeight(double height) {
			this.height = height;
			return this;
		}


		public String toString() {
			return "This is a "+width+"x"+height+" Rectangle";
		}

	}
}