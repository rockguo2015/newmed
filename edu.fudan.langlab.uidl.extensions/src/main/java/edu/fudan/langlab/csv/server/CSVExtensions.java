package edu.fudan.langlab.csv.server;

import com.uniquesoft.gwt.server.service.common.HttpAware;
import edu.fudan.langlab.csv.server.DownloadParameter;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("all")
public class CSVExtensions {
  public static <T extends Object> String csvPrepare(final HttpAware httpAware, final String fileTitle, final Class<? extends Object> mapperClass, final Collection<T> data) {
    String _xblockexpression = null;
    {
      UUID _randomUUID = UUID.randomUUID();
      String uuid = _randomUUID.toString();
      HttpServletRequest _request = httpAware.getRequest();
      HttpSession _session = _request.getSession();
      DownloadParameter<T> _downloadParameter = new DownloadParameter<T>(fileTitle, data, mapperClass);
      _session.setAttribute(uuid, _downloadParameter);
      _xblockexpression = (uuid);
    }
    return _xblockexpression;
  }
}
