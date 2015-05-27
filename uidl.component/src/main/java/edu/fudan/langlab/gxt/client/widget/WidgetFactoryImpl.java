package edu.fudan.langlab.gxt.client.widget;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;

import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.theme.blue.client.panel.NavContentPanelAppearance;

public class WidgetFactoryImpl implements IWidgetFactory {

	@Inject
	Commands commands;

	@Override
	public HorizontalLayoutContainer HLayout() {
		return new HorizontalLayoutContainer();
	}

	@Override
	public HorizontalLayoutData HLayoutData(double width, double height) {
		return new HorizontalLayoutData(width, height);
	}

	@Override
	public HorizontalLayoutData HLayoutData(double width, double height,
			int margin) {
		HorizontalLayoutData data = new HorizontalLayoutData(width, height);
		data.setMargins(new Margins(margin));
		return data;
	}

	@Override
	public VerticalLayoutContainer VLayout() {
		return new VerticalLayoutContainer();
	}

	@Override
	public VerticalLayoutData VLayoutData(double width, double height) {
		return new VerticalLayoutData(width, height);
	}

	@Override
	public VerticalLayoutData VLayoutData(double width, double height,
			int margin) {
		VerticalLayoutData data = new VerticalLayoutData(width, height);
		data.setMargins(new Margins(margin));
		return data;

	}

