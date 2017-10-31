
//
// This is a simple facade to reading remote resources, where the "remote" is a simple string for S3 or Azure.
//
//

import std.stdio : writeln;

// Abstract acting as a facade to the backend. It could easily be a normal class
// that has the remote resources as members, to act as a facade.
abstract class Resource {
private:
  int type;

public:
  this(int type) {
    this.type = type;
  }

  @property {
    int getType() {
      return type;
    }
  }

  abstract protected string read();
}

class RemoteS3Resource : Resource {
  this() {
    super(1);
  }
  override protected string read() {
    return "Reading from remote s3 resource";
  }
}

class RemoteAzureResource : Resource {
  this() {
    super(2);
  }
  override protected string read() {
    return "Reading from remote azure resource";
  }
}

void main() {
   Resource[2] resources = [new RemoteS3Resource(), new RemoteAzureResource()];
   foreach (resource; resources) {
     writeln(resource.read());
   }
}
