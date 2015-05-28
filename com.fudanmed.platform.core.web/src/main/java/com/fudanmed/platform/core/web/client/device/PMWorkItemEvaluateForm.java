package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.ScoreItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemEvaluateForm extends GXTFormComponent<UIPMWorkItemEvaluate> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem worker;
  
  public DateItem notifyDate;
  
  public DateItem arriveDate;
  
  public DoubleItem price;
  
  public TextItem materials;
  
  public ScoreItem arrivalOnTime;
  
  public ScoreItem attitude;
  
  public ScoreItem frequency;
  
  public ScoreItem quality;
  
  public TextAreaItem problemsRemains;
  
  public TextAreaItem comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMWorkItemEvaluate value = new UIPMWorkItemEvaluate();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();worker = stringValueProviderFactory.createAsTextItem("worker","维保人员");
    widgetsRegistory.put("worker",worker);
    notifyDate = dateValueProviderFactory.createAsDateItem("notifyDate","通知日期");
    widgetsRegistory.put("notifyDate",notifyDate);
    arriveDate = dateValueProviderFactory.createAsDateItem("arriveDate","维保日期");
    widgetsRegistory.put("arriveDate",arriveDate);
    price = doubleValueProviderFactory.createAsDoubleItem("price","维保价格");
    widgetsRegistory.put("price",price);
    materials = stringValueProviderFactory.createAsTextItem("materials","更换材料");
    widgetsRegistory.put("materials",materials);
    arrivalOnTime = integerValueProviderFactory.createAsScoreItem("arrivalOnTime","到达及时性",Integer.valueOf(5));
    widgetsRegistory.put("arrivalOnTime",arrivalOnTime);
    attitude = integerValueProviderFactory.createAsScoreItem("attitude","服务态度",Integer.valueOf(5));
    widgetsRegistory.put("attitude",attitude);
    frequency = integerValueProviderFactory.createAsScoreItem("frequency","同一问题频度",Integer.valueOf(5));
    widgetsRegistory.put("frequency",frequency);
    quality = integerValueProviderFactory.createAsScoreItem("quality","维保质量",Integer.valueOf(5));
    widgetsRegistory.put("quality",quality);
    problemsRemains = stringValueProviderFactory.createAsTextAreaItem("problemsRemains","需要解决问题");
    widgetsRegistory.put("problemsRemains",problemsRemains);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","意见与建议");
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMWorkItemEvaluate getValueAsNew() {
    UIPMWorkItemEvaluate value = new UIPMWorkItemEvaluate();
    value.setWorker(worker.getValue());
    value.setNotifyDate(notifyDate.getValue());
    value.setArriveDate(arriveDate.getValue());
    value.setPrice(price.getValue());
    value.setMaterials(materials.getValue());
    value.setArrivalOnTime(arrivalOnTime.getValue());
    value.setAttitude(attitude.getValue());
    value.setFrequency(frequency.getValue());
    value.setQuality(quality.getValue());
    value.setProblemsRemains(problemsRemains.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIPMWorkItemEvaluate doGetValue() {
    
    value.setWorker(worker.getValue());
    value.setNotifyDate(notifyDate.getValue());
    value.setArriveDate(arriveDate.getValue());
    value.setPrice(price.getValue());
    value.setMaterials(materials.getValue());
    value.setArrivalOnTime(arrivalOnTime.getValue());
    value.setAttitude(attitude.getValue());
    value.setFrequency(frequency.getValue());
    value.setQuality(quality.getValue());
    value.setProblemsRemains(problemsRemains.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIPMWorkItemEvaluate getValue(final UIPMWorkItemEvaluate copyValue) {
    
    copyValue.setWorker(worker.getValue());
    copyValue.setNotifyDate(notifyDate.getValue());
    copyValue.setArriveDate(arriveDate.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setMaterials(materials.getValue());
    copyValue.setArrivalOnTime(arrivalOnTime.getValue());
    copyValue.setAttitude(attitude.getValue());
    copyValue.setFrequency(frequency.getValue());
    copyValue.setQuality(quality.getValue());
    copyValue.setProblemsRemains(problemsRemains.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected PMWorkItemEvaluateForm doSetValue(final UIPMWorkItemEvaluate value) {
    this.value = value;
    worker.setValue(value.getWorker());
    notifyDate.setValue(value.getNotifyDate());
    arriveDate.setValue(value.getArriveDate());
    price.setValue(value.getPrice());
    materials.setValue(value.getMaterials());
    arrivalOnTime.setValue(value.getArrivalOnTime());
    attitude.setValue(value.getAttitude());
    frequency.setValue(value.getFrequency());
    quality.setValue(value.getQuality());
    problemsRemains.setValue(value.getProblemsRemains());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)worker,(ICanAsWidget)notifyDate,(ICanAsWidget)arriveDate,(ICanAsWidget)price,(ICanAsWidget)materials,(ICanAsWidget)arrivalOnTime,(ICanAsWidget)attitude,(ICanAsWidget)frequency,(ICanAsWidget)quality,(ICanAsWidget)problemsRemains,(ICanAsWidget)comment
    					);
  }
  
  public void disableAll() {
    FieldLabel _asWidget = this.worker.asWidget();
    _asWidget.disable();
    FieldLabel _asWidget_1 = this.notifyDate.asWidget();
    _asWidget_1.disable();
    FieldLabel _asWidget_2 = this.arriveDate.asWidget();
    _asWidget_2.disable();
    FieldLabel _asWidget_3 = this.price.asWidget();
    _asWidget_3.disable();
    FieldLabel _asWidget_4 = this.materials.asWidget();
    _asWidget_4.disable();
    FieldLabel _asWidget_5 = this.problemsRemains.asWidget();
    _asWidget_5.disable();
    FieldLabel _asWidget_6 = this.comment.asWidget();
    _asWidget_6.disable();
    FieldLabel _asWidget_7 = this.arrivalOnTime.asWidget();
    _asWidget_7.disable();
    FieldLabel _asWidget_8 = this.attitude.asWidget();
    _asWidget_8.disable();
    FieldLabel _asWidget_9 = this.frequency.asWidget();
    _asWidget_9.disable();
    FieldLabel _asWidget_10 = this.quality.asWidget();
    _asWidget_10.disable();
  }
  
  public void enableAll() {
    FieldLabel _asWidget = this.worker.asWidget();
    _asWidget.enable();
    FieldLabel _asWidget_1 = this.notifyDate.asWidget();
    _asWidget_1.enable();
    FieldLabel _asWidget_2 = this.arriveDate.asWidget();
    _asWidget_2.enable();
    FieldLabel _asWidget_3 = this.price.asWidget();
    _asWidget_3.enable();
    FieldLabel _asWidget_4 = this.materials.asWidget();
    _asWidget_4.enable();
    FieldLabel _asWidget_5 = this.problemsRemains.asWidget();
    _asWidget_5.enable();
    FieldLabel _asWidget_6 = this.comment.asWidget();
    _asWidget_6.enable();
    FieldLabel _asWidget_7 = this.arrivalOnTime.asWidget();
    _asWidget_7.enable();
    FieldLabel _asWidget_8 = this.attitude.asWidget();
    _asWidget_8.enable();
    FieldLabel _asWidget_9 = this.frequency.asWidget();
    _asWidget_9.enable();
    FieldLabel _asWidget_10 = this.quality.asWidget();
    _asWidget_10.enable();
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
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.worker.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.notifyDate.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
          PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.arriveDate.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.price.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
          PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.materials.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
          PlainHTMLTR _tr_3 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_3 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.arrivalOnTime.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.attitude.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_3, _function_3);
          PlainHTMLTR _tr_4 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_4 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.frequency.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.quality.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_4, _function_4);
          PlainHTMLTR _tr_5 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_5 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      it.setColSpan(2);
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.problemsRemains.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            it.setWidth(500);
                            it.setHeight(80);
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                      ClientUi.operator_add(it, _doubleArrow);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_5, _function_5);
          PlainHTMLTR _tr_6 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_6 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      it.setColSpan(2);
                      FieldLabel _asWidget = PMWorkItemEvaluateForm.this.comment.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            it.setWidth(500);
                            it.setHeight(80);
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                      ClientUi.operator_add(it, _doubleArrow);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_6, _function_6);
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
    return _doubleArrow;
  }
}
