package com.lanmon.business.client.event;

import com.google.inject.Inject;
import com.lanmon.business.client.event.GWTEventTypeContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.event.GWTEvent;
import com.lanmon.business.shared.event.GWTEventType;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.SmartGwtClientUi;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory.DateItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.FileValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.FileValueProviderFactory.FileUploaderValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ReadonlyValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextAreaBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.validation.ValidationUtils;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EventForm extends FormComponent<GWTEvent> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ComboBoxSingleEntitySelector<GWTEventType> type;
  
  @Inject
  public GWTEventTypeContentProvider typeContentProvider;
  
  public TextAreaBasedStringValueProvider note;
  
  public DateItemBasedStringValueProvider eventDate;
  
  public ReadonlyValueProvider<GWTNamedEntity> eventAuthor;
  
  public FileUploaderValueProvider attachment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private FileValueProviderFactory fileValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTEvent value = new GWTEvent();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsSelectItemAdaptor("type","类型");
    type.setContentProvider(typeContentProvider);
    note = stringValueProviderFactory.createAsTextAreaAdaptor("note","事件信息");
    eventDate = dateValueProviderFactory.createAsDateItem("eventDate","日期");
    eventAuthor = defaultObjectSelectorFactory.createAsReadonlyTextItem("eventAuthor","记录人");
    attachment = fileValueProviderFactory.createAsFileItem("attachment","上传附件");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTEvent getValueAsNew() {
    GWTEvent value = new GWTEvent();
    value.setType(type.getValue());
    value.setNote(note.getValue());
    value.setEventDate(eventDate.getValue());
    value.setAttachment(attachment.getValue());
    return value;
  }
  
  public GWTEvent doGetValue() {
    
    value.setType(type.getValue());
    value.setNote(note.getValue());
    value.setEventDate(eventDate.getValue());
    value.setAttachment(attachment.getValue());
    return value;
  }
  
  public GWTEvent getValue(final GWTEvent copyValue) {
    
    copyValue.setType(type.getValue());
    copyValue.setNote(note.getValue());
    copyValue.setEventDate(eventDate.getValue());
    copyValue.setAttachment(attachment.getValue());
    return copyValue;
  }
  
  protected EventForm doSetValue(final GWTEvent value) {
    this.value = value;
    type.setValue(value.getType());
    note.setValue(value.getNote());
    eventDate.setValue(value.getEventDate());
    eventAuthor.setValue(value.getEventAuthor());
    attachment.setValue(value.getAttachment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)type,(ICanAsWidget)note,(ICanAsWidget)eventDate,(ICanAsWidget)eventAuthor,(ICanAsWidget)attachment
    					);
  }
  
  public VLayout asWidget() {
    final Function1<Void,VLayout> _function = new Function1<Void,VLayout>() {
        public VLayout apply(final Void it) {
          VLayout _VLayout = EventForm.this.widgets.VLayout();
          final Procedure1<VLayout> _function = new Procedure1<VLayout>() {
              public void apply(final VLayout it) {
                SelectItem _asWidget = EventForm.this.type.asWidget();
                final Procedure1<SelectItem> _function = new Procedure1<SelectItem>() {
                    public void apply(final SelectItem it) {
                      EventForm.this.type.setValue(GWTEventType.PhoneCall);
                    }
                  };
                SelectItem _doubleArrow = ObjectExtensions.<SelectItem>operator_doubleArrow(_asWidget, _function);
                DateItem _asWidget_1 = EventForm.this.eventDate.asWidget();
                StaticTextItem _asWidget_2 = EventForm.this.eventAuthor.asWidget();
                CanvasItem _asWidget_3 = EventForm.this.attachment.asWidget();
                DynamicForm _DynamicForm = EventForm.this.widgets.DynamicForm(_doubleArrow, _asWidget_1, _asWidget_2, _asWidget_3);
                final Procedure1<DynamicForm> _function_1 = new Procedure1<DynamicForm>() {
                    public void apply(final DynamicForm it) {
                      it.setNumCols(4);
                    }
                  };
                DynamicForm _doubleArrow_1 = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function_1);
                DynamicForm _form = EventForm.this.form = _doubleArrow_1;
                SmartGwtClientUi.operator_add(it, _form);
                TextAreaItem _asWidget_4 = EventForm.this.note.asWidget();
                final Procedure1<TextAreaItem> _function_2 = new Procedure1<TextAreaItem>() {
                    public void apply(final TextAreaItem it) {
                      it.setWidth(400);
                    }
                  };
                TextAreaItem _doubleArrow_2 = ObjectExtensions.<TextAreaItem>operator_doubleArrow(_asWidget_4, _function_2);
                DynamicForm _DynamicForm_1 = EventForm.this.widgets.DynamicForm(_doubleArrow_2);
                DynamicForm _form_1 = EventForm.this.form = _DynamicForm_1;
                SmartGwtClientUi.operator_add(it, _form_1);
              }
            };
          VLayout _doubleArrow = ObjectExtensions.<VLayout>operator_doubleArrow(_VLayout, _function);
          return _doubleArrow;
        }
      };
    VLayout _lazy = ClientUi.<VLayout>lazy(this.body, _function);
    VLayout _body = this.body = _lazy;
    return _body;
  }
  
  public void showErrors(final Collection<ValidationErrorItem> errors) {
    ValidationUtils.showErrors(this.form, errors);
    ValidationUtils.showErrors(this.formNote, errors);
  }
  
  private DynamicForm form;
  
  private DynamicForm formNote;
  
  private VLayout body;
}
