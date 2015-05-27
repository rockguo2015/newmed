package com.uniquesoft.gwt.client.common.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;

public class ActionContext<VT> implements ObjectSelectionProvider<VT>,
		ObjectSelectionProvider.SelectionChangedListener<VT> {
	Collection<ObjectContextAwareAction<VT>> actions = new ArrayList<ObjectContextAwareAction<VT>>();

	HashMap<ObjectContextAwareAction<VT>, Requester> mapping = new HashMap<ObjectContextAwareAction<VT>, Requester>();

	ObjectSelectionProvider<VT> objectSelectionProvider;

	public ActionContext(ObjectSelectionProvider<VT> objectSelectionProvider) {
		setObjectSelectionTarget(objectSelectionProvider);
	}

	public <NT> ActionContext<NT> adapt(final Function<VT, NT> transformer) {
		return new ActionContext<NT>(new ObjectSelectionProvider<NT>() {

			@Override
			public Iterable<NT> getSelectedObjects() {
				return Iterables.transform(
						ActionContext.this.getSelectedObjects(), transformer);
			}

			@Override
			public void deselect() {
				ActionContext.this.deselect();

			}

			@Override
			public void select(NT item) {
				// TODO Auto-generated method stub

			}

			@Override
			public void addSelectionChangedListener(
					final com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<NT> listener) {
				ActionContext.this
						.addSelectionChangedListener(new com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<VT>() {

							@Override
							public void selectionChanged(Iterable<VT> selections) {
								listener.selectionChanged(Iterables.transform(
										selections, transformer));

							}

						});

			}

		});
	}

	public void registerAction(final Requester request,
			final ObjectContextAwareAction<VT> action) {
		actions.add(action);
		mapping.put(action, request);
		if (action instanceof SingleObjectAction) {
			request.setRequestHandler(new RequestHandler() {
				@Override
				public void execute() {
					((SingleObjectAction<VT>) action)
							.setSelectedObject(objectSelectionProvider
									.getSelectedObjects().iterator().next());
					action.execute();

				}
			});

		} else if (action instanceof MutilObjectAction) {
			request.setRequestHandler(new RequestHandler() {
				@Override
				public void execute() {
					((MutilObjectAction<VT>) action)
							.setSelectedObject(objectSelectionProvider
									.getSelectedObjects());
					action.execute();

				}
			});

		} else {
			request.setRequestHandler(new RequestHandler() {

				@Override
				public void execute() {
					action.execute();

				}
			});
		}
		updateState(action);
	}

	private void setObjectSelectionTarget(
			ObjectSelectionProvider<VT> objectSelectionProvider) {
		this.objectSelectionProvider = objectSelectionProvider;
		objectSelectionProvider.addSelectionChangedListener(this);
	}

	@Override
	public void selectionChanged(Iterable<VT> selections) {
		selectedObjects = selections;
		for (SelectionChangedListener<VT> listener : listeners) {
			listener.selectionChanged(selections);
		}
		updateStates();
	}

	private void updateState(ObjectContextAwareAction<VT> action) {

		Iterable<VT> selectedEntites = objectSelectionProvider
				.getSelectedObjects();
		if (action instanceof SingleObjectAction) {
			if (Iterables.size(selectedEntites) == 1 && action.checkEnable())
				mapping.get(action).enable();
			else
				mapping.get(action).disable();
		} else if (action instanceof MutilObjectAction) {
			if (Iterables.size(selectedEntites) >= 1 && action.checkEnable())
				mapping.get(action).enable();
			else
				mapping.get(action).disable();
		} else {
			if(action.checkEnable())
				mapping.get(action).enable();
			else 
				mapping.get(action).disable();
		}
	}

	public void updateStates() {
		for (ObjectContextAwareAction<VT> action : actions) {
			updateState(action);
		}
	}

	private Iterable<VT> selectedObjects = Lists.newArrayList();

	@Override
	public Iterable<VT> getSelectedObjects() {
		return selectedObjects;
	}

	private Collection<SelectionChangedListener<VT>> listeners = Lists
			.newArrayList();

	@Override
	public void addSelectionChangedListener(
			SelectionChangedListener<VT> listener) {
		listeners.add(listener);

	}

	@Override
	public void deselect() {
		objectSelectionProvider.deselect();
	}

	@Override
	public void select(VT item) {
		objectSelectionProvider.select(item);

	}

}
