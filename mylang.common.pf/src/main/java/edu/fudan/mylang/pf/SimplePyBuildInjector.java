package edu.fudan.mylang.pf;

import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.tuple.StandardProperty;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Component
public class SimplePyBuildInjector implements PreUpdateEventListener,
		PreInsertEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5930039281301523441L;

	private Iterable<String> multi(Iterable<String> first,
			Iterable<String> second) {
		List<String> result = Lists.newArrayList();
		for (String f : first) {
			for (String s : second) {
				result.add(f + s);
			}
		}
		return result;
	}

	public String getPinYinHeadChar(String str) {
		List<Iterable<String>> headerStrings = Lists.newArrayList();
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray == null || pinyinArray.length == 0) {
				if (Character.isLetter(word) || Character.isDigit(word)) {
					pinyinArray = new String[] { Character.valueOf(word)
							.toString().toLowerCase() };
				} else
					continue;
			}
			headerStrings.add(Iterables.transform(
					Lists.newArrayList(pinyinArray),
					new Function<String, String>() {
						public String apply(String value) {
							return value.substring(0, 1);
						}
					}));
		}
		Function2<Iterable<String>, Iterable<String>, Iterable<String>> function = new Function2<Iterable<String>, Iterable<String>, Iterable<String>>() {

			@Override
			public Iterable<String> apply(Iterable<String> p1,
					Iterable<String> p2) {
				return multi(p1, p2);
			}

		};
		Iterable<String> result = IterableExtensions.reduce(headerStrings,
				function);
		if (result == null)
			return "";
		return IterableExtensions.join(ImmutableSet.copyOf(result).asList(),
				",");

	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {

		if (event.getEntity() instanceof IHasSimplePy) {
			IHasSimplePy hasPy = (IHasSimplePy) event.getEntity();

			StandardProperty[] properties = event.getPersister()
					.getEntityMetamodel().getProperties();
			Object[] state = event.getState();

			for (int i = 0; i < properties.length; i++) {
				if (properties[i].getName().equals("simplePy")) {
					state[i] = getPinYinHeadChar(getNameFieldValue(properties,
							state, hasPy.getNameField()));
					break;
				}
			}
		}
		return false;
	}

	private String getNameFieldValue(StandardProperty[] properties,
			Object[] state, String nameField) {
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getName().equals(nameField)) {
				if (state[i] != null)
					return state[i].toString();
				else
					return "";
			}
		}
		throw new RuntimeException("name field not found:" + nameField);

	}

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		if (event.getEntity() instanceof IHasSimplePy) {
			IHasSimplePy hasPy = (IHasSimplePy) event.getEntity();

			StandardProperty[] properties = event.getPersister()
					.getEntityMetamodel().getProperties();
			Object[] state = event.getState();

			for (int i = 0; i < properties.length; i++) {
				if (properties[i].getName().equals("simplePy")) {
					state[i] = getPinYinHeadChar(getNameFieldValue(properties,
							state, hasPy.getNameField()));
					break;
				}
			}
		}
		return false;
	}
}
