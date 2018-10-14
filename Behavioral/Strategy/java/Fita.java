
public class Fita {
    private TipoFita tipo;
    private String titulo;
    public Fita(String titulo, TipoFita tipo) { 
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() { 
        return titulo;
    }
    
    public double getValor(int diasAlugada) {
        return this.tipo.calculaPrecoFita(diasAlugada);
    }
}
