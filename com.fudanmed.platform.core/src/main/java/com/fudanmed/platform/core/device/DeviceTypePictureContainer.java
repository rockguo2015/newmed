package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypePicture;
import com.fudanmed.platform.core.device.proxy.DeviceTypePictureContainerProxy;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityAdaptor;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceTypePictureContainer extends EntityAdaptor<RCDeviceType> implements IDocumentContainer {
  public DeviceTypePictureContainer() {
    super();
  }
  
  public DeviceTypePictureContainer(final RCDeviceType adaptee) {
    this.adaptee = adaptee;
  }
  
  public DeviceTypePictureContainerProxy toProxy() {
    return new DeviceTypePictureContainerProxy(adaptee.toProxy());
  }
  
  public Collection<? extends IDocument> getDocuments() {
    Collection<RCDeviceTypePicture> _pictures = this.adaptee.getPictures();
    return _pictures;
  }
  
  public IDocument createDocument(final Procedure1<? super IDocument> init) {
    final Procedure1<RCDeviceTypePicture> _function = new Procedure1<RCDeviceTypePicture>() {
        public void apply(final RCDeviceTypePicture it) {
          init.apply(it);
        }
      };
    RCDeviceTypePicture _createPicture = this.adaptee.createPicture(_function);
    return _createPicture;
  }
  
  public void removeDocument(final IDocument document) {
    this.adaptee.removePicture(((RCDeviceTypePicture) document));
  }
}
