package com.uniquesoft;

import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.application.ApplicationBasePackage;
import com.uniquesoft.application.ExtensionImports;
import com.uniquesoft.application.ExtensionPair;
import com.uniquesoft.application.StaticImports;
import com.uniquesoft.application.UseBaseFormViewer;
import com.uniquesoft.application.UseBaseViewerWithValidation;
import com.uniquesoft.application.UseComponentTypeFactory;
import com.uniquesoft.application.UseWidgetFactory;
import com.uniquesoft.application.UserBasePresenter;
import com.uniquesoft.application.UserBaseViewer;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.server.service.common.HttpAware;
import com.uniquesoft.gwt.shared.datatype.File;

import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.csv.server.CSVExtensions;
import edu.fudan.langlab.csv.server.CSVUploader;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.component.grid.AggregationExtensions;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.gxt.client.dialog.MessageBoxExtensions;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;

@ApplicationBasePackage("/edu.fudan.langlab.uidl.domain")

@UseWidgetFactory(edu.fudan.langlab.gxt.client.widget.IWidgetFactory.class)
@UseComponentTypeFactory(edu.fudan.langlab.gxt.client.component.ComponentTypeFactory.class)
@UserBaseViewer(GWTAbstractView.class)
@UseBaseViewerWithValidation(ErrorNotifierViewer.class)
@UseBaseFormViewer(FormViewerImpl.class)
@UserBasePresenter(WorkbenchAbstractPresenter.class)

@StaticImports({Info.class,HTMLTagsExt.class,CSVClientExtensions.class})

@ExtensionImports({ 
	@ExtensionPair(target = com.uniquesoft.gwt.client.common.action.ActionContext.class, extensions = { edu.fudan.langlab.gxt.client.action.SingleObjectActions.class}),
	@ExtensionPair(target = CommitablePresenter.class, extensions = { DialogPresenterExtensions.class}),
	@ExtensionPair(target=ObjectListView.class,extensions = {edu.fudan.langlab.gxt.client.pager.Extensions.class}),
	@ExtensionPair(target=GXTGridComponent.class,extensions = {AggregationExtensions.class}),
	@ExtensionPair(target=AggregationRowConfig.class,extensions = {AggregationExtensions.class}),
	@ExtensionPair(target=GXTGridColumn.class,extensions = {AggregationExtensions.class}),
	@ExtensionPair(target=HasWidgets.class,extensions={HTMLTagsExt.class}),
	@ExtensionPair(target=BorderLayoutContainer.class,extensions={HTMLTagsExt.class}),
	@ExtensionPair(target=MessageBox.class,extensions={MessageBoxExtensions.class}),
	@ExtensionPair(target=HttpAware.class,extensions={CSVExtensions.class}),
	@ExtensionPair(target=File.class,extensions={CSVUploader.class}),
	@ExtensionPair(target=CSVUploader.class,extensions={CSVUploader.class}),
	@ExtensionPair(target=Throwable.class,extensions={CSVClientExtensions.class}),
	//Double
	@ExtensionPair(target=GXTFormComponent.class,extensions={Validations.class}),
	@ExtensionPair(target=VerticalLayoutContainer.class,extensions={WidgetExtensions.class}),

})
public interface Application {

}
