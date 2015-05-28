package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationUploaderPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationUploaderPresenterService")
@Transactional
public class ProductSpecificationUploaderPresenterServiceImpl extends BaseService implements ProductSpecificationUploaderPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSpecificationCSVMapper csvMapper;
  
  @Autowired
  private ProductSpecificationMapper mapper;
  
  public void doUpload(final File file) throws SessionTimeOutException, ValidationException, CSVValidationException {
    final Procedure1<CSVUploader<UIProductSpecification>> _function = new Procedure1<CSVUploader<UIProductSpecification>>() {
        public void apply(final CSVUploader<UIProductSpecification> it) {
          final Procedure1<UIProductSpecification> _function = new Procedure1<UIProductSpecification>() {
              public void apply(final UIProductSpecification uivalue) {
                RCProductSpecification value = ProductSpecificationUploaderPresenterServiceImpl.this.entities.<RCProductSpecification>create(RCProductSpecification.class);
                ProductSpecificationUploaderPresenterServiceImpl.this.mapper.transform(uivalue, value);
              }
            };
          CSVUploader.<UIProductSpecification>onCommitEach(it, _function);
        }
      };
    CSVUploader.<UIProductSpecification>importWith(file, this.csvMapper, _function);
  }
}
