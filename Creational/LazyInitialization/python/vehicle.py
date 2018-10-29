class Fruit:
    def __init__(self, item):
        self.item = item


class Fruits:
    def __init__(self):
        self.items = {}

    def get_fruit(self, item):
        if item not in self.items:
            self.items[item] = Fruit(item)

        return self.items[item]


if __name__ == '__main__':
    fruits = Fruits()
    print(fruits.get_fruit('Apple'))
    print(fruits.get_fruit('Lime'))