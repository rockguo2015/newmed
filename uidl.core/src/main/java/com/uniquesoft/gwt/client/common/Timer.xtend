package com.uniquesoft.gwt.client.common

/**
 * Set a time for a process, when the time has passed, execute the process
 */
class Timer extends com.google.gwt.user.client.Timer{
	
	(void) => void process
	override run() {
		process.apply(null)
	}
	
	def setProcess((void)=>void process){
		this.process = process
	}
	
}