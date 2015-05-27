package edu.fudan.langlab.csv.server.mapper;

import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;

public interface ICSVItemMapper<T> {
	String toString(T data);

	T fromString(String s,IFieldValidationResultAcceptor acceptor);
}
