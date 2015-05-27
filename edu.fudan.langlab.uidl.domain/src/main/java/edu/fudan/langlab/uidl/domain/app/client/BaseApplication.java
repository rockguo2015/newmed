package edu.fudan.langlab.uidl.domain.app.client;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;

import edu.fudan.langlab.common.client.UIDLApplication;

public abstract class BaseApplication extends UIDLApplication {
	private Logger logger = Logger.getLogger("");

	@Override
	public void onModuleLoad() {

		Resources.INSTANCE.css().ensureInjected();
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				System.out.println("=========>>>>>>"+e.getClass());
				logger.log(Level.SEVERE, "exception raised", e);
				if (e instanceof DataBaseConstraintException) {
					Window.alert("数据完整性错误,可能是试图删除已经在使用的数据");
				}else if(e instanceof SessionTimeOutException){
					Window.alert("超时,请重新登录");
				} else {
					Window.alert((new Date()).toString() + ":" + e.getMessage());
				}
			}
		});

		doOnModuleLoad();
		final Presenter<?> p = createMainPresenter();
		p.activate(new IPostInitializeAction() {

			@Override
			public void initializeFinished(Void v) {
				RootPanel.get().add(p.getView().asWidget());
				logger.info("application initialized");
			}
		});

	}

	abstract protected void doOnModuleLoad();
}
