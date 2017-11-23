package controller.fileReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import model.ObjectReferences.*;

public class ExcelReadWrite {

	private static FileInputStream Excel_file;
	Workbook workbook=null;
	
		public ExcelReadWrite(String fileName)
		{
			try {
				Excel_file=new FileInputStream(fileName);
				workbook=WorkbookFactory.create(Excel_file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		public ExcelReadWrite(File fileName)
		{
			try {
				Excel_file=new FileInputStream(fileName);
				workbook=WorkbookFactory.create(Excel_file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
		
		
		
		
		public ArrayList<String> getExcelCol_header(int rowIndex)
		{
			ArrayList<String> arl_ExcelRowl=new ArrayList<>();
			Sheet sheet=workbook.getSheetAt(0);
			
			        for (int a=1;a<=rowIndex;a++)
			        {
			        	Row row=sheet.getRow(a);
			        	Cell cell=row.getCell(0);	 
			        		 String income="'";
			        		 String sdtr=(cell.getCellTypeEnum()+"").trim();
			        		 switch (sdtr) 
			        		 {
				        		 	case "NUMERIC": income=cell.getNumericCellValue()+"";
				        		 							break;
				        		 		case "BOOLEAN": income=cell.getBooleanCellValue()+"";
															break;
				        		 		case "STRING": income=cell.getStringCellValue()+"";
				        		 							break;
				        		 		case "DATE": income=cell.getDateCellValue()+"";
				        		 							break;
				        		 		default:
				        		 			income=cell.getStringCellValue()+"";
				        		 			break;
			        		 	}
			            	arl_ExcelRowl.add(income);
			        	}
				
			return arl_ExcelRowl;
		}
		
		
		public ArrayList<ExcelData> getExcelRow_header(int colIndex)
		{
			ArrayList<ExcelData> arl_ExcelCol=new ArrayList<>();
			
			Sheet sheet=workbook.getSheetAt(0);
			        	Row row=sheet.getRow(0);
			        	for(int a=0;a<=colIndex;a++)
			        	{
			        		
			        		Cell cell=row.getCell(a);	 
			        		 String income="'";
			        		 String sdtr=(cell.getCellTypeEnum()+"").trim();
			        		 switch (sdtr) 
			        		 {
				        		 	case "NUMERIC": income=cell.getNumericCellValue()+"";
				        		 							break;
				        		 		case "BOOLEAN": income=cell.getBooleanCellValue()+"";
															break;
				        		 		case "STRING": income=cell.getStringCellValue()+"";
				        		 							break;
				        		 		case "DATE": income=cell.getDateCellValue()+"";
				        		 							break;
				        		 		default:
				        		 			income=cell.getStringCellValue()+"";
				        		 			break;
			        		 	}
			        		 String value=income.trim();
			            	arl_ExcelCol.add(new ExcelData("", "", value, cell.getAddress()+""));
			        	}
				
			return arl_ExcelCol;
		}
		
		
		
		
		public ArrayList<ExcelData> ReadExecleFileDataString(int rowIndex,int colIndex)
		{
				ArrayList<ExcelData> arl_execel_read=new ArrayList<>();
				ArrayList<String> arl_ExcelRow=new ArrayList<>();
				ArrayList<String> arl_ExcelCol=new ArrayList<>();
				arl_ExcelCol=getExcelCol_header(colIndex);
				//arl_ExcelRow=getExcelRow_header(rowIndex);
				
				Sheet sheet=workbook.getSheetAt(0);
				
					    for (int a=1;a<rowIndex;a++)
				        {
					    	Row row=sheet.getRow(a);
				        	for (int b=1;b<colIndex;b++) 
				        	 { 		 
				        		Cell cell=row.getCell(b);
				        		String realAddress=cell.getAddress()+"";
				        		
				        		 String income="'";
				        		 String sdtr=(cell.getCellTypeEnum()+"").trim();
				        		 switch (sdtr) 
				        		 {
					        		 	case "NUMERIC": income=cell.getNumericCellValue()+"";
					        		 							break;
					        		 		case "BOOLEAN": income=cell.getBooleanCellValue()+"";
																break;
					        		 		case "STRING": income=cell.getStringCellValue()+"";
					        		 							break;
					        		 		case "DATE": income=cell.getDateCellValue()+"";
					        		 							break;
									default:
										income=cell.getStringCellValue()+"";
										break;
				        		 	}
				        		 arl_execel_read.add(new ExcelData(arl_ExcelCol.get(b),arl_ExcelRow.get(a),income, realAddress));
				        	 }
				        	
				        }
				    
				return arl_execel_read;
		}
		
		
		
		
		

		public boolean Excel_file_write(String excel_file_name,Object [][]income_data)
		{
					String newFileName=excel_file_name+".xlsx";
					int rowCount=0;
					try {
						XSSFWorkbook workbook = new XSSFWorkbook();
						 XSSFSheet sheet= workbook.createSheet(excel_file_name);
				         sheet.protectSheet("ths");
						 CellStyle unLockedCellStyle=workbook.createCellStyle();
				         CellStyle LockedCellStyle=workbook.createCellStyle();
					     unLockedCellStyle.setLocked(false);
				         LockedCellStyle.setLocked(true);
				         
						 for (int a=0;a< income_data.length;a++) 
						 {
						        Row row = sheet.createRow(rowCount++);
					            	int columnCount = 0;
					            	Object  []arr_temp=income_data[a];
					            	//read all cell in a row 
					            	for (int b=0;b<arr_temp.length;b++) 
					            	{
					            		Cell cell = row.createCell(columnCount++);
					            		if (arr_temp[b] instanceof String) 
					            		{
					            			cell.setCellValue((String) arr_temp[b]);
					            		}
					            		else if (arr_temp[b] instanceof Integer) 
					                	{
					                		cell.setCellValue((Integer) arr_temp[b]);
					                	}
					                
					                	if(!(a==0 ||b==0))
					                		cell.setCellStyle(unLockedCellStyle);
					            		
					            		}
					        }
						 
						FileOutputStream outputFile=new FileOutputStream(newFileName);
						workbook.write(outputFile);
						
					} catch (EncryptedDocumentException e) 
					{
						e.printStackTrace();
					} catch (IOException e) 
					{
						e.printStackTrace();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
					return true;
		}
		
		
		public boolean Excel_key_write(String excel_file_name,ArrayList<String> col_key,ArrayList<String> header_key)
		{
			String newFileName=excel_file_name+".xlsx";
					int rowCount=1;
					try {

				        XSSFWorkbook workbook = new XSSFWorkbook();
						 XSSFSheet sheet= workbook.createSheet(excel_file_name);
				         sheet.protectSheet("ths");
						  
				         /*
				          * add data to column key to excel file
				          */
						 for (int a=0;a<col_key.size();a++) {
							   Row row = sheet.createRow(rowCount++);
					           /*
					            * define first columns as column key 
					            */
							   Cell cell=row.createCell(0);
					            cell.setCellValue(col_key.get(a));
					        }
						 
						 int columnCount = 1;
						 for (int b=0;b<header_key.size();b++) {
							 /*
							  * define first row as header keys
							  */
							 Row row = sheet.createRow(0);
				                Cell cell = row.createCell(columnCount++);
				                   	cell.setCellValue(header_key.get(b));
				                } 
						 
						 FileOutputStream outputFile=new FileOutputStream(newFileName);
						 workbook.write(outputFile);
						
					} catch (EncryptedDocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					return true;
		}
		
		
		
		public ArrayList<String> Get_excel_headerAddress(int total_num)
		{
							ArrayList<String> Cell_address=new ArrayList<>();
							
							ArrayList<String> keys=new ArrayList<>();
							keys.add("A");
							keys.add("B");
							keys.add("C");
							keys.add("D");
							keys.add("E");
							keys.add("F");
							keys.add("G");
							keys.add("H");
							keys.add("I");
							keys.add("J");
							keys.add("K");
							keys.add("L");
							keys.add("M");
							keys.add("N");
							keys.add("O");
							keys.add("P");
							keys.add("Q");
							keys.add("R");
							keys.add("S");
							keys.add("T");
							keys.add("U");
							keys.add("V");
							keys.add("W");
							keys.add("X");
							keys.add("Y");
							keys.add("Z");
							
				System.out.println(keys.size());
				
				for(int i=0;i<total_num;i++)
				{
					String addressName="";
					
					int index=i;
					if(index>=keys.size())
					{
					
						int quotient=(int)index/keys.size();
						int remainder=(int) Math.ceil(index%keys.size());
						String temp="";
						System.out.println(remainder);
						/*
						 * fist row is define as header 
						 */
						for(int a=0;a<quotient;a++)
						{
							temp+="A";
						}
						temp+=keys.get(remainder);
						addressName=temp+"0";
					}
					else
					{
						addressName=keys.get(index)+"0";
					}
					Cell_address.add(addressName);
					
					}
				
				return Cell_address;
		}
		
		
		
		
		
		
		
		public ArrayList<String> Get_excel_column(int total_num)
		{
			ArrayList<String> columns_index=new ArrayList<>();
			for(int i=0;i<total_num;i++)
			{
				columns_index.add("A"+i);
			}
			return columns_index;
		}
		
		
		
	

		
		public ArrayList<ExcelData_row_col> ReadExcel_by_Col_index(int colIndex)
		{
				ArrayList<ExcelData_row_col> arl_ExcelAll=new ArrayList<>();
				DataFormatter objDefaultFormat= new DataFormatter();
				FormulaEvaluator objFormulaEvaluator=new XSSFFormulaEvaluator((XSSFWorkbook)workbook);
				Sheet sheet=workbook.getSheetAt(0);
					    for (int a=1;a<sheet.getLastRowNum();a++)
				        {

							Row row=sheet.getRow(a);
					    	ArrayList<ExcelData> arl_temp=new ArrayList<>();
							for (int i=0;i<colIndex;i++)
				        	 { 		 
								Cell cell=row.getCell(i);
							objFormulaEvaluator.evaluate(cell);
				        		 String income=objDefaultFormat.formatCellValue(cell,objFormulaEvaluator);
				        		
				        		 String value=income;
				        		// System.out.println(i+"<<"+a);
				        		 arl_temp.add(new ExcelData("", "", income, cell.getAddress()+""));
				        	 }
				        	arl_ExcelAll.add(new ExcelData_row_col(arl_temp));
				        }
				    
				return arl_ExcelAll;
				
				
		}
		

		public ArrayList<ExcelData_row_col> ReadExcel_by_Row_index(int rowIndex)
		{
				ArrayList<ExcelData_row_col> arl_ExcelAll=new ArrayList<>();
				for (Sheet sheet : workbook ) 
				{
					    for (Row row: sheet)
				        {
					    	ArrayList<ExcelData> arl_temp=new ArrayList<>();
							for (Cell cell: row) 
				        	 { 		 
				        		String realAddress=cell.getAddress()+"";
				        		
				        		 String income="'";
				        		 String sdtr=(cell.getCellTypeEnum()+"").trim();
				        		 switch (sdtr) 
				        		 {
					        		 	case "NUMERIC": income=cell.getNumericCellValue()+"";
					        		 							break;
					        		 		case "BOOLEAN": income=cell.getBooleanCellValue()+"";
																break;
					        		 		case "STRING": income=cell.getStringCellValue()+"";
					        		 							break;
					        		 		case "DATE": income=cell.getDateCellValue()+"";
					        		 							break;
									default:
										income=cell.getStringCellValue()+"";
										break;
				        		 	}
				        		 String value=income+"".trim();
				        		 arl_temp.add(new ExcelData("", "", value, cell.getAddress()+""));
				        	 }
				        	arl_ExcelAll.add(new ExcelData_row_col(arl_temp));
				        }
				    }
				return arl_ExcelAll;
		}
		
	
}


