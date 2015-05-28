package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.File;

public class DeviceUploadData implements IsSerializable {
  private File file;
  
  public File getFile() {
    return this.file;
  }
  
  public void setFile(final File file) {
    this.file = file;
  }
  
  public final static String P_File = "file";
  
  public static IObjectFieldAccessor<DeviceUploadData,File> FileAccessor = new IObjectFieldAccessor<DeviceUploadData,File>(){
    				public com.uniquesoft.gwt.shared.datatype.File getValue(DeviceUploadData object){
    					return object.getFile();
    				}
    				public void setValue(DeviceUploadData object,com.uniquesoft.gwt.shared.datatype.File value){
    					object.setFile(value);
    				}
    			};
}
