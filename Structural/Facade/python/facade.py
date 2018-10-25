'''
we need to 
	1-do something 
	2-save it to database 
	3-log all these process
instead of doing this everytime, we simply define a facade class that has a method to do it'''


class SomeBusiness():
	def DoSomething(self):
		pass
		
class SomeRepository():
	def SaveSomething(self, thing):
		pass
		
class SomeLogger:
	def Log(self, message):
		pass
		
		
class SomeFacade:
	def __init__(self):
		self.business = SomeBusiness()
		self.repository = SomeRepository()
		self.logger = SomeLogger()

	def DoSomething(self):
		done = self.business.DoSomething()
		self.logger.Log("done")
		saved = self.repository.SaveSomething(done)
		self.logger.Log("saved")
		

def main():
	facade = SomeFacade()
	facade.DoSomething()


if __name__ == "__main__":
    main()
