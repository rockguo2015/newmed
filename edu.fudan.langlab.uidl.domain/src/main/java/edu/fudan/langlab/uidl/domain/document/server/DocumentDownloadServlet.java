package edu.fudan.langlab.uidl.domain.document.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.uniquesoft.gwt.server.service.common.HttpRequestThreadLocal;

public class DocumentDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpRequestThreadLocal.set(req);
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(req.getSession().getServletContext());
		DocumentDownloader parameter = (DocumentDownloader) req.getSession()
				.getAttribute(req.getParameter("uuid"));
		parameter.download(applicationContext, resp);
		req.getSession().removeAttribute(req.getParameter("uuid"));

	}

}
