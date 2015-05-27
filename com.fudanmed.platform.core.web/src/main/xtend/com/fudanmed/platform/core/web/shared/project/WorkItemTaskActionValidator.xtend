package com.fudanmed.platform.core.web.shared.project

import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus

class StatusValidator {
	def static canExecute(UIWorkItemTaskStatus state,UIWorkItemTaskActionType action){
		switch(state){
			case UIWorkItemTaskStatus::processing:{
				
				action == UIWorkItemTaskActionType::pend || 
				action == UIWorkItemTaskActionType::misDispatching ||
				action == UIWorkItemTaskActionType::oursource ||
				action == UIWorkItemTaskActionType::followup ||
				action == UIWorkItemTaskActionType::finish
			}
			case UIWorkItemTaskStatus::pending:{
				action == UIWorkItemTaskActionType::cancelPend
			}
			case UIWorkItemTaskStatus::outsourcing:{
				action == UIWorkItemTaskActionType::finishOutsource
			}
			case UIWorkItemTaskStatus::followuping:{
				action == UIWorkItemTaskActionType::finish
			}
			default:{
				false
			}
		}
	}
	
	def static canExecute(UIGroupTaskStatus state,UIGroupTaskActionType action){
		switch(state){
			case UIGroupTaskStatus::newCreated:{
				action == UIGroupTaskActionType::reportMisdispatch ||
				action == UIGroupTaskActionType::createTask
			}
			case UIGroupTaskStatus::wait4TeamOwnerProcess:{
				action == UIGroupTaskActionType::reportFinish ||
				action == UIGroupTaskActionType::createTask
			}
			case UIGroupTaskStatus::wait4TasksFinish:{
				action == UIGroupTaskActionType::createTask
			}
			default:{
				false
			}
		}
	}
	
	def static canExecute(UIRepairTaskStatus state,UIRepairTaskActionType action){
		switch(state){
			case UIRepairTaskStatus::wait4SchedulerProcess:{
				action == UIRepairTaskActionType::update ||
				action == UIRepairTaskActionType::createGroupTask
			}
			case UIRepairTaskStatus::wait4Close:{
				action == UIRepairTaskActionType::close ||
				action == UIRepairTaskActionType::createGroupTask||
				action == UIRepairTaskActionType::cancel
			}
			case UIRepairTaskStatus::scheduled:{
				action == UIRepairTaskActionType::cancel
			}
			case UIRepairTaskStatus::newCreated:{
				action == UIRepairTaskActionType::delete ||
				action == UIRepairTaskActionType::cancel ||
				action == UIRepairTaskActionType::update ||
				action == UIRepairTaskActionType::createGroupTask
			}
			default:{
				false
			}
		}
	}		
}