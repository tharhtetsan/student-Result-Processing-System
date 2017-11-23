package PDF_tamplates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pdf_test.Item;
import model.ObjectReferences.*;
public class Result_Generate {

	   public static void main(String[] args) throws FileNotFoundException {
	        try {
	            /* User home directory location */
	            String userHomeDirectory = System.getProperty("user.home");
	            /* Output file location */
	            String outputFile = userHomeDirectory + File.separatorChar + "Documents/Result_generate.pdf";

	            /* List to hold Items */
	            List<Obj_resultGenerate_marks> listItems = new ArrayList<Obj_resultGenerate_marks>();

	          
	            Obj_resultGenerate_marks obj1=new Obj_resultGenerate_marks();
	            obj1.setNo("1");
	            obj1.setSub("Introducation to java programming");
	            obj1.setMark("70");
	            obj1.setGrade("B");
	            obj1.setRemark("Distinction");
	            
	            

	            Obj_resultGenerate_marks obj2=new Obj_resultGenerate_marks();
	            obj2.setNo("2");
	            obj2.setSub("Database Management System");
	            obj2.setMark("80");
	            obj2.setGrade("B");
	            obj2.setRemark("Distinction");
	            
	            
	            

	            Obj_resultGenerate_marks obj3=new Obj_resultGenerate_marks();
	            obj3.setNo("3");
	            obj3.setSub("Math");
	            obj3.setMark("70");
	            obj3.setGrade("B");
	            obj3.setRemark("-");
	            
	            
	            

	            Obj_resultGenerate_marks obj4=new Obj_resultGenerate_marks();
	            obj4.setNo("4");
	            obj4.setSub("English");
	            obj4.setMark("58");
	            obj4.setGrade("C");
	            obj4.setRemark("-");
	            
	            

	            Obj_resultGenerate_marks obj5=new Obj_resultGenerate_marks();
	            obj5.setNo("5");
	            obj5.setSub("Modeling Calculation");
	            obj5.setMark("70");
	            obj5.setGrade("B");
	            obj5.setRemark("-");
	            
	            

	            Obj_resultGenerate_marks obj6=new Obj_resultGenerate_marks();
	            obj6.setNo("6");
	            obj6.setSub("Computer NetWork");
	            obj6.setMark("70");
	            obj6.setGrade("B");
	            obj6.setRemark("-");
	            
	            
	            Obj_resultGenerate_marks obj7=new Obj_resultGenerate_marks();
	            obj7.setNo("");
	            obj7.setSub("TOTAL");
	            obj7.setMark("450");
	            obj7.setGrade("");
	            obj7.setRemark("");
	            
	            	            
	            listItems.add(obj1);
	            listItems.add(obj2);
	            listItems.add(obj3);
	            listItems.add(obj4);
	            listItems.add(obj5);
	            listItems.add(obj6);
	            listItems.add(obj7);
	            
	            
	   
	            /* Convert List to JRBeanCollectionDataSource */
	            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

	            /* Map to hold Jasper report Parameters */
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("Result_Generate1", itemsJRBean);

	            
	            parameters.put("stu_StudentName",new String("gggk"));

	            /* Using compiled version(.jasper) of Jasper report to generate PDF */
	            JasperPrint jasperPrint = JasperFillManager.fillReport("/Users/tharhtetsan/Documents/workspace/java/student_Result_processing/src/PDF_tamplates/Result_Generate_Tamplate.jasper", parameters, new JREmptyDataSource());

	            /* outputStream to create PDF */
	            OutputStream outputStream = new FileOutputStream(new File(outputFile));
	            /* Write content to PDF file */
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

	            
	 
	            System.out.println("File Generated");
	        } catch (JRException ex) {
	            ex.printStackTrace();
	        }
	    }
}
