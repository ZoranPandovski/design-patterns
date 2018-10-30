import java.util.List;

public interface Repository<T> {

	public void add(T object);
	public void remove(int i);
	public List<T> getAll();
	public T getSpecific(int i);
}