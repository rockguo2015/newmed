package com.uniquesoft.uidl.transform;

public abstract class AbstractDataTypeMapper<GWTDataType, DataType> extends
		AbstractMapper<GWTDataType, DataType> {
	public DataType create() {
		throw new UnsupportedOperationException();
	}
}
