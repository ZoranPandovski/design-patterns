public class ObserverDesignPattern {
    public static void main(String[] args) {
        //Create a new subject
        WeatherSubject weatherSubject = new WeatherSubject();

        //Register the observers
        weatherSubject.registerObserver(new CitizenObserver());
        weatherSubject.registerObserver(new RestaurantObserver());

        //Change the current weather, notifying the appropriate observers
        for (WeatherType weatherType : WeatherType.values()) {
            weatherSubject.setCurrentWeatherType(weatherType);
        }
    }
}
