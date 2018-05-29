class Handler:
	def __init__(self):
		self.next = None

	#execute chain	
	def execu(self, obj):
		if self.next is None:
			return self.handle(obj)
		else:
			return self.next.execu(self.handle(obj))
	#chain handler
	def handle(self, obj):
		raise NotImplementedError("You MUST implement this method!")
	
	#adds handler at the last element of the chain
	def addHandler(self, handler):
		nxt = self
		while nxt.next is not None:
			nxt = nxt.next
		nxt.next = handler
		return handler

class SplitDot(Handler):
	def handle(self, obj):
		return obj.split('.')

class Reverse(Handler):
	def handle(self, obj):
		return obj[::-1]

class JoinWithDot(Handler):
	def handle(self, obj):
		return ".".join(obj)

class AppendInAddr(Handler):
	def handle(self, obj):
		return obj+".in-addr.arpa"

if __name__=="__main__":
	addr = "192.168.1.3"	
	split = SplitDot()
	reverse = Reverse()
	join = JoinWithDot()
	app = AppendInAddr()
	
	# set the chain of responsibility
	split.addHandler(reverse)
	reverse.addHandler(join)
	join.addHandler(app)

	print("Result1: " + split.execu(addr))
	
	# alternative
	base = SplitDot()
	
	# set the chain of responsibility
	base.addHandler(Reverse())
	base.addHandler(JoinWithDot())
	base.addHandler(AppendInAddr())

	print("Result2: " + split.execu(addr))
	

