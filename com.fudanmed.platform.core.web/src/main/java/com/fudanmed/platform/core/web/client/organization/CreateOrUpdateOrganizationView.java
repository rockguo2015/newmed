package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationPresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionSimpleListGrid;
import com.fudanmed.platform.core.web.client.organization.OrganizationForm;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Objects;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateOrganizationView extends ErrorNotifierViewer implements CreateOrUpdateOrganizationPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form,selectedLocation),
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
  
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  public void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter) {
    this.onsiteLocationOutlinePresenter = onsiteLocationOutlinePresenter;
  }
  
  @Inject
  private OrganizationForm form;
  
  @Inject
  private OnsitePositionSimpleListGrid selectedLocation;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Widget _asWidget = CreateOrUpdateOrganizationView.this.form.asWidget();
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = CreateOrUpdateOrganizationView.this.widgets.VLayoutData(390, _minus, 10);
          it.add(_asWidget, _VLayoutData);
          FieldSet _FieldSet = CreateOrUpdateOrganizationView.this.widgets.FieldSet("\u9009\u62E9\u4F4D\u7F6E");
          final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                OnsiteLocationOutlinePresenterView _view = CreateOrUpdateOrganizationView.this.onsiteLocationOutlinePresenter.getView();
                final ActionContext<UIOnsitePosition> avaiableAc = _view.getActionContext();
                CreateOrUpdateOrganizationView.this.selectedLocation.asWidget();
                final ActionContext<UIOnsitePosition> selectedAc = ActionExtensions.<UIOnsitePosition>createActionContext(CreateOrUpdateOrganizationView.this.selectedLocation);
                PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                    public void apply(final PlainHTMLTable it) {
                      PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  OnsiteLocationOutlinePresenterView _view = CreateOrUpdateOrganizationView.this.onsiteLocationOutlinePresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  final Procedure1<Widget> _function = new Procedure1<Widget>() {
                                      public void apply(final Widget it) {
                                        it.setWidth("150");
                                        it.setHeight("180");
                                      }
                                    };
                                  Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_asWidget, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  VerticalLayoutContainer _VLayout = CreateOrUpdateOrganizationView.this.widgets.VLayout();
                                  final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                      public void apply(final VerticalLayoutContainer it) {
                                        final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
                                                  public void apply(final UIOnsitePosition p) {
                                                    avaiableAc.deselect();
                                                    CreateOrUpdateOrganizationView.this.selectedLocation.addElement(p);
                                                  }
                                                };
                                              it.onExecute(_function);
                                              final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                                  public Boolean apply(final Void it) {
                                                    final Function1<UIOnsitePosition,Boolean> _function = new Function1<UIOnsitePosition,Boolean>() {
                                                        public Boolean apply(final UIOnsitePosition selected) {
                                                          Iterable<UIOnsitePosition> _objects = CreateOrUpdateOrganizationView.this.selectedLocation.getObjects();
                                                          final Function1<UIOnsitePosition,Boolean> _function = new Function1<UIOnsitePosition,Boolean>() {
                                                              public Boolean apply(final UIOnsitePosition it) {
                                                                Long _id = it.getId();
                                                                Long _id_1 = selected.getId();
                                                                boolean _equals = Objects.equal(_id, _id_1);
                                                                return Boolean.valueOf(_equals);
                                                              }
                                                            };
                                                          boolean _exists = IterableExtensions.<UIOnsitePosition>exists(_objects, _function);
                                                          boolean _not = (!_exists);
                                                          return Boolean.valueOf(_not);
                                                        }
                                                      };
                                                    Boolean _isOnlySelectedAnd = ObjectSelectionProviders.<UIOnsitePosition>isOnlySelectedAnd(avaiableAc, _function);
                                                    return _isOnlySelectedAnd;
                                                  }
                                                };
                                              it.onCheckEnable(_function_1);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOnsitePosition>onSingleObjectAction(avaiableAc, _function);
                                        TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("=>");
                                        it.add(_asButtonRequester);
                                        final Procedure1<SingleObjectActions> _function_1 = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
                                                  public void apply(final UIOnsitePosition p) {
                                                    avaiableAc.deselect();
                                                    CreateOrUpdateOrganizationView.this.selectedLocation.removeElement(p);
                                                  }
                                                };
                                              it.onExecute(_function);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction_1 = SingleObjectActions.<UIOnsitePosition>onSingleObjectAction(selectedAc, _function_1);
                                        TextButton _asButtonRequester_1 = _onSingleObjectAction_1.asButtonRequester("<=");
                                        it.add(_asButtonRequester_1);
                                      }
                                    };
                                  VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                  it.add(_doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  ContentPanel _ContentPanel = CreateOrUpdateOrganizationView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        SGroupingGrid<UIOnsitePosition> _asWidget = CreateOrUpdateOrganizationView.this.selectedLocation.asWidget();
                                        final Procedure1<SGroupingGrid<UIOnsitePosition>> _function = new Procedure1<SGroupingGrid<UIOnsitePosition>>() {
                                            public void apply(final SGroupingGrid<UIOnsitePosition> it) {
                                              it.setHeight("180");
                                            }
                                          };
                                        SGroupingGrid<UIOnsitePosition> _doubleArrow = ObjectExtensions.<SGroupingGrid<UIOnsitePosition>>operator_doubleArrow(_asWidget, _function);
                                        it.setWidget(_doubleArrow);
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                it.setWidget(_doubleArrow);
              }
            };
          FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
          int _minus_1 = (-1);
          VerticalLayoutData _VLayoutData_1 = CreateOrUpdateOrganizationView.this.widgets.VLayoutData(380, _minus_1, 1);
          it.add(_doubleArrow, _VLayoutData_1);
          FieldLabel _asWidget_1 = CreateOrUpdateOrganizationView.this.form.inputNext.asWidget();
          final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                CreateOrUpdateOrganizationView.this.form.inputNext.setValue(Boolean.valueOf(true));
              }
            };
          FieldLabel _doubleArrow_1 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function_1);
          int _minus_2 = (-1);
          VerticalLayoutData _VLayoutData_2 = CreateOrUpdateOrganizationView.this.widgets.VLayoutData(100, _minus_2, 10);
          it.add(_doubleArrow_1, _VLayoutData_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIOrganization getValue() {
    UIOrganization _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIOrganization value) {
    this.form.setValue(value);
    FieldLabel _asWidget = this.form.inputNext.asWidget();
    _asWidget.hide();
  }
  
  public Size getSize() {
    Size _size = new Size(400, 420);
    return _size;
  }
  
  public String getTitle() {
    return "\u7EC4\u7EC7\u673A\u6784\u7EF4\u62A4";
  }
  
  public void setPositions(final Collection<UIOnsitePosition> positions) {
    this.selectedLocation.setObjects(positions);
  }
  
  public Collection<UIOnsitePosition> getPositions() {
    Iterable<UIOnsitePosition> _objects = this.selectedLocation.getObjects();
    Collection<UIOnsitePosition> _unlazy = IterableExtensions2.<UIOnsitePosition>unlazy(_objects);
    return _unlazy;
  }
  
  public void setParent(final RCOrganizationProxy parent) {
    this.form.parent.setValue(parent);
  }
}
