package com.uniquesoft.gwt.shared.extensions;

public class SequenceGenerator {
	private Integer start;

	public SequenceGenerator(Integer start) {
		this.start = start;
	}

	public Integer next() {
		return start++;
	}
}
