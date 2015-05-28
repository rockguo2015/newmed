package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.device.PictureBrowsePresenter;
import com.fudanmed.platform.core.web.shared.project.HasDocumentsWithAdditionalInfo;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ViewWorkItemPictureCommand extends BaseContextAwareSingleObjectCommand<HasDocumentsWithAdditionalInfo> implements IContextConsumer<HasDocumentsWithAdditionalInfo> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "查看图片";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ViewWorkItemPictureCommand";
  }
  
  public void execute(final HasDocumentsWithAdditionalInfo value) {
    PictureBrowsePresenter _get = this.createOrUpdateDocumentStoragePresenter.get();
    IHasDocumentsProxy _value = value.getValue();
    final Procedure1<PictureBrowsePresenter> _function = new Procedure1<PictureBrowsePresenter>() {
        public void apply(final PictureBrowsePresenter it) {
          it.popup(it);
        }
      };
    _get.setup(_value, new IPresenterInitiazerNotifier<PictureBrowsePresenter>() {
        public void done(PictureBrowsePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public boolean checkEnable(final HasDocumentsWithAdditionalInfo value) {
    Boolean _hasDocuments = value.getHasDocuments();
    return (_hasDocuments).booleanValue();
  }
  
  @Inject
  private Provider<PictureBrowsePresenter> createOrUpdateDocumentStoragePresenter;
}
