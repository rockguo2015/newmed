package com.uniquesoft.uidl.datatype;

import java.sql.Blob;

public class FileAttachment{
	public FileAttachment() {
		super();
	}

	private String title;

	public String getTitle() {
		return this.title;
	}

	public FileAttachment setTitle(final String title) {
		this.title = title;
		return this;

	}

	private String contentType;

	public String getContentType() {
		return this.contentType;
	}

	public FileAttachment setContentType(final String contentType) {
		this.contentType = contentType;
		return this;

	}

	private Blob content;

	public Blob getContent() {
		return this.content;
	}

	public FileAttachment setContent(final Blob content) {
		this.content = content;
		return this;

	}

	public static FileAttachment create() {
		return new FileAttachment();

	}
}
