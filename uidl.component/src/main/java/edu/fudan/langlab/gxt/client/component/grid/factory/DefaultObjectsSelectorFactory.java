package edu.fudan.langlab.gxt.client.component.grid.factory;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;

public class DefaultObjectsSelectorFactory {
	

	public static class CollectionListColumn<D,T> extends GXTGridColumn<D, Collection<T>> {
		public CollectionListColumn(String id, String title,
				IObjectFieldAccessor<D, Collection<T>> objectValues, final IObjectNameProvider objectNameProvider,int width) {
			columnConfig = new SummaryColumnConfig<D, Collection<T>>(
					new ValueProviderAdaptor<D, Collection<T>>(objectValues,id),width);
			columnConfig.setHeader(title);
			columnConfig.setCell(new AbstractCell<Collection<T>>() {
				@Override
				public void render(
						com.google.gwt.cell.client.Cell.Context context,
						Collection<T> value, SafeHtmlBuilder sb) {
					Iterable<String> names = Iterables.transform(value, new Function<T,String>(){

						@Override
						public String apply(@Nullable T input) {
							return objectNameProvider.getName(input);
						}});
					sb.appendEscaped(IterableExtensions.join(names,","));
					
				}
			});
		}
	
	}

	@Inject
	RuntimeGinjector runtimeGinjector;

	@WidgetProvider(isDefault=true, requireAccessor = true)
	public <D,T> CollectionListColumn<D,T> createAsStringColumn(String id,
			String title,IObjectFieldAccessor<D, Collection<T>> objectValues) {
		return new CollectionListColumn<D,T>(id, title, objectValues,runtimeGinjector.getObjectNameProvider(),100);
	}
	@WidgetProvider(requireAccessor = true)
	public <D,T> CollectionListColumn<D,T> createAsStringColumn(String id,
			String title,IObjectFieldAccessor<D, Collection<T>> objectValues,int width) {
		return new CollectionListColumn<D,T>(id, title, objectValues,runtimeGinjector.getObjectNameProvider(),width);
	}

	@WidgetProvider(requireAccessor = true)
	public <D,T> CollectionListColumn<D,T> createAsAutoExpandListGridField(String id,
			String title,IObjectFieldAccessor<D, Collection<T>> objectValues) {
		CollectionListColumn<D, T> result = new CollectionListColumn<D,T>(id, title, objectValues,runtimeGinjector.getObjectNameProvider(),100);
		result.setAutoExpand(true);
		return result;
	}
	
}
