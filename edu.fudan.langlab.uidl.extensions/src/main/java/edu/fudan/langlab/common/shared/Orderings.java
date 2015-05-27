package edu.fudan.langlab.common.shared;

import java.util.Date;

import javax.annotation.Nullable;

import com.google.common.collect.Ordering;

public class Orderings {
	public static Ordering<Date> getDateOrdering(){
		return new Ordering<Date>(){

			@Override
			public int compare(@Nullable Date left, @Nullable Date right) {
				return left.compareTo(right);
			}
			
		};
	}
}
