using System;
using System.Collections.Generic;
using System.Text;
using DependencyInjection.Interfaces;

namespace DependencyInjection.Concretes
{
    class AudioManager : IAudioManager
    {
        public void PlaySound()
        {
            Console.WriteLine("I will play a sound - Doe Ray Me Far Sew La Tea Doe");
        }
    }
}
