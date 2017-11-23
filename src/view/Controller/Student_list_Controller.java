package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.ObjectReferences.*;
import view.UI_relatives.*;
import controller.DB.*;
public class Student_list_Controller implements Initializable{

    @FXML
    private TableView<Obj_stu_profile> tb_view1;

    @FXML
    private TableColumn<Obj_stu_profile,String> ID_1;

    @FXML
    private TableColumn<Obj_stu_profile,String> Name_1;

    @FXML
    private TableColumn<Obj_stu_profile,String> Gender_1;

    @FXML
    private TableColumn<Obj_stu_profile,String> Nrc_1;

    @FXML
    private TableColumn<Obj_stu_profile,String> year_1;

    @FXML
    private TableColumn<Obj_stu_profile,String> major_1;

    @FXML
    private TableColumn<Obj_stu_profile,String> roll_1;

   

    @FXML
    private TableColumn<Obj_stu_profile,String> address_1;

    @FXML
    private TableView<Obj_stu_profile> tb_view11;

    @FXML
    private TableColumn<Obj_stu_profile,String> ID_11;

    @FXML
    private TableColumn<Obj_stu_profile,String> Name_11;

    @FXML
    private TableColumn<Obj_stu_profile,String> Gender_11;

    @FXML
    private TableColumn<Obj_stu_profile,String> Nrc_11;

    @FXML
    private TableColumn<Obj_stu_profile,String> year_11;

    @FXML
    private TableColumn<Obj_stu_profile,String> major_11;

    @FXML
    private TableColumn<Obj_stu_profile,String> roll_11;


    @FXML
    private TableColumn<Obj_stu_profile,String> address_11;

    @FXML
    private TableView<Obj_stu_profile> tb_view12;

    @FXML
    private TableColumn<Obj_stu_profile,String> ID_12;

    @FXML
    private TableColumn<Obj_stu_profile,String> Name_12;

    @FXML
    private TableColumn<Obj_stu_profile,String> Gender_12;

    @FXML
    private TableColumn<Obj_stu_profile,String> Nrc_12;

    @FXML
    private TableColumn<Obj_stu_profile,String> year_12;

    @FXML
    private TableColumn<Obj_stu_profile,String> major_12;

    @FXML
    private TableColumn<Obj_stu_profile,String> roll_12;

   

    @FXML
    private TableColumn<Obj_stu_profile,String> address_12;

    @FXML
    private TableView<Obj_stu_profile> tb_view13;

    @FXML
    private TableColumn<Obj_stu_profile,String> ID_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> Name_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> Gender_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> Nrc_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> year_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> major_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> roll_13;

    @FXML
    private TableColumn<Obj_stu_profile,String> address_13;

    @FXML
    private TableView<Obj_stu_profile> tb_view14;

    @FXML
    private TableColumn<Obj_stu_profile,String> ID_14;

    @FXML
    private TableColumn<Obj_stu_profile,String> Name_14;

    @FXML
    private TableColumn<Obj_stu_profile,String> Gender_14;

    @FXML
    private TableColumn<Obj_stu_profile,String> Nrc_14;

    @FXML
    private TableColumn<Obj_stu_profile,String> year_14;

    @FXML
    private TableColumn<Obj_stu_profile,String> major_14;

    @FXML
    private TableColumn<Obj_stu_profile,String> roll_14;

  
    @FXML
    private TableColumn<Obj_stu_profile,String> address_14;
    
    
    
    private ObservableList<Obj_stu_profile> items1 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_profile> items2 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_profile> items3 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_profile> items4 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_profile> items5 = FXCollections.observableArrayList();
  
    private Quaries db;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		db=new Quaries(1);
		Intialize_Cols();
		tb_view1.setItems(items1);
		tb_view11.setItems(items2);
		tb_view12.setItems(items3);
		tb_view13.setItems(items4);
		tb_view14.setItems(items5);
		
		ArrayList<Obj_stu_profile_all> arlDATA_all=db.get_ALL_Student_DATA();
		
