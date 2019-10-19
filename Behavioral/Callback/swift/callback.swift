class NetworkRequester {
    func performRequest(completion: (Result<Int, NetworkError>) -> Void) {
        // perform async operation
        // and call `completion` when process finishes
        // with result value
        completion(.success(1))
    }
}

enum NetworkError: Error {
    case notFound
}

class Client {

    private let requester: NetworkRequester = NetworkRequester()

    func getAsyncData() {
        requester.performRequest { result in
            switch result {
            case .success(let value):
                print(value)
            case .failure(let error):
                print(error)
            }
        }
    }
}

Client().getAsyncData()
