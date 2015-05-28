package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStoragePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateWorkItemPictureCommand extends BaseContextAwareSingleObjectCommand<IDocumentContainerProxy> implements IContextConsumer<IDocumentContainerProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "图片上传";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateWorkItemPictureCommand";
  }
  
  public void execute(final IDocumentContainerProxy value) {
    CreateOrUpdateDocumentStoragePresenter _get = this.createOrUpdateDocumentStoragePresenter.get();
    final Procedure1<CreateOrUpdateDocumentStoragePresenter> _function = new Procedure1<CreateOrUpdateDocumentStoragePresenter>() {
        public void apply(final CreateOrUpdateDocumentStoragePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateDocumentStoragePresenter>() {
        public void done(CreateOrUpdateDocumentStoragePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDocumentStoragePresenter> createOrUpdateDocumentStoragePresenter;
}
