package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.web.client.organization.EmployeeUploaderPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.Employee4CSVMapper;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeCSVMapper;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.server.CSVUploader;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.EmployeeUploaderPresenterService")
@Transactional
public class EmployeeUploaderPresenterServiceImpl extends BaseService implements EmployeeUploaderPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private EmployeeCSVMapper csvMapper;
  
  @Autowired
  private Employee4CSVMapper mapper;
  
  @Autowired
  private RCEmployeeDAO employeeDAO;
  
  public void doUpload(final File file) throws SessionTimeOutException, ValidationException, CSVValidationException {
    final Procedure1<CSVUploader<UIEmployee>> _function = new Procedure1<CSVUploader<UIEmployee>>() {
        public void apply(final CSVUploader<UIEmployee> it) {
          final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
              public void apply(final UIEmployee uivalue) {
                String _eid = uivalue.getEid();
                final Procedure1<RCEmployee> _function = new Procedure1<RCEmployee>() {
                    public void apply(final RCEmployee it) {
                      EmployeeUploaderPresenterServiceImpl.this.mapper.transform(uivalue, it);
                    }
                  };
                EmployeeUploaderPresenterServiceImpl.this.employeeDAO.create(_eid, _function);
              }
            };
          CSVUploader.<UIEmployee>onCommitEach(it, _function);
        }
      };
    CSVUploader.<UIEmployee>importWith(file, this.csvMapper, _function);
  }
}