		for(Obj_stu_profile_all Obj : arlDATA_all )
		{
			if(Obj.getStu().getYear_s().equalsIgnoreCase("First Year"))
			{
				Settb1_data(Obj.getStu());
			}
			else if(Obj.getStu().getYear_s().equalsIgnoreCase("Second Year"))
			{
				Settb2_data(Obj.getStu());
			}
			else if(Obj.getStu().getYear_s().equalsIgnoreCase("Third Year"))
			{
				Settb3_data(Obj.getStu());
			}
			else if(Obj.getStu().getYear_s().equalsIgnoreCase("Fourth Year"))
			{
				Settb4_data(Obj.getStu());
			}
			else 
			{
				Settb5_data(Obj.getStu());
			}
			
		}
	
	}
    
	

	
	
	
	public void Settb1_data(Obj_stu_profile obj)
	{
		items1.add(obj);
	}
	public void Settb2_data(Obj_stu_profile obj)
	{
		items2.add(obj);
	}
	public void Settb3_data(Obj_stu_profile obj)
	{
		items3.add(obj);
	}
	public void Settb4_data(Obj_stu_profile obj)
	{
		items4.add(obj);
	}
	public void Settb5_data(Obj_stu_profile obj)
	{
		items5.add(obj);
	}
	
	
	
	
	public void  Intialize_Cols()
	{
			//first year tb repare;
				ID_1.setCellValueFactory(cellData -> cellData.getValue().getId());
				Name_1.setCellValueFactory(cellData -> cellData.getValue().getStuName());
				Gender_1.setCellValueFactory(cellData -> cellData.getValue().getGender());
				Nrc_1.setCellValueFactory(cellData -> cellData.getValue().getNrc());
				year_1.setCellValueFactory(cellData -> cellData.getValue().getYear());
				major_1.setCellValueFactory(cellData -> cellData.getValue().getMajor());
				roll_1.setCellValueFactory(cellData -> cellData.getValue().getCurrentRoll());
				address_1.setCellValueFactory(cellData -> cellData.getValue().getAddress());
				
				//Second year tb repare;
				ID_11.setCellValueFactory(cellData -> cellData.getValue().getId());
				Name_11.setCellValueFactory(cellData -> cellData.getValue().getStuName());
				Gender_11.setCellValueFactory(cellData -> cellData.getValue().getGender());
				Nrc_11.setCellValueFactory(cellData -> cellData.getValue().getNrc());
				year_11.setCellValueFactory(cellData -> cellData.getValue().getYear());
				major_11.setCellValueFactory(cellData -> cellData.getValue().getMajor());
				roll_11.setCellValueFactory(cellData -> cellData.getValue().getCurrentRoll());
				address_11.setCellValueFactory(cellData -> cellData.getValue().getAddress());
				
				//Third year tb repare;
				ID_12.setCellValueFactory(cellData -> cellData.getValue().getId());
				Name_12.setCellValueFactory(cellData -> cellData.getValue().getStuName());
				Gender_12.setCellValueFactory(cellData -> cellData.getValue().getGender());
				Nrc_12.setCellValueFactory(cellData -> cellData.getValue().getNrc());
				year_12.setCellValueFactory(cellData -> cellData.getValue().getYear());
				major_12.setCellValueFactory(cellData -> cellData.getValue().getMajor());
				roll_12.setCellValueFactory(cellData -> cellData.getValue().getCurrentRoll());
				address_12.setCellValueFactory(cellData -> cellData.getValue().getAddress());
				
				
				//fourth year tb repare;
				ID_13.setCellValueFactory(cellData -> cellData.getValue().getId());
				Name_13.setCellValueFactory(cellData -> cellData.getValue().getStuName());
				Gender_13.setCellValueFactory(cellData -> cellData.getValue().getGender());
				Nrc_13.setCellValueFactory(cellData -> cellData.getValue().getNrc());
				year_13.setCellValueFactory(cellData -> cellData.getValue().getYear());
				major_13.setCellValueFactory(cellData -> cellData.getValue().getMajor());
				roll_13.setCellValueFactory(cellData -> cellData.getValue().getCurrentRoll());
				address_13.setCellValueFactory(cellData -> cellData.getValue().getAddress());
				
				
				//final year tb repare;
				ID_14.setCellValueFactory(cellData -> cellData.getValue().getId());
				Name_14.setCellValueFactory(cellData -> cellData.getValue().getStuName());
				Gender_14.setCellValueFactory(cellData -> cellData.getValue().getGender());
				Nrc_14.setCellValueFactory(cellData -> cellData.getValue().getNrc());
				year_14.setCellValueFactory(cellData -> cellData.getValue().getYear());
				major_14.setCellValueFactory(cellData -> cellData.getValue().getMajor());
				roll_14.setCellValueFactory(cellData -> cellData.getValue().getCurrentRoll());
				address_14.setCellValueFactory(cellData -> cellData.getValue().getAddress());
				
	}
	
    
}
