package com.fudanmed.platform.core.organization;

import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.RCSecurityService;
import edu.fudan.mylang.pf.test.BaseTest;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = "classpath:HibernateApplicationContext-test.xml")
public class ExportDDL extends BaseTest {
  public ExportDDL() {
    super();
  }
  
  @Autowired
  private RCOrganizationService organizationService;
  
  @Autowired
  private RCSecurityService securityService;
  
  @Autowired
  private LocalSessionFactoryBean sessionFactory;
  
  @Test
  public void exportddl() {
    InputOutput.<LocalSessionFactoryBean>println(this.sessionFactory);
    Configuration _configuration = this.sessionFactory.getConfiguration();
    SchemaExport _schemaExport = new SchemaExport(_configuration);
    final Procedure1<SchemaExport> _function = new Procedure1<SchemaExport>() {
        public void apply(final SchemaExport it) {
          it.setFormat(true);
          it.setOutputFile("/Users/zhangtiange/Documents/git/fudanmed/com.fudanmed.platform.core/ddl.sql");
          it.create(true, false);
        }
      };
    ObjectExtensions.<SchemaExport>operator_doubleArrow(_schemaExport, _function);
  }
}
