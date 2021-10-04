using System;
using System.Collections.Generic;
using System.Text;
using DependencyInjection.Interfaces;

namespace DependencyInjection.Concretes
{
    class SceneManager : ISceneManager
    {
        List<String> Scenes = new List<String>();

        public void DisplayScene()
        {
            Console.WriteLine("I will display the Scene");
        }

        public void ListScenes()
        {
            Scenes.ForEach(x => Console.WriteLine(x));
        }
    }
}
