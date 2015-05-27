package edu.fudan.langlab.uidl.domain.app.server.service.converter;

import org.springframework.stereotype.Component;

import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.uidl.transform.IConverter;

import edu.fudan.langlab.domain.common.FileStorage;

@Component
public class FIleConverter implements IConverter<File,FileStorage>{

	@Override
	public boolean isAppliable(Class<?> from, Class<?> to) {
		return File.class.isAssignableFrom(from)
				&& FileStorage.class.isAssignableFrom(to);
	}

	@Override
	public FileStorage toValue(Class<FileStorage> targetType, File value) {
	
		return null;
	}

}
