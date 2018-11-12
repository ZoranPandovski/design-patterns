interface ICatSoundBehaviour {
	void makeSound();
}

class CatSound implements ICatSoundBehaviour {

	@Override
	public void makeSound() {
		System.out.println("Meow");
	}

}

class CatRelaxSound implements ICatSoundBehaviour {

	@Override
	public void makeSound() {
		System.out.println("Prrr");
	}

}

class Cat {

	ICatSoundBehaviour catSound;

	public Cat() {
		catSound = new CatSound();
	}

	public void makeSound() {
		this.catSound.makeSound();
	}

	public void setCatSound(ICatSoundBehaviour catSound) {
		this.catSound = catSound;
	}

}

public class Delegation {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.makeSound(); // Meow
		cat.setCatSound(new CatRelaxSound());
		cat.makeSound(); // Prrr
	}
}
