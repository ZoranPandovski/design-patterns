import Foundation

//                            +-----------------+
//                            |   Object using  |
//                            |     Strategy    |
//                            +-------+---------+
//                                    |
//                                    v
//                            +-----------------+
//                            |   <<protocol>>  |
//          +---------------->|    Strategy     |<-------------+
//          |                 |    Protocol     |              |
//          |                 +-----------------+              |
//          |                          ^                       |
//          |                          |                       |
//   +------+----------+      +--------+--------+    +---------+-------+
//   |    Concrete     |      |     Concrete    |    |     Concrete    |
//   |   Strategy 1    |      |    Strategy 2   |    |    Strategy 3   |
//   +-----------------+      +-----------------+    +-----------------+
//
// What: A protocol that defines the action that we want to encapsulate. In our example, the action would be log a message.
// Who: An object who contains an object who conforms the strategy. In our example, it could be an object who using the strategy log the message.
// How: Specific implementations of the strategy. Each implementation is different. In our example, we would have three strategies, one for each style.
//

// What
protocol LoggerStrategy {
    func log(_ message: String)
}

// Who
struct Logger {
    let strategy: LoggerStrategy

    func log(_ message: String) {
        strategy.log(message)
    }
}

// How
struct LowercaseStrategy: LoggerStrategy {
    func log(_ message: String) {
        print(message.lowercased())
    }
}

struct UppercaseStrategy: LoggerStrategy {
    func log(_ message: String) {
        print(message.uppercased())
    }
}

struct CapitalizedStrategy: LoggerStrategy {
    func log(_ message: String) {
        print(message.capitalized)
    }
}

// Initialize Logs

var logger = Logger(strategy: CapitalizedStrategy())
logger.log("my first strategy")  // Output My First Strategy

logger = Logger(strategy: UppercaseStrategy())
logger.log("my first strategy")  // MY FIRST STRATEGY

logger = Logger(strategy: LowercaseStrategy())
logger.log("my first strategy")  // my first strategy
