
public class ListOfDoubleIterator implements IteratorOfDouble {
	private ListOfDouble list;
	private int index;

	public ListOfDoubleIterator(ListOfDouble list) {
		this.list = list;
		index=0;
	}

	public double next() {
		return list.getElement(index++);
	}

	public boolean hasNext() {
		return index < list.size();
	}
}
