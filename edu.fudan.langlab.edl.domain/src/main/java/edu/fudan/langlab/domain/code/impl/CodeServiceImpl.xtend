package edu.fudan.langlab.domain.code.impl

import edu.fudan.langlab.domain.code.Code
import edu.fudan.langlab.domain.code.CodeService
import edu.fudan.langlab.domain.code.CodeType
import edu.fudan.langlab.domain.code.CodeTypeProvider
import edu.fudan.langlab.domain.code.events.CodeEventsManager
import java.util.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import edu.fudan.mylang.pf.IObjectFactory
import edu.fudan.mylang.pf.EntityImplementation

@Service("CodeService")
class CodeServiceImpl implements CodeService {

	@Autowired(required=false)
	List<CodeTypeProvider> codeTypeProviders = newArrayList()
	
	@Autowired
	CodeEventsManager eventsManager
	
	@Autowired
	IObjectFactory entities;
	override getAllCodeTypes() {
		codeTypeProviders.map[it.codeTypes].flatten.toList
	}
	override  findCodeType(String className) {
		getAllCodeTypes().findFirst[it.className == className]
	}

	override createCode(CodeType codeType) {
		val result = codeType.createCode(entities)
		eventsManager.fireCreated(result)
		result
	}
	

	override deleteCode(Code code) {
		entities.delete(code)
		eventsManager.fireDeleted(code)
	}
	
	override <T extends Code> getCodeByName(Class<T> codeType, String name) {
		val EntityImplementation entityImplAnnotation = codeType
				.getAnnotation(typeof(EntityImplementation));
		val hql = "from "+entityImplAnnotation.implementBy().name + " e where e.name = '"+name+"'"
		entities.createQuery(hql).uniqueResult as T
	}
	
}