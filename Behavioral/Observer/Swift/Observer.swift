
//===----------------------------------------------------------------------===//
// PropertyObserver protocol
//===----------------------------------------------------------------------===//

protocol PropertyObserver {
    
    func willChange(newValue: Any?)
    func didChange(oldValue: Any?)
    
}

//===----------------------------------------------------------------------===//
// Observer
//===----------------------------------------------------------------------===//

class WeatherObserver: PropertyObserver {
    
    func willChange(newValue: Any?) {
        guard let newWeather = newValue as? String else { return }
        if newWeather == "rain" {
            print("I think there will be a rain pretty soon, I should take an umbrella.")
        } else {
            print("The weatherman said there won't be any rain today, I can leave my umbrella at home.")
        }
    }
    func didChange(oldValue: Any?) {
        guard let oldWeather = oldValue as? String else { return }
        if oldWeather == "rain" {
            print("Rain has passed, I don't need my umbrella anymore.")
        } else {
            print("It hasn't been raining lately, I think I will take an umbrella.")
        }
    }
    
}

//===----------------------------------------------------------------------===//
// Day
//===----------------------------------------------------------------------===//

class Day {
    
    let weatherObserver = WeatherObserver()
    var weather: String = "sunny" {
        willSet { weatherObserver.willChange(newValue: newValue) }
        didSet { weatherObserver.didChange(oldValue: oldValue) }
    }
    
}

//===----------------------------------------------------------------------===//
// Demo
//===----------------------------------------------------------------------===//

let day = Day()
var newWeather: String = ""

newWeather = "rain"
print("\(day.weather) -> \(newWeather)")
day.weather = newWeather

newWeather = "cloudy"
print("\n" + "\(day.weather) -> \(newWeather)")
day.weather = newWeather
