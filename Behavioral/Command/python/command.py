# encoding utf-8
''' Command design pattern written in python'''

class Command():
    def execute(self):
        pass

class LunchCommand(Command):
    def __init__(self, lunch):
        self.lunch = lunch

    def execute(self):
        self.lunch.make_lunch()
    
    def clean(self):
        self.lunch.clean_table()

class DinnerCommand(Command):
    def __init__(self, dinner):
        self.dinner = dinner

    def execute(self):
        self.dinner.make_dinner()
    
    def clean(self):
        self.dinner.clean_table()

class Lunch:
    def make_lunch(self):
        print "Lunch is being made"
        
    def clean_table(self):
        print "Lunch is over, clean table!"

class Dinner:
    def make_dinner(self):
        print "Dinner is being made"

    def clean_table(self):
        print "Dinner is over, clean table!"

class MealInvoker:
    def __init__(self, command):
        self.command = command

    def set_command(self, command):
        self.command = command

    def invoke(self):
        self.command.execute()

    def clean(self):
        self.command.clean()


if __name__ == '__main__':
    lunch = Lunch()
    lunch_command = LunchCommand(lunch)

    dinner = Dinner()
    dinner_command = DinnerCommand(dinner)

    meal_invoker = MealInvoker(lunch_command)
    meal_invoker.invoke()
    meal_invoker.clean()

    meal_invoker.set_command(dinner_command)
    meal_invoker.invoke()
    meal_invoker.clean()
