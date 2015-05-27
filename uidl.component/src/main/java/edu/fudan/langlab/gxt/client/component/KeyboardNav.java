package edu.fudan.langlab.gxt.client.component;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.KeyNav;

public class KeyboardNav {
	public static void OnKey(Widget widget, final int keyCode,
			final Procedure1<? super Void> handler) {
		new KeyNav(widget) {
			@Override
			public void onKeyPress(NativeEvent evt) {
				if (evt.getKeyCode() == keyCode)
					handler.apply(null);
			}
		};
	}

	public static void OnEnter(Widget widget,
			final Procedure1<? super Void> handler) {
		new KeyNav(widget) {
			@Override
			public void onEnter(NativeEvent evt) {
				handler.apply(null);
			}
		};
	}
}
