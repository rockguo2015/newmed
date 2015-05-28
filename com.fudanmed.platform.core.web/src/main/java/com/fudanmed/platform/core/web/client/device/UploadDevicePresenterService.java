package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.UploadDevicePresenterService")
public interface UploadDevicePresenterService extends RemoteService {
  public abstract Collection<UIDevice> doUpload(final File file) throws SessionTimeOutException, ValidationException, DataBaseConstraintException, CSVValidationException;
  
  public abstract void commit(final Collection<UIDevice> results) throws SessionTimeOutException, ValidationException, DataBaseConstraintException, CSVValidationException;
}
