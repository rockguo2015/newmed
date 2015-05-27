package edu.fudan.langlab.csv.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

@SuppressWarnings("all")
public class CSVClientExtensions {
  public static void doDownload(final String uuid) {
    String _moduleBaseURL = GWT.getModuleBaseURL();
    String _plus = (_moduleBaseURL + "service/csvFileDownloader?uuid=");
    String url = (_plus + uuid);
    Window.open(url, "_blank", "");
  }
}
