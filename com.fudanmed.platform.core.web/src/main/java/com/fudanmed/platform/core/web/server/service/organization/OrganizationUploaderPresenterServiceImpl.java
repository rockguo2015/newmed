package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOnsitePositionDAO;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationDAO;
import com.fudanmed.platform.core.web.client.organization.OrganizationUploaderPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationCSVMapper;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.csv.server.CSVUploader;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.OrganizationUploaderPresenterService")
@Transactional
public class OrganizationUploaderPresenterServiceImpl extends BaseService implements OrganizationUploaderPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OrganizationCSVMapper csvMapper;
  
  @Autowired
  private OrganizationMapper mapper;
  
  @Autowired
  private RCOnsitePositionDAO onsitePositionDAO;
  
  @Autowired
  private RCOrganizationDAO organizationDAO;
  
  public void doUpload(final File file) throws SessionTimeOutException, ValidationException, CSVValidationException {
    final Procedure1<CSVUploader<UIOrganization>> _function = new Procedure1<CSVUploader<UIOrganization>>() {
        public void apply(final CSVUploader<UIOrganization> it) {
          final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
              public void apply(final UIOrganization uivalue) {
                final RCOrganization value = OrganizationUploaderPresenterServiceImpl.this.entities.<RCOrganization>create(RCOrganization.class);
                OrganizationUploaderPresenterServiceImpl.this.mapper.transform(uivalue, value);
                String _parentCode = uivalue.getParentCode();
                RCOrganization _findByCode = OrganizationUploaderPresenterServiceImpl.this.organizationDAO.findByCode(_parentCode);
                value.setParent(_findByCode);
                boolean _and = false;
                String _parentCode_1 = uivalue.getParentCode();
                boolean _notEquals = (!Objects.equal(_parentCode_1, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  RCOrganization _parent = value.getParent();
                  boolean _equals = Objects.equal(_parent, null);
                  _and = (_notEquals && _equals);
                }
                if (_and) {
                  String _parentCode_2 = uivalue.getParentCode();
                  String _plus = ("\u65E0\u6548\u6240\u5C5E\u673A\u6784\u4EE3\u7801:" + _parentCode_2);
                  Validates.reportSingleError("parentCode", _plus);
                }
                String _positionCodes = uivalue.getPositionCodes();
                boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_positionCodes);
                boolean _not = (!_isNullOrEmpty);
                if (_not) {
                  String _positionCodes_1 = uivalue.getPositionCodes();
                  String[] _split = _positionCodes_1.split(":");
                  final Procedure1<String> _function = new Procedure1<String>() {
                      public void apply(final String it) {
                        final RCOnsitePosition onsitePosition = OrganizationUploaderPresenterServiceImpl.this.onsitePositionDAO.findByCode(it);
                        boolean _equals = Objects.equal(onsitePosition, null);
                        if (_equals) {
                          String _plus = ("\u65E0\u6548\u4F4D\u7F6E\u4EE3\u7801:" + it);
                          Validates.reportSingleError("positionCodes", _plus);
                        } else {
                          value.addtoPositions(onsitePosition);
                        }
                      }
                    };
                  IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_split)), _function);
                }
              }
            };
          CSVUploader.<UIOrganization>onCommitEach(it, _function);
        }
      };
    CSVUploader.<UIOrganization>importWith(file, this.csvMapper, _function);
  }
}
