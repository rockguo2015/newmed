package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.google.common.base.Objects;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.ICellRender;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.TimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class GroupTaskOutlineListGrid extends GXTGridComponent<UIGroupTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIGroupTask,UIGroupTaskStatus> status;
  
  public StringValueColumn<UIGroupTask,RCMaintenanceTeamProxy> team;
  
  public DateColumn<UIGroupTask> date;
  
  public TimeColumn<UIGroupTask> time;
  
  public DateColumn<UIGroupTask> finishDate;
  
  public DateColumn<UIGroupTask> finishTime;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIGroupTask value = new UIGroupTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIGroupTask.StatusAccessor);
    widgetsRegistory.put("status",status);
    team = defaultObjectSelectorFactory.createAsDefaultColumn("team","班组",UIGroupTask.TeamAccessor);
    widgetsRegistory.put("team",team);
    date = dateValueProviderFactory.createAsStringColumn("date","派发日期",UIGroupTask.DateAccessor);
    widgetsRegistory.put("date",date);
    time = dateValueProviderFactory.createAsTimeColumn("time","派发时间",UIGroupTask.TimeAccessor);
    widgetsRegistory.put("time",time);
    finishDate = dateValueProviderFactory.createAsStringColumn("finishDate","完工上报日期",UIGroupTask.FinishDateAccessor);
    widgetsRegistory.put("finishDate",finishDate);
    finishTime = dateValueProviderFactory.createAsStringColumn("finishTime","完工上报时间",UIGroupTask.FinishTimeAccessor);
    widgetsRegistory.put("finishTime",finishTime);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIGroupTask getValueAsNew() {
    UIGroupTask value = new UIGroupTask();
    value.setStatus(status.getValue());
    value.setTeam(team.getValue());
    value.setDate(date.getValue());
    value.setTime(time.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    return value;
  }
  
  public UIGroupTask doGetValue() {
    
    value.setStatus(status.getValue());
    value.setTeam(team.getValue());
    value.setDate(date.getValue());
    value.setTime(time.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    return value;
  }
  
  public UIGroupTask getValue(final UIGroupTask copyValue) {
    
    copyValue.setStatus(status.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setTime(time.getValue());
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setFinishTime(finishTime.getValue());
    return copyValue;
  }
  
  protected GroupTaskOutlineListGrid doSetValue(final UIGroupTask value) {
    this.value = value;
    status.setValue(value.getStatus());
    team.setValue(value.getTeam());
    date.setValue(value.getDate());
    time.setValue(value.getTime());
    finishDate.setValue(value.getFinishDate());
    finishTime.setValue(value.getFinishTime());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)status,(ICanAsWidget)team,(ICanAsWidget)date,(ICanAsWidget)time,(ICanAsWidget)finishDate,(ICanAsWidget)finishTime
    					);
  }
  
  public void initializeComponent() {
    final Procedure3<Context,UIGroupTaskStatus,SafeHtmlBuilder> _function = new Procedure3<Context,UIGroupTaskStatus,SafeHtmlBuilder>() {
        public void apply(final Context context, final UIGroupTaskStatus value, final SafeHtmlBuilder sb) {
          boolean _or = false;
          boolean _equals = Objects.equal(value, UIGroupTaskStatus.newCreated);
          if (_equals) {
            _or = true;
          } else {
            boolean _equals_1 = Objects.equal(value, UIGroupTaskStatus.wait4TeamOwnerProcess);
            _or = (_equals || _equals_1);
          }
          if (_or) {
            String _string = value.toString();
            String _plus = ("<B style=\'color:red;\'>" + _string);
            String _plus_1 = (_plus + "</B>");
            sb.appendHtmlConstant(_plus_1);
          } else {
            String _string_1 = value.toString();
            sb.appendHtmlConstant(_string_1);
          }
        }
      };
    this.status.setRender(new ICellRender<UIGroupTaskStatus>() {
        public void render(Context context,UIGroupTaskStatus value,SafeHtmlBuilder sb) {
          _function.apply(context,value,sb);
        }
    });
  }
}