	@Override
	public edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem TextItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem(
				"_id_", title, false);
	}

	@Override
	public edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem DateItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem(
				"_id_", title, false);
	}

	@Override
	public edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem CheckBoxItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem(
				"_id_", title);
	}

	@Override
	public com.sencha.gxt.widget.core.client.button.TextButton TextButton(
			String title) {

		com.sencha.gxt.widget.core.client.button.TextButton btn = new com.sencha.gxt.widget.core.client.button.TextButton(
				title);
		return btn;
	}

	@Override
	public edu.fudan.langlab.gxt.client.widget.FramedPanel FramedPanel(
			String title) {
		edu.fudan.langlab.gxt.client.widget.FramedPanel result = new edu.fudan.langlab.gxt.client.widget.FramedPanel(
				commands, this);
		result.setHeadingText(title);
		// result.setHeadingHtml("<span>" + title
		// + "</span>");
		return result;
	}

	@Override
	public ContentPanel ContentPanel(String title) {
		ContentPanel result = new ContentPanel(commands, this);
		result.setBodyBorder(true);
		result.setHeadingHtml("<span>" + title + "</span>");
		return result;
	}

	@Override
	public ContentPanel ContentPanel() {
		ContentPanel result = new ContentPanel(commands, this);
		result.setHeaderVisible(false);
		return result;
	}

	@Override
	public ContentPanel ContentPanel(String title, Widget content) {
		ContentPanel result = ContentPanel(title);
		result.setWidget(content);
		return result;
	}

	@Override
	public com.sencha.gxt.widget.core.client.container.MarginData MarginData(
			int marginData) {
		return new com.sencha.gxt.widget.core.client.container.MarginData(
				marginData);
	}

	@Override
	public com.google.gwt.user.client.ui.Label Label(String title) {
		return new com.google.gwt.user.client.ui.Label(title);
	}

	@Override
	public edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.EscapedTextItem EscapedTextItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.EscapedTextItem(
				"_id_", title);
	}

	public edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem IntegerItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem(
				"_id_", title, false);
	}

	@Override
	public edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem DoubleItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem(
				"_id_", title, false);
	}

	@Override
	public HorizontalPanel HPanel() {
		return new HorizontalPanel();
	}

	@Override
	public com.sencha.gxt.widget.core.client.form.TextField TextField() {
		return new com.sencha.gxt.widget.core.client.form.TextField();
	}

	@Override
	public HBoxLayoutContainer HBoxLayout() {
		return new HBoxLayoutContainer();
	}

	@Override
	public com.sencha.gxt.widget.core.client.box.ConfirmMessageBox ConfirmMessageBox(
			String title, String content,
			final Procedure1<? super Void> confirmHandler) {
		com.sencha.gxt.widget.core.client.box.ConfirmMessageBox result = new com.sencha.gxt.widget.core.client.box.ConfirmMessageBox(
				title, content);
		result.addHideHandler(new HideHandler() {
			@Override
			public void onHide(HideEvent event) {
				String buttonID = ((Dialog) event.getSource()).getHideButton()
						.getItemId();
				if (buttonID.equals(PredefinedButton.YES.name())) {
					confirmHandler.apply(null);
				}

			}
		});
		return result;
	}

	@Override
	public com.sencha.gxt.widget.core.client.form.FieldSet FieldSet(String title) {
		com.sencha.gxt.widget.core.client.form.FieldSet fieldSet = new com.sencha.gxt.widget.core.client.form.FieldSet();
		fieldSet.setHeadingText(title);
		return fieldSet;
	}

	@Override
	public BorderLayoutContainer BorderLayout() {
		return new BorderLayoutContainer();
	}

	@Override
	public FieldLabel FieldLabel(Widget content, String title) {
		return new FieldLabel(content, title);
	}

	@Override
	public com.sencha.gxt.widget.core.client.box.MultiLinePromptMessageBox MultiLinePromptMessageBox(
			String title, String message,
			final Procedure1<String> confirmHandler) {
		final com.sencha.gxt.widget.core.client.box.MultiLinePromptMessageBox messageBox = new com.sencha.gxt.widget.core.client.box.MultiLinePromptMessageBox(
				title, message);
		messageBox.addHideHandler(new HideHandler() {
			@Override
			public void onHide(HideEvent event) {
				String buttonID = ((Dialog) event.getSource()).getHideButton()
						.getItemId();
				if (buttonID.equals(PredefinedButton.OK.name())) {
					confirmHandler.apply(messageBox.getValue());
				}

			}
		});
		return messageBox;
	}

	@Override
	public HTableLayoutContainer HTableLayout() {
		return new HTableLayoutContainer();
	}

	@Override
	public TabPanel TabPanel() {
		return new TabPanel(commands, this);
	}

	@Override
	public com.sencha.gxt.widget.core.client.form.TextArea TextArea() {
		return new com.sencha.gxt.widget.core.client.form.TextArea();
	}

	@Override
	public com.sencha.gxt.widget.core.client.box.MessageBox MessageBox(
			String title, String content) {
		return new com.sencha.gxt.widget.core.client.box.MessageBox(title,
				content);
	}

	@Override
	public com.sencha.gxt.widget.core.client.menu.Menu Menu() {
		return new com.sencha.gxt.widget.core.client.menu.Menu();
	}

	@Override
	public com.sencha.gxt.widget.core.client.menu.MenuItem MenuItem(String title) {
		return new com.sencha.gxt.widget.core.client.menu.MenuItem(title);
	}

	@Override
	public com.sencha.gxt.widget.core.client.button.ButtonBar ButtonBar() {
		com.sencha.gxt.widget.core.client.button.ButtonBar result = new com.sencha.gxt.widget.core.client.button.ButtonBar();
		result.setHeight(30);
		result.setMinButtonWidth(75);
		result.setPack(BoxLayoutPack.END);
		return result;
	}

	@Override
	public edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem TextAreaItem(
			String title) {
		return new edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem(
				"_id_", title, false);
	}

	@Override
	public com.sencha.gxt.widget.core.client.button.TextButton TextButton(
			String title, final Procedure1<? super SelectEvent> handler) {
		com.sencha.gxt.widget.core.client.button.TextButton result = TextButton(title);
		result.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				handler.apply(event);

			}
		});
		return result;
	}

	@Override
	public com.sencha.gxt.widget.core.client.ContentPanel AccordionPanel(
			String title, ImageResource image) {
		com.sencha.gxt.widget.core.client.ContentPanel result = new com.sencha.gxt.widget.core.client.ContentPanel(
				GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class));
		result.setHeadingHtml("<span style='font-size:12px;'>" + title
				+ "</span>");

		if (image != null)
			result.getHeader().setIcon(image);
		return result;
	}

	@Override
	public com.sencha.gxt.widget.core.client.ContentPanel NavHeader(String title) {
		com.sencha.gxt.widget.core.client.ContentPanel result = new com.sencha.gxt.widget.core.client.ContentPanel(
				new NavContentPanelAppearance());
		result.setHeadingText(title);
		result.getHeader()
				.setIcon(
						GWT.<edu.fudan.langlab.theme.blue.client.navbar.NavMenuItemBaseAppearance.NavMenuItemResources> create(
								edu.fudan.langlab.theme.blue.client.navbar.NavMenuItemBaseAppearance.NavMenuItemResources.class)
								.nav_header());
		return result;
	}

	@Override
	public com.uniquesoft.gwt.client.common.widgets.IPresenterContainer PresenterContainer() {
		return new edu.fudan.langlab.gxt.client.widget.PresenterContainer();
	}

	@Override
	public com.sencha.gxt.widget.core.client.form.PasswordField PasswordField() {
		return new com.sencha.gxt.widget.core.client.form.PasswordField();
	}

	@Override
	public VerticalLayoutContainer DialogContent(Widget content) {
		VerticalLayoutContainer result = VLayout();
		result.add(content, VLayoutData(1, -1, 10));
		return result;
	}

	@Override
	public <T> edu.fudan.langlab.gxt.client.widget.ValueDialog<T> ValueDialog(
			IValueProvider<T> valueProvider,
			Procedure1<? super T> valueProcessor) {
		return new edu.fudan.langlab.gxt.client.widget.ValueDialog<T>(
				valueProvider, valueProcessor);
	}

}
