package edu.fudan.langlab.gxt.client.component.grid.factory;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.cell.core.client.ButtonCell;
import com.sencha.gxt.cell.core.client.ResizeCell;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.ActionColumn;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;

public class ActionColumnValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class ImageCell<C> extends ResizeCell<C> implements
			HasSelectHandlers {
		private String title;
		ImageResource icon;

		@Override
		public HandlerRegistration addSelectHandler(SelectHandler handler) {
			return addHandler(handler, SelectEvent.getType());
		}

		public ImageCell(String title) {
			super("click", "keydown", "mousedown", "mouseup", "mouseover",
					"mouseout", "focus", "blur");
			this.title = title;

		}

		@Override
		public void onBrowserEvent(
				com.google.gwt.cell.client.Cell.Context context,
				Element parent, C value, NativeEvent event,
				ValueUpdater<C> valueUpdater) {
			super.onBrowserEvent(context, parent, value, event, valueUpdater);

			String eventType = event.getType();
			if ("click".equals(eventType)) {
				fireEvent(context, new SelectEvent(context));
			}

		}

		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context,
				C value, SafeHtmlBuilder sb) {
			sb.appendHtmlConstant("<img src='" + icon.getSafeUri().asString() + "'/>");

		}
		public void setImage(ImageResource icon) {
			this.icon = icon;
		}

	}

	public static class ImageCellColumn<D> extends
			GXTGridColumn<D, ActionColumn> {

		public interface GridItemSelectHandler<D> {
			void objectSelected(D d);
		}

		private GridItemSelectHandler<D> selectHandler;
		GXTGridComponent<D> gridComponent;
		ImageCell<ActionColumn> buttonCell;

		public ImageCellColumn(String id, String title,
				IObjectFieldAccessor<D, ActionColumn> objectValues) {
			columnConfig = new SummaryColumnConfig<D, ActionColumn>(
					new ValueProviderAdaptor<D, ActionColumn>(objectValues, id));
			buttonCell = new ImageCell<ActionColumn>(title);
			buttonCell.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					if (selectHandler != null) {
						Context c = event.getContext();
						int row = c.getIndex();
						D p = gridComponent.asWidget().getStore().get(row);
						selectHandler.objectSelected(p);
					}
				}
			});
			columnConfig.setCell(buttonCell);
		}

		public void setSelectHandler(GXTGridComponent<D> gridComponent,
				GridItemSelectHandler<D> selectHandler) {
			this.selectHandler = selectHandler;
			this.gridComponent = gridComponent;
		}

		public void setImage(ImageResource icon) {
			buttonCell.setImage(icon);
		}
	}

	public static class LinkCell<C> extends ResizeCell<C> implements
			HasSelectHandlers {
		private String title;

		@Override
		public HandlerRegistration addSelectHandler(SelectHandler handler) {
			return addHandler(handler, SelectEvent.getType());
		}

		public LinkCell(String title) {
			super("click", "keydown", "mousedown", "mouseup", "mouseover",
					"mouseout", "focus", "blur");
			this.title = title;

		}

		@Override
		public void onBrowserEvent(
				com.google.gwt.cell.client.Cell.Context context,
				Element parent, C value, NativeEvent event,
				ValueUpdater<C> valueUpdater) {
			super.onBrowserEvent(context, parent, value, event, valueUpdater);

			String eventType = event.getType();
			if ("click".equals(eventType)) {
				fireEvent(context, new SelectEvent(context));
			}

		}

		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context,
				C value, SafeHtmlBuilder sb) {
			sb.appendHtmlConstant("<a style='text-decoration:underline;cursor:pointer;'>"
					+ title + "</a>");

		}

	}

	public static class LinkCellColumn<D> extends
			GXTGridColumn<D, ActionColumn> {
		public interface GridItemSelectHandler<D> {
			void objectSelected(D d);
		}

		private GridItemSelectHandler<D> selectHandler;
		GXTGridComponent<D> gridComponent;
		LinkCell<ActionColumn> buttonCell;

		public LinkCellColumn(String id, String title,
				IObjectFieldAccessor<D, ActionColumn> objectValues) {
			columnConfig = new SummaryColumnConfig<D, ActionColumn>(
					new ValueProviderAdaptor<D, ActionColumn>(objectValues, id));
			buttonCell = new LinkCell<ActionColumn>(title);
			buttonCell.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					if (selectHandler != null) {
						Context c = event.getContext();
						int row = c.getIndex();
						D p = gridComponent.asWidget().getStore().get(row);
						selectHandler.objectSelected(p);
					}
				}
			});
			// buttonCell.setText(title);
			columnConfig.setCell(buttonCell);

		}

		public void setImage(ImageResource icon) {
			// buttonCell.setIcon(icon);
		}

		public void setSelectHandler(GXTGridComponent<D> gridComponent,
				GridItemSelectHandler<D> selectHandler) {
			this.selectHandler = selectHandler;
			this.gridComponent = gridComponent;
		}

	}

	public static class TextButtonActionColumn<D> extends
			GXTGridColumn<D, ActionColumn> {

		public interface GridItemSelectHandler<D> {
			void objectSelected(D d);
		}

		private GridItemSelectHandler<D> selectHandler;
		GXTGridComponent<D> gridComponent;
		ButtonCell<ActionColumn> buttonCell;

		public TextButtonActionColumn(String id, String title,
				IObjectFieldAccessor<D, ActionColumn> objectValues) {
			columnConfig = new SummaryColumnConfig<D, ActionColumn>(
					new ValueProviderAdaptor<D, ActionColumn>(objectValues, id));
			buttonCell = new ButtonCell<ActionColumn>();
			buttonCell.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					if (selectHandler != null) {
						Context c = event.getContext();
						int row = c.getIndex();
						D p = gridComponent.asWidget().getStore().get(row);
						selectHandler.objectSelected(p);
					}
				}
			});
			buttonCell.setText(title);
			columnConfig.setCell(buttonCell);
		}

		public void setSelectHandler(GXTGridComponent<D> gridComponent,
				GridItemSelectHandler<D> selectHandler) {
			this.selectHandler = selectHandler;
			this.gridComponent = gridComponent;
		}

		public void setImage(ImageResource icon) {
			buttonCell.setIcon(icon);
		}
	}

	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> TextButtonActionColumn<D> createAsButtonColumn(String id,
			String title, IObjectFieldAccessor<D, ActionColumn> objectValues) {
		return new TextButtonActionColumn<D>(id, title, objectValues);
	}

	@WidgetProvider(requireAccessor = true)
	public <D> LinkCellColumn<D> createAsLinkColumn(String id, String title,
			IObjectFieldAccessor<D, ActionColumn> objectValues) {
		return new LinkCellColumn<D>(id, title, objectValues);
	}
	@WidgetProvider(requireAccessor = true)
	public <D> ImageCellColumn<D> createAsImageColumn(String id, String title,
			IObjectFieldAccessor<D, ActionColumn> objectValues) {
		return new ImageCellColumn<D>(id, title, objectValues);
	}

}
