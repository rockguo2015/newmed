package edu.fudan.mylang.pf.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class Collections3 {

	public interface ItemWithIndex<T> {
		int getIndex();

		T getValue();
	}

	public static <T> Collection<T> collect(Iterator<T> iterator) {
		Collection<T> result = new ArrayList<T>();
		while (iterator.hasNext())
			result.add(iterator.next());
		return result;
	}

	public static <T> Iterable<T> collectCommon(final Iterable<T> first,
			final Iterable<T> second) {
		return Iterables.filter(first, new Predicate<T>() {
			public boolean apply(T target) {
				return Iterables.contains(second, target);
			}
		});

	}

	public static <T> Iterable<ItemWithIndex<T>> iteratorWithIndex(
			final Iterable<T> values) {
		final Iterator<T> theIterator = values.iterator();
		return new Iterable<ItemWithIndex<T>>() {

			@Override
			public Iterator<ItemWithIndex<T>> iterator() {
				return new Iterator<ItemWithIndex<T>>() {
					int index = -1;

					@Override
					public boolean hasNext() {
						return theIterator.hasNext();
					}

					@Override
					public ItemWithIndex<T> next() {
						index ++;
						final T v = theIterator.next();
						return new ItemWithIndex<T>() {

							@Override
							public int getIndex() {
								return index;
							}

							@Override
							public T getValue() {
								return v;
							}

						};
					}

					@Override
					public void remove() {
						// TODO Auto-generated method stub

					}

				};
			}

		};
	}
}
