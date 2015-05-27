package edu.fudan.langlab.uidl.domain.document.server;

import javax.servlet.http.HttpServletResponse;

import org.jgroups.util.UUID;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.io.ByteStreams;
import com.uniquesoft.gwt.server.service.common.HttpAware;

import edu.fudan.langlab.domain.document.IDocument;

public class DocumentDownloader {
	private IDocument document;

	public DocumentDownloader(IDocument document) {
		this.document = document;
	}

	public void download(WebApplicationContext applicationContext,
			HttpServletResponse resp) {
		try {
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ getFileName(document));
			resp.setContentType(document.getContentType());
			ByteStreams.copy(document.getContent().getBinaryStream(),
					resp.getOutputStream());
			resp.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String getFileName(IDocument document) {
		String fname = document.getFileName();
		int index = fname.lastIndexOf('.');
		if (index == -1)
			return "document";
		else
			return "document" + fname.substring(fname.lastIndexOf('.'));
	}

	public static String prepareDownload(HttpAware httpAware, IDocument document) {
		String uuid = UUID.randomUUID().toString();
		httpAware.getRequest().getSession()
				.setAttribute(uuid, new DocumentDownloader(document));
		return uuid;

	}
}
