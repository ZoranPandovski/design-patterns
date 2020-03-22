interface Repository<T, K> {
  store(data: T): void
  getBy(param: string, value: K): T | null
  listAll(): Array<T>
}

// layer to persist db: use array in this example
abstract class RepositoryDefault<T, K> implements Repository<T, K> {
  private _items: Array<T> = new Array<T>()

  public store(data: T): void {
    this._items.push(data)
  }

  public getBy(param: string, value: K): T | null {
    const el: T | undefined = this._items.find((element: any) => element[param] === value)
    return el === undefined ? null: el
  }

  public listAll(): Array<T> {
    return this._items
  }
}

class ProductRepository extends RepositoryDefault<Product, number> {
  public createNewProduct(data: Product) {
    this.store(data)
  }

  public getProductById(id: number): Product | null {
    return this.getBy('id', id)
  }

  public listAllProducts(): Array<Product> {
    return this.listAll()
  }

  // other methods more specifics
}

class Product {
  constructor(private _id: number, private _title: string, private _price: number) {}

  public get id(): number { return this._id }

  public set id(value: number) { this._id = value }

  public get title(): string { return this._title }

  public set title(value: string) { this._title = value }

  public get price(): number { return this._price }

  public set private(value: number) { this._price = value }
}

const repository: ProductRepository = new ProductRepository()

repository.createNewProduct(new Product(1, 'Coffe Starbucks', 7.50))
repository.createNewProduct(new Product(2, 'Cheetos', 6.50))
repository.createNewProduct(new Product(3, 'Doritos', 10.50))

console.log(repository.getProductById(3)) // { "_id": 3, "_title": "Doritos", "_price": 10.5 }
