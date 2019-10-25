// Defining Chain protocol

protocol Chain {
    var nextManagementLevel: Chain? { get set }
    var responsibleForAmountUntil: Float { get set }
}

extension Chain {
    func shouldApproveExpenditure(amount: Float) {
        guard amount > 0 else {
            print("Only amount bigger than zero can be checked")
            return
        }

        if canApprove(amount) {
            print("\(self) can approve this expenditure")
        } else if let nextManagementLevel = nextManagementLevel {
            nextManagementLevel.shouldApproveExpenditure(amount: amount)
        } else {
            print("None can approve this expenditure :(")
        }
    }

    func canApprove(_ amount: Float) -> Bool {
        return responsibleForAmountUntil >= amount
    }
}

// Defining Classes that implment Chain protocol

class Boss: Chain {
    private var _nextManagementLevel: Chain?
    var nextManagementLevel: Chain? {
        set {
            _nextManagementLevel = newValue
        }
        get {
            return _nextManagementLevel
        }
    }

    private var _responsibleForAmountUntil: Float
    var responsibleForAmountUntil: Float {
        set {
            _responsibleForAmountUntil = newValue
        }
        get {
            return _responsibleForAmountUntil
        }
    }

    init(responsibleForAmount until: Float, ledBy: Chain?) {
        self._responsibleForAmountUntil = until
        self._nextManagementLevel = ledBy
    }
}

class CEO : Chain {
    private var _nextManagementLevel: Chain?
    var nextManagementLevel: Chain? {
        set {
            _nextManagementLevel = newValue
        }
        get {
            return _nextManagementLevel
        }
    }

    private var _responsibleForAmountUntil: Float
    var responsibleForAmountUntil: Float {
        set {
            _responsibleForAmountUntil = newValue
        }
        get {
            return _responsibleForAmountUntil
        }
    }

    init(responsibleForAmount until: Float, ledBy: Chain?) {
        self._responsibleForAmountUntil = until
        self._nextManagementLevel = ledBy
    }
}

class Employee : Chain {
    private var _nextManagementLevel: Chain?
    var nextManagementLevel: Chain? {
        set {
            _nextManagementLevel = newValue
        }
        get {
            return _nextManagementLevel
        }
    }

    private var _responsibleForAmountUntil: Float
    var responsibleForAmountUntil: Float {
        set {
            _responsibleForAmountUntil = newValue
        }
        get {
            return _responsibleForAmountUntil
        }
    }

    init(responsibleForAmount until: Float, ledBy: Chain?) {
        self._responsibleForAmountUntil = until
        self._nextManagementLevel = ledBy
    }
}

// Initialize the chain
let ceo = CEO(responsibleForAmount: 100_000, ledBy: nil)
let boss = Boss(responsibleForAmount: 10_000, ledBy: ceo)
let employee = Employee(responsibleForAmount: 1_000, ledBy: boss)

// Try to approve expenditures
employee.shouldApproveExpenditure(amount: 10)
employee.shouldApproveExpenditure(amount: 1_000)
employee.shouldApproveExpenditure(amount: 5_000)
employee.shouldApproveExpenditure(amount: 15_000)
employee.shouldApproveExpenditure(amount: 150_000)

// Output will be
// ==============
// Employee can approve this expenditure
// Employee can approve this expenditure
// Boss can approve this expenditure
// CEO can approve this expenditure
// None can approve this expenditure :(
