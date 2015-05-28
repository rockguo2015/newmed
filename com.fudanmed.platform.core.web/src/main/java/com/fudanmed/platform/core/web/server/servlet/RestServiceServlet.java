package com.fudanmed.platform.core.web.server.servlet;

import com.fudanmed.platform.core.web.server.jsonservice.IAppRestService;
import com.fudanmed.platform.core.web.server.jsonservice.JSONServiceException;
import com.fudanmed.platform.core.web.server.jsonservice.JSONUtil;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.HttpRequestThreadLocal;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.statemachine.InvalidStateException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("all")
public class RestServiceServlet extends HttpServlet {
  private HashMap<String,Function2<? super HttpServletRequest,? super HttpServletResponse,? extends JSONObject>> dispatcher = new Function0<HashMap<String,Function2<? super HttpServletRequest,? super HttpServletResponse,? extends JSONObject>>>() {
    public HashMap<String,Function2<? super HttpServletRequest,? super HttpServletResponse,? extends JSONObject>> apply() {
      HashMap<String,Function2<? super HttpServletRequest,? super HttpServletResponse,? extends JSONObject>> _hashMap = new HashMap<String,Function2<? super HttpServletRequest,? super HttpServletResponse,? extends JSONObject>>();
      return _hashMap;
    }
  }.apply();
  
  private static Log logger = new Function0<Log>() {
    public Log apply() {
      Log _log = LogFactory.getLog(RestServiceServlet.class);
      return _log;
    }
  }.apply();
  
  public boolean isEncode(final String s, final String encoding) {
    try {
      byte[] _bytes = s.getBytes(encoding);
      String _string = new String(_bytes, encoding);
      boolean _equals = s.equals(_string);
      return _equals;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getRequiredParameter(final HttpServletRequest request, final String key) {
    String _xblockexpression = null;
    {
      final String value = request.getParameter(key);
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
        String _plus = ("missing parameter:" + key);
        JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
        throw _jSONServiceException;
      }
      _xblockexpression = (value);
    }
    return _xblockexpression;
  }
  
  public String[] getRequiredParameterValues(final HttpServletRequest request, final String key) {
    String[] _xblockexpression = null;
    {
      final String[] value = request.getParameterValues(key);
      boolean _or = false;
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
        _or = true;
      } else {
        int _size = ((List<String>)Conversions.doWrapArray(value)).size();
        boolean _equals_1 = (_size == 0);
        _or = (_equals || _equals_1);
      }
      if (_or) {
        String _plus = ("missing parameter:" + key);
        JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
        throw _jSONServiceException;
      }
      _xblockexpression = (value);
    }
    return _xblockexpression;
  }
  
