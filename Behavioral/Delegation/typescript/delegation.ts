interface ISoundBehaviour {
  makeSound: () => void;
}

class CatSound implements ISoundBehaviour {
  makeSound() {
    console.log("Meow");
  }
}

class CatRelaxSound implements ISoundBehaviour {
  makeSound() {
    console.log("Prrrrrr");
  }
}

class Cat {
  sound: ISoundBehaviour;
  constructor() {
    this.sound = new CatSound();
  }

  makeSound() {
    this.sound.makeSound();
  }

  setSoundBehaviour(newSound: ISoundBehaviour) {
    this.sound = newSound;
  }
}

const cat = new Cat();
cat.makeSound(); // Meow
const newSound: ISoundBehaviour = new CatRelaxSound();
cat.setSoundBehaviour(newSound);
cat.makeSound(); // Prrrr
