# Abstract Factory

Has primary responsibility for reducing the use of `new`, this pattern provide a interface to create a family objects.

How in example we have a family of Car( Minivan and Pickups ), but can have several implementations how:

- ToyotaFactory
- GMCFactory

With this pattern we can create any CarFactory, just implemented it.

See follow classes:

- `FactoryCar`
- `MiniVan`
- `Pickup`
- Implementations for `Minivan` and `Pickup`
- `GMCFactory`
- `ToyotaFactory`