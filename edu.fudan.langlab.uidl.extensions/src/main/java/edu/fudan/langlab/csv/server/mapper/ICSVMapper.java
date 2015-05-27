package edu.fudan.langlab.csv.server.mapper;

import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;

public interface ICSVMapper<T> {
	
	String getTitle4Key(String key);

	String toHeader();

	String toString(T data);

	T fromString(String s, IValidationResultAcceptor acceptor);

}
