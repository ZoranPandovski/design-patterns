class Singleton {

    // The singleton instance
    static let sharedInstance = Singleton()
    
    private init() {
        // Private init prevents creation of other instances
    }
    
}
