class Resource():

    def __init__(self):
        self._value = 0
    
    def print_value(self):
        print("Resource value: %d" % self._value)

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, value):
        self._value = value

    @value.deleter
    def value(self):
        self._value = 0


class ObjectPool():

    def __init__(self):
        self._resources = []

    @property
    def size(self):
        return len(self._resources)

    def acquire(self):
        if len(self._resources) == 0:
            return Resource()
        else:
            return self._resources.pop()

    def release(self, resource: Resource):
        del resource.value
        self._resources.append(resource)


def main():
    pool = ObjectPool()

    for i in range(10):
        resource = pool.acquire()
    
        resource.value += i
        resource.print_value()

        pool.release(resource)
    
    print("Pool size: %d" % pool.size)


if __name__ == "__main__":
    main()
