public class RestaurantObserver implements WeatherObserver {
    @Override
    public void notify(WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                System.out.println("Turn on heating");
                break;
            case SUNNY:
                System.out.println("Open the terrace");
                break;
            case RAINY:
                System.out.println("Make some hot drinks for the clients");
                break;
            case WINDY:
                System.out.println("Close the terrace");
                break;
            default:
                System.out.println("Restaurant doesn't know about this kind of weather");
        }
    }
}
