def callback_fun():
    print("got callback")
    pass


def my_fun(callback):
    print("function called")
    callback()
    pass


def main():
    print("call a function with callback")
    my_fun(callback_fun)
    pass


if __name__ == "__main__":
    main()
