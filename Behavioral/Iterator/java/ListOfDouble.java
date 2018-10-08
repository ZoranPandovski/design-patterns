
public class ListOfDouble implements CollectionOfDouble {
	private double[] elements;
	private int pointer; // point the first empty slot in the array

	public ListOfDouble(int size) {
		elements = new double[size];
		pointer = 0;
	}

	public void add(double x) {
		elements[pointer++] = x;
	}

	public int size() {
		return pointer;
	}

	public double getElement(int index) {
		return elements[index];
	}

	public IteratorOfDouble iterator() {
		return new ListOfDoubleIterator(this);
	}
}
