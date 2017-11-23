package controller.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import model.ObjectReferences.*;

public class Quaries {


	
	public static Connection con=null;	
	public static Statement statement=null;
	private static String query=null;
	private static Db_commection db;

	
	
	
	
	public Quaries()
	{
			db=new Db_commection();
		try {
			con=db.GetMySQLConnection();
			statement=con.createStatement();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public Quaries(int num)
	{
		
	}
	

	
	
	
	public Boolean set_Exam_Mark(Obj_db_Course Obj,String tb_Name)
	{
		
		ResultSet rs=null;
		String query1="";
		try{
			System.out.println(!isMark_tb_ExistData(Obj,tb_Name)+"<<<<");
			if(!isMark_tb_ExistData(Obj,tb_Name))
			{
				query1="insert into "+tb_Name+" values('"+Obj.getId()+"','"+Obj.getStuid()+"','-','-','"+Obj.getAceId()+"');";
				statement.executeUpdate(query1);
				System.out.println(query1+">>>>OK");
			}
			
			

				System.out.println("1.....");
				query1="update "+tb_Name+" set Mark='"+Obj.getfMark()+"',Grade='"+Obj.getfGrade()+"' where id='"+Obj.getId()+"' and stuId='"+Obj.getStuid()+"';";
				statement.executeUpdate(query1);
				System.out.println(query1+">>>>>OK");
		
			
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
		return true;
	}
	
	
	public Boolean isMark_tb_ExistData(Obj_db_Course Obj,String tb_Name)
	{
		ResultSet rs=null;
		String query1="";
		try{
			query="select * from "+tb_Name+" where id='"+Obj.getId()+"';";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>>>OK"+(rs.getString(1)==null));
			
		}catch(Exception e)
		{
			
			return false;
		}
		return true;
	}
	
	
	
	public ArrayList<String> get_Table_by_id(String id,String tb_Name)
	{
		ArrayList<String> arl_data=new ArrayList<>();
		ResultSet rs;
		try{
			query="select "+id+" from "+tb_Name+";";
		rs=statement.executeQuery(query);
				while(rs.next())
				{
					arl_data.add(rs.getString("field"));
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	
	
	
	
	
	
	public ArrayList get_ALL_Student_DATA()
	{
		Obj_stu_profile_all ObjMain;
		Obj_stu_profile obj_stu;
		Obj_stu_parent obj_parent;
		Obj_histroy obj_histroy;
		ArrayList<Obj_stu_profile_all> arl_obj=new ArrayList<>();
		
		ResultSet rs;
		try{
			query="select * from  stu_profile_all;";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					obj_stu=new Obj_stu_profile(rs.getString(1),
							rs.getString(4),
							rs.getString(3),
							rs.getString(2),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getString(9),
							rs.getString(10),
							rs.getString(11),
							rs.getString(12),
							rs.getString(13),
							rs.getString(14),
							rs.getString(15),
							rs.getString(16),
							rs.getString(17));
					
					obj_parent=new Obj_stu_parent(rs.getString(3),
							rs.getString(18),
							rs.getString(19),
							rs.getString(20),
							rs.getString(21),
							rs.getString(22),
							rs.getString(23));
					
					obj_histroy=new Obj_histroy(rs.getString(4),
							 rs.getString(24),
							 rs.getString(25),
							 rs.getString(26),
							 rs.getString(27),
							 rs.getString(28),
							 rs.getString(29),
							 rs.getString(30),
							 rs.getString(31),
							 rs.getString(32),
							 rs.getString(33),
							 rs.getString(34)
							 );
				
					 ObjMain=new Obj_stu_profile_all(obj_parent,obj_stu,obj_histroy);
					 arl_obj.add(ObjMain);
					
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		return arl_obj;
	}
	
	
	
	
	
	
	public HashMap get_Student_IdAndName_by_CourrentCouseId(String Courseid,String year,String major)
	{
		HashMap<String,String> arl_data=new HashMap<>();
		ResultSet rs;
		try{
			query="select stuId,name from Stu_profile where CurrentCourseId='"+Courseid+"' and CurrentYear='"+year+"' and CurrentMajor='"+major+"';";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					arl_data.put(rs.getString(2),rs.getString(1));
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	
	public HashMap get_Student_IdAndName_all()
	{
		HashMap<String,String> arl_data=new HashMap<>();
		ResultSet rs;
		try{
			query="select stuId,name from Stu_profile;";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					arl_data.put(rs.getString(2),rs.getString(1));
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	public HashMap get_Student_obj_by_year_and_major(String year,String major)
	{
		HashMap<String,String> arl_data=new HashMap<>();
		ResultSet rs;
		try{
			query="select stuId,name from Stu_profile where CurrentYear='"+year+"' and CurrentMajor='"+major+"';";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					arl_data.put(rs.getString(1),rs.getString(2));
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	
	public HashMap get_Student_obj_by_year_and_major1(String year,String major)
	{
		HashMap<String,String> arl_data=new HashMap<>();
		ResultSet rs;
		try{
			query="select stuId,name from Stu_profile where CurrentYear='"+year+"' and CurrentMajor='"+major+"';";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					arl_data.put(rs.getString(2),rs.getString(1));
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	
	public ArrayList<Obj_db_Course> get_Create_CourseDATA(String tbName)
	{
		ArrayList<Obj_db_Course> arl_data=new ArrayList<>();
		ResultSet rs;
		try{
			query="select * from "+tbName+";" ;
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					Obj_db_Course objTemp=new Obj_db_Course(rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)
							);
					arl_data.add(objTemp);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	
	
	public ArrayList<String> get_Student_ID_ALL(String year,String major)
	{
		ArrayList<String> arl_data=new ArrayList<>();
		ResultSet rs;
		try{
			query="select stuId from Stu_profile where CurrentYear='"+year+"' and CurrentMajor='"+major+"';";
			rs=statement.executeQuery(query);
			System.out.println(query+">>>Ok");
				while(rs.next())
				{
					arl_data.add(rs.getString(1));
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return arl_data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList get_Course_Data()
	{
		ArrayList<Obj_db_Course_profile> arl_Course=new ArrayList<>();
		ResultSet rs = null;
		try {

			String query="Select * from Course_tb;";
			rs=statement.executeQuery(query);
			
			
			while(rs.next())
			{
				Obj_db_Course_profile course=new Obj_db_Course_profile(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				arl_Course.add(course);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return arl_Course;
	}
	
	
	
	
	
	
	public String get_Course_Mark(String stuId,String ACEid,String tbName)
	{
		String CourseMark=null;
		ResultSet rs = null;
		try {

			String query="Select Mark from "+tbName+"  where stuId='"+stuId+"' ;";
			rs=statement.executeQuery(query);
			
			System.out.println(query+"<<<OK");
			while(rs.next())
			{
				
				CourseMark=(rs.getString(1));
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return CourseMark;
	}
	
	
	public Obj_db_Course_profile get_Course_Data(String couserId)
	{
		Obj_db_Course_profile return_Course=null;
		ResultSet rs = null;
		try {

			String query="Select * from Course_tb where CourseId='"+couserId+"';";
			rs=statement.executeQuery(query);
			
			
			while(rs.next())
			{
				Obj_db_Course_profile course=new Obj_db_Course_profile(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				return_Course=(course);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return return_Course;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Obj_Result_View_tb getExam_Mark(ArrayList<String> tb_Names,String ACE_id,String stuId)
	{
		Obj_Result_View_tb arlMarks=null;
		
			String queryNew="";
			
			queryNew="Select "+tb_Names.get(0)+".stuId,"
							+tb_Names.get(0)+".Mark,"
							+ tb_Names.get(1)+".Mark,"
							+ tb_Names.get(2)+".Mark,"
							+ tb_Names.get(3)+".Mark,"
							+ tb_Names.get(4)+".Mark,"
							+ tb_Names.get(5)+".Mark from "+tb_Names.get(0)+","
															+tb_Names.get(1)+","
															+tb_Names.get(2)+","
															+tb_Names.get(3)+","
															+tb_Names.get(4)+","
															+tb_Names.get(5)+" where "+tb_Names.get(0)+".Ace_id='"+ACE_id+"' and "
																							+tb_Names.get(5)+".stuId='"+stuId+"';";
																																												
																														
																	
			System.out.println(queryNew+">>>>>OK");
			ResultSet rs = null;
			try {

				rs=statement.executeQuery(queryNew);
				int count=0;
				
				while(rs.next())
				{
					Obj_Result_View_tb obj=new Obj_Result_View_tb(
							rs.getString(1),
							"-",
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							"-");
					
					arlMarks=(obj);
				}
				
				} catch (SQLException e)
				{
				System.out.println(e.getMessage());
				e.printStackTrace();	
				}
			
			
			return arlMarks;
															
							
		
	}
	
	
	
	public Obj_Result_View_tb getExam_Mark1(ArrayList<String> tb_Names,String ACE_id,String stuId)
	{
		Obj_Result_View_tb arlMarks=null;
		
			String queryNew="";
			
			queryNew="Select "+tb_Names.get(0)+".stuId,"
							+tb_Names.get(0)+".Mark,"
							+ tb_Names.get(1)+".Mark,"
							+ tb_Names.get(2)+".Mark,"
							+ tb_Names.get(3)+".Mark,"
							+ tb_Names.get(4)+".Mark,"
							+ tb_Names.get(5)+".Mark from "+tb_Names.get(0)+","
															+tb_Names.get(1)+","
															+tb_Names.get(2)+","
															+tb_Names.get(3)+","
															+tb_Names.get(4)+","
															+tb_Names.get(5)+" where "+tb_Names.get(0)+".Ace_id='"+ACE_id+"' and "
																																		+tb_Names.get(0)+".stuId='"+stuId+"' and "
																																		+tb_Names.get(1)+".stuId='"+stuId+"' and "
																																		+tb_Names.get(2)+".stuId='"+stuId+"' and "
																																		+tb_Names.get(3)+".stuId='"+stuId+"' and "
																																		+tb_Names.get(4)+".stuId='"+stuId+"' and "
																																		+tb_Names.get(5)+".stuId='"+stuId+"';";
																																												
																														
																	
			System.out.println(queryNew+">>>>>OK");
			ResultSet rs = null;
			try {

				rs=statement.executeQuery(queryNew);
				int count=0;
				
				while(rs.next())
				{
					Obj_Result_View_tb obj=new Obj_Result_View_tb(
							rs.getString(1),
							"-",
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							"-");
					
					arlMarks=(obj);
				}
				
				} catch (SQLException e)
				{
				System.out.println(e.getMessage());
				e.printStackTrace();	
				}
			
			
			return arlMarks;
															
							
		
	}
	
	
	
	
	public ArrayList get_Define_Course_Data()
	{
		ArrayList<Obj_db_Define_Course> arl_Course=new ArrayList<>();
		ResultSet rs = null;
		try {

			String query="Select * from AcedimicCoures_tb;";
			rs=statement.executeQuery(query);
			
			
			while(rs.next())
			{
				Obj_db_Define_Course dfcourse=new Obj_db_Define_Course(
						rs.getString(1),
						rs.getString(4),
						rs.getString(2),
						rs.getString(3),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				arl_Course.add(dfcourse);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return arl_Course;
	}
	
	
	
	
	public ArrayList get_Define_Course_Data(String year,String major,String ACEyear,String isMarkFill)
	{
		ArrayList<Obj_db_Define_Course> arl_Course=new ArrayList<>();
		ResultSet rs = null;
		try {

			String query="Select * from AcedimicCoures_tb where foryear='"+year+"' and major='"+major+"' and acedimic_year='"+ACEyear+"' and isMarkFill='"+isMarkFill+"';";
			rs=statement.executeQuery(query);
			System.out.println(query);
			
			while(rs.next())
			{
				Obj_db_Define_Course dfcourse=new Obj_db_Define_Course(
						rs.getString(1),
						rs.getString(4),
						rs.getString(2),
						rs.getString(3),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				arl_Course.add(dfcourse);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return arl_Course;
	}
	
	
	
	public Obj_db_Define_Course get_Define_Course_Data(String ACE_id)
	{
		Obj_db_Define_Course arl_Course=null;
		ResultSet rs = null;
		try {

			String query="Select * from AcedimicCoures_tb where AcedimicId='"+ACE_id+"';";
			rs=statement.executeQuery(query);
			
			
			while(rs.next())
			{
				Obj_db_Define_Course dfcourse=new Obj_db_Define_Course(
						rs.getString(1),
						rs.getString(4),
						rs.getString(2),
						rs.getString(3),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				arl_Course =(dfcourse);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return arl_Course;
	}
	
	
	
	
	
	
	public ArrayList<Obj_db_Define_Course> get_AceCourse_by_year(String year)
	{
		ArrayList<Obj_db_Define_Course> arl_Course=new ArrayList<>();
		ResultSet rs = null;
		try {

			String query="Select * from AcedimicCoures_tb where foryear='"+year+"';";
			rs=statement.executeQuery(query);
			
			
			while(rs.next())
			{
				Obj_db_Define_Course dfcourse=new Obj_db_Define_Course(
						rs.getString(1),
						rs.getString(4),
						rs.getString(2),
						rs.getString(3),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				arl_Course.add(dfcourse);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return arl_Course;
	}
	
	
	
	public Obj_db_Define_Course get_AceCourse_by_id(String id)
	{
		Obj_db_Define_Course arl_Course=null;
		ResultSet rs = null;
		try {

			System.out.println(query+">>>>>>OK");
			
			String query="Select * from AcedimicCoures_tb where AcedimicId='"+id+"';";
			rs=statement.executeQuery(query);
			
			while(rs.next())
			{
				Obj_db_Define_Course dfcourse=new Obj_db_Define_Course(
						rs.getString(1),
						rs.getString(4),
						rs.getString(2),
						rs.getString(3),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
				arl_Course=(dfcourse);
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return arl_Course;
	}
	
	
	
	public Obj_histroy get_History_Data(String key)
	{
		Obj_histroy obj=null;
		ResultSet rs = null;
		try {

			String query="Select * from History_tb where historyId='"+key+"';";
			rs=statement.executeQuery(query);
			
			
			while(rs.next())
			{
				 obj=new Obj_histroy(rs.getString(1),
						rs.getString(2),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11));
			}
			
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			}
		
		
		
		return obj;
	}
	
	
	
	
	private boolean isCourse_tb(String tbName) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean set_Table_by_Name(String tb_Name,ArrayList<String> data,String index_id)
	{
		try {
			
			query="insert into "+tb_Name+" values ('"+index_id+"'";
				 String query_part1="";
				 for(int i=data.size()-1;i>=0;i--)
					 {
						 query_part1=",'"+data.get(i)+"'"+query_part1;
					 }
				 query=query+query_part1+") ;";
				 System.out.println("query "+query);
			 	 statement.executeUpdate(query);
			 		
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			return false;
			}
		return true;
	}
	
	
	

	
	
	public String getPrimaryKey(String field,String table,String prefix)
	{
		ResultSet rs=SQLSelect(field, table);
		int current;
		try{
			
			java.util.ArrayList result=new java.util.ArrayList();
			
			while(rs.next())
			{
				result.add(rs.getString(field));
			}
		
			
			if(result.size()>0)
			{
				current=Integer.parseInt(result.get(result.size()-1).toString().substring(4,11))+1;
			
				if(current>0&& current<=9)
				{
					return prefix+"000000"+current;
				}else if(current>9&&current<=99)
				{
					return prefix+"00000"+current;
				}else if(current>99&&current<=999)
				{
					return prefix+"0000"+current;
				}
				else if(current>999&&current<9999)
				{
					return prefix+"000"+current;
				}
				else if(current>9999&&current<99999)
				{
					return prefix+"00"+current;
				}
				else if(current>99999&&current<999999)
				{
					return prefix+"0"+current;
				}else if(current>999999&&current<9999999)
				{
					return prefix+current;
				}
				
				
				
			}
		}catch(SQLException ex)
		{
			
		}
		return prefix+"0000001";
	}
	
	
	
	
	
	
	public ResultSet SQLSelect(String field,String table)
	{
		ResultSet rs=null;
		try{
			rs=statement.executeQuery("SELECT "+field+" FROM  "+table);
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return rs;
	}
	
	
	
	
	

	
	public boolean AddNewStudent(Obj_histroy ObjH,Obj_stu_parent ObjP,Obj_stu_profile ObjS)
	{
		try {
			
			
			ObjS.setStuId_s(getPrimaryKey("stuid","Stu_profile","STU-"));
			ObjS.setAboutid_s(getPrimaryKey("AboutId","Stu_about","ABO-"));
			ObjP.setParentid(getPrimaryKey("ParentId","Parent_tb","PAR-"));
			ObjH.setId_s(getPrimaryKey("historyId","History_tb","HIS-"));
			
			
			ObjS.setParentId_s(ObjP.getParentid());
			ObjS.setHistoryId_s(ObjH.getId_s());
			
			String query4="Insert into Stu_about Values('"+ObjS.getAboutid_s()+"', '"+ObjS.getStuId_s()+"', '"+ObjS.getParentId_s()+"', '"+ObjS.getHistoryId_s()+"');";
			String query3="Insert into History_tb Values('"+ObjH.getId_s()+"', '"+ObjH.getRollRecord_s()+"', '"+ObjH.getFirstyear1_s()+"','"+ObjH.getFirstyear2_s()+"', '"+ObjH.getSecondyear1_s()+"', '"+ObjH.getSecondyear2_s()+"', '"+ObjH.getThirdyear1_s()+"', '"+ObjH.getThirdyear2_s()+"', '"+ObjH.getFourthyear1_s()+"', '"+ObjH.getFourthyear2_s()+"', '"+ObjH.getFinal1_s()+"', '"+ObjH.getRepeatorId_s()+"');";
			String query2="Insert into Parent_tb Values('"+ObjP.getParentid()+"', '"+ObjP.getFather_name()+"', '"+ObjP.getFather_nrc()+"', '"+ObjP.getMother_name()+"', '"+ObjP.getMother_nrc()+"', '"+ObjP.getParent_address()+"', '"+ObjP.getParent_phno()+"');";
			String query1="Insert into Stu_Profile Values('"+ObjS.getStuId_s()+"', '"+ObjS.getStuName_s()+"', '"+ObjS.getBirthDate_s()+"', '"+ObjS.getGender_s()+"', '"+ObjS.getCurrentCourseId_s()+"', '"+ObjS.getCurrentRoll_s()+"', '"+ObjS.getAddress_s()+"', '"+ObjS.getNrc_s()+"', '"+ObjS.getYear_s()+"','"+ObjS.getMajor_s()+"','"+ObjS.getEmail_s()+"','"+ObjS.getPhno_s()+"','"+ObjS.getStartDate_s()+"','"+ObjS.getImgName_s()+"');";
			 	 
			
			
			
			
			statement.executeUpdate(query1);
			System.out.println(query1+">>OK");
			
			statement.executeUpdate(query2);
			System.out.println(query2+">>OK");
			
			statement.executeUpdate(query3);
			System.out.println(query3+">>OK");
			
			statement.executeUpdate(query4);
			System.out.println(query4+">>OK"); 		
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			return false;
			}
		return true;
	}
	
	public boolean AddNewCourse(Obj_db_Course_profile obj)
	{
		try {
			String query2="Insert into Course_tb Values('"+obj.getCourseId()+"', '"+obj.getName()+"', '"+obj.getDate()+"', '"+obj.getRefName()+"', '"+obj.getTrName()+"', '"+obj.getAim()+"', '"+obj.getForYear()+"');";
			String query1="CREATE TABLE `stu_result`.`"+obj.getRefName()+"` ("
					+ "`id` VARCHAR(100) NOT NULL,"
					+ "`stuId` VARCHAR(100) NULL,"
					+ "`Mark` VARCHAR(100) NULL,"
					+ "`Grade` VARCHAR(100) NULL,"
					+ "`Ace_id` VARCHAR(100) NULL,"
					+ "PRIMARY KEY (`id`));";
			 	 
			
			
			
			
			statement.executeUpdate(query1);
			System.out.println(query1+">>OK");
			
			statement.executeUpdate(query2);
			System.out.println(query2+">>OK");
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			return false;
			}
		return true;
	}
	
	

	public boolean DefineNewCourse(Obj_db_Define_Course obj)
	{
		try {
			String query="Insert into AcedimicCoures_tb Values('"+obj.getId()+"', '"+obj.getTerm()+"', '"+obj.getCourseId()+"', '"+obj.getForyear()+" ','"+obj.getMajor()+"','"+obj.getAcedimic_year()+"','"+obj.getIsMarkFill()+"');";
			
			
			statement.executeUpdate(query);
			System.out.println(query+">>OK");
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			return false;
			}
		return true;
	}
	
	
	
	
	public boolean Add_Transcript_tb(Obj_transcript obj)
	{
		try {
			String query="Insert into transcript_tb Values('"+obj.getTrnId()+"', '"+obj.getSutId()+"', '"+obj.getCount()+"');";
			
			
			statement.executeUpdate(query);
			System.out.println(query+">>OK");
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			e.printStackTrace();	
			return false;
			}
		return true;
	}
	
	
	
	
	
	
	
	
	public String getUserId(String user,String pass)
	{
		String returnStr="0";
		try {
			String query="Select userid from User_tb where userName='"+user+"' and password='"+pass+"';";
			ResultSet rs;
			
			rs=statement.executeQuery(query);
			System.out.println(query+">>OK");
			while(rs.next())
			returnStr=rs.getString(1);
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			//e.printStackTrace();	
			return returnStr;
			}
		return returnStr;
		
	}
	

	public String getUserNameAndPass()
	{
		String returnStr="";
		try {
			String query="Select password from User_tb ;";
			ResultSet rs;
			
			rs=statement.executeQuery(query);
			System.out.println(query+">>OK");
			while(rs.next())
			returnStr=(rs.getString(1));
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			//e.printStackTrace();	
			return returnStr;
			}
		return returnStr;
		
	}
	
	
	public void ChangeUserNameAndPass(String userName,String Pass)
	{
		ArrayList<String> returnStr=new ArrayList();
		try {
			String query="update User_tb set userName='"+userName+"', password='"+Pass+"' where userid='1' ;";
			ResultSet rs;
			
			statement.executeUpdate(query);
			System.out.println(query+">>OK");
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			//e.printStackTrace();	
			}
	
		
	}

	

	public ArrayList<Integer> getGetMainBarChartData_f_value(ArrayList<Integer> arlfirst_value_barchart) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public String getStudent_Transcript_Count(String stuId) {

		String Count="";
		try {
			String query="Select count from  transcript_tb where  stuId='"+stuId+"';";
			ResultSet rs;
			
			rs=statement.executeQuery(query);
			System.out.println(query+">>OK");
			while(rs.next())
				Count=(rs.getString(1));
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			//e.printStackTrace();	
			}
		
		
		return Count;
	}
	
	public void UpdateStudent_Transcript_Count(String stuId,String count) {

		String Count="";
		try {
			String query="update transcript_tb set count='"+count+"'where  stuId='"+stuId+"';";
			ResultSet rs;
			
			statement.executeUpdate(query);
			System.out.println(query+">>OK");
			
				
			} catch (SQLException e)
			{
			System.out.println(e.getMessage());
			//e.printStackTrace();	
			}
		
	
	}
	
	
}
