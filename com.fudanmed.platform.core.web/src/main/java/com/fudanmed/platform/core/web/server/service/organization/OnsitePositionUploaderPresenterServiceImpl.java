package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOnsitePositionDAO;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionUploaderPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionCSVMapper;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.csv.server.CSVUploader;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.OnsitePositionUploaderPresenterService")
@Transactional
public class OnsitePositionUploaderPresenterServiceImpl extends BaseService implements OnsitePositionUploaderPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OnsitePositionCSVMapper onsitePositionCSVMapper;
  
  @Autowired
  private OnsitePositionMapper onsitePositionMapper;
  
  @Autowired
  private RCOnsitePositionDAO onsitePositionDAO;
  
  public void doUpload(final File file) throws SessionTimeOutException, ValidationException, CSVValidationException {
    final Procedure1<CSVUploader<UIOnsitePosition>> _function = new Procedure1<CSVUploader<UIOnsitePosition>>() {
        public void apply(final CSVUploader<UIOnsitePosition> it) {
          final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
              public void apply(final UIOnsitePosition uivalue) {
                RCOnsitePosition value = OnsitePositionUploaderPresenterServiceImpl.this.entities.<RCOnsitePosition>create(RCOnsitePosition.class);
                OnsitePositionUploaderPresenterServiceImpl.this.onsitePositionMapper.transform(uivalue, value);
                String _parentCode = uivalue.getParentCode();
                boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_parentCode);
                boolean _not = (!_isNullOrEmpty);
                if (_not) {
                  String _parentCode_1 = uivalue.getParentCode();
                  RCOnsitePosition _findByCode = OnsitePositionUploaderPresenterServiceImpl.this.onsitePositionDAO.findByCode(_parentCode_1);
                  final Procedure1<RCOnsitePosition> _function = new Procedure1<RCOnsitePosition>() {
                      public void apply(final RCOnsitePosition it) {
                        boolean _equals = Objects.equal(it, null);
                        if (_equals) {
                          Validates.reportSingleError("parentCode", "\u6240\u5C5E\u4F4D\u7F6E\u4E0D\u5B58\u5728");
                        }
                      }
                    };
                  RCOnsitePosition _doubleArrow = ObjectExtensions.<RCOnsitePosition>operator_doubleArrow(_findByCode, _function);
                  value.setParent(_doubleArrow);
                }
              }
            };
          CSVUploader.<UIOnsitePosition>onCommitEach(it, _function);
        }
      };
    CSVUploader.<UIOnsitePosition>importWith(file, this.onsitePositionCSVMapper, _function);
  }
}
