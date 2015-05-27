package edu.fudan.langlab.domain.code.impl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.domain.code.CodeService;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.CodeTypeProvider;
import edu.fudan.langlab.domain.code.events.CodeEventsManager;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CodeService")
@SuppressWarnings("all")
public class CodeServiceImpl implements CodeService {
  @Autowired(required = false)
  private List<CodeTypeProvider> codeTypeProviders = new Function0<List<CodeTypeProvider>>() {
    public List<CodeTypeProvider> apply() {
      ArrayList<CodeTypeProvider> _newArrayList = CollectionLiterals.<CodeTypeProvider>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  @Autowired
  private CodeEventsManager eventsManager;
  
  @Autowired
  private IObjectFactory entities;
  
  public Collection<CodeType> getAllCodeTypes() {
    final Function1<CodeTypeProvider,Collection<CodeType>> _function = new Function1<CodeTypeProvider,Collection<CodeType>>() {
        public Collection<CodeType> apply(final CodeTypeProvider it) {
          Collection<CodeType> _codeTypes = it.getCodeTypes();
          return _codeTypes;
        }
      };
    List<Collection<CodeType>> _map = ListExtensions.<CodeTypeProvider, Collection<CodeType>>map(this.codeTypeProviders, _function);
    Iterable<CodeType> _flatten = Iterables.<CodeType>concat(_map);
    List<CodeType> _list = IterableExtensions.<CodeType>toList(_flatten);
    return _list;
  }
  
  public CodeType findCodeType(final String className) {
    Collection<CodeType> _allCodeTypes = this.getAllCodeTypes();
    final Function1<CodeType,Boolean> _function = new Function1<CodeType,Boolean>() {
        public Boolean apply(final CodeType it) {
          String _className = it.getClassName();
          boolean _equals = Objects.equal(_className, className);
          return Boolean.valueOf(_equals);
        }
      };
    CodeType _findFirst = IterableExtensions.<CodeType>findFirst(_allCodeTypes, _function);
    return _findFirst;
  }
  
  public Code createCode(final CodeType codeType) {
    Code _xblockexpression = null;
    {
      final Code result = codeType.createCode(this.entities);
      this.eventsManager.fireCreated(result);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void deleteCode(final Code code) {
    this.entities.delete(code);
    this.eventsManager.fireDeleted(code);
  }
  
  public <T extends Code> T getCodeByName(final Class<T> codeType, final String name) {
    T _xblockexpression = null;
    {
      final EntityImplementation entityImplAnnotation = codeType.<EntityImplementation>getAnnotation(EntityImplementation.class);
      Class<? extends BaseModelObject> _implementBy = entityImplAnnotation.implementBy();
      String _name = _implementBy.getName();
      String _plus = ("from " + _name);
      String _plus_1 = (_plus + " e where e.name = \'");
      String _plus_2 = (_plus_1 + name);
      final String hql = (_plus_2 + "\'");
      Query _createQuery = this.entities.createQuery(hql);
      Object _uniqueResult = _createQuery.uniqueResult();
      _xblockexpression = (((T) _uniqueResult));
    }
    return _xblockexpression;
  }
}
