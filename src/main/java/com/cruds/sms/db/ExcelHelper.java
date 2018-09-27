package com.cruds.sms.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.cruds.sms.entity.Student;



public class ExcelHelper {
	
	public List<Student> addBook(MultipartFile file)
	{
		 List<Student> studentList = new ArrayList<>();
		 try {

	           
	            Workbook workbook = new XSSFWorkbook(file.getInputStream());
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            
	            
	            for(int i=datatypeSheet.getFirstRowNum()+1;i<=datatypeSheet.getLastRowNum();i++){
	            	Student e= new Student();
	                  Row ro=datatypeSheet.getRow(i);
	                  for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
	                      Cell ce = ro.getCell(j);
	                    if(j==0){  
	                        //If you have Header in text It'll throw exception because it won't get NumericValue
	                    	e.setUSN(ce.getStringCellValue());
	                    }
	                    if(j==1){
	                    	e.setName(ce.getStringCellValue());
	                    }
	                    
	                     
	                  }
	                  studentList.add(e);
	              }
	              for(Student emp: studentList){
	                  System.out.println("firstName:"+emp.getUSN() + "lastName:" + emp.getName());
	              }
	           
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    
		return studentList;
		
	}
	

}
