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

import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.Author;
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
	
	
	public List<Book> helper(MultipartFile file)
	{
	
		
		 List<Book> book1 = new ArrayList<Book>();
	
        try {

           
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet datatypeSheet = workbook.getSheetAt(0);
            
            
            Row ro = null;
            
            List<Book> book = new ArrayList<Book>();
            
            for(int i=datatypeSheet.getFirstRowNum()+1;i<=datatypeSheet.getLastRowNum();i++){
            	Book e= new Book();
            	
            	  List<Author> author = new ArrayList<Author>();
                   ro=datatypeSheet.getRow(i);
                  for(int j=ro.getFirstCellNum();j<=2;j++){
                      Cell ce = ro.getCell(j);
                    if(j==0){  
                        //If you have Header in text It'll throw exception because it won't get NumericValue
                    	e.setTitle(ce.getStringCellValue());
                    }
                    else if(j==1){
                    	e.setCategory(ce.getStringCellValue());
                    }
                    else if(j==2)
                    {
                    	e.setNoOfCopies((int) ce.getNumericCellValue());
                    }
                    
                  }
                  Author a = new Author();
                    for(int j=3;j<ro.getLastCellNum();j++)
                    {
                    	
                    	 Cell ce = ro.getCell(j);
                    	
                    	 System.out.println(ro.getLastCellNum());
                    	if(j%2==0 )
                    	{
                    		
                    		a.setAuthorName(ce.getStringCellValue());
                    		
                    	}
                    	else 
                    	{
                    		a.setMailID(ce.getStringCellValue());
                    	}
                    	
                    	
                    	if(a.getAuthorName()!=null && a.getMailID()!=null)
                    	{
                    		
                    		author.add(a);
                    		a = new Author();
                    	}
                    	
                    }
                  
                  e.setAuthors(author);
                  book.add(e);
                  book1=book;
                  
              }
           
//              for(Book b1: book){
//                  System.out.println(b1);
//              }
              workbook.close();
              
           
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
	
	
	return book1;
	}
	

}
