//
//  Builder.swift
//  
//
//  Created by Alexey Ivanov on 15.10.2020.
//

import Foundation

//lets build https://google.com/search?q=builder%20pattern url

var urlComponents = URLComponents()
urlComponents.host = "google.com"
urlComponents.scheme = "https"
urlComponents.path = "/search"
urlComponents.queryItems = [URLQueryItem(name: "q", value: "builder pattern")]

//https://google.com/search?q=builder%20pattern
urlComponents.url

//classic builder pattern
class ClassicURLBuilder {
    private var components = URLComponents()
    
    func set(scheme: String) -> Self {
        components.scheme = scheme
        return self
    }
    
    func set(path: String) -> Self {
        components.path = path
        return self
    }
    
    func set(host: String?) -> Self {
        components.host = host
        return self
    }
    
    func set(queryItems: [URLQueryItem]?) -> Self {
        components.queryItems = queryItems
        return self
    }
    
    func set(port: Int?) -> Self {
        components.port = port
        return self
    }
    //etc
    
    func build() -> URL? {
        components.url
    }
}
//https://google.com/search?q=builder%20pattern
ClassicURLBuilder()
    .set(host: "google.com")
    .set(path: "/search")
    .set(queryItems: [.init(name: "q", value: "builder pattern")])
    .set(scheme: "https")
    .build()

//Closure style builder
extension URLComponents {
    static func build(_ f: ((inout URLComponents) -> Void)) -> URL? {
        var urlComponents = URLComponents()
        f(&urlComponents)
        return urlComponents.url
    }
}

//https://google.com/search?q=builder%20pattern
URLComponents.build {
    $0.host = "google.com"
    $0.path = "/search"
    $0.scheme = "https"
    $0.queryItems = [.init(name: "q", value: "builder pattern")]
}

