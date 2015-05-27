package mock.impl;

import com.fudanmed.platform.core.domain.RCEmployeeUser;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.stereotype.Service;

@Service("mock.MockSystemUserService")
public class MockSystemUserServiceImpl extends BaseService implements ISystemUserService {
  public User getCurrentUser() {IGenericQuery<RCEmployeeUser> query=getObjectFactory().createGenericQuery(RCEmployeeUser.class,"select eu from com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl as eu   where  eu.active = 1      ");
    Collection<RCEmployeeUser> _list = query.list();
    final Function1<RCEmployeeUser,Boolean> _function = new Function1<RCEmployeeUser,Boolean>() {
        public Boolean apply(final RCEmployeeUser it) {
          return Boolean.valueOf(true);
        }
      };
    RCEmployeeUser _findFirst = IterableExtensions.<RCEmployeeUser>findFirst(_list, _function);
    return _findFirst;
  }
  
  public void setCurrentUser(final User user) {
  }
  
  public Party getCurrentUserAsParty() {
    return null;
  }
}
