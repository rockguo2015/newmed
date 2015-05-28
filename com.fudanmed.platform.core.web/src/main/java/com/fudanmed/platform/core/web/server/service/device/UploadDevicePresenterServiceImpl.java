package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceDAO;
import com.fudanmed.platform.core.web.client.device.UploadDevicePresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapper;
import com.fudanmed.platform.core.web.server.service.device.DeviceMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.server.CSVUploader;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import edu.fudan.langlab.csv.shared.CSVValidationExtensions;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.UploadDevicePresenterService")
@Transactional
public class UploadDevicePresenterServiceImpl extends BaseService implements UploadDevicePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceCSVMapper csvMapper;
  
  @Autowired
  private DeviceMapper mapper;
  
  @Autowired
  private RCDeviceDAO dao;
  
  public Collection<UIDevice> doUpload(final File file) throws SessionTimeOutException, ValidationException, CSVValidationException {
    ArrayList<UIDevice> _xblockexpression = null;
    {
      final ArrayList<UIDevice> result = CollectionLiterals.<UIDevice>newArrayList();
      final Procedure1<CSVUploader<UIDevice>> _function = new Procedure1<CSVUploader<UIDevice>>() {
          public void apply(final CSVUploader<UIDevice> it) {
            final Procedure1<Collection<UIDevice>> _function = new Procedure1<Collection<UIDevice>>() {
                public void apply(final Collection<UIDevice> it) {
                  final Procedure2<UIDevice,Long> _function = new Procedure2<UIDevice,Long>() {
                      public void apply(final UIDevice item, final Long index) {
                        result.add(item);
                      }
                    };
                  IterableExtensions2.<UIDevice>forEachWithIndex(it, _function);
                }
              };
            CSVUploader.<UIDevice>onCommitAll(it, _function);
          }
        };
      CSVUploader.<UIDevice>importWith(file, this.csvMapper, _function);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void commit(final Collection<UIDevice> results) throws SessionTimeOutException, ValidationException, CSVValidationException {
    final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
        public void apply(final UIDevice data) {
          String _sid = data.getSid();
          final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
              public void apply(final RCDevice it) {
                UploadDevicePresenterServiceImpl.this.mapper.transform(data, it);
              }
            };
          UploadDevicePresenterServiceImpl.this.dao.createDevice(_sid, _function);
        }
      };
    final Function1<String,String> _function_1 = new Function1<String,String>() {
        public String apply(final String key) {
          String _title4Key = UploadDevicePresenterServiceImpl.this.csvMapper.getTitle4Key(key);
          return _title4Key;
        }
      };
    CSVValidationExtensions.<UIDevice>forEachWithCVSValidation(results, _function, _function_1);
  }
}
