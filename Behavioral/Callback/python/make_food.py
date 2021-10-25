def cook(item):
    print(f"Your {item} has been cooked enjoy!!")

def make_food(item, callback):
    print("Food is being made")
    callback(item)

def main():
    item = input("What do you want to eat?\n")
    make_food(item, cook)
    pass

if __name__ == "__main__":
    main()
