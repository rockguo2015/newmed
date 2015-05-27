package com.fudanmed.platform.core.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.RCSecurityService;
import edu.fudan.mylang.pf.test.BaseTest;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = "classpath:HibernateApplicationContext-test.xml")
public class InitData extends BaseTest {
  public InitData() {
    super();
  }
  
  @Autowired
  private RCOrganizationService organizationService;
  
  @Autowired
  private RCSecurityService securityService;
  
  @Test
  public void initdatas() {
    this.organizationService.createRootOrganization("00n", "\u534E\u5C71\u533B\u9662");
  }
  
  public void initAdmin() {
  }
  
  public void initOrgzniation() {
    final RCOrganization hospital = this.organizationService.createRootOrganization("001", "\u534E\u5C71\u533B\u9662");
    final RCOrganization host = this.organizationService.createRootOrganization("002", "\u590D\u65E6\u540E\u52E4\u8FD0\u8425\u70B9");
    RCOrganization _createAndAddtoSubOrganizations = hospital.createAndAddtoSubOrganizations();
    final Procedure1<RCOrganization> _function = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization it) {
          it.setCode("001001");
          it.setName("\u4F4F\u9662\u90E8");
        }
      };
    ObjectExtensions.<RCOrganization>operator_doubleArrow(_createAndAddtoSubOrganizations, _function);
    RCOrganization _createAndAddtoSubOrganizations_1 = hospital.createAndAddtoSubOrganizations();
    final Procedure1<RCOrganization> _function_1 = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization it) {
          it.setCode("001002");
          it.setName("\u95E8\u8BCA");
        }
      };
    ObjectExtensions.<RCOrganization>operator_doubleArrow(_createAndAddtoSubOrganizations_1, _function_1);
    RCOrganization _createAndAddtoSubOrganizations_2 = host.createAndAddtoSubOrganizations();
    final Procedure1<RCOrganization> _function_2 = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization it) {
          it.setCode("002001");
          it.setName("\u5DE5\u7A0B\u90E8");
        }
      };
    final RCOrganization edepart = ObjectExtensions.<RCOrganization>operator_doubleArrow(_createAndAddtoSubOrganizations_2, _function_2);
    RCOrganization _createAndAddtoSubOrganizations_3 = edepart.createAndAddtoSubOrganizations();
    final Procedure1<RCOrganization> _function_3 = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization it) {
          it.setCode("002001001");
          it.setName("\u6C34\u7535\u73ED\u7EC4");
        }
      };
    ObjectExtensions.<RCOrganization>operator_doubleArrow(_createAndAddtoSubOrganizations_3, _function_3);
    RCOrganization _createAndAddtoSubOrganizations_4 = edepart.createAndAddtoSubOrganizations();
    final Procedure1<RCOrganization> _function_4 = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization it) {
          it.setCode("002001002");
          it.setName("\u7A7A\u8C03\u73ED\u7EC4");
        }
      };
    ObjectExtensions.<RCOrganization>operator_doubleArrow(_createAndAddtoSubOrganizations_4, _function_4);
  }
  
  public void initLocation() {
    this.organizationService.createRootOnsitePosition("001", "\u534E\u5C71\u533B\u9662");
  }
}
