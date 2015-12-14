/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import javafx.scene.image.ImageView;


/**
 *
 * @author Tom Scholten
 */
public class F1Screen {

    //private LuggageUI UI;
    //private DatabaseManager db;
    //public GridPane view = new GridPane();
    //private final int MAX_LINE_COUNT = 150;

    //private static final user.Session USER = user.Session.getInstance();

    public F1Screen() {
        
        
        
        /****************** TOMS GEDEELTE ****************************\
        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Help");

        LuggageForm form = new LuggageForm(UI);

        Label heading = UI.createHeading("Help");
        form.add(heading);
        form.addRow();

        String role = "employee";

        if (USER.getUser().getManager() != 0) {
            role = "manager";
        }

        if (USER.getUser().getAdmin() != 0) {
            role = "admin";
        }

        BufferedReader br = new BufferedReader(new FileReader(role + "Instructions.txt"));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

//        while ((line = br.readLine()) != null) {
//            boolean repeat = true;
//            while (repeat) {
//                int count = 0;
//                if (line.length() > MAX_LINE_COUNT * (count + 1)) {
//                    String tempLine = line.substring(count * MAX_LINE_COUNT, MAX_LINE_COUNT * (count + 1));
//                    repeat = (tempLine.length() == MAX_LINE_COUNT);
//                    count++;
//                    form.addLabel(tempLine);
//                    form.addRow();
//                } else {
//                    form.addLabel(line);
//                    form.addRow();
//                    repeat = false;
//                }
//            }
//        }

        view.add(form.toNode(), 1, 2);

        UI.setCenter(view);
        UI.setLeft(null);
        \******************************* EINDE ********************************/
    }
    
    public ImageView getImage(String page){
        ImageView image;
        switch( page ){
            case "SearchLuggage":
                image = new ImageView("file:files/images/help/SearchLuggage.png");
               break;
            default:
                image = new ImageView("file:files/images//help/default.png");
               break;
        }
        return image;
    }
}
