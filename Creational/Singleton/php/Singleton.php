<?php

class Singleton
{
    /**
     * Returns an unique instance of this class
     *
     * @staticvar Singleton $instance Class instance
     *
     * @return Singleton Class instance
     */
    public static function getInstance()
    {
        static $instance = null;
        if (null === $instance) {
            $instance = new static();
        }

        return $instance;
    }

    /**
     * Protected so no new instances can be created
     */
    protected function __construct() {}

    /**
     * Don't allow this instance to be cloned
     */
    private function __clone() {}

    /**
     * Don't allow an instance of this class to be deserialized
     */
    private function __wakeup() {}
}
