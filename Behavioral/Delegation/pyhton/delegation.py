from abc import ABC, abstractmethod


class SoundBehavior(ABC):

    @abstractmethod
    def make_sound(self):
        pass


class CatSound(SoundBehavior):

    def make_sound(self):
        print("Meow")


class RelaxCatSound(SoundBehavior):

    def make_sound(self):
        print("Prrrrrrrr")


class Cat:

    def __init__(self):
        self._sound = CatSound()

    def make_sound(self):
        self._sound.make_sound()

    @property
    def sound(self):
        return self._sound

    @sound.setter
    def sound(self, sound):
        self._sound = sound


def main():
    cat = Cat()
    cat.make_sound()  # Meow
    cat.sound = RelaxCatSound()
    cat.make_sound()  # Prrrrrrrr


if __name__ == "__main__":
    main()
