
/**
 * A simple domain class
 */
class Rectangle{

	protected int width;
	protected int height;
	
	private Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public String describe() {
		return "I'm a rectangle, my width=" + width + " and my height=" + height;
	}
	
	//-- Flow-API for creation
	/**
	 * Builder designed as flowent api builder.
	 * 
	 */
	static class RectangleFl extends Rectangle{
		
		public static int DEFAULT_HIGHT = 1;
		public static int DEFAULT_WIDTH = 1;
		
		private boolean makeAsSquare = false;
		
		private RectangleFl() {
			super(DEFAULT_WIDTH, DEFAULT_HIGHT);
		}
		
		public static RectangleFl newRectangle() {
			return new RectangleFl();
		}
		
		/**
		 * Create a special rectangle with equal height and width.
		 * During the creation process, this builder ensures equity of with and height.
		 * @return
		 */
		public static RectangleFl newSquare() {
			RectangleFl rectangle = new RectangleFl();
			rectangle.width = DEFAULT_WIDTH;
			rectangle.height = DEFAULT_HIGHT;
			rectangle.makeAsSquare = true;
			return rectangle;
		}
		
		public RectangleFl withHeight(int height) {
			this.height = height;
			if (this.makeAsSquare) {
				/*
				 * In this example, the method ensured equal width for squares.
				 * An other option can be throwing a exception.
				 */
				this.width = this.height;
			}
			return this;
		}
		
		public RectangleFl withWidth(int width) {
			this.width = width;
			if (this.makeAsSquare) {
				this.height = this.width;
			}
			return this;
		}
	}
}

/**
 * Little application uses the Builder.
 */
public class CreationWithFlowApi {

	public static void main(String[] args) {
		Rectangle newRectangle = RectangleFl.newRectangle().withHeight(5).withWidth(7);
		// now there are no creation elements available
		// the Rectangle-Instance newRectangle is a pure Rectangle
		// and there is no knowledge to the builder
		//newRectangle.withWidth(5); // will not compile
		System.out.println(newRectangle.describe());
		
		Rectangle secondRectangle = RectangleFl.newSquare().withHeight(4);
		System.out.println(secondRectangle.describe()); // write down height AND width to 4
	}
}
