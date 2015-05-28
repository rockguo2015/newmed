package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.UISupplierTypeContentProvider;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierType;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.RadioButtonSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SupplierForm extends GXTFormComponent<UISupplier> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem code;
  
  public TextItem name;
  
  public TextItem phone;
  
  public TextItem email;
  
  public TextItem address;
  
  public RadioButtonSelector<UISupplierType> type;
  
  @Inject
  public UISupplierTypeContentProvider typeContentProvider;
  
  public TextItem shortName;
  
  public TextItem ename;
  
  public TextItem spell;
  
  public TextItem helpCode;
  
  public TextItem enterpriseEnrolNum;
  
  public TextItem workNo;
  
  public DoubleItem regCapital;
  
  public TextItem legalPerson;
  
  public TextItem aptitudeName;
  
  public TextItem aptitudeNo;
  
  public CheckBoxItem inputNext;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UISupplier value = new UISupplier();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsTextItem("code","代码");
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    phone = stringValueProviderFactory.createAsTextItem("phone","联系电话");
    widgetsRegistory.put("phone",phone);
    email = stringValueProviderFactory.createAsTextItem("email","电子邮件");
    widgetsRegistory.put("email",email);
    address = stringValueProviderFactory.createAsTextItem("address","地址 ");
    widgetsRegistory.put("address",address);
    type = defaultObjectSelectorFactory.createAsRadioGroupItem("type","类型");
    type.setContentProvider(typeContentProvider);
    widgetsRegistory.put("type",type);
    shortName = stringValueProviderFactory.createAsTextItem("shortName","简称");
    widgetsRegistory.put("shortName",shortName);
    ename = stringValueProviderFactory.createAsTextItem("ename","英文名称");
    widgetsRegistory.put("ename",ename);
    spell = stringValueProviderFactory.createAsTextItem("spell","拼音");
    widgetsRegistory.put("spell",spell);
    helpCode = stringValueProviderFactory.createAsTextItem("helpCode","助记码");
    widgetsRegistory.put("helpCode",helpCode);
    enterpriseEnrolNum = stringValueProviderFactory.createAsTextItem("enterpriseEnrolNum","企业注册号");
    widgetsRegistory.put("enterpriseEnrolNum",enterpriseEnrolNum);
    workNo = stringValueProviderFactory.createAsTextItem("workNo","营业执照号");
    widgetsRegistory.put("workNo",workNo);
    regCapital = doubleValueProviderFactory.createAsDoubleItem("regCapital","注册资金");
    widgetsRegistory.put("regCapital",regCapital);
    legalPerson = stringValueProviderFactory.createAsTextItem("legalPerson","法定代表人");
    widgetsRegistory.put("legalPerson",legalPerson);
    aptitudeName = stringValueProviderFactory.createAsTextItem("aptitudeName","已获得资质");
    widgetsRegistory.put("aptitudeName",aptitudeName);
    aptitudeNo = stringValueProviderFactory.createAsTextItem("aptitudeNo","资质证号");
    widgetsRegistory.put("aptitudeNo",aptitudeNo);
    inputNext = booleanValueProviderFactory.createAsCheckBoxItem("inputNext","继续输入");
    widgetsRegistory.put("inputNext",inputNext);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UISupplier getValueAsNew() {
    UISupplier value = new UISupplier();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setEmail(email.getValue());
    value.setAddress(address.getValue());
    value.setType(type.getValue());
    value.setShortName(shortName.getValue());
    value.setEname(ename.getValue());
    value.setSpell(spell.getValue());
    value.setHelpCode(helpCode.getValue());
    value.setEnterpriseEnrolNum(enterpriseEnrolNum.getValue());
    value.setWorkNo(workNo.getValue());
    value.setRegCapital(regCapital.getValue());
    value.setLegalPerson(legalPerson.getValue());
    value.setAptitudeName(aptitudeName.getValue());
    value.setAptitudeNo(aptitudeNo.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UISupplier doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setEmail(email.getValue());
    value.setAddress(address.getValue());
    value.setType(type.getValue());
    value.setShortName(shortName.getValue());
    value.setEname(ename.getValue());
    value.setSpell(spell.getValue());
    value.setHelpCode(helpCode.getValue());
    value.setEnterpriseEnrolNum(enterpriseEnrolNum.getValue());
    value.setWorkNo(workNo.getValue());
    value.setRegCapital(regCapital.getValue());
    value.setLegalPerson(legalPerson.getValue());
    value.setAptitudeName(aptitudeName.getValue());
    value.setAptitudeNo(aptitudeNo.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UISupplier getValue(final UISupplier copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setEmail(email.getValue());
    copyValue.setAddress(address.getValue());
    copyValue.setType(type.getValue());
    copyValue.setShortName(shortName.getValue());
    copyValue.setEname(ename.getValue());
    copyValue.setSpell(spell.getValue());
    copyValue.setHelpCode(helpCode.getValue());
    copyValue.setEnterpriseEnrolNum(enterpriseEnrolNum.getValue());
    copyValue.setWorkNo(workNo.getValue());
    copyValue.setRegCapital(regCapital.getValue());
    copyValue.setLegalPerson(legalPerson.getValue());
    copyValue.setAptitudeName(aptitudeName.getValue());
    copyValue.setAptitudeNo(aptitudeNo.getValue());
    copyValue.setInputNext(inputNext.getValue());
    return copyValue;
  }
  
  protected SupplierForm doSetValue(final UISupplier value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    email.setValue(value.getEmail());
    address.setValue(value.getAddress());
    type.setValue(value.getType());
    shortName.setValue(value.getShortName());
    ename.setValue(value.getEname());
    spell.setValue(value.getSpell());
    helpCode.setValue(value.getHelpCode());
    enterpriseEnrolNum.setValue(value.getEnterpriseEnrolNum());
    workNo.setValue(value.getWorkNo());
    regCapital.setValue(value.getRegCapital());
    legalPerson.setValue(value.getLegalPerson());
    aptitudeName.setValue(value.getAptitudeName());
    aptitudeNo.setValue(value.getAptitudeNo());
    inputNext.setValue(value.getInputNext());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)email,(ICanAsWidget)address,(ICanAsWidget)type,(ICanAsWidget)shortName,(ICanAsWidget)ename,(ICanAsWidget)spell,(ICanAsWidget)helpCode,(ICanAsWidget)enterpriseEnrolNum,(ICanAsWidget)workNo,(ICanAsWidget)regCapital,(ICanAsWidget)legalPerson,(ICanAsWidget)aptitudeName,(ICanAsWidget)aptitudeNo,(ICanAsWidget)inputNext
    					);
  }
  
  public Widget createWidget() {
    PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          PlainHTMLTR _tr = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.code.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.name.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
          PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.shortName.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.ename.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
          PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.spell.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.helpCode.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
          PlainHTMLTR _tr_3 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_3 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.phone.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.email.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_3, _function_3);
          PlainHTMLTR _tr_4 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_4 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.address.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.enterpriseEnrolNum.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_4, _function_4);
          PlainHTMLTR _tr_5 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_5 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.workNo.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.regCapital.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_5, _function_5);
          PlainHTMLTR _tr_6 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_6 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.legalPerson.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.aptitudeName.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_6, _function_6);
          PlainHTMLTR _tr_7 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_7 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.aptitudeNo.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.type.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_7, _function_7);
          PlainHTMLTR _tr_8 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_8 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = SupplierForm.this.inputNext.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            it.setWidth(120);
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                      ClientUi.operator_add(it, _doubleArrow);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_8, _function_8);
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
    return _doubleArrow;
  }
}
