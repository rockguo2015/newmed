package com.fudanmed.platform.core.web.client.organization;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.shared.CSVValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.OnsitePositionUploaderPresenterService")
public interface OnsitePositionUploaderPresenterService extends RemoteService {
  public abstract void doUpload(final File file) throws SessionTimeOutException, ValidationException, DataBaseConstraintException, CSVValidationException;
}
