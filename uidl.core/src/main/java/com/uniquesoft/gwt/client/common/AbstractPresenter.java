package com.uniquesoft.gwt.client.common;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

/**
 * 
 * A basic Presenter implementation for GWT, this class integrate the GWT RPC
 * mechanism, only leave the doBind() method to be implemented in subclass.
 * 
 * @param <V>
 *            the type of the displayer in the presenter
 */
public abstract class AbstractPresenter<V extends Viewer> implements
		Presenter<V> , IInitializerSupport{

	private final V display;

	protected final EventBus eventBus;

	public AbstractPresenter(V display, EventBus eventBus) {
		this.display = display;
		this.eventBus = eventBus;
	}

	@Override
	public V getView() {
		return display;
	}

	/**
	 * Initialize the presenter, usually this method is called to initialize
	 * displayer of the presenter.
	 * 
	 */
	protected abstract void doBind();

	/**
	 * 
	 * Clear the presenter, this method shall be called when a Presenter is
	 * abandon.
	 * 
	 */
	protected void doUnbind() {

	}
	
	boolean isActivated = false;
	
	public boolean getIsActivated(){
		return isActivated;
	}

	public static Set<Presenter> activePresenters = Sets.newHashSet();
	
	protected void postActivated(){
		
	}
	@Override
	public void activate(final IPostInitializeAction postAction) {
		getView().initialize(new IPostInitializeAction() {

			@Override
			public void initializeFinished(Void v) {
				doBind();
				postAction.initializeFinished(null);
				activePresenters.add(AbstractPresenter.this);
//				System.out.println("+++++++++++++++> Active presenters"+activePresenters.size());
//				for(Presenter p : activePresenters){
//					System.out.println(p.getClass());
//				}
//				System.out.println("+++++++++++++++> End");
				isActivated = true;
				postActivated();
			}
		});
	}

	protected void postDeactivated(){
		
	}
	@Override
	public void deactivate() {
		
		for(Presenter<?> part : parts){
			part.deactivate();
		}
		doUnbind();
		getView().destroy();
		activePresenters.remove(AbstractPresenter.this);
		isActivated = false;
		postDeactivated();
	}

	private Procedure0 onFailure;

	public void setRPCFailureHandler(final Procedure0 onFailure) {
		this.onFailure = onFailure;
	}

	public Procedure0 getRPCFailureHandler() {
		return onFailure;
	}

	/**
	 * Returns a callback of type {@link ConfigurableAsyncCallback} that
	 * contains the Procedure {@code onSuccess}
	 * 
	 * If {@code display} is an instance of {@link ViewerWithValidation}, append
	 * the validation Procedure to the callback.
	 * 
	 * @param onSuccess
	 *            the Procedure shall be applied when success
	 * @return
	 */
	public <T extends Object> AsyncCallback<T> onSuccess(
			final Procedure1<? super T> onSuccess) {
		final ConfigurableAsyncCallback<T> callback = new ConfigurableAsyncCallback<T>();
		callback.onSuccessDo(onSuccess);
		callback.onSessionTimeoutDo(new Procedure1<Void>() {

			@Override
			public void apply(Void v) {
				eventBus.fireEvent(new SessionTimeoutEvent());
			}
		});
		if (getView() instanceof ViewerWithValidation) {
			callback.onValidationFailureDo(new Procedure1<Collection<ValidationErrorItem>>() {
				@Override
				public void apply(Collection<ValidationErrorItem> errors) {
					if (AbstractPresenter.this.getRPCFailureHandler() != null)
						AbstractPresenter.this.getRPCFailureHandler().apply();
					((ViewerWithValidation) getView())
							.showValidationErrors(errors);
				}
			});
		}
		return callback;
	}
	
	public void initialize(IPostInitializeAction postInitialize){
		postInitialize.initializeFinished(null);
	}

	private Collection<Presenter<?>> parts = Lists.newArrayList();
	
	protected void registerPart(Presenter<?> part){
		parts.add(part);
	}
	
}
