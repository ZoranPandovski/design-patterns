package com.rj.designPatterns.Builder;

// Builder Design Pattern
public class Box {
	private int height, width, length;
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getLength() {
		return length;
	}
	@Override
	public String toString() {
		return "Box [height=" + height + ", width=" + width + ", length=" + length + "]";
	}
	private Box(BoxBuilder b) throws Exception {
		if (b.height == 0 || b.width == 0) {
			throw new Exception("Height and Width necessary..");
		}
		this.height = b.height;
		this.width = b.width;
		this.length = b.length;
	}
	public static class BoxBuilder {
		private int height, width, length;

		public BoxBuilder setHeight(int height) {
			this.height = height;
			return this;
		}

		public BoxBuilder setWidth(int width) {
			this.width = width;
			return this;
		}

		public BoxBuilder setLength(int length) {
			this.length = length;
			return this;
		}
		
		public Box buildBox() throws Exception {
			return new Box(this);
		}
	}
}
