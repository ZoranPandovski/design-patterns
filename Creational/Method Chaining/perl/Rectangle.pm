package Rectangle;

# Constructor - default 0x0 rectangle
sub new {
    my ($class, %args) = @_;

    my $self = {
        height => 0,
        width  => 0
    };

    return (bless($self, $class));
}

# Width setter
sub setWidth {
    my ($self, $width) = @_;

    $self->{width} = $width;
    return $self;
}

# Height setter
sub setHeight {
    my ($self, $height) = @_;

    $self->{height} = $height;
    return $self;
}

1;
