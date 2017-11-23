package view.UI_relatives;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;


public class TableSelectionComboxtableCell<MyTableRowList, Object> extends TableCell<MyTableRowList, Object>{
	
		private CheckBox cb=new CheckBox();
		private CheckBox Headercombox;
		
		public CheckBox getCb() {
			return cb;
		}

		public void setCb(CheckBox cb) {
			this.cb = cb;
		}

		public void checkBoxAction(){
			 (( MyTableRow ) getTableView().getItems().get( getIndex())).setSelected(cb.isSelected());
			  int i;
			  for(i=0;i<getTableView().getItems().size();i++)
			  {
				  MyTableRow ii=  (( MyTableRow ) getTableView().getItems().get( i));
				
				if(ii.isSelected()==false)
					break;
			}
			 if(getTableView().getItems().size()==0)
				 Headercombox.setSelected(false);
			if(i<getTableView().getItems().size())
				Headercombox.setSelected(false);
			else
				Headercombox.setSelected(true);
			  getTableView().refresh();
			  getTableView().requestFocus();
			  getTableView().getSelectionModel().select(getIndex());
		  	 getTableView().getFocusModel().focus(getIndex());
		
			}
		
		
		public TableSelectionComboxtableCell(CheckBox Headercombox)
		{
			this.Headercombox=Headercombox;
			 cb.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						checkBoxAction();
					}
				});
		}
		
		@Override
		public void startEdit() {
	
			
			  if ( !isEmpty() )
	            {
	                super.startEdit();
	               
	             
	                setText( null );
	                setGraphic( cb );
	             
	            }
		}
		
	
		@Override
        public void updateItem( Object i, boolean empty )
        {
			 super.updateItem(i, empty);
			
			 
			if (i == null || empty) {
				setText(null);
				setStyle("");
				
				 

			} else {
					if(i instanceof java.lang.Boolean)
					{	
						java.lang.Boolean bb=(java.lang.Boolean)i;
						if(bb.booleanValue()==true)
						{
							setStyle("-fx-background-color:Yellow");
							cb.setTextFill(Color.BLUE);
							
						}
					
						cb.setText(getIndex()+1+"");
						cb.setSelected(bb);
					
						setGraphic(null);
						setGraphic(cb);
					
			
					}
			
				
				
			}
        }

	
	}

	

	

