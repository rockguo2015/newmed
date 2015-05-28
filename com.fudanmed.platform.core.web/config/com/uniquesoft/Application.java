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
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
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
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.selector.ObjectsSelector;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.ComponentExtensions;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IHasStoreComponent;
import edu.fudan.langlab.gxt.client.widget.PagedList;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.document.client.DocumentDownloadExtensions;
import edu.fudan.langlab.uidl.domain.document.server.DocumentDownloader;
@ApplicationBasePackage("com.shrct.businessprocess")

@UseWidgetFactory(edu.fudan.langlab.gxt.client.widget.IWidgetFactory.class)
@UseComponentTypeFactory(edu.fudan.langlab.gxt.client.component.ComponentTypeFactory.class)
@UserBaseViewer(GWTAbstractView.class)
@UseBaseViewerWithValidation(ErrorNotifierViewer.class)
@UseBaseFormViewer(FormViewerImpl.class)
@UserBasePresenter(WorkbenchAbstractPresenter.class)
@StaticImports({Info.class,HTMLTagsExt.class,CSVClientExtensions.class})

@ExtensionImports({ 
	@ExtensionPair(target = com.uniquesoft.gwt.client.common.action.ActionContext.class, extensions = {
		edu.fudan.langlab.gxt.client.action.SingleObjectActions.class,
		edu.fudan.langlab.gxt.client.action.MultiObjectActions.class
		}),
	@ExtensionPair(target = CommitablePresenter.class, extensions = { DialogPresenterExtensions.class}),
	@ExtensionPair(target=ObjectListView.class,extensions = {edu.fudan.langlab.gxt.client.pager.Extensions.class}),
	@ExtensionPair(target=GXTGridComponent.class,extensions = {AggregationExtensions.class,PagedList.class}),
	@ExtensionPair(target=AggregationRowConfig.class,extensions = {AggregationExtensions.class}),
	@ExtensionPair(target=GXTGridColumn.class,extensions = {AggregationExtensions.class}),
	@ExtensionPair(target=HasWidgets.class,extensions={HTMLTagsExt.class}),
	@ExtensionPair(target=BorderLayoutContainer.class,extensions={HTMLTagsExt.class}),
	@ExtensionPair(target=MessageBox.class,extensions={MessageBoxExtensions.class}),
	@ExtensionPair(target=HttpAware.class,extensions={CSVExtensions.class,DocumentDownloader.class}),
	@ExtensionPair(target=File.class,extensions={CSVUploader.class}),
	@ExtensionPair(target=CSVUploader.class,extensions={CSVUploader.class}),
	@ExtensionPair(target=Throwable.class,extensions={edu.fudan.langlab.gxt.client.validation.CSVClientExtensions.class}),
	@ExtensionPair(target=String.class,extensions={DocumentDownloadExtensions.class}),
	@ExtensionPair(target=GXTFormComponent.class,extensions={Validations.class}),
	@ExtensionPair(target=VerticalLayoutContainer.class,extensions={WidgetExtensions.class}),
	@ExtensionPair(target=IHasStoreComponent.class,extensions={ComponentExtensions.class})
	,@ExtensionPair(target=IHasObjectSelectionProvider.class,extensions={ObjectSelector.class})
//	,@ExtensionPair(target=IHasObjectSelectionProvider.class,extensions={ObjectsSelector.class})
	,@ExtensionPair(
			target=com.google.gwt.user.client.ui.Widget.class,
			extensions={edu.fudan.langlab.gxt.client.component.KeyboardNav.class,edu.fudan.langlab.gxt.client.widget.WidgetExtensions.class})
//	,@ExtensionPair(target=com.fudanmed.platform.core.web.shared.organization.UIGroupTaskStatus.class,extensions={StatusValidator.class})
//	,@ExtensionPair(target=com.fudanmed.platform.core.web.shared.organization.UIRepairTaskStatus.class,extensions={StatusValidator.class})
	
})

public interface Application {

}
