package com.lanmon.business.server.service.customer;

import com.google.common.base.Objects;
import com.lanmon.business.shared.customer.GWTCustomer;
import com.lanmon.workflow.business.Customer;
import com.lanmon.workflow.business.CustomerService;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.CustomerValidator")
public class CustomerValidator implements IValidator<GWTCustomer> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CustomerService customerService;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean NameShouldBeUnique(final GWTCustomer _entity) {
    boolean _xblockexpression = false;
    {
      String _name = _entity.getName();
      Customer customer = this.customerService.findCustomerByExactName(_name);
      boolean _xifexpression = false;
      Long _id = _entity.getId();
      boolean _notEquals = (!Objects.equal(_id, null));
      if (_notEquals) {
        boolean _or = false;
        boolean _equals = Objects.equal(customer, null);
        if (_equals) {
          _or = true;
        } else {
          Long _id_1 = customer.getId();
          Long _id_2 = _entity.getId();
          boolean _equals_1 = Objects.equal(_id_1, _id_2);
          _or = (_equals || _equals_1);
        }
        _xifexpression = _or;
      } else {
        boolean _equals_2 = Objects.equal(customer, null);
        _xifexpression = _equals_2;
      }
      _xblockexpression = (_xifexpression);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public Boolean PhoneShouldBeUnique(final GWTCustomer _entity) {
    boolean _xblockexpression = false;
    {
      String _phone = _entity.getPhone();
      Customer customer = this.customerService.findCustomerByExactPhone(_phone);
      boolean _or = false;
      boolean _equals = Objects.equal(customer, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _and = false;
        Long _id = customer.getId();
        Long _id_1 = _entity.getId();
        boolean _equals_1 = Objects.equal(_id, _id_1);
        if (!_equals_1) {
          _and = false;
        } else {
          Long _id_2 = _entity.getId();
          boolean _notEquals = (!Objects.equal(_id_2, null));
          _and = (_equals_1 && _notEquals);
        }
        _or = (_equals || _and);
      }
      _xblockexpression = (_or);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public Collection<ValidationErrorItem> validate(final GWTCustomer _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getName()!=null && !NameShouldBeUnique(_entity)){
    	errors.add(new ValidationErrorItem("客户名称重复","name"));
    }
    if(_entity.getPhone()!=null && !PhoneShouldBeUnique(_entity)){
    	errors.add(new ValidationErrorItem("电话号码重复","phone"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"name"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Phone rule 
    		= ruleFactory.Phone(_entity.getPhone());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"phone"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getStatus());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"status"));
    }
    return errors;
    
  }
}
