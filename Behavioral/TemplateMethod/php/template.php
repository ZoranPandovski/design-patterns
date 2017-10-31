<?php

/**
 * Class Builder
 */
abstract class Builder
{

    // Template method
    final public function build()
    {
        $this->test();
        $this->lint();
        $this->assemble();
        $this->deploy();
    }

    /**
     * @return mixed
     */
    abstract public function test();

    /**
     * @return mixed
     */
    abstract public function lint();

    /**
     * @return mixed
     */
    abstract public function assemble();

    /**
     * @return mixed
     */
    abstract public function deploy();
}


/**
 * Class AndroidBuilder
 */
class AndroidBuilder extends Builder
{
    public function test()
    {
        echo 'Running android tests';
    }
    public function lint()
    {
        echo 'Linting the android code';
    }
    public function assemble()
    {
        echo 'Assembling the android build';
    }

    public function deploy()
    {
        echo 'Deploying android build to server';
    }
}

/**
 * Class IosBuilder
 */
class IosBuilder extends Builder
{
    public function test()
    {
        echo 'Running ios tests';
    }

    public function lint()
    {
        echo 'Linting the ios code';
    }

    public function assemble()
    {
        echo 'Assembling the ios build';
    }

    public function deploy()
    {
        echo 'Deploying ios build to server';
    }
}

$androidBuilder = new AndroidBuilder();
$androidBuilder->build();

// Output:
// Running android tests
// Linting the android code
// Assembling the android build
// Deploying android build to server

$iosBuilder = new IosBuilder();
$iosBuilder->build();

// Output:
// Running ios tests
// Linting the ios code
// Assembling the ios build
// Deploying ios build to server
