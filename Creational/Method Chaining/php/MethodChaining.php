<?php

class Rectangle {
    public const DEFAULT_WIDTH = 0;
    public const DEFAULT_HEIGHT = 0;
    protected $width;
    protected $height;
    
    public function __construct(int $width = 0, int $height = 0)
    {
        $this->width = $width;
        $this->height = $height;
    }

    public function setWidth(int $width)
    {
        $this->width = $width;
        return $this;
    }

    public function setHeight(int $height)
    {
        $this->height = $height;
        return $this;
    }

    public function __toString()
    {
        return sprintf("\n\nThis is a %dx%d Rectangle\n\n", $this->width, $this->height);
    }
}

print(new Rectangle());
$rect = new Rectangle();
print($rect->setWidth(10)->setHeight(5));
