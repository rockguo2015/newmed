package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SupplierCriteriaForm extends GXTFormComponent<UISupplierCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem info;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UISupplierCriteria value = new UISupplierCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();info = stringValueProviderFactory.createAsEscapedTextItem("info","供应商信息");
    widgetsRegistory.put("info",info);
    if(queryRequest instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)queryRequest);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UISupplierCriteria getValueAsNew() {
    UISupplierCriteria value = new UISupplierCriteria();
    value.setInfo(info.getValue());
    return value;
  }
  
  public UISupplierCriteria doGetValue() {
    
    value.setInfo(info.getValue());
    return value;
  }
  
  public UISupplierCriteria getValue(final UISupplierCriteria copyValue) {
    
    copyValue.setInfo(info.getValue());
    return copyValue;
  }
  
  protected SupplierCriteriaForm doSetValue(final UISupplierCriteria value) {
    this.value = value;
    info.setValue(value.getInfo());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)info
    					);
  }
  
  public void setQueryRequest(final Procedure1<? super Void> queryRequest) {
    this.queryRequest = queryRequest;
  }
  
  public Widget createWidget() {
    PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          PlainHTMLTR _tr = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierCriteriaForm.this.info.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      TextButton _TextButton = SupplierCriteriaForm.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  SupplierCriteriaForm.this.queryRequest.apply(null);
                                }
                              };
                            it.addSelectHandler(new SelectHandler() {
                                public void onSelect(SelectEvent event) {
                                  _function.apply(event);
                                }
                            });
                          }
                        };
                      TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                      ClientUi.operator_add(it, _doubleArrow);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
    return _doubleArrow;
  }
  
  private Procedure1<? super Void> queryRequest;
}
