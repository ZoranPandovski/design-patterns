import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryDefault<T> implements Repository<T> {

	public void add(T object) {
		
	};
	public void remove(int i) {
		
	};
	public List<T> getAll(){
		
		return new ArrayList<T>();
	};
	public T getSpecific(int i) {

		return null;
	};

}
