# Entry point for perl method chaining demo
use strict;
use warnings;

use Rectangle;

use Data::Dumper;
$Data::Dumper::Terse = 1;

my $rectangle = new Rectangle();
# display 0x0 rectangle
print(Dumper($rectangle));

$rectangle->setWidth(5)->setHeight(10);
# display 5x10 rectangle
print(Dumper($rectangle));
