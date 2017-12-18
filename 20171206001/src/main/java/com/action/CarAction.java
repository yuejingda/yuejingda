package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.domain.Car;
import com.service.ICarService;

@Controller
public class CarAction {
	@Autowired
	private ICarService service;
	
	@RequestMapping("/upload.do")
	public void upload(MultipartFile excl ) throws Exception{
		System.out.println("---------------------------");
		Workbook book =  WorkbookFactory.create(excl.getInputStream());
		Sheet sheet = book.cloneSheet(0);
		List<Car> cars = new ArrayList<>();
		for(int i=1;i<=sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			Cell c3 = row.getCell(2);
			Cell c4 = row.getCell(3);
			
			int cno = (int) c1.getNumericCellValue();
			String cname = c2.getStringCellValue();
			String color = c3.getStringCellValue();
			int price = (int) c4.getNumericCellValue();
			
			Car car = new Car(cno,cname,color,price);
			cars.add(car);
		}
		service.save(cars);
		
	}
}
