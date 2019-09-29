public class IteratorDemo {
	
	public static void main(String[] args) {
		double[] values = { 1.0, 5.5, 3.2, 2.3, 9.8 };
		CollectionOfDouble colecao = new ListOfDouble(10);
		for (double d : values) {
			colecao.add(d);
		}
		printList(colecao);
	}
	
	public static void printList(CollectionOfDouble collection) {
		System.out.print("Elements: ");
		IteratorOfDouble iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
