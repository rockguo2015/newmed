package com.fudanmed.platform.core.web.client.extensiableentity

import com.google.inject.Inject
import com.google.inject.Provider
import com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenter

class ValueEditorCreator {
	@Inject
	private Provider<NumberValueEditorPresenter> numberValueEditorPresenter	
	
	def getNumberValueEditorPresenter(){
		numberValueEditorPresenter.get
	}
}