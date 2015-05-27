package edu.fudan.langlab.domain.code;

import java.util.Collection;

import edu.fudan.mylang.pf.IObjectFactory;

public class CodeType {

	private String name;
	private String className;

	public CodeType(String name, Class<? extends Code> clazz) {
		this.name = name;
		this.className = clazz.getName();
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public Code createCode(IObjectFactory objectFactory) {
		try {
			Code code = (Code) Class.forName(className).newInstance();
			objectFactory.save(code);
			return code;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Collection<Code> getAllCodes(IObjectFactory objectFactory) {
		String hql = "from " + className + " as code order by code.codeid";
		return objectFactory.createQuery(hql).list();
	}

	@Override
	public boolean equals(Object obj) {
		return className.equals(((CodeType) obj).getClassName());
	}

	public int hashCode() {
		return className.hashCode();
	};
}
