/*
Christian Upschulte
16094590
10/16/17
HCS5405HW07
Circles.java
*/

package code;

import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Circles extends Application {
	Pane pane1 = new Pane();
	Pane pane2 = new Pane();
	Pane pane3 = new Pane();
	Pane pane4 = new Pane();
	Pane root = new Pane();
	Scene scene;
	Stage stage;

	public void start(Stage stage){
		root = createFrontPage();
		createInputField();
		scene = new Scene(root, 700, 600, Color.GRAY);
		stage.setTitle("Circles DEMO");
		stage.setScene(scene);
		stage.show();
	}

	Text t1, t2, t3, t4, t5, t6, t7, t8, t9, circlelab;
	Button button1, button2, button3, button4;
	Label inputlabel, labelboth, same, distance;
	TextField circleinput;

	
	public Pane createFrontPage(){

		t1 = new Text(10, 80, "Demonstration of Assignment 7 for\nJava, GUI and Visualization: CS5405");
        t1.setFont(new Font(20));
        t1.setFill(Color.RED);
        t1.setWrappingWidth(500);
        t1.setTextAlignment(TextAlignment.CENTER);
       
        t2 = new Text(10, 120, "\nPresented by\n\nChristian Upschulte \n\ncjutmc@mst.edu\n");
        t2.setFont(new Font(20));
        t2.setFill(Color.GREEN);
        t2.setWrappingWidth(500);
        t2.setTextAlignment(TextAlignment.CENTER);

        t3 = new Text(10, 80,
                      "  This is extension of HW06, but adding four buttons(Author, Problem, Reference, CirclesDemo)\n\n Ensure the outut contains 8 samples, one for each of the 8 cases. \n\n Use Labels or Text components to annotata. \n\n Partial Java code is given. No Late work will be graded\n ");
        t3.setFill(Color.BLUE);
        t3.setWrappingWidth(600);
        t3.setTextAlignment(TextAlignment.JUSTIFY);

        t4 = new Text(10, 140, "This is my orignal code, No IDE used in the submission. \n I did not give my code to anyone \nI did not use anyone's code in this work");
        t4.setFont(new Font(20));
        t4.setFill(Color.RED);
        t4.setWrappingWidth(500);
        t4.setTextAlignment(TextAlignment.CENTER);

        t5 = new Text(10, 180, "\n\n\nLink: https://mst.instructure.com/courses/21035/assignments/65553");
        t5.setFont(new Font(20));
        t5.setFill(Color.GREEN);
        t5.setWrappingWidth(500);
        t5.setTextAlignment(TextAlignment.CENTER);

        pane1.getChildren().addAll(t1, t2);
        pane2.getChildren().addAll(t3);
        pane3.getChildren().addAll(t4, t5);

        pane1.setLayoutX(10);pane1.setLayoutY(50);
        pane2.setLayoutX(10);pane2.setLayoutY(50);
        pane3.setLayoutX(10);pane3.setLayoutY(50);
        pane4.setLayoutX(250);pane4.setLayoutY(200);

        button1 =  new Button("Author");
        button2 =  new Button("Problem");
        button3 =  new Button("References");
        button4 =  new Button("CirclesDemo");
        
        button1.setLayoutX(100);button1.setLayoutY(20);
        button2.setLayoutX(250);button2.setLayoutY(20);
        button3.setLayoutX(400);button3.setLayoutY(20);
        button4.setLayoutX(550);button4.setLayoutY(20);

        root.getChildren().addAll(pane1);
        root.getChildren().addAll(button1,button2,button3,button4);

        button1.setOnAction(ae->
                            {root.getChildren().removeAll(pane1,pane2,pane3,pane4);root.getChildren().add(pane1);});
       
        button2.setOnAction(ae->
                            {root.getChildren().removeAll(pane1,pane2,pane3,pane4);root.getChildren().add(pane2);});
        
        button3.setOnAction(ae->
                            {root.getChildren().removeAll(pane1,pane2,pane3,pane4);root.getChildren().add(pane3);});
       
        button4.setOnAction(ae->
                            {root.getChildren().removeAll(pane1,pane2,pane3,pane4);root.getChildren().add(pane4);});

        return root;
	}

	public void createInputField (){
		//Create input field
		circlelab = new Text(10, 80, "Input x1, y1, r1, x2, y2,");
		circleinput = new TextField();
		circleinput.setOnAction(new TextFieldHandler()); 
		labelboth = new Label("");
     	same = new Label("");
	 	distance = new Label("");
		pane4.getChildren().addAll(circlelab, circleinput, labelboth, same, distance);
	}

	public class TextFieldHandler implements EventHandler<ActionEvent>{        
		public void handle( ActionEvent e){        
			String str = circleinput.getText();;//Initialize Readables
			String[] tokens;
			int x1=0;  
            int y1=0; 
			int r1=0; 
			int x2=0; 
			int y2=0;
			int r2=0;
			double d, left;
			labelboth.setText(str);
			circleinput.setText("");//Clear field
			tokens = str.split(" ");
			
			x1 = Integer.parseInt(tokens[0]);
			y1 = Integer.parseInt(tokens[1]);
			r1 = Integer.parseInt(tokens[2]);
			x2 = Integer.parseInt(tokens[3]);
			y2 = Integer.parseInt(tokens[4]);
			r2 = Integer.parseInt(tokens[5]);
			pane4.getChildren().clear();
			createCircle1(x1+100, y1+100, r1); //Output to stage
			createCircle2(x2+100, y2+100, r2); //Adding 100 so the output looks cleaner
            testCircles(x1, y1, r1, x2, y2, r2);
		}    
	}
    
    public Circle createCircle1(float x, float y, float r){
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(r);
        circle.setStroke(Color.CYAN);
        circle.setFill(Color.CYAN);
        pane4.getChildren().addAll(circle);
        return circle;
    }

    public Circle createCircle2(float x, float y, float r){
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(r);
        circle.setStroke(Color.RED);
        circle.setFill(Color.RED);
        pane4.getChildren().addAll(circle);
        return circle;
    }

    public void testCircles(int x1, int y1, int r1, int x2, int y2, int r2){
        Text text = new Text(100, 100, " Welcome ");
        double left = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        double right = (r1+r2)*(r1+r2);
        double d = Math.sqrt(left);
        
        if (d > r1+r2){
            text = new Text(100, 100, " DC disjoint not connected ");
                    }
        else if(d == r1+r2){
            text = new Text(100, 100, " EC outside each other, touching each other, externally connected ");      
        }
        else if (d==0 && r1==r2){
            text = new Text(100, 100, " EQ equal in all respects");
        }
        else if (d <= Math.abs(r1-r2)){
            if(r1>r2){
                if (d < r1-r2){
                    text = new Text(100, 100, " NTPP circle1 is inside circle 2 and NOT touching circle 2, non-tangential proper part ");
                }
                else if(d == Math.abs(r2-r1)){
                    text = new Text(100, 100, " TPP circle1 is inside circle 2 and touching circle 2, tangential proper part ");
                }
            }
            else{
                if (d < r2-r1){
                    text = new Text(100, 100, " NTPPc circle2 is inside circle 1 and NOT touching circle 1, non-tangential proper part ");
                }
                else if (d == Math.abs(r2-r1)){
                    text = new Text(100, 100, " TPPc circle2 is inside circle 1 and touching circle 1, tangential proper part ");
                }
            }
        }
        else if (left<right){
            text = new Text(100, 100, " PO proper overlap each contains partially inside and partially outside of the other  ");
        }
        pane4.getChildren().addAll(text);  
    }

	 public static void main(String[] args) {
        Application.launch(args);
    }
}

