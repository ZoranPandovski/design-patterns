public class FitaInfantil implements TipoFita{   
    @Override
    public double calculaPrecoFita(int diasAlugada) {
       double valorCorrente = 1.5;
        if(diasAlugada > 3) {
                valorCorrente += (diasAlugada - 3) * 1.5;
        }
        return valorCorrente;
    }
}
