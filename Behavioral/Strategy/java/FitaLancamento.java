public class FitaLancamento implements TipoFita{
    @Override
    public double calculaPrecoFita(int diasAlugada) {
       return diasAlugada * 3;   
    }
}
