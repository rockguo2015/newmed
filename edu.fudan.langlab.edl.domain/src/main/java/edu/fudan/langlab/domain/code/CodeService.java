package edu.fudan.langlab.domain.code;

import java.util.Collection;

public interface CodeService {
	Collection<CodeType> getAllCodeTypes();
	CodeType findCodeType(String className);
	Code createCode(CodeType codeType);
	void deleteCode(Code code);
	<T extends Code> T getCodeByName(Class<T> codeType,String name);
}