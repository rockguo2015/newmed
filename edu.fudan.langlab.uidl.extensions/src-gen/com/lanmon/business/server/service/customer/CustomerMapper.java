package com.lanmon.business.server.service.customer;

import com.lanmon.business.server.service.customer.CustomerValidator;
import com.lanmon.business.shared.customer.GWTCustomer;
import com.lanmon.workflow.business.Customer;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.CustomerMapper")
public class CustomerMapper extends AbstractEntityMapper<GWTCustomer,Customer> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Customer loadEntityById(final Long id) {
    return entities.get(Customer.class,id);
  }
  
  public Customer create() {
    return entities.create(Customer.class);
  }
  
  @Autowired
  private CustomerValidator validator;
  
  public void copyToEntity(final GWTCustomer from, final Customer to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setPhone(convertService.toValue(java.lang.String.class,from.getPhone()));
    to.setFax(convertService.toValue(java.lang.String.class,from.getFax()));
    to.setOnsiteSaleOwner(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getOnsiteSaleOwner()));
    to.setPhoneSaleOwner(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getPhoneSaleOwner()));
    to.setStatus(convertService.toValue(com.lanmon.workflow.business.CustomerStatus.class,from.getStatus()));
    to.setAnnotation(convertService.toValue(java.lang.String.class,from.getAnnotation()));
    to.getAddress().setZipcode(convertService.toValue(java.lang.String.class,from.getPostcode()));
    to.getAddress().setAddrinfo(convertService.toValue(java.lang.String.class,from.getAddressInfo()));
    to.getAddress().setEmail(convertService.toValue(java.lang.String.class,from.getEmail()));
    to.getAddress().setHomepage(convertService.toValue(java.lang.String.class,from.getHomePage()));
    to.setContractDate(convertService.toValue(edu.fudan.langlab.datatypes.DateRange.class,from.getContractDate()));
    to.setOutsourceDate(convertService.toValue(edu.fudan.langlab.datatypes.DateRange.class,from.getOutsourceDate()));
    to.setDomainCode(convertService.toValue(com.lanmon.workflow.business.DomainCode.class,from.getDomainCode()));
    to.setPropertyCode(convertService.toValue(com.lanmon.workflow.business.PropertyCode.class,from.getPropertyCode()));
    to.setScaleCode(convertService.toValue(com.lanmon.workflow.business.ScaleCode.class,from.getScaleCode()));
    to.setRegionCode(convertService.toValue(com.lanmon.workflow.business.RegionCode.class,from.getRegionCode()));
    to.setContractor(convertService.toValue(java.lang.String.class,from.getContractor()));
    to.setCustomerComment(convertService.toValue(java.lang.String.class,from.getCustomerComment()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final GWTCustomer _gwt, final Customer _entity) {
    Date _date = new Date();
    _entity.setLastUpdate(_date);
  }
  
  public GWTCustomer copyFromEntity(final GWTCustomer result, final Customer entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setPhone(convertService.toValue(java.lang.String.class,entity.getPhone()));
    result.setFax(convertService.toValue(java.lang.String.class,entity.getFax()));
    result.setOnsiteSaleOwner(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getOnsiteSaleOwner()));
    result.setPhoneSaleOwner(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getPhoneSaleOwner()));
    result.setStatus(convertService.toValue(com.lanmon.business.shared.customer.GWTCustomerStatus.class,entity.getStatus()));
    result.setAnnotation(convertService.toValue(java.lang.String.class,entity.getAnnotation()));
    if(entity. getAddress()  != null )
    	result.setPostcode(convertService.toValue(java.lang.String.class,entity.getAddress().getZipcode()));
    if(entity. getAddress()  != null )
    	result.setAddressInfo(convertService.toValue(java.lang.String.class,entity.getAddress().getAddrinfo()));
    if(entity. getAddress()  != null )
    	result.setEmail(convertService.toValue(java.lang.String.class,entity.getAddress().getEmail()));
    if(entity. getAddress()  != null )
    	result.setHomePage(convertService.toValue(java.lang.String.class,entity.getAddress().getHomepage()));
    result.setContractDate(convertService.toValue(com.uniquesoft.gwt.shared.datatype.DateRange.class,entity.getContractDate()));
    result.setOutsourceDate(convertService.toValue(com.uniquesoft.gwt.shared.datatype.DateRange.class,entity.getOutsourceDate()));
    result.setDomainCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getDomainCode()));
    result.setPropertyCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getPropertyCode()));
    result.setScaleCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getScaleCode()));
    result.setRegionCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getRegionCode()));
    result.setContractor(convertService.toValue(java.lang.String.class,entity.getContractor()));
    result.setCustomerComment(convertService.toValue(java.lang.String.class,entity.getCustomerComment()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public GWTCustomer buildFrom(final Customer entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.customer.GWTCustomer result = new com.lanmon.business.shared.customer.GWTCustomer();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final GWTCustomer _gwt, final Customer _entity) {
    Date _lastUpdate = _entity.getLastUpdate();
    _gwt.setLastUpdate(_lastUpdate);
  }
  
  public Class<?> getUIClass() {
    return GWTCustomer.class;
  }
  
  public Class<?> getEntityClass() {
    return Customer.class;
  }
}
