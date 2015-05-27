package com.uniquesoft.gwt.shared.datatype;

public interface IUIDLEnum<E extends Enum<E>> {
	E fromString(String value);
}
