<?php
class Observable 
{
    private $observers = [];

    function register($observer)
    {
        $this->observers[] = $observer;
    }

    function unregister($observerToRemove)
    {
        foreach($this->observers as $k => $observer) {
            if ($observer === $observerToRemove) {
                unset($this->observers[$k]);
            }
        }
    }

    function dispatch()
    {
        foreach($this->observers as $observer) {
            $observer->fire();
        }
    }

}