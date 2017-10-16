import java.util.ArrayList;
import java.util.List;


interface Subject {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();

}

interface Observer {
	public void update(boolean inStock);
}


class Dress implements Subject {
	
	private List<Observer> observers;
	private boolean inStock = false;
	
	public Dress(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		observers.remove(o);
	}
	
	public void notifyObserver(){
		for(Observer obs:observers){
			obs.update(inStock);
		}
	}

	public void inStock(boolean inStock){
		this.inStock = inStock;
		notifyObserver();
	}
}

class User implements Observer{
	
	private Dress d;
	private boolean isinStock;
	
	public User(Dress d ){
		this.d = d;
		d.registerObserver(this);
	}
	
	public void update(boolean inStock){
		this.isinStock=inStock;
		if(inStock ==true){
			display();
		}
	}
	
	public void display(){
		System.out.println("Dress back in Stock");
	}
	

}


public class ObserverDemo {
	
	public static void main (String[]args){
		Dress dress= new Dress();
		User anne = new User(dress);
		dress.inStock(true);
		}

}
