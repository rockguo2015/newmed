package com.lanmon.business.client.event;

import com.google.inject.Inject;
import com.lanmon.business.client.common.Downloader;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.event.GWTEvent;
import com.lanmon.business.shared.event.GWTEventType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListView;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListView.CustomComponentCreator;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListView.CustomListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory.DateListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.ListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.datatype.File;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EventList extends ListViewComponent<GWTEvent> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ListViewItem<GWTEventType> type;
  
  public StringListViewItem note;
  
  public DateListViewItem eventDate;
  
  public ListViewItem<GWTNamedEntity> eventAuthor;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTEvent value = new GWTEvent();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsListGridItem("type","类型");
    note = stringValueProviderFactory.createAsListGridField("note","事件信息");
    eventDate = dateValueProviderFactory.createAsListGridField("eventDate","日期");
    eventAuthor = defaultObjectSelectorFactory.createAsListGridItem("eventAuthor","记录人");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTEvent getValueAsNew() {
    GWTEvent value = new GWTEvent();
    value.setType(type.getValue());
    value.setNote(note.getValue());
    value.setEventDate(eventDate.getValue());
    value.setEventAuthor(eventAuthor.getValue());
    return value;
  }
  
  public GWTEvent doGetValue() {
    
    value.setType(type.getValue());
    value.setNote(note.getValue());
    value.setEventDate(eventDate.getValue());
    value.setEventAuthor(eventAuthor.getValue());
    return value;
  }
  
  public GWTEvent getValue(final GWTEvent copyValue) {
    
    copyValue.setType(type.getValue());
    copyValue.setNote(note.getValue());
    copyValue.setEventDate(eventDate.getValue());
    copyValue.setEventAuthor(eventAuthor.getValue());
    return copyValue;
  }
  
  protected EventList doSetValue(final GWTEvent value) {
    this.value = value;
    type.setValue(value.getType());
    note.setValue(value.getNote());
    eventDate.setValue(value.getEventDate());
    eventAuthor.setValue(value.getEventAuthor());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)type,(ICanAsWidget)note,(ICanAsWidget)eventDate,(ICanAsWidget)eventAuthor
    					);
  }
  
  public void initialize() {
    ListView<GWTEvent> _listView = new ListView<GWTEvent>(this);
    final Procedure1<ListView<GWTEvent>> _function = new Procedure1<ListView<GWTEvent>>() {
        public void apply(final ListView<GWTEvent> it) {
          final Procedure1<StringListViewItem> _function = new Procedure1<StringListViewItem>() {
              public void apply(final StringListViewItem it) {
                ListGridField _asWidget = it.asWidget();
                _asWidget.setWidth("40%");
              }
            };
          StringListViewItem _doubleArrow = ObjectExtensions.<StringListViewItem>operator_doubleArrow(
            EventList.this.note, _function);
          final Function1<GWTEvent,ImgButton> _function_1 = new Function1<GWTEvent,ImgButton>() {
              public ImgButton apply(final GWTEvent event) {
                ImgButton _xifexpression = null;
                Boolean _hasAttachment = event.getHasAttachment();
                if ((_hasAttachment).booleanValue()) {
                  ImgButton _ImgButton = EventList.this.widgets.ImgButton("download.png");
                  final Procedure1<ImgButton> _function = new Procedure1<ImgButton>() {
                      public void apply(final ImgButton it) {
                        it.setWidth(16);
                        it.setHeight(16);
                        final Procedure1<ClickEvent> _function = new Procedure1<ClickEvent>() {
                            public void apply(final ClickEvent it) {
                              File _attachment = event.getAttachment();
                              String _fullPathName = _attachment.getFullPathName();
                              Downloader.download(_fullPathName);
                            }
                          };
                        it.addClickHandler(new ClickHandler() {
                            public void onClick(ClickEvent event) {
                              _function.apply(event);
                            }
                        });
                      }
                    };
                  ImgButton _doubleArrow = ObjectExtensions.<ImgButton>operator_doubleArrow(_ImgButton, _function);
                  _xifexpression = _doubleArrow;
                }
                return _xifexpression;
              }
            };
          CustomListViewItem _newColumn = it.newColumn("attachment", "\u9644\u4EF6", new CustomComponentCreator<GWTEvent>() {
              public Canvas createRecordComponent(GWTEvent record) {
                return _function_1.apply(record);
              }
          });
          final Procedure1<CustomListViewItem> _function_2 = new Procedure1<CustomListViewItem>() {
              public void apply(final CustomListViewItem it) {
                ListGridField _asWidget = it.asWidget();
                _asWidget.setWidth(30);
              }
            };
          CustomListViewItem _doubleArrow_1 = ObjectExtensions.<CustomListViewItem>operator_doubleArrow(_newColumn, _function_2);
          it.setFields(
            EventList.this.type, _doubleArrow, 
            EventList.this.eventDate, 
            EventList.this.eventAuthor, _doubleArrow_1);
        }
      };
    ListView<GWTEvent> _doubleArrow = ObjectExtensions.<ListView<GWTEvent>>operator_doubleArrow(_listView, _function);
    this.listView = _doubleArrow;
    ListGrid _listGrid = this.listView.getListGrid();
    _listGrid.setWrapCells(Boolean.valueOf(false));
  }
}
