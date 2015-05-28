package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskSimpleListGrid;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchDataForm;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.action.MultiObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverTaskDispatchView extends ErrorNotifierViewer implements DeliverTaskDispatchPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form,taskList),
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
  private DeliverTaskDispatchDataForm form;
  
  @Inject
  private CenterlizedDeliverTaskSimpleListGrid taskList;
  
  @Inject
  private Provider<CenterlizedDeliverTaskQueryListPresenter> centerlizedDeliverTaskQueryListPresenter;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldSet _FieldSet = DeliverTaskDispatchView.this.widgets.FieldSet("\u4EFB\u52A1\u6E05\u5355");
          final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                ContentPanel _ContentPanel = DeliverTaskDispatchView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      SGroupingGrid<UICenterlizedDeliverTask> _asMultiSelectGrid = DeliverTaskDispatchView.this.taskList.asMultiSelectGrid();
                      it.setWidget(_asMultiSelectGrid);
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {
                            CenterlizedDeliverTaskQueryListPresenter _get = DeliverTaskDispatchView.this.centerlizedDeliverTaskQueryListPresenter.get();
                            final Procedure1<CenterlizedDeliverTaskQueryListPresenter> _function = new Procedure1<CenterlizedDeliverTaskQueryListPresenter>() {
                                public void apply(final CenterlizedDeliverTaskQueryListPresenter it) {
                                  final Procedure1<Iterable<UICenterlizedDeliverTask>> _function = new Procedure1<Iterable<UICenterlizedDeliverTask>>() {
                                      public void apply(final Iterable<UICenterlizedDeliverTask> it) {
                                        final Procedure1<UICenterlizedDeliverTask> _function = new Procedure1<UICenterlizedDeliverTask>() {
                                            public void apply(final UICenterlizedDeliverTask it) {
                                              DeliverTaskDispatchView.this.taskList.addElement(it);
                                            }
                                          };
                                        IterableExtensions.<UICenterlizedDeliverTask>forEach(it, _function);
                                      }
                                    };
                                  Dialog _asMultiSelector = ObjectSelector.<UICenterlizedDeliverTask>asMultiSelector(it, "\u9009\u62E9", 800, 500, _function);
                                  _asMultiSelector.show();
                                }
                              };
                            _get.setup(new IPresenterInitiazerNotifier<CenterlizedDeliverTaskQueryListPresenter>() {
                                public void done(CenterlizedDeliverTaskQueryListPresenter presenter) {
                                  _function.apply(presenter);
                                }
                            });
                          }
                        };
                      TextButton _TextButton = DeliverTaskDispatchView.this.widgets.TextButton("\u8FFD\u52A0", _function);
                      it.addButton(_TextButton);
                      final ActionContext<UICenterlizedDeliverTask> taskListAc = ActionExtensions.<UICenterlizedDeliverTask>createActionContext(DeliverTaskDispatchView.this.taskList);
                      final Procedure1<MultiObjectActions> _function_1 = new Procedure1<MultiObjectActions>() {
                          public void apply(final MultiObjectActions it) {
                            final Procedure1<Iterable<UICenterlizedDeliverTask>> _function = new Procedure1<Iterable<UICenterlizedDeliverTask>>() {
                                public void apply(final Iterable<UICenterlizedDeliverTask> selectedTasks) {
                                  final Procedure1<UICenterlizedDeliverTask> _function = new Procedure1<UICenterlizedDeliverTask>() {
                                      public void apply(final UICenterlizedDeliverTask it) {
                                        DeliverTaskDispatchView.this.taskList.removeElement(it);
                                      }
                                    };
                                  IterableExtensions.<UICenterlizedDeliverTask>forEach(selectedTasks, _function);
                                }
                              };
                            it.onExecute(_function);
                          }
                        };
                      MultiObjectActions _onMultiObjectAction = MultiObjectActions.<UICenterlizedDeliverTask>onMultiObjectAction(taskListAc, _function_1);
                      TextButton _asButtonRequester = _onMultiObjectAction.asButtonRequester("\u79FB\u9664");
                      it.addButton(_asButtonRequester);
                    }
                  };
                ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                it.setWidget(_doubleArrow);
              }
            };
          FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
          VerticalLayoutData _VLayoutData = DeliverTaskDispatchView.this.widgets.VLayoutData(1, 200);
          it.add(_doubleArrow, _VLayoutData);
          FieldSet _FieldSet_1 = DeliverTaskDispatchView.this.widgets.FieldSet("\u8C03\u5EA6\u4FE1\u606F");
          final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                Widget _asWidget = DeliverTaskDispatchView.this.form.asWidget();
                it.setWidget(_asWidget);
              }
            };
          FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData_1 = DeliverTaskDispatchView.this.widgets.VLayoutData(1, _minus);
          it.add(_doubleArrow_1, _VLayoutData_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_doubleArrow);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public DeliverTaskDispatchData getValue() {
    DeliverTaskDispatchData _value = this.form.getValue();
    return _value;
  }
  
  public Size getSize() {
    Size _size = new Size(600, 550);
    return _size;
  }
  
  public String getTitle() {
    return "\u8C03\u5EA6";
  }
  
  public void setTasks(final Iterable<UICenterlizedDeliverTask> tasks) {
    this.taskList.setObjects(tasks);
  }
  
  public Iterable<UICenterlizedDeliverTask> getTasks() {
    Iterable<UICenterlizedDeliverTask> _objects = this.taskList.getObjects();
    return _objects;
  }
}
