// Defining Builder protocol

protocol Builder {
    func test()
    func lint()
    func assemble()
    func deploy()
}

extension Builder {
    func build() {
        self.test()
        self.lint()
        self.assemble()
        self.deploy()
    }
}

// Defining Classes that implment Builder protocol

class AndroidBuilder: Builder {
    func test() {
        print("Running android tests")
    }

    func lint() {
        print("Linting the android code")
    }

    func assemble() {
        print("Assembling the android build")
    }

    func deploy() {
        print("Deploying android build to Google Play")
    }
}

class IosBuilder: Builder {
    func test() {
        print("Running iOS tests")
    }

    func lint() {
        print("Linting the iOS code")
    }

    func assemble() {
        print("Assembling the iOS build")
    }

    func deploy() {
        print("Deploying iOS build to AppStore")
    }
}

// Initialize Builders

AndroidBuilder().build()

// Output
// ------
// Running android tests
// Linting the android code
// Assembling the android build
// Deploying android build to Google Play

IosBuilder().build()

// Output
// ------
// Running iOS tests
// Linting the iOS code
// Assembling the iOS build
// eploying iOS build to AppStore
