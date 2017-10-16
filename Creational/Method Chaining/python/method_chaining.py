class Rectangle:
	DEFAULT_WIDTH = 0
	DEFAULT_HEIGHT = 0

	def __init__(self):
		self.width = self.DEFAULT_WIDTH
		self.height = self.DEFAULT_HEIGHT

	def __str__(self):
		return "This is a "+str(self.width)+"x"+str(self.height)+" Rectangle"

	def set_width(self, width):
		self.width = width
		return self

	def set_height(self, height):
		self.height = height
		return self


print(str(Rectangle()))
#This is a 0x0 Rectangle
print(str(Rectangle().set_width(5).set_height(10)))
#This is a 5x10 Rectangle

