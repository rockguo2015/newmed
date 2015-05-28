package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.AttributeSlotListGrid;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterView;
import com.fudanmed.platform.core.web.client.device.IValueEditor;
import com.fudanmed.platform.core.web.client.tree.ExtensiableValueTreeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AttributeSlotTreeListView extends GWTAbstractView implements AttributeSlotTreeListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid),
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
  
  private Widget con;
  
  private IPresenterContainer editorPart;
  
  private IValueEditor activeEditor;
  
  private TextButton confirmButton;
  
  @Inject
  private AttributeSlotListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    HorizontalLayoutContainer _HLayout = this.widgets.HLayout();
    final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
        public void apply(final HorizontalLayoutContainer it) {
          SGrid<UIAttributeSlot> _asWidget = AttributeSlotTreeListView.this.listGrid.asWidget();
          HorizontalLayoutData _HLayoutData = AttributeSlotTreeListView.this.widgets.HLayoutData(1, 1);
          it.add(_asWidget, _HLayoutData);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
                    public void apply(final UIAttributeSlot it) {
                      editSlotValueRequestRequestHandler.execute(it);
                      
                    }
                  };
                AttributeSlotTreeListView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIAttributeSlot>() {
                    public void objectSelected(UIAttributeSlot selected) {
                      _function.apply(selected);
                    }
                });
                IPresenterContainer _PresenterContainer = AttributeSlotTreeListView.this.widgets.PresenterContainer();
                AttributeSlotTreeListView.this.editorPart = _PresenterContainer;
                ContentPanel _ContentPanel = AttributeSlotTreeListView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      Widget _asWidget = AttributeSlotTreeListView.this.editorPart.asWidget();
                      it.setWidget(_asWidget);
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {
                            AttributeSlotTreeListView.this.activeEditor.performCommit();
                          }
                        };
                      TextButton _TextButton = AttributeSlotTreeListView.this.widgets.TextButton("\u786E\u8BA4", _function);
                      TextButton _confirmButton = AttributeSlotTreeListView.this.confirmButton = _TextButton;
                      it.addButton(_confirmButton);
                    }
                  };
                ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                HorizontalLayoutData _HLayoutData = AttributeSlotTreeListView.this.widgets.HLayoutData(200, 1);
                it.add(_doubleArrow, _HLayoutData);
              }
            };
          AttributeSlotTreeListView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter.editSlotValueRequest" );
            }
          }.apply(), _function);
        }
      };
    HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIAttributeSlot> results) {
    
    ExtensiableValueTreeContentProvider _extensiableValueTreeContentProvider = new ExtensiableValueTreeContentProvider(results);
    this.listGrid.setContentProvider(_extensiableValueTreeContentProvider);
  }
  
  public void activateEditor(final IValueEditor editor) {
    
    this.activeEditor = editor;
    this.editorPart.showActivatedPresenter(((Presenter) editor));
    this.confirmButton.enable();
  }
  
  public ActionContext<UIAttributeSlot> getActionContext() {
    ActionContext<UIAttributeSlot> _createActionContext = ActionExtensions.<UIAttributeSlot>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void addSlot(final UIAttributeSlot slot, final UIAttributeSlot parent) {
    TreeStore store = this.listGrid.getStore();
    boolean _equals = Objects.equal(parent, null);
    if (_equals) {
      store.add(slot);
    } else {
      int _hashCode = parent.hashCode();
      String _string = Integer.valueOf(_hashCode).toString();
      Object parentInStore = store.findModelWithKey(_string);
      store.add(parentInStore, slot);
    }
  }
  
  public void updateSlot(final UIAttributeSlot slot) {
    TreeStore store = this.listGrid.getStore();
    store.update(slot);
  }
  
  public void deactivateEditor() {
    this.editorPart.clear();
    this.confirmButton.disable();
  }
  
  public void destory() {
    this.editorPart.destory();
  }
  
  private RequestHandler1<UIAttributeSlot> editSlotValueRequestRequestHandler;
  
  public void editSlotValueRequest(final RequestHandler1<UIAttributeSlot> requestHandler) {
    this.editSlotValueRequestRequestHandler = requestHandler;
  }
}
