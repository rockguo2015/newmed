package edu.fudan.langlab.uidl.domain.document.client;

import com.google.gwt.core.client.GWT;

public class DocumentDownloadExtensions {
	public static void doDownload(String uuid) {
		com.google.gwt.user.client.Window.open(buildUrl(uuid), "_blank", "");

	}

	public static String buildUrl(String uuid) {
		return GWT.getModuleBaseURL() + "service/documentDownloader?uuid="
				+ uuid;
	}
}
