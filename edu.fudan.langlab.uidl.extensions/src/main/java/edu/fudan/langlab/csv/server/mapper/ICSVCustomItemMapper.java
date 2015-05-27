package edu.fudan.langlab.csv.server.mapper;

import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;

public interface ICSVCustomItemMapper<T, C> {
	String toString(T data, C context);

	T fromString(String s, C context, IFieldValidationResultAcceptor acceptor);

}
