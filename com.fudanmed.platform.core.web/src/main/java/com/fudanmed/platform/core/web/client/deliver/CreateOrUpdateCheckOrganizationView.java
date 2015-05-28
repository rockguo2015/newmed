package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationForm;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateCheckOrganizationView extends FormViewerImpl<UICheckOrganization> implements CreateOrUpdateCheckOrganizationPresenterView, IHasSize, IHasTitle {
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
  private CheckOrganizationForm form;
  
  public CheckOrganizationForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(300,200);
  }
  
  public String getTitle() {
    return "??维护";
  }
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  public void initialize() {
    
    PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          PlainHTMLTR _tr = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = CreateOrUpdateCheckOrganizationView.this.form.code.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
          PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = CreateOrUpdateCheckOrganizationView.this.form.name.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
          PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                      final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                          public void apply(final PlainHTMLTable it) {
                            PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                            final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                public void apply(final PlainHTMLTR it) {
                                  PlainHTMLTD _td = HTMLTagsExt.td(it);
                                  final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                      public void apply(final PlainHTMLTD it) {
                                        FieldLabel _asWidget = CreateOrUpdateCheckOrganizationView.this.form.organization.asWidget();
                                        ClientUi.operator_add(it, _asWidget);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                  PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                  final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                      public void apply(final PlainHTMLTD it) {
                                        TextButton _TextButton = CreateOrUpdateCheckOrganizationView.this.widgets.TextButton("\u9009\u62E9");
                                        final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                            public void apply(final TextButton it) {
                                              final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                  public void apply(final SelectEvent it) {
                                                    OrganizationOutlinePresenter _get = CreateOrUpdateCheckOrganizationView.this.organizationOutlinePresenter.get();
                                                    final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                        public void apply(final OrganizationOutlinePresenter it) {
                                                          final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                              public void apply(final UIOrganization it) {
                                                                RCOrganizationProxy _proxy = it.toProxy();
                                                                CreateOrUpdateCheckOrganizationView.this.form.organization.setValue(_proxy);
                                                              }
                                                            };
                                                          Dialog _asSelector = ObjectSelector.<UIOrganization>asSelector(it, "\u9009\u62E9\u533A\u57DF\u4F4D\u7F6E", 300, 500, _function);
                                                          _asSelector.show();
                                                        }
                                                      };
                                                    _get.setupAsSimpleTree(_function);
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
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_doubleArrow);
    ClientUi.operator_add(this, _DialogContent);
  }
}
