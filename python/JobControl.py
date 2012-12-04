import time
import math

import random

class JobControl:
	
	def __init__(self, totalJobs = 1):
		self.totalJobs = totalJobs
		self.jobs = 0
		self.avgTime = 0
		self.lastTime = None
		self.N = min(10, math.ceil(float(self.totalJobs)/10))
		self.a = float(2)/(self.N+1)
		
	
	def jobDone(self):
		self.jobs = self.jobs + 1
		t = int(time.time()*1000)
		if self.lastTime is None:
			self.lastTime = t
		diff = t - self.lastTime
		self.avgTime = self.a * diff + (1-self.a) * self.avgTime
		self.lastTime = t

	def getProgress(self):
		return float(self.jobs) / self.totalJobs
	
	def getProgressFormatted(self):
		return str(int(self.getProgress()*100)) + "%"
	
	def getETA(self):
		return int(self.avgTime * (self.totalJobs - self.jobs))
	
	def getETAFormatted(self):
		t = float(self.getETA())
		msecs = math.floor(t%1000)
		t -= msecs
		secs = math.floor(t/1000)
		mins = math.floor(secs / 60)
		secs -= mins*60
		hours = math.floor(mins / 60)
		mins -= hours * 60
		return "%02u:%02u:%02u.%03u" % (hours, mins, secs, msecs)

def test():
	N = 100
	DELAY = 100
	RAND = 10
	jc = JobControl(N)
	for i in xrange(N):
		milis = DELAY + (random.random()-0.5)*RAND
		time.sleep(milis/1000)
		jc.jobDone()
		#print jc.getProgressFormatted()
		print jc.getETAFormatted()

if __name__ == '__main__':
	test()