import sys

class DebugTools:
	
	class DEBUG_LEVEL:
		QUIET = 0
		FATAL = 1
		ERROR = 2
		INFO = 3
		VERBOSE = 4
		DEBUG = 5
		DEBUG2 = 6
		DEBUG3 = 7
	
	def __init__(self, debugLevel = DEBUG_LEVEL.QUIET, stream = sys.stdout, errStream = sys.stderr):
		self.debugLevel = debugLevel
		self.stream = stream
		self.errStream = errStream
	
	def println(self, arg, debugLevel = DEBUG_LEVEL.DEBUG):
		self.write(arg, debugLevel)

	def write(self, arg, debugLevel = DEBUG_LEVEL.DEBUG):
		if debugLevel <= self.debugLevel:
			print >> self.stream, arg,

	def printerr(self, arg, debugLevel = DEBUG_LEVEL.DEBUG):
		if debugLevel <= self.debugLevel:
			print >> self.errStream, arg
