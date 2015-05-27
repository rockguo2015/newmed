package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppFunctionService;
import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenterService;
import edu.fudan.langlab.uidl.domain.app.server.service.security.AppFunctionMapper;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenterService")
@Transactional
public class CreateOrUpdateAppFunctionAssignmentPresenterServiceImpl extends BaseService implements CreateOrUpdateAppFunctionAssignmentPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private AppFunctionMapper appFunctionMapper;
  
  @Autowired
  private AppFunctionService appFunctionService;
  
  public UIAppFunctionAssignment loadValue(final String roleId) throws SessionTimeOutException, ValidationException {
    UIAppFunctionAssignment _uIAppFunctionAssignment = new UIAppFunctionAssignment();
    final Procedure1<UIAppFunctionAssignment> _function = new Procedure1<UIAppFunctionAssignment>() {
        public void apply(final UIAppFunctionAssignment it) {
          it.setRoleId(roleId);
          Collection<AppFunction> _loadAllFunctions4Role = CreateOrUpdateAppFunctionAssignmentPresenterServiceImpl.this.appFunctionService.loadAllFunctions4Role(roleId);
          final Function1<AppFunction,UIAppFunction> _function = new Function1<AppFunction,UIAppFunction>() {
              public UIAppFunction apply(final AppFunction it) {
                UIAppFunction _transform = CreateOrUpdateAppFunctionAssignmentPresenterServiceImpl.this.appFunctionMapper.transform(it);
                return _transform;
              }
            };
          Iterable<UIAppFunction> _map = IterableExtensions.<AppFunction, UIAppFunction>map(_loadAllFunctions4Role, _function);
          List<UIAppFunction> _list = IterableExtensions.<UIAppFunction>toList(_map);
          it.setFunctions(_list);
        }
      };
    UIAppFunctionAssignment _doubleArrow = ObjectExtensions.<UIAppFunctionAssignment>operator_doubleArrow(_uIAppFunctionAssignment, _function);
    return _doubleArrow;
  }
  
  public void updateValue(final UIAppFunctionAssignment uivalue) throws SessionTimeOutException, ValidationException {
    String _roleId = uivalue.getRoleId();
    Collection<RoleFunctionAssignment> _loadAllFunctionAssignments4Role = this.appFunctionService.loadAllFunctionAssignments4Role(_roleId);
    final Procedure1<RoleFunctionAssignment> _function = new Procedure1<RoleFunctionAssignment>() {
        public void apply(final RoleFunctionAssignment it) {
          CreateOrUpdateAppFunctionAssignmentPresenterServiceImpl.this.entities.delete(it);
        }
      };
    IterableExtensions.<RoleFunctionAssignment>forEach(_loadAllFunctionAssignments4Role, _function);
    Collection<UIAppFunction> _functions = uivalue.getFunctions();
    final Procedure1<UIAppFunction> _function_1 = new Procedure1<UIAppFunction>() {
        public void apply(final UIAppFunction uifunction) {
          Long _id = uifunction.getId();
          final AppFunction function = CreateOrUpdateAppFunctionAssignmentPresenterServiceImpl.this.entities.<AppFunction>get(AppFunction.class, _id);
          RoleFunctionAssignment _create = CreateOrUpdateAppFunctionAssignmentPresenterServiceImpl.this.entities.<RoleFunctionAssignment>create(RoleFunctionAssignment.class);
          final Procedure1<RoleFunctionAssignment> _function = new Procedure1<RoleFunctionAssignment>() {
              public void apply(final RoleFunctionAssignment it) {
                String _roleId = uivalue.getRoleId();
                it.setRoleId(_roleId);
                it.setFunction(function);
              }
            };
          ObjectExtensions.<RoleFunctionAssignment>operator_doubleArrow(_create, _function);
        }
      };
    IterableExtensions.<UIAppFunction>forEach(_functions, _function_1);
  }
}
