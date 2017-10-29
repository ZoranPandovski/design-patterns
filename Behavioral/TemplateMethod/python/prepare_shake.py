class ShakePreparationTemplate:

    def add_sugar(self): pass
    def add_main_ingredients(self): pass
    def prepare_ice(self): 
        print("Crushing Ice for shake")   
    def serve(self):
        print("Hello customer, here is your freshly made shake!");
    def blend(self):
        print("Revving up the blender. VVVoooooooommm!");
    
    def prepare(self):
       self.prepare_ice() 
       self.add_sugar()
       self.add_main_ingredients()
       self.blend()
       self.serve()

class MangoShakePreparation(ShakePreparationTemplate):

    def add_sugar(self):
        print("Adding 50% sugar") 

    def add_main_ingredients(self):
        print("Adding 4 slices of mangoes")

class PineappleShakePreparation(ShakePreparationTemplate):

    def add_sugar(self):
        print("Adding 30% sugar")

    def add_main_ingredients(self):
        print("Adding 6 slices of pineapples")

class DetoxShakePreparation(ShakePreparationTemplate):

    def add_sugar(self):
        print("Adding 40% sugar")

    def add_main_ingredients(self):
        print("Adding 3 slices of pineapples, 2 slices of kiwi, and 5 slices of oranges!")

