using System;
using DependencyInjection.Concretes;

namespace DependencyInjection
{
    // Overview: Depency Injection, a broader technique of inversion of control, is one in which an object receives the dependencies - in the form of objects - that it depends on. 

    // Scenario: 
    //    Suppose that we have a game manager that is responsible for managing displaying scenes via a Scene Manager and playing audio via an Audio Manager. Now, we don't want to
    // instantiate the instances of these objects directly in the game manager itself, but rather instantiate it in what we can call the composition root (in this case, the main program
    // class). This is because we should be able to swap out the implementation of the Scene Manage or the Audio Manager without the Game Manager worrying about how they are implemented.
    // So, what we can instead do is create interfaces, ISceneManager and IAudioManager and have the SceneManager and AudioManager implement each of the interfaces respectively.
    // We then update the GameManager class to take instances of this interface in the constructor instead of instantiating instances of the SceneManager and AudioManager directly in the
    // GameManager itself. We then instantiate our desired implementations of the interface in the composition root, pass in the instances in the constructor of the GameManager when we construct
    // the object, and voila, we have dependency injection.

    // So, essentially, what it boils down to is that dependency injection reduces coupling between classes and their dependencies.
    class Program
    {
        static void Main(string[] args)
        {
            AudioManager audioManager = new AudioManager();
            SceneManager sceneManager = new SceneManager();

            GameManager gameManager = new GameManager(audioManager, sceneManager);

            gameManager.Tick();
        }
    }
}
