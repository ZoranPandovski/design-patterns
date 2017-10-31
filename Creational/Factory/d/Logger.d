
import std.stdio : writeln;

class GenericLogger {
private:
  string theClass;
public:
  this(string theClass) {
    this.theClass = theClass;
  }

  void info(string s) {
    writeln(theClass ~ ": INFO: " ~ s);
  }
}

//
// A simple factory that is used to track the source of a log message.
// 
class LoggerFactory {
public:
  static GenericLogger getLogger(string theClass) {
    return new GenericLogger(theClass);
  }
}

void main() {
  GenericLogger log = LoggerFactory.getLogger("Logger.d");
  log.info("This is a log message");
}
