package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.EBoardPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.EBoardPresenterView;
import com.fudanmed.platform.core.web.shared.project.EBoardResult;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.Timer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EBoardPresenter extends WorkbenchAbstractPresenter<EBoardPresenterView> {
  @Inject
  protected EBoardPresenterServiceAsync _service;
  
  @Inject
  public EBoardPresenter(final EBoardPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Integer curPage;
  
  public void setup(final IPresenterInitiazerNotifier<EBoardPresenter> _notifier) {
    
    this.curPage = Integer.valueOf(0);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          int _plus = ((EBoardPresenter.this.curPage).intValue() + 1);
          final Procedure1<EBoardResult> _function = new Procedure1<EBoardResult>() {
              public void apply(final EBoardResult it) {
                Integer _curPage = it.getCurPage();
                EBoardPresenter.this.curPage = _curPage;
                EBoardPresenterView _view = EBoardPresenter.this.getView();
                String _contents = it.getContents();
                _view.showResults(_contents);
                final Procedure1<Integer> _function = new Procedure1<Integer>() {
                    public void apply(final Integer interval) {
                      Timer _timer = new Timer();
                      final Procedure1<Timer> _function = new Procedure1<Timer>() {
                          public void apply(final Timer timer) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  int _plus = ((EBoardPresenter.this.curPage).intValue() + 1);
                                  final Procedure1<EBoardResult> _function = new Procedure1<EBoardResult>() {
                                      public void apply(final EBoardResult it) {
                                        Integer _curPage = it.getCurPage();
                                        EBoardPresenter.this.curPage = _curPage;
                                        EBoardPresenterView _view = EBoardPresenter.this.getView();
                                        String _contents = it.getContents();
                                        _view.showResults(_contents);
                                        int _multiply = (1500 * (interval).intValue());
                                        timer.schedule(_multiply);
                                      }
                                    };
                                  AsyncCallback<EBoardResult> _onSuccess = EBoardPresenter.this.<EBoardResult>onSuccess(_function);
                                  _service.loadActiveTasks(Integer.valueOf(_plus), _onSuccess);
                                }
                              };
                            timer.setProcess(_function);
                          }
                        };
                      Timer _doubleArrow = ObjectExtensions.<Timer>operator_doubleArrow(_timer, _function);
                      int _multiply = (1500 * (interval).intValue());
                      _doubleArrow.schedule(_multiply);_notifier.done(EBoardPresenter.this);
                    }
                  };
                AsyncCallback<Integer> _onSuccess = EBoardPresenter.this.<Integer>onSuccess(_function);
                _service.loadRefreshInterval(_onSuccess);
              }
            };
          AsyncCallback<EBoardResult> _onSuccess = EBoardPresenter.this.<EBoardResult>onSuccess(_function);
          _service.loadActiveTasks(Integer.valueOf(_plus), _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
