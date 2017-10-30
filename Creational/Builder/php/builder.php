<?php

/**
 * Class Burger
 */
class Burger
{
    /**
     * @var int
     */
    protected $size;

    /**
     * @var bool
     */
    protected $cheese = false;
    /**
     * @var bool
     */
    protected $pepperoni = false;
    /**
     * @var bool
     */
    protected $lettuce = false;
    /**
     * @var bool
     */
    protected $tomato = false;

    /**
     * Burger constructor.
     * @param BurgerBuilder $builder
     */
    public function __construct(BurgerBuilder $builder)
    {
        $this->size = $builder->size;
        $this->cheese = $builder->cheese;
        $this->pepperoni = $builder->pepperoni;
        $this->lettuce = $builder->lettuce;
        $this->tomato = $builder->tomato;
    }
}

/**
 * Class BurgerBuilder
 */
class BurgerBuilder
{
    /**
     * @var int
     */
    public $size;

    /**
     * @var bool
     */
    public $cheese = false;
    /**
     * @var bool
     */
    public $pepperoni = false;
    /**
     * @var bool
     */
    public $lettuce = false;
    /**
     * @var bool
     */
    public $tomato = false;

    /**
     * BurgerBuilder constructor.
     * @param int $size
     */
    public function __construct(int $size)
    {
        $this->size = $size;
    }

    /**
     * @return $this
     */
    public function addPepperoni()
    {
        $this->pepperoni = true;
        return $this;
    }

    /**
     * @return $this
     */
    public function addLettuce()
    {
        $this->lettuce = true;
        return $this;
    }

    /**
     * @return $this
     */
    public function addCheese()
    {
        $this->cheese = true;
        return $this;
    }

    /**
     * @return $this
     */
    public function addTomato()
    {
        $this->tomato = true;
        return $this;
    }

    /**
     * @return Burger
     */
    public function build(): Burger
    {
        return new Burger($this);
    }
}

$burger = (new BurgerBuilder(14))
    ->addPepperoni()
    ->addLettuce()
    ->addTomato()
    ->build();
