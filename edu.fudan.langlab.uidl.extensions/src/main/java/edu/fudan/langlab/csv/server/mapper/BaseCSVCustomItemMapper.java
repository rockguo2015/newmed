package edu.fudan.langlab.csv.server.mapper;

import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;

public abstract class BaseCSVCustomItemMapper<T, C> implements
		ICSVCustomItemMapper<T, C> {
	public T fromString(String s, C context,
			IFieldValidationResultAcceptor acceptor) {
		try {
			return doFromString(s, context, acceptor);
		} catch (Exception e) {
			acceptor.accept(e.getMessage());
			return null;
		}
	}

	abstract protected T doFromString(String s, C context,
			IFieldValidationResultAcceptor acceptor);
}
