<?php
interface WritingState
{
    public function write(string $words);
}

class UpperCase implements WritingState
{
    public function write(string $words)
    {
        echo strtoupper($words) . PHP_EOL;
    }
}

class LowerCase implements WritingState
{
    public function write(string $words)
    {
        echo strtolower($words) . PHP_EOL;
    }
}

class Simple implements WritingState
{
    public function write(string $words)
    {
        echo $words . PHP_EOL;
    }
}

class TextEditor
{
    protected $state;

    public function __construct(WritingState $state)
    {
        $this->state = $state;
    }

    public function setState(WritingState $state)
    {
        $this->state = $state;
    }

    public function type(string $words)
    {
        $this->state->write($words);
    }
}

$editor = new TextEditor(new Simple());

$editor->type('First line');

$editor->setState(new UpperCase());

$editor->type('Second line');
$editor->type('Third line');

$editor->setState(new LowerCase());

$editor->type('Fourth line');
$editor->type('Fifth line');

// Output:
// First line
// SECOND LINE
// THIRD LINE
// fourth line
// fifth line
