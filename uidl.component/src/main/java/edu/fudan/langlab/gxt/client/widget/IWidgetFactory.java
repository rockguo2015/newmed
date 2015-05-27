package edu.fudan.langlab.gxt.client.widget;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.ImplementedBy;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;

import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.ValueDialog;
@ImplementedBy(WidgetFactoryImpl.class)
public interface IWidgetFactory extends
		com.uniquesoft.gwt.client.common.widgets.IWidgetFactory {
	HorizontalLayoutContainer HLayout();

	HorizontalLayoutData HLayoutData(double width, double height);

	HorizontalLayoutData HLayoutData(double width, double height, int margin);

	VerticalLayoutContainer VLayout();

	VerticalLayoutData VLayoutData(double width, double height);
	VerticalLayoutData VLayoutData(double width, double height, int margin);

	HBoxLayoutContainer HBoxLayout();

	HTableLayoutContainer HTableLayout();

	MarginData MarginData(int marginData);

	HorizontalPanel HPanel();

	com.sencha.gxt.widget.core.client.form.TextField TextField();
	
	com.sencha.gxt.widget.core.client.form.PasswordField PasswordField();

	TextItem TextItem(String title);
	DateItem DateItem(String title);

	edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem TextAreaItem(
			String title);

	CheckBoxItem CheckBoxItem(String title);

	edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.EscapedTextItem EscapedTextItem(
			String title);

	edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem IntegerItem(
			String title);

	edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem DoubleItem(
			String title);

	TextButton TextButton(String title);

	TextButton TextButton(String title, Procedure1<? super SelectEvent> handler);

	com.sencha.gxt.widget.core.client.form.TextArea TextArea();

	com.google.gwt.user.client.ui.Label Label(String title);

	edu.fudan.langlab.gxt.client.widget.FramedPanel FramedPanel(String title);

	ContentPanel ContentPanel(String title);
	
	com.sencha.gxt.widget.core.client.ContentPanel NavHeader(String title);

	com.sencha.gxt.widget.core.client.ContentPanel AccordionPanel(String title, ImageResource image);

	ContentPanel ContentPanel();

	ContentPanel ContentPanel(String title, Widget content);

	FieldSet FieldSet(String title);

	BorderLayoutContainer BorderLayout();

	FieldLabel FieldLabel(Widget content, String title);

	com.sencha.gxt.widget.core.client.box.MessageBox MessageBox(String title,
			String content);

	ConfirmMessageBox ConfirmMessageBox(String title, String content,
			Procedure1<? super Void> handler);

	com.sencha.gxt.widget.core.client.box.MultiLinePromptMessageBox MultiLinePromptMessageBox(
			String title, String message, Procedure1<String> handler);

	TabPanel TabPanel();

	com.sencha.gxt.widget.core.client.menu.Menu Menu();

	com.sencha.gxt.widget.core.client.menu.MenuItem MenuItem(String title);

	ButtonBar ButtonBar();
	
	com.uniquesoft.gwt.client.common.widgets.IPresenterContainer PresenterContainer();
	
	VerticalLayoutContainer DialogContent(Widget content);
	
	<T> ValueDialog<T> ValueDialog(IValueProvider<T> valueProvider,final Procedure1<? super T> valueProcessor);
}
