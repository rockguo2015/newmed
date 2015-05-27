package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.datatype.File;

public class FileValueProviderFactory {
	public static class FileUploaderValueProvider implements
	IValueProvider<File> {

		private GWTFormItem formItem;
		FileUpload fileUpload;
		private String uploadFilePath = "";
		private String uploadFileName = "";
		FileUploaderValueProvider(String id, final String title){
			fileUpload = new FileUpload();
			fileUpload.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					uploadFileName = fileUpload.getFilename();
					uploadFilePath = fileUpload.getName();
				}
			});
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return fileUpload;
				}

			};
						
		}
		@Override
		public IValueViewer<File> setValue(File value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		@Override
		public File getValue() {
			File file = new File();
			file.setFullPathName(uploadFilePath);
			file.setFileName(uploadFileName);
			return file;
		}

		@Override
		public void addValueChangedListener(ValueChangedListener<File> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@WidgetProvider(isDefault=true)
	public FileUploaderValueProvider createAsFileItem(String id, String title) {
		return new FileUploaderValueProvider(id, title);
	}
}