  public JSONObject stateAwareExecute(final Function1<? super Void,? extends JSONObject> executer) {
    JSONObject _xtrycatchfinallyexpression = null;
    try {
      JSONObject _apply = executer.apply(null);
      _xtrycatchfinallyexpression = _apply;
    } catch (final Throwable _t) {
      if (_t instanceof InvalidStateException) {
        final InvalidStateException e = (InvalidStateException)_t;
        JSONObject _fail = JSONUtil.fail("\u5DE5\u5355\u72B6\u6001\u9519\u8BEF\uFF0C\u8BF7\u5237\u65B0\u72B6\u6001");
        _xtrycatchfinallyexpression = _fail;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  private File tempDir = new Function0<File>() {
    public File apply() {
      String _property = System.getProperty("java.io.tmpdir");
      File _file = new File(_property);
      return _file;
    }
  }.apply();
  
  public RestServiceServlet() {
    super();
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _parameter = req.getParameter("userid");
          String _parameter_1 = req.getParameter("passwd");
          JSONObject _login = _appRestService.login(_parameter, _parameter_1);
          return _login;
        }
      };
    this.dispatcher.put("login", _function);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_1 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "oldPasswd");
          String _requiredParameter_2 = RestServiceServlet.this.getRequiredParameter(req, "newPasswd");
          JSONObject _modifyPasswd = _appRestService.modifyPasswd(_userid, _requiredParameter_1, _requiredParameter_2);
          return _modifyPasswd;
        }
      };
    this.dispatcher.put("modifypasswd", _function_1);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_2 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "startDate");
          String _requiredParameter_2 = RestServiceServlet.this.getRequiredParameter(req, "endDate");
          JSONObject _finishedCount = _appRestService.getFinishedCount(_userid, _requiredParameter_1, _requiredParameter_2);
          return _finishedCount;
        }
      };
    this.dispatcher.put("finishedcount", _function_2);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_3 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "startDate");
          String _requiredParameter_2 = RestServiceServlet.this.getRequiredParameter(req, "endDate");
          String _requiredParameter_3 = RestServiceServlet.this.getRequiredParameter(req, "startNumber");
          String _requiredParameter_4 = RestServiceServlet.this.getRequiredParameter(req, "endNumber");
          JSONObject _finishedWorkItems = _appRestService.getFinishedWorkItems(_userid, _requiredParameter_1, _requiredParameter_2, _requiredParameter_3, _requiredParameter_4);
          return _finishedWorkItems;
        }
      };
    this.dispatcher.put("finishedworkitems", _function_3);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_4 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          JSONObject _processingCount = _appRestService.getProcessingCount(_userid);
          return _processingCount;
        }
      };
    this.dispatcher.put("processingcount", _function_4);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_5 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "startNumber");
          String _requiredParameter_2 = RestServiceServlet.this.getRequiredParameter(req, "endNumber");
          JSONObject _processingWorkItems = _appRestService.getProcessingWorkItems(_userid, _requiredParameter_1, _requiredParameter_2);
          return _processingWorkItems;
        }
      };
    this.dispatcher.put("processingworkitems", _function_5);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_6 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "startNumber");
          String _requiredParameter_2 = RestServiceServlet.this.getRequiredParameter(req, "endNumber");
          String _parameter = req.getParameter("startDate");
          String _parameter_1 = req.getParameter("endDate");
          String _requiredParameter_3 = RestServiceServlet.this.getRequiredParameter(req, "status");
          JSONObject _workItem4Status = _appRestService.getWorkItem4Status(_userid, _requiredParameter_1, _requiredParameter_2, _parameter, _parameter_1, _requiredParameter_3);
          return _workItem4Status;
        }
      };
    this.dispatcher.put("workitems4status", _function_6);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_7 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
          JSONObject _workItemDetail = _appRestService.getWorkItemDetail(_requiredParameter);
          return _workItemDetail;
        }
      };
    this.dispatcher.put("workitemdetail", _function_7);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_8 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  JSONObject _pendWorkItem = _appRestService.pendWorkItem(_requiredParameter, _string);
                  return _pendWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("pend", _function_8);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_9 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "reportTime");
                  String _parameter_1 = req.getParameter("deviceNumber");
                  String[] _parameterValues = req.getParameterValues("photoIds");
                  JSONObject _cancelPendWorkItem = _appRestService.cancelPendWorkItem(_requiredParameter, _string, _requiredParameter_1, _parameter_1, _parameterValues);
                  return _cancelPendWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("cancelpend", _function_9);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_10 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  JSONObject _outsourceWorkItem = _appRestService.outsourceWorkItem(_requiredParameter, _string);
                  return _outsourceWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("outsource", _function_10);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_11 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "reportTime");
                  String _parameter_1 = req.getParameter("deviceNumber");
                  String[] _parameterValues = req.getParameterValues("photoIds");
                  JSONObject _finishOutsourceWorkItem = _appRestService.finishOutsourceWorkItem(_requiredParameter, _string, _requiredParameter_1, _parameter_1, _parameterValues);
                  return _finishOutsourceWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("finishoutsource", _function_11);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_12 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "reportTime");
                  JSONObject _misdispatchWorkItem = _appRestService.misdispatchWorkItem(_requiredParameter, _string, _requiredParameter_1);
                  return _misdispatchWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("misdispatching", _function_12);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_13 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "reportTime");
                  JSONObject _followupWorkItem = _appRestService.followupWorkItem(_requiredParameter, _string, _requiredParameter_1);
                  return _followupWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("followup", _function_13);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_14 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          final Function1<Void,JSONObject> _function = new Function1<Void,JSONObject>() {
              public JSONObject apply(final Void it) {
                try {
                  IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
                  String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "id");
                  String _parameter = req.getParameter("description");
                  byte[] _bytes = _parameter.getBytes("iso8859-1");
                  String _string = new String(_bytes, "utf-8");
                  String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "reportTime");
                  String _parameter_1 = req.getParameter("deviceNumber");
                  String[] _parameterValues = req.getParameterValues("photoIds");
                  JSONObject _finishWorkItem = _appRestService.finishWorkItem(_requiredParameter, _string, _requiredParameter_1, _parameter_1, _parameterValues);
                  return _finishWorkItem;
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _stateAwareExecute = RestServiceServlet.this.stateAwareExecute(_function);
          return _stateAwareExecute;
        }
      };
    this.dispatcher.put("finish", _function_14);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_15 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _parameter = req.getParameter("deviceType");
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "startNumber");
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "endNumber");
          String _parameter_1 = req.getParameter("deviceSid");
          JSONObject _measureDeviceList = _appRestService.getMeasureDeviceList(_parameter, _requiredParameter, _requiredParameter_1, _parameter_1);
          return _measureDeviceList;
        }
      };
    this.dispatcher.put("measuredevicelist", _function_15);
    final Function2<HttpServletRequest,HttpServletResponse,JSONObject> _function_16 = new Function2<HttpServletRequest,HttpServletResponse,JSONObject>() {
        public JSONObject apply(final HttpServletRequest req, final HttpServletResponse resp) {
          IAppRestService _appRestService = RestServiceServlet.this.getAppRestService(req);
          String _requiredParameter = RestServiceServlet.this.getRequiredParameter(req, "sessionid");
          String _userid = RestServiceServlet.this.toUserid(_requiredParameter);
          String _requiredParameter_1 = RestServiceServlet.this.getRequiredParameter(req, "id");
          String[] _requiredParameterValues = RestServiceServlet.this.getRequiredParameterValues(req, "value");
          String _requiredParameter_2 = RestServiceServlet.this.getRequiredParameter(req, "date");
          JSONObject _submitMeasureResult = _appRestService.submitMeasureResult(_userid, _requiredParameter_1, ((Collection<String>)Conversions.doWrapArray(_requiredParameterValues)), _requiredParameter_2);
          return _submitMeasureResult;
        }
      };
    this.dispatcher.put("submitmeasureresult", _function_16);
  }
  
  public String toUserid(final String sessionid) {
    return sessionid;
  }
  
  public IAppRestService getAppRestService(final HttpServletRequest req) {
    IAppRestService _xblockexpression = null;
    {
      HttpSession _session = req.getSession();
      ServletContext _servletContext = _session.getServletContext();
      final WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(_servletContext);
      IAppRestService _bean = applicationContext.<IAppRestService>getBean(IAppRestService.class);
      _xblockexpression = (_bean);
    }
    return _xblockexpression;
  }
  
  public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    HttpRequestThreadLocal.set(req);
    String _requestURI = req.getRequestURI();
    String _requestURI_1 = req.getRequestURI();
    int _lastIndexOf = _requestURI_1.lastIndexOf("/");
    int _plus = (_lastIndexOf + 1);
    final String serviceName = _requestURI.substring(_plus);
    String _plus_1 = ("invoke rest service:" + serviceName);
    RestServiceServlet.logger.info(_plus_1);
    ServletOutputStream _outputStream = resp.getOutputStream();
    OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(_outputStream, "UTF-8");
    final OutputStreamWriter writer = _outputStreamWriter;
    resp.setContentType("application/json");
    try {
      Function2<? super HttpServletRequest,? super HttpServletResponse,? extends JSONObject> _get = this.dispatcher.get(serviceName);
      final JSONObject result = _get.apply(req, resp);
      String _string = result.toString();
      writer.write(_string);
    } catch (final Throwable _t) {
      if (_t instanceof ValidationException) {
        final ValidationException e = (ValidationException)_t;
        String _message = e.getMessage();
        JSONObject _fail = JSONUtil.fail(_message);
        String _string_1 = _fail.toString();
        writer.write(_string_1);
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        RestServiceServlet.logger.error(e_1);
        String _message_1 = e_1.getMessage();
        JSONObject _fatal = JSONUtil.fatal(_message_1);
        String _string_2 = _fatal.toString();
        writer.write(_string_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      writer.flush();
    }
  }
  
  public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    String _requestURI = request.getRequestURI();
    String _requestURI_1 = request.getRequestURI();
    int _lastIndexOf = _requestURI_1.lastIndexOf("/");
    int _plus = (_lastIndexOf + 1);
    final String serviceName = _requestURI.substring(_plus);
    ServletOutputStream _outputStream = response.getOutputStream();
    OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(_outputStream, "UTF-8");
    final OutputStreamWriter writer = _outputStreamWriter;
    String _plus_1 = ("invoke rest service:" + serviceName);
    RestServiceServlet.logger.info(_plus_1);
    try {
      boolean _and = false;
      boolean _isMultipartContent = ServletFileUpload.isMultipartContent(request);
      if (!_isMultipartContent) {
        _and = false;
      } else {
        boolean _equals = "upload".equals(serviceName);
        _and = (_isMultipartContent && _equals);
      }
      if (_and) {
        DiskFileItemFactory _diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload _servletFileUpload = new ServletFileUpload(_diskFileItemFactory);
        final List<FileItem> multiparts = _servletFileUpload.parseRequest(request);
        final Function1<FileItem,Boolean> _function = new Function1<FileItem,Boolean>() {
            public Boolean apply(final FileItem it) {
              boolean _isFormField = it.isFormField();
              boolean _not = (!_isFormField);
              return Boolean.valueOf(_not);
            }
          };
        Iterable<FileItem> _filter = IterableExtensions.<FileItem>filter(multiparts, _function);
        final FileItem item = IterableExtensions.<FileItem>head(_filter);
        UUID _randomUUID = UUID.randomUUID();
        String _string = _randomUUID.toString();
        String _name = item.getName();
        final String name = (_string + _name);
        File _file = new File(this.tempDir, name);
        item.write(_file);
        String _absolutePath = this.tempDir.getAbsolutePath();
        String _plus_2 = (_absolutePath + "/");
        String _plus_3 = (_plus_2 + name);
        InputOutput.<String>println(_plus_3);
        final Procedure1<JSONObject> _function_1 = new Procedure1<JSONObject>() {
            public void apply(final JSONObject it) {
              try {
                it.put("photoId", name);
              } catch (Exception _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        JSONObject _success = JSONUtil.success(_function_1);
        final String respStr = _success.toString();
        InputOutput.<String>println(respStr);
        writer.write(respStr);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _message = e.getMessage();
        JSONUtil.fail(_message);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      writer.flush();
    }
  }
}
