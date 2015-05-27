package edu.fudan.langlab.csv.server;

import java.io.OutputStreamWriter;
import java.util.Collection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import edu.fudan.langlab.csv.server.mapper.ICSVMapper;

public class DownloadParameter<T> {
	private String fileTitle;
	private Collection<T> data;
	private Class<?> mapperClass;

	public DownloadParameter(String fileTitle, Collection<T> data,
			Class<?> mapperClass) {
		this.fileTitle = fileTitle;
		this.data = data;
		this.mapperClass = mapperClass;
	}

	public Collection<T> getData() {
		return data;
	}

	public Class<?> getMapperClass() {
		return mapperClass;
	}
	
	public void download(WebApplicationContext context, HttpServletResponse resp) {
		try {
			System.out.println("Begin download");
			OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream(),"GB2312");					
			
			resp.setContentType("text/txt");
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ getFileTitle() + ".csv");
			ICSVMapper<T> mapper = (ICSVMapper<T>) context.getBean(mapperClass);
			writer.write(mapper.toHeader());
			writer.write("\r\n");
			System.out.println("Begin each row");
			for (T t : data) {
				System.out.println("process row");
				writer.write(mapper.toString(t));
				writer.write("\r\n");
			}
			System.out.println("finish each row");
			writer.flush();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String getFileTitle() {
		return fileTitle;
	}
}
