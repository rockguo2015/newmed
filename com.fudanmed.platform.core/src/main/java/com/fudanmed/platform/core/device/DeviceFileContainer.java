package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceFile;
import com.fudanmed.platform.core.device.proxy.DeviceFileContainerProxy;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityAdaptor;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceFileContainer extends EntityAdaptor<RCDevice> implements IDocumentContainer {
  public DeviceFileContainer() {
    super();
  }
  
  public DeviceFileContainer(final RCDevice adaptee) {
    this.adaptee = adaptee;
  }
  
  public DeviceFileContainerProxy toProxy() {
    return new DeviceFileContainerProxy(adaptee.toProxy());
  }
  
  public Collection<? extends IDocument> getDocuments() {
    Collection<RCDeviceFile> _files = this.adaptee.getFiles();
    return _files;
  }
  
  public IDocument createDocument(final Procedure1<? super IDocument> init) {
    final Procedure1<RCDeviceFile> _function = new Procedure1<RCDeviceFile>() {
        public void apply(final RCDeviceFile it) {
          init.apply(it);
        }
      };
    RCDeviceFile _createFile = this.adaptee.createFile(_function);
    return _createFile;
  }
  
  public void removeDocument(final IDocument document) {
    this.adaptee.removeFile(((RCDeviceFile) document));
  }
}
