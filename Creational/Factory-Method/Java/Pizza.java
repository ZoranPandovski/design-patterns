public class Pizza{

    private int rebanadas;
    private String especialidad;

    public Pizza(int rebanadas, String especialidad){
        this.rebanadas = rebanadas;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Rebanadas: "+this.rebanadas+" Especialidad: "+this.especialidad;
    }

}
