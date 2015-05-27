package com.uniquesoft.gwt.shared.command;

import org.eclipse.xtext.xbase.lib.Functions.Function0;

public interface IValueConsumer<T> {
	void setValueProvider(Function0<? extends T> valueProvider);
}
