public class FitaNormal implements TipoFita {
    @Override
    public double calculaPrecoFita(int diasAlugada) {
     double valorCorrente = 2;
        if(diasAlugada > 2) {
            valorCorrente += (diasAlugada - 2) * 1.5;
        }
        return valorCorrente;
    }
}
