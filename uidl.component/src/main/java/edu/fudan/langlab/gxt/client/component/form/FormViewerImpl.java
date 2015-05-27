package edu.fudan.langlab.gxt.client.component.form;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.client.common.AbstractPresenter;
import com.uniquesoft.gwt.client.common.FormViewer;
import com.uniquesoft.gwt.client.common.SessionTimeoutEvent;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;

public abstract class FormViewerImpl<T> extends ErrorNotifierViewer implements
		FormViewer<T> {

	protected abstract GXTFormComponent<T> doGetFormComponent();

	@Override
	public void clearErrors() {
		Validations.clearErrors(doGetFormComponent());
	}

	@Override
	public HasEditorErrors mapField(String errorKey) {
		return Validations.mapToErrorEditor(doGetFormComponent(), errorKey);
	}

	@Override
	public T getValue() {
		return doGetFormComponent().getValue();
	}

	@Override
	public void setValue(T value) {
		doGetFormComponent().setValue(value);
	}
}
