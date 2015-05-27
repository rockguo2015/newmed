package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeFile;
import com.fudanmed.platform.core.device.proxy.DeviceTypeFileContainerProxy;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityAdaptor;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceTypeFileContainer extends EntityAdaptor<RCDeviceType> implements IDocumentContainer {
  public DeviceTypeFileContainer() {
    super();
  }
  
  public DeviceTypeFileContainer(final RCDeviceType adaptee) {
    this.adaptee = adaptee;
  }
  
  public DeviceTypeFileContainerProxy toProxy() {
    return new DeviceTypeFileContainerProxy(adaptee.toProxy());
  }
  
  public Collection<? extends IDocument> getDocuments() {
    Collection<RCDeviceTypeFile> _files = this.adaptee.getFiles();
    return _files;
  }
  
  public IDocument createDocument(final Procedure1<? super IDocument> init) {
    final Procedure1<RCDeviceTypeFile> _function = new Procedure1<RCDeviceTypeFile>() {
        public void apply(final RCDeviceTypeFile it) {
          init.apply(it);
        }
      };
    RCDeviceTypeFile _createFile = this.adaptee.createFile(_function);
    return _createFile;
  }
  
  public void removeDocument(final IDocument document) {
    this.adaptee.removeFile(((RCDeviceTypeFile) document));
  }
}
