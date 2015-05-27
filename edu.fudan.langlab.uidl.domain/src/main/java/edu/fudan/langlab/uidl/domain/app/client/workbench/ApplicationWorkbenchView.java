package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.common.base.Objects;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.ResizeContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.container.ResizeTrackerBorderLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PresenterWindow;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.theme.blue.client.navbar.NavMenuItem;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchActivePresenterProxy;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchCommandProxy;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchPartCategory;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchPartProxy;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchPresenterProxy;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchWindowProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenterView;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ApplicationWorkbenchView extends GWTAbstractView implements ApplicationWorkbenchPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(workbenchManager),
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
  
  private Viewport viewport;
  
  private BorderLayoutContainer body;
  
  private ContentPanel west;
  
  private SimpleContainer center;
  
  @Inject
  private WorkbenchManager workbenchManager;
  
  public void initialize() {
    
    Viewport _viewport = new Viewport();
    this.viewport = _viewport;
    ResizeTrackerBorderLayoutContainer _resizeTrackerBorderLayoutContainer = new ResizeTrackerBorderLayoutContainer();
    this.body = _resizeTrackerBorderLayoutContainer;
    int _clientWidth = Window.getClientWidth();
    int _clientHeight = Window.getClientHeight();
    this.body.setPixelSize(_clientWidth, _clientHeight);
    BorderLayoutData _borderLayoutData = new BorderLayoutData(80);
    final BorderLayoutData northData = _borderLayoutData;
    Margins _margins = new Margins(0);
    northData.setMargins(_margins);
    Presenter<? extends Viewer> _headerPresenter = this.workbenchManager.getHeaderPresenter();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          Presenter<? extends Viewer> _headerPresenter = ApplicationWorkbenchView.this.workbenchManager.getHeaderPresenter();
          Viewer _view = _headerPresenter.getView();
          Widget _asWidget = _view.asWidget();
          ApplicationWorkbenchView.this.body.setNorthWidget(_asWidget, northData);
        }
      };
    _headerPresenter.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
    BorderLayoutData _borderLayoutData_1 = new BorderLayoutData(180);
    BorderLayoutData westData = _borderLayoutData_1;
    Margins _margins_1 = new Margins(5, 0, 5, 5);
    westData.setMargins(_margins_1);
    westData.setSplit(true);
    westData.setCollapsible(true);
    westData.setCollapseMini(true);
    final ArrayList<NavMenuItem> allMenuItems = CollectionLiterals.<NavMenuItem>newArrayList();
    ContentPanel _NavHeader = this.widgets.NavHeader("\u529F\u80FD\u5BFC\u822A");
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          AccordionLayoutContainer _accordionLayoutContainer = new AccordionLayoutContainer();
          final Procedure1<AccordionLayoutContainer> _function = new Procedure1<AccordionLayoutContainer>() {
              public void apply(final AccordionLayoutContainer accordion) {
                Iterable<WorkbenchPartCategory> _categories = ApplicationWorkbenchView.this.workbenchManager.getCategories();
                final Function1<WorkbenchPartCategory,Boolean> _function = new Function1<WorkbenchPartCategory,Boolean>() {
                    public Boolean apply(final WorkbenchPartCategory it) {
                      Boolean _isVisable = it.isVisable();
                      return _isVisable;
                    }
                  };
                Iterable<WorkbenchPartCategory> _filter = IterableExtensions.<WorkbenchPartCategory>filter(_categories, _function);
                final Procedure1<WorkbenchPartCategory> _function_1 = new Procedure1<WorkbenchPartCategory>() {
                    public void apply(final WorkbenchPartCategory category) {
                      String _categoryId = category.getCategoryId();
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            String _categoryName = category.getCategoryName();
                            ImageResource _image = category.getImage();
                            ContentPanel _AccordionPanel = ApplicationWorkbenchView.this.widgets.AccordionPanel(_categoryName, _image);
                            final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  VerticalLayoutContainer _VLayout = ApplicationWorkbenchView.this.widgets.VLayout();
                                  final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                      public void apply(final VerticalLayoutContainer l) {
                                        l.setScrollMode(ScrollMode.AUTOY);
                                        Iterable<WorkbenchPartProxy> _presenterParts = ApplicationWorkbenchView.this.workbenchManager.getPresenterParts(category);
                                        final Procedure1<WorkbenchPartProxy> _function = new Procedure1<WorkbenchPartProxy>() {
                                            public void apply(final WorkbenchPartProxy pp) {
                                              final Procedure0 _function = new Procedure0() {
                                                  public void apply() {
                                                    String _name = pp.getName();
                                                    NavMenuItem _navMenuItem = new NavMenuItem(_name);
                                                    final Procedure1<NavMenuItem> _function = new Procedure1<NavMenuItem>() {
                                                        public void apply(final NavMenuItem it) {
                                                          allMenuItems.add(it);
                                                          final Procedure1<ClickEvent> _function = new Procedure1<ClickEvent>() {
                                                              public void apply(final ClickEvent e) {
                                                                final Procedure1<NavMenuItem> _function = new Procedure1<NavMenuItem>() {
                                                                    public void apply(final NavMenuItem it) {
                                                                      it.unselected();
                                                                    }
                                                                  };
                                                                IterableExtensions.<NavMenuItem>forEach(allMenuItems, _function);
                                                                it.selected();
                                                                boolean _matched = false;
                                                                if (!_matched) {
                                                                  if (pp instanceof WorkbenchCommandProxy) {
                                                                    final WorkbenchCommandProxy _workbenchCommandProxy = (WorkbenchCommandProxy)pp;
                                                                    _matched=true;
                                                                    _workbenchCommandProxy.execute();
                                                                  }
                                                                }
                                                                if (!_matched) {
                                                                  if (pp instanceof WorkbenchPresenterProxy) {
                                                                    final WorkbenchPresenterProxy _workbenchPresenterProxy = (WorkbenchPresenterProxy)pp;
                                                                    _matched=true;
                                                                    Presenter<? extends Object> _presenter = _workbenchPresenterProxy.getPresenter();
                                                                    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                                                        public void apply(final Void it) {
                                                                        }
                                                                      };
                                                                    ApplicationWorkbenchView.this.showPresenter(_presenter, _function_1);
                                                                  }
                                                                }
                                                                if (!_matched) {
                                                                  if (pp instanceof WorkbenchWindowProxy) {
                                                                    final WorkbenchWindowProxy _workbenchWindowProxy = (WorkbenchWindowProxy)pp;
                                                                    _matched=true;
                                                                    _workbenchWindowProxy.show();
                                                                  }
                                                                }
                                                                if (!_matched) {
                                                                  if (pp instanceof WorkbenchActivePresenterProxy) {
                                                                    final WorkbenchActivePresenterProxy _workbenchActivePresenterProxy = (WorkbenchActivePresenterProxy)pp;
                                                                    _matched=true;
                                                                    final Procedure1<Presenter<? extends Object>> _function_1 = new Procedure1<Presenter<? extends Object>>() {
                                                                        public void apply(final Presenter<? extends Object> it) {
                                                                          ApplicationWorkbenchView.this.showActivatedPresenter(it);
                                                                        }
                                                                      };
                                                                    _workbenchActivePresenterProxy.getPresenter(_function_1);
                                                                  }
                                                                }
                                                              }
                                                            };
                                                          it.addClickHandler(new ClickHandler() {
                                                              public void onClick(ClickEvent event) {
                                                                _function.apply(event);
                                                              }
                                                          });
                                                        }
                                                      };
                                                    NavMenuItem _doubleArrow = ObjectExtensions.<NavMenuItem>operator_doubleArrow(_navMenuItem, _function);
                                                    int _minus = (-1);
                                                    VerticalLayoutData _VLayoutData = ApplicationWorkbenchView.this.widgets.VLayoutData(1, _minus);
                                                    l.add(_doubleArrow, _VLayoutData);
                                                  }
                                                };
                                              final Procedure0 t = _function;
                                              Boolean _requireCheck = pp.requireCheck();
                                              if ((_requireCheck).booleanValue()) {
                                                String _functionId = pp.getFunctionId();
                                                final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                                    public void apply(final Void it) {
                                                      t.apply();
                                                    }
                                                  };
                                                ApplicationWorkbenchView.this.securities.check(_functionId, _function_1);
                                              } else {
                                                t.apply();
                                              }
                                            }
                                          };
                                        IterableExtensions.<WorkbenchPartProxy>forEach(_presenterParts, _function);
                                      }
                                    };
                                  VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                  it.setWidget(_doubleArrow);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_AccordionPanel, _function);
                            accordion.add(_doubleArrow);
                          }
                        };
                      ApplicationWorkbenchView.this.securities.check(_categoryId, _function);
                    }
                  };
                IterableExtensions.<WorkbenchPartCategory>forEach(_filter, _function_1);
              }
            };
          AccordionLayoutContainer _doubleArrow = ObjectExtensions.<AccordionLayoutContainer>operator_doubleArrow(_accordionLayoutContainer, _function);
          it.setWidget(_doubleArrow);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_NavHeader, _function_1);
    this.west = _doubleArrow;
    this.body.setWestWidget(this.west, westData);
    MarginData _marginData = new MarginData();
    MarginData centerData = _marginData;
    Margins _margins_2 = new Margins(5, 5, 5, 5);
    centerData.setMargins(_margins_2);
    SimpleContainer _simpleContainer = new SimpleContainer();
    this.center = _simpleContainer;
    this.body.setCenterWidget(this.center, centerData);
    RootPanel _get = RootPanel.get();
    ClientUi.operator_add(_get, this.body);
  }
  
  private Presenter activePresenter;
  
  public Viewport asWidget() {
    return this.viewport;
  }
  
  public void popPresenter(final Presenter p, final Procedure1<? super Void> init) {
    PresenterWindow _presenterWindow = new PresenterWindow(p);
    _presenterWindow.showWindow();
  }
  
  public void popActivatedPresenter(final Presenter p) {
    PresenterWindow _presenterWindow = new PresenterWindow(p);
    _presenterWindow.showActivatedWindow();
  }
  
  public void showActivatedPresenter(final Presenter p) {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    this.activePresenter = p;
    Viewer _view_1 = p.getView();
    Widget w = _view_1.asWidget();
    this.center.setWidget(w);
    if ((w instanceof ResizeContainer)) {
      ((ResizeContainer) w).forceLayout();
    }
    this.body.forceLayout();
    this.viewport.setWidget(this.body);
  }
  
  public void showSctivatedPresenterWithHeader(final Presenter p, final String header) {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    this.activePresenter = p;
    Viewer _view_1 = p.getView();
    final Widget v = _view_1.asWidget();
    edu.fudan.langlab.gxt.client.widget.ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel> _function = new Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel>() {
        public void apply(final edu.fudan.langlab.gxt.client.widget.ContentPanel it) {
          it.setTitle(header);
          it.setWidget(v);
        }
      };
    edu.fudan.langlab.gxt.client.widget.ContentPanel w = ObjectExtensions.<edu.fudan.langlab.gxt.client.widget.ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.center.setWidget(w);
    if ((v instanceof ResizeContainer)) {
      ((ResizeContainer) w).forceLayout();
    }
    this.body.forceLayout();
    this.viewport.setWidget(this.body);
  }
  
  public void showPresenter(final Presenter p, final Procedure1<? super Void> init) {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ApplicationWorkbenchView.this.activePresenter = p;
          Viewer _view = p.getView();
          Widget w = _view.asWidget();
          ApplicationWorkbenchView.this.center.setWidget(w);
          if ((w instanceof ResizeContainer)) {
            ((ResizeContainer) w).forceLayout();
          }
          ApplicationWorkbenchView.this.body.forceLayout();
          ApplicationWorkbenchView.this.viewport.setWidget(ApplicationWorkbenchView.this.body);
          boolean _notEquals = (!Objects.equal(init, null));
          if (_notEquals) {
            init.apply(null);
          }
        }
      };
    p.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
}
