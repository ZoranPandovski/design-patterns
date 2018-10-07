import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


public class Cliente {
	private String nome;
	private Collection fitasAlugadas = new Vector();

	public Cliente(String nome) { 
		this.nome = nome;
	}
	
	public String getNome() { 
		return nome;
	} 
	
	public void adicionaAluguel(Aluguel aluguel) {
		fitasAlugadas.add(aluguel);
	}
	
	public String extrato() { 
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0; 
		int pontosDeAlugadorFrequente = 0;

		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
		
		Iterator alugueis = fitasAlugadas.iterator();
		while(alugueis.hasNext()) {
			double valorCorrente = 0.0;
			
			Aluguel cada = (Aluguel)alugueis.next();
			
			valorCorrente = cada.getValor();

			resultado += cada.getTituloFita() + ":" + valorCorrente + fimDeLinha;
			valorTotal += valorCorrente;
		} // fim do while
		
		resultado += "Valor total devido: " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos" + fimDeLinha;
		
		return resultado;
	}
}
