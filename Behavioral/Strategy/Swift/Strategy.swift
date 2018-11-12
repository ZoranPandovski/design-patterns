
//===----------------------------------------------------------------------===//
// Writer
//===----------------------------------------------------------------------===//

class Writer {
    
    private let strategy: WritingStrategy
    init(strategy: WritingStrategy) {
        self.strategy = strategy
    }
    
    func write(_ string: String) {
        strategy.write(string)
    }
    
}

//===----------------------------------------------------------------------===//
// WritingStrategy protocol
//===----------------------------------------------------------------------===//

protocol WritingStrategy {
    
    func write(_ string: String)
    
}

//===----------------------------------------------------------------------===//
// Strategies
//===----------------------------------------------------------------------===//

struct ConsoleStrategy: WritingStrategy {
    
    func write(_ string: String) {
        print(string)
    }
    
}
var array: [String] = []
struct GlobalArrayStrategy: WritingStrategy {
    
    func write(_ string: String) {
        array.append(string)
    }
    
}

//===----------------------------------------------------------------------===//
// Demo
//===----------------------------------------------------------------------===//

let consoleWriter = Writer(strategy: ConsoleStrategy())
consoleWriter.write("This message goes to console.")

let globalArrayWriter = Writer(strategy: GlobalArrayStrategy())
globalArrayWriter.write("While this message goes to global array.")
print(array)

