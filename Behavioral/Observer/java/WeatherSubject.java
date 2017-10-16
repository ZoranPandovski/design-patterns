import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeatherSubject {

    private List<WeatherObserver> weatherObservers = new ArrayList<>();

    private WeatherType currentWeatherType;

    public void registerObserver(WeatherObserver weatherObserver) {
        weatherObservers.add(weatherObserver);
    }

    public void unregisterObserver(WeatherObserver weatherObserver) {
        weatherObservers.remove(weatherObserver);
    }

    public void setCurrentWeatherType(WeatherType currentWeatherType) {
        this.currentWeatherType = currentWeatherType;
        System.out.println(String.format("The weather is changed to %s. Notifying the observers", currentWeatherType));
        notifyObservers();
    }

    private void notifyObservers() {
        Optional.ofNullable(currentWeatherType)
                .ifPresent(cwt -> weatherObservers.forEach(wo -> wo.notify(cwt)));
    }
}
