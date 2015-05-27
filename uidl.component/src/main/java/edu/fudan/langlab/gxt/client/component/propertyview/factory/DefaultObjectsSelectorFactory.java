package edu.fudan.langlab.gxt.client.component.propertyview.factory;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesViewer;

import edu.fudan.langlab.gxt.client.component.form.factory.DualListMultiSelector;

public class DefaultObjectsSelectorFactory implements IInitializerSupport {

	public class PropertyItem<T> implements IValuesViewer<T>, IPropertyItem<T> {
		private String name;
		private Collection<T> value;
		private int colspan;
		private String id;
		private Label label;

		public PropertyItem() {

		}

		public PropertyItem(String id, String name, int colspan) {
			label = new Label();
			this.id = id;
			this.name = name;
			this.colspan = colspan;
		}

		public PropertyItem(String id, String name) {
			label = new Label();
			this.id = id;
			this.name = name;
			this.colspan = 1;
		}

		/* (non-Javadoc)
		 * @see edu.fudan.langlab.gxt.client.component.propertyview.factory.IPropertyItem#getName()
		 */
		@Override
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setValue(Collection<T> value) {
			this.value = value;
			label.setText(toString(value));
		}

		/* (non-Javadoc)
		 * @see edu.fudan.langlab.gxt.client.component.propertyview.factory.IPropertyItem#getColspan()
		 */
		@Override
		public int getColspan() {
			return colspan;
		}

		public void setColspan(int colspan) {
			this.colspan = colspan;
		}

		public String toString(Collection<T> value) {
			Iterable<String> desc = Iterables.transform(value,
					new Function<T, String>() {

						@Override
						@Nullable
						public String apply(@Nullable final T arg0) {
							return runtimeGinjector.getObjectNameProvider()
									.getName(arg0);
						}
					});
			return IterableExtensions.join(desc,",");
		}

		/* (non-Javadoc)
		 * @see edu.fudan.langlab.gxt.client.component.propertyview.factory.IPropertyItem#asWidget()
		 */
		@Override
		public Label asWidget() {
			return label;
		}

	}

	@Inject
	RuntimeGinjector runtimeGinjector;

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	@WidgetProvider(isDefault = true)
	public <T> IValuesViewer<T> createAsPropertyItem(String id, String title) {
		return new PropertyItem<T>(id, title);
	}

	@WidgetProvider
	public <T> IValuesViewer<T> createAsPropertyItem(String id, String title,
			int colSpan) {
		return new PropertyItem<T>(id, title, colSpan);
	}
}
