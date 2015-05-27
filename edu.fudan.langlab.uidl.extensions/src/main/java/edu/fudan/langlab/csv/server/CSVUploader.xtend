package edu.fudan.langlab.csv.server

import edu.fudan.langlab.csv.server.mapper.ICSVMapper
import java.io.IOException
import java.io.FileReader
import java.io.BufferedReader
import java.util.Collection
import 	com.uniquesoft.gwt.shared.datatype.File
import com.uniquesoft.gwt.shared.validation.ValidationException
import java.util.Map
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem
import edu.fudan.langlab.csv.shared.CSVValidationException
import static extension com.uniquesoft.gwt.shared.extensions.IterableExtensions2.*
class CSVUploader<T> {
	/*
	 * file.importWith(csvMapper)[onSuccess[]]
	 */
	 
	def static <M> importWith(File f,ICSVMapper<M> csvMapper, (CSVUploader<M>)=>void initializer){
		var uploader = new CSVUploader<M>
		uploader.csvMapper = csvMapper
		initializer.apply(uploader)
		uploader.doUpload(f.fullPathName)
	}

	def static <M> onCommitEach(CSVUploader<M> uploader,(M) => void commitEach){
		uploader.commitEach = commitEach
	}	
	def static <M> onCommitAll(CSVUploader<M> uploader,(Collection<M>) => void commitAll){
		uploader.commitAll = commitAll
	}	
	def static onFailure(CSVUploader<?> uploader, (Map<Integer, Collection<ValidationErrorItem>>) => void failure){
		uploader.failure = failure
	}
	def static <M> onPrecommitValidator(CSVUploader<M> uploader,(Collection<M>, M ,(String,String)=>void) => void precommitValidator){
		uploader.precommitValidator = precommitValidator
	}
	 
	ICSVMapper<T> csvMapper;
	
	(Collection<T>) => void commitAll
	
	(Collection<T>, T ,(String,String)=>void) => void precommitValidator
	
	(T) => void commitEach
	
	(Map<Integer, Collection<ValidationErrorItem>>) => void failure
	
	Map<Integer, Collection<ValidationErrorItem>> errors = newLinkedHashMap();	
	
	def void doUpload(String csvPath) throws IOException{
		var reader = new BufferedReader(new FileReader(csvPath))
		reader.readLine //skip header
		var lineIndex = 1
		var curLine = reader.readLine
		val result = <T>newArrayList
		while(curLine!=null){
			val errorsInThisLine = <ValidationErrorItem>newArrayList
			try{
				result += csvMapper.fromString(curLine)[
					errorsInThisLine.add(it)
				] as T
			}catch(ValidationException e){
				errors.put(lineIndex + 1,e.errors)
			}
			if(errorsInThisLine.size!=0)
				errors.put(lineIndex+1,errorsInThisLine)
			curLine = reader.readLine
			lineIndex = lineIndex + 1;
		}
		if(precommitValidator!=null){
			result.forEachWithIndex[T it,index|
				val errorsInThisLine = <ValidationErrorItem>newArrayList
				precommitValidator.apply(result,it)[key,message|
					errorsInThisLine.add(new ValidationErrorItem(message,key))
				]
				if(errorsInThisLine.size!=0)
					errors.put(index.intValue+1,errorsInThisLine)
			]
		}
		if(errors.size!=0 ){
			if(failure!=null)
				failure.apply(errors)
			else {
				var keyTitleMap = errors.values.flatten.map[keys].flatten.toSet.toInvertedMap[csvMapper.getTitle4Key(it)]
				throw new CSVValidationException(keyTitleMap,errors)
			}
		}else{
			if(commitEach!=null){
				result.forEachWithIndex[T it,index|
					try{
						commitEach.apply(it)
					}catch(ValidationException e){
						errors.put(index.intValue+1,e.errors)
					}
				]
				if(errors.size!=0 ){
					if(failure!=null)
						failure.apply(errors)
					else {
						var keyTitleMap = errors.values.flatten.map[keys].flatten.toSet.toInvertedMap[csvMapper.getTitle4Key(it)]
						throw new CSVValidationException(keyTitleMap,errors)
					}
					
				}
			}
			
//			success.apply(result)
		}
		
		if(errors.size==0 && commitAll!=null) commitAll.apply(result)
	}
}