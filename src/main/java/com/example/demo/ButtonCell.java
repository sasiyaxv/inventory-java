package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

public class ButtonCell extends TableCell<Record, Boolean> {
    final Button cellButton = new Button("Remove");

    ButtonCell(final TableView tblView){

//        cellButton.setOnAction(new EventHandler<ActionEvent>(){
//
//            @Override
//            public void handle(ActionEvent t) {
//                int selectedIndex = getTableRow().getIndex();
//                BillOfMaterial toRemove = (BillOfMaterial) tblView.getItems().get(selectedIndex);
//                tempBoM.remove(toRemove);
//                prepareBoMTable();
//            }
//        });
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty){
            setGraphic(cellButton);
        }
    }
}
