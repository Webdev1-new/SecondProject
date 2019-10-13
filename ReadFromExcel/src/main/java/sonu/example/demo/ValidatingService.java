package sonu.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidatingService {
	private static Workbook wb;
	private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;
	public String ValidateUser(UserDetail detail) throws Exception
	{
		fis=new FileInputStream("./practice.xlsx");
		wb= WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		int noOfRows=sh.getLastRowNum();
		System.out.println(noOfRows);
		System.out.println(detail.getUsername()+" "+detail.getPassword());
		for(int i=1;i<=noOfRows;i++)
		{
			String read=String.valueOf(sh.getRow(i).getCell(0));
			String read1=String.valueOf(sh.getRow(i).getCell(1));
			System.out.println(read+" "+read1);
			if(read.equals(detail.getUsername()) && read1.equals(detail.getPassword()))
			{
				return "Succesful";
				
			}
			
		}
		
		
			return "unsucessful";
		
	}

}
