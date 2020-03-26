<?php

interface Box
{
    public function getWidth();

    public function getHeight();
}

class MetalBox implements Box
{
    protected $width;
    protected $height;

    public function __construct($width, $height)
    {
        $this->width = $width;
        $this->height = $height;
    }

    public function getWidth()
    {
        return $this->width;
    }

    public function getHeight()
    {
        return $this->height;
    }
}

class BoxFactory
{
    public static function makeBox($width, $height)
    {
        return new MetalBox($width, $height);
    }
}

// Testing:
$box = BoxFactory::makeBox(100, 200);
echo 'Width: ' . $box->getWidth();
echo 'Height: ' . $box->getHeight();
