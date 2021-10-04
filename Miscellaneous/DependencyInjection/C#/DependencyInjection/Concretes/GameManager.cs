using System;
using System.Collections.Generic;
using System.Text;
using DependencyInjection.Interfaces;

namespace DependencyInjection.Concretes
{
    class GameManager
    {
        private readonly IAudioManager AudioManager;
        private readonly ISceneManager SceneManager;

        public GameManager(IAudioManager audioManager, ISceneManager sceneManager)
        {
            AudioManager = audioManager;
            SceneManager = sceneManager;
        }

        public void Tick()
        {
            AudioManager.PlaySound();
            SceneManager.DisplayScene();
        }
    }
}
