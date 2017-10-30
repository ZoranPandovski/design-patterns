package Rectangle;

sub new {
    my ($class, %args) = @_;

    my $self = {
        height => 0,
        width  => 0
    };

    return (bless($self, $class));
}

sub setWidth {
    my ($self, $width) = @_;

    $self->{width} = $width;
    return $self;
}

sub setHeight {
    my ($self, $height) = @_;

    $self->{height} = $height;
    return $self;
}

1;