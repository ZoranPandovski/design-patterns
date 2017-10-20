package _go

type single struct {
	O interface{}
}

var instantiated *single = nil

func New() *single {
	if instantiated == nil {
		instantiated = new(single)
	}
	return instantiated
}
