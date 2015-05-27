package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDevicePicture;
import com.fudanmed.platform.core.device.proxy.DevicePictureContainerProxy;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityAdaptor;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePictureContainer extends EntityAdaptor<RCDevice> implements IDocumentContainer {
  public DevicePictureContainer() {
    super();
  }
  
  public DevicePictureContainer(final RCDevice adaptee) {
    this.adaptee = adaptee;
  }
  
  public DevicePictureContainerProxy toProxy() {
    return new DevicePictureContainerProxy(adaptee.toProxy());
  }
  
  public Collection<? extends IDocument> getDocuments() {
    Collection<RCDevicePicture> _pictures = this.adaptee.getPictures();
    return _pictures;
  }
  
  public IDocument createDocument(final Procedure1<? super IDocument> init) {
    final Procedure1<RCDevicePicture> _function = new Procedure1<RCDevicePicture>() {
        public void apply(final RCDevicePicture it) {
          init.apply(it);
        }
      };
    RCDevicePicture _createPicture = this.adaptee.createPicture(_function);
    return _createPicture;
  }
  
  public void removeDocument(final IDocument document) {
    this.adaptee.removePicture(((RCDevicePicture) document));
  }
}
