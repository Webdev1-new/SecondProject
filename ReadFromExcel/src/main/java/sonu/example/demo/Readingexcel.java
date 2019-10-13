package sonu.example.demo;
/*import java.io.FileInputStream;
import java.io.FileOutputStream;*/

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Readingexcel {
	/*private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;
	private static Workbook wb;*/
	@Autowired
	ValidatingService serviced;
	
	@ResponseBody
	@RequestMapping(value="/getrow",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> DataRead(@RequestBody UserDetail detail) 
	{
		
		/*fis=new FileInputStream("./practice.xlsx");
		wb= WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		int noOfRows=sh.getLastRowNum();
		System.out.println(noOfRows);
		System.out.println(sh.getRow(1).getCell(0)+" "+sh.getRow(1).getCell(1));
		return noOfRows;*/
		try
		{
		String value=serviced.ValidateUser(detail);
		if(value.equals("Succesful"))
		{
			return new ResponseEntity<String>("you are succesfully logged",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Sorry please provide correct details",HttpStatus.OK);
		}
		
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Sorry please provide correct details",HttpStatus.OK);
		}
		
		
	}

}
