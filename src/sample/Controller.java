package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToggleGroup lang;
    @FXML
    private RadioButton en;
    @FXML
    private RadioButton ar;
    @FXML
    private TextField searchTxt;
    @FXML
    private TextArea resArea;
    @FXML
    private Label resuL;

    private String userStr = "";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchTxt.setOnKeyReleased(e -> {
            userStr = searchTxt.getText().trim();
            if (userStr == "") {
                resArea.setText("");
            }
            if (e.getCode().isLetterKey() || e.getCode() == KeyCode.BACK_SPACE) {
            resArea.setText("");
            
            try {
            	DictionaryDataSets serchCLS = new DictionaryDataSets();
                int x = 0;
                ArrayList returnedArr = serchCLS.splittingSearch(userStr);
                if (returnedArr.size() ==0) {}
                else if (userStr.length()==0) {}
                else if (returnedArr.size()>150) {
                for (int i = 0; i < 150/*returnedArr.size()*/; i++) {
                    resArea.setText(resArea.getText() + "\n" + returnedArr.get(i).toString());
                    x = i;
                    resuL.setText("Total : " + returnedArr.size() + " Words Results Showed :" + x + " Words ");
                }
                }
                else {
                	 for (int i = 0; i < returnedArr.size(); i++) {
                         resArea.setText(resArea.getText() + "\n" + returnedArr.get(i).toString());
                         x = i;
                         resuL.setText("Total : " + returnedArr.size() + " Words Results Showed :" + x + " Words ");
                     }
                }
            } catch (Exception exp) {
                //exp.printStackTrace();
            }
            }
        });
    }
}
