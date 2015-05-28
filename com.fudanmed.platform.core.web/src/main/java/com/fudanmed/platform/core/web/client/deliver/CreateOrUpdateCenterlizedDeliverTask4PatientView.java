package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTask4PatientForm;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenter;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientForm;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenter;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateCenterlizedDeliverTask4PatientView extends FormViewerImpl<UICenterlizedDeliverTask4Patient> implements CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  @Inject
  private CenterlizedDeliverTask4PatientForm form;
  
  public CenterlizedDeliverTask4PatientForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(915,550);
  }
  
  public String getTitle() {
    return "运送病人";
  }
  
  private InHospitalPatientPropertyPresenter inHospitalPatientPropertyPresenter;
  
  public void setInHospitalPatientPropertyPresenter(final InHospitalPatientPropertyPresenter inHospitalPatientPropertyPresenter) {
    this.inHospitalPatientPropertyPresenter = inHospitalPatientPropertyPresenter;
  }
  
  @Inject
  private Provider<CreateOrUpdateInHospitalPatientPresenter> createOrUpdateInHospitalPatientPresenter;
  
  public void initialize() {
    
    final Procedure1<DLDeliverPatientCheckTypeProxy> _function = new Procedure1<DLDeliverPatientCheckTypeProxy>() {
        public void apply(final DLDeliverPatientCheckTypeProxy it) {
          DLDeliverPatientCheckTypeProxy _value = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.checkType.getValue();
          checkTypeChangedRequestHandler.execute(_value);
          
        }
      };
    this.form.checkType.addValueChangedListener(new ValueChangedListener<DLDeliverPatientCheckTypeProxy>() {
        public void onValueChanged(DLDeliverPatientCheckTypeProxy value) {
          _function.apply(value);
        }
    });
    final Procedure1<DLInHospitalPatientProxy> _function_1 = new Procedure1<DLInHospitalPatientProxy>() {
        public void apply(final DLInHospitalPatientProxy it) {
          CreateOrUpdateCenterlizedDeliverTask4PatientView.this.inHospitalPatientPropertyPresenter.setValue(it);
        }
      };
    this.form.patient.addValueChangedListener(new ValueChangedListener<DLInHospitalPatientProxy>() {
        public void onValueChanged(DLInHospitalPatientProxy value) {
          _function_1.apply(value);
        }
    });
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function_2 = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.patient.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            TextButton _TextButton = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.widgets.TextButton("\u65B0\u5EFA");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        CreateOrUpdateInHospitalPatientPresenter _get = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.createOrUpdateInHospitalPatientPresenter.get();
                                        final Procedure1<DLInHospitalPatientProxy> _function = new Procedure1<DLInHospitalPatientProxy>() {
                                            public void apply(final DLInHospitalPatientProxy it) {
                                              CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.patient.setValue(it);
                                            }
                                          };
                                        final Procedure1<CreateOrUpdateInHospitalPatientPresenter> _function_1 = new Procedure1<CreateOrUpdateInHospitalPatientPresenter>() {
                                            public void apply(final CreateOrUpdateInHospitalPatientPresenter it) {
                                              eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                                              
                                            }
                                          };
                                        _get.setup4Create(_function, new IPresenterInitiazerNotifier<CreateOrUpdateInHospitalPatientPresenter>() {
                                            public void done(CreateOrUpdateInHospitalPatientPresenter presenter) {
                                              _function_1.apply(presenter);
                                            }
                                        });
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
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            it.setWidth("500");
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
          FieldSet _FieldSet = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.widgets.FieldSet("\u75C5\u4EBA\u4FE1\u606F");
          final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                InHospitalPatientPropertyPresenterView _view = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.inHospitalPatientPropertyPresenter.getView();
                Widget _asWidget = _view.asWidget();
                it.setWidget(_asWidget);
              }
            };
          FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_1);
          WidgetExtensions.<FieldSet>addFill(it, _doubleArrow_1);
          FieldSet _FieldSet_1 = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.widgets.FieldSet("\u68C0\u67E5\u9879\u76EE");
          final Procedure1<FieldSet> _function_2 = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                    public void apply(final PlainHTMLTable it) {
                      PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.checkType.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.checkOrganization.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.deliverMethod.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                      PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.emergency.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.planDate.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.planTime.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                      PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  it.setColSpan(3);
                                  FieldLabel _asWidget = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.patients.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        it.setHeight(300);
                                        final Function1<Void,UICenterlizedDeliverTask4Patient> _function = new Function1<Void,UICenterlizedDeliverTask4Patient>() {
                                            public UICenterlizedDeliverTask4Patient apply(final Void it) {
                                              UICenterlizedDeliverTask4Patient _valueAsNew = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.getValueAsNew();
                                              return _valueAsNew;
                                            }
                                          };
                                        CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.patients.setObjectCreater(new Function<Void,UICenterlizedDeliverTask4Patient>() {
                                            public UICenterlizedDeliverTask4Patient apply(Void input) {
                                              return _function.apply(input);
                                            }
                                        });
                                      }
                                    };
                                  FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                it.setWidget(_doubleArrow);
              }
            };
          FieldSet _doubleArrow_2 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_2);
          WidgetExtensions.<FieldSet>addFill(it, _doubleArrow_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function_2);
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_doubleArrow);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public Collection<UICenterlizedDeliverTask4Patient> getPatientDeliverList() {
    Collection<UICenterlizedDeliverTask4Patient> _patientDeliverList = this.form.getPatientDeliverList();
    return _patientDeliverList;
  }
  
  public void setCheckOrganization(final DLDeliverPatientCheckTypeProxy checkType) {
    this.form.checkOrganization.setValue(null);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.checkOrganization.selectFirst();
        }
      };
    this.form.checkOrganizationContentProvider.load(checkType, _function);
  }
  
  public void showPatientDetail(final UIInHospitalPatient detail) {
    InHospitalPatientForm _patientForm = this.form.getPatientForm();
    _patientForm.setValue(detail);
  }
  
  private RequestHandler1<DLDeliverPatientCheckTypeProxy> checkTypeChangedRequestHandler;
  
  public void checkTypeChanged(final RequestHandler1<DLDeliverPatientCheckTypeProxy> requestHandler) {
    this.checkTypeChangedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<DLInHospitalPatientProxy> patientChangedRequestHandler;
  
  public void patientChanged(final RequestHandler1<DLInHospitalPatientProxy> requestHandler) {
    this.patientChangedRequestHandler = requestHandler;
  }
}
