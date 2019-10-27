<?php
require_once 'Observer.php';
require_once 'Observable.php';

$observerMike = new Observer('Mike');
$observerBetty = new Observer('Betty');
$observerFlip = new Observer('Flip');
$observerFlap = new Observer('Flap');
$observable = new Observable();

echo 'register all observers' . PHP_EOL;
$observable->register($observerMike);
$observable->register($observerBetty);
$observable->register($observerFlip);
$observable->register($observerFlap);

$observable->dispatch();

echo 'unregister Flip and Flap' . PHP_EOL;
$observable->unregister($observerFlip);
$observable->unregister($observerFlap);

$observable->dispatch();
