package com.uniquesoft.uidl.servlet;

import gwtupload.server.exceptions.UploadActionException;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

//import gwtupload.server.UploadAction;

public class FileUploader extends UploadAction {

	private static final long serialVersionUID = -9126810158619099138L;

	@Override
	public String executeAction(HttpServletRequest request,
			List<FileItem> sessionFiles) throws UploadActionException {
		String response = "";
		for (FileItem item : sessionFiles) {
			if (!item.isFormField()) {
				try {
					File file = File.createTempFile("upload-", null);
					item.write(file);

					response += file.getAbsolutePath();
				} catch (UploadActionException e) {
					throw e;
				} catch (Exception e) {
					throw new UploadActionException(
							"Sorry, an error occured when trying to save the file.");
				}
			}
		}
		removeSessionFileItems(request);

		return response;
	}
}
