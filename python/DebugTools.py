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
	
	debugLevel = DEBUG_LEVEL.QUIET
	
	@staticmethod
	def println(arg, debugLevel = DEBUG_LEVEL.DEBUG):
		if debugLevel <= DebugTools.debugLevel:
			print arg

	@staticmethod
	def printerr(arg, debugLevel = DEBUG_LEVEL.DEBUG):
		if debugLevel <= DebugTools.debugLevel:
			print >> sys.stderr, arg