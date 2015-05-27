package edu.fudan.langlab.gxt.client.component.form.factory;

import gwtupload.client.IFileInput.FileInputType;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.IUploader.ServerMessage;
import gwtupload.client.MultiUploader;
import gwtupload.client.SingleUploader;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.datatype.File;

public class FileValueProviderFactory {

	public static class FileItem implements IValueProvider<File> {

		private MultiUploader uploaderField = new MultiUploader(
				FileInputType.ANCHOR);
		private FieldLabel fieldLabel;
		private File file = new File();
		private String title;

		public FileItem(String id, String title) {
			this.title = title;
			uploaderField.setServletPath(GWT.getModuleBaseURL()
					+ "service/fileUploader");
			uploaderField.setMaximumFiles(1);
			uploaderField.reset();

			uploaderField
					.addOnFinishUploadHandler(new OnFinishUploaderHandler() {

						@Override
						public void onFinish(IUploader uploader) {
							file.setFullPathName(uploader.getServerMessage()
									.getMessage());
							file.setFileName(uploaderField.getFileInput()
									.getFilenames().iterator().next());
							file.setContentType(uploader.getServerInfo().ctype);
							System.out.println("===1>"+uploader.getServerMessage().getMessage());
							System.out.println("===2>"+uploader.getServerMessage().getUploadedFieldNames());
						}
					});

		}

		@Override
		public IValueViewer<File> setValue(File value) {
			file = value;
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			if (fieldLabel == null) {
				AdapterField<File> field = new AdapterField<File>(uploaderField) {

					@Override
					public void setValue(File value) {
						FileItem.this.setValue(value);
					}

					@Override
					public File getValue() {
						return FileItem.this.getValue();
					}

				};
				fieldLabel = new FieldLabel(field, title);
			}
			return fieldLabel;
		}

		@Override
		public File getValue() {
			return file;
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<File> listener) {
			uploaderField
					.addOnFinishUploadHandler(new OnFinishUploaderHandler() {
						@Override
						public void onFinish(IUploader uploader) {
							listener.onValueChanged(file);

						}
					});
		}
	}

	@WidgetProvider(isDefault = true)
	public FileItem createAsFileItem(String id, String title) {
		return new FileItem(id, title);
	}

	public static class FileAutoCommitItem implements IValueProvider<File> {

		private SingleUploader uploaderField = new SingleUploader(
				FileInputType.ANCHOR) {
			public void setServerMessage(ServerMessage msg) {
				super.setServerMessage(msg);
			}

		};
		private FieldLabel fieldLabel;
		private File file = new File();
		private String title;

		public FileAutoCommitItem(String id, String title) {
			this.title = title;
			uploaderField.setServletPath(GWT.getModuleBaseURL()
					+ "service/fileUploader");
			uploaderField.setAutoSubmit(true);
			uploaderField.reset();

			uploaderField
					.addOnFinishUploadHandler(new OnFinishUploaderHandler() {

						@Override
						public void onFinish(IUploader uploader) {
							file.setFullPathName(uploader.getServerMessage()
									.getMessage());
							uploaderField.reuse();
							uploaderField.reset();
						}
					});

		}

		@Override
		public IValueViewer<File> setValue(File value) {
			file = value;
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			if (fieldLabel == null) {
				AdapterField<File> field = new AdapterField<File>(uploaderField) {

					@Override
					public void setValue(File value) {
						FileAutoCommitItem.this.setValue(value);
					}

					@Override
					public File getValue() {
						return FileAutoCommitItem.this.getValue();
					}

				};
				fieldLabel = new FieldLabel(field, title);
			}
			return fieldLabel;
		}

		@Override
		public File getValue() {
			return file;
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<File> listener) {
			uploaderField
					.addOnFinishUploadHandler(new OnFinishUploaderHandler() {
						@Override
						public void onFinish(IUploader uploader) {
							listener.onValueChanged(file);

						}
					});
		}
	}

	public FileAutoCommitItem createAsAutoCommitFileItem(String id, String title) {
		return new FileAutoCommitItem(id, title);
	}

}
