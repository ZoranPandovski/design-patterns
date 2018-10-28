import java.util.List;

public interface ProductRepository extends Repository<Product> {

	public List<Product> expiredProducts();
}
