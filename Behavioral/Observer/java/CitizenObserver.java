public class CitizenObserver implements WeatherObserver {
    @Override
    public void notify(WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                System.out.println("Dress warmly");
                break;
            case SUNNY:
                System.out.println("Put On The Glasses");
                break;
            case RAINY:
                System.out.println("Take an umbrella");
                break;
            case WINDY:
                System.out.println("Hold your hat");
                break;
            default:
                System.out.println("Citizen doesn't know about this kind of weather");
        }
    }
}
