package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
class ButtonEvent implements EventHandler<ActionEvent>{
	ButtonEvent(Text t,Text t2){
		this.t=t;
		this.t2=t2;
	}
	static Text t;
	static Text t2;
	static int dcount=0;
	static String op1="";
	static String op2="";
	static String operator="";
	static Boolean b=false;
	static Boolean checker=false;
	static double lastResult=0;
	public void handle(ActionEvent e) {
		String s=(((Button)e.getSource()).getText());
		try {
		if(s=="+"||s=="-"||s=="x"||s=="/"||s=="%"||s=="^") {
			checker=false;
			if(op1==""&&s!="-")
				return;
			if(op1.length()==1&&op1=="-") {
				return;
				}
			if(op1==""&&s=="-") {
				op1+=s;
				t.setText(op1+operator+op2);
				return;
			}
			dcount=0;
			b=true;
			operator=s;
			t.setText(op1+operator+op2);
		}else if(s=="AC") {
			b=false;
			dcount=0;
			checker=false;
			op1="";
			op2="";
			operator="";
			t.setText("0.0000");
		}else if(s=="clr") {
			checker=false;
			if(op1=="") {
				return;
			}
			if(b==false) {
				int j=op1.length()-1;
				char arr[]=op1.toCharArray();
				if(arr[j]=='.')
					dcount=0;
				op1="";
				for( int i=0;i<j;i++){
					op1+=arr[i];
				}
			}else if(b==true&& op2=="") {
				operator="";
				b=false;
			}else if(b==true) {
				int j=op2.length()-1;
				char arr[]=op2.toCharArray();
				if(arr[j]=='.')
					dcount=0;
				op2="";
				
				for( int i=0;i<j;i++){
					op2+=arr[i];
			}
				}
			t.setText(op1+operator+op2);
			if(b==false&&op1=="") {
				t.setText("0.0000");
			}
		} else   if(s=="="){
			if(op2==""||op1=="") {
				return;
			}else {
				if(op1.equals("."))
					op1="0";
				 if(op2.equals("."))
					op2="0";
			switch(operator) {
			case "+":
				t.setText(Double.parseDouble(op1)+Double.parseDouble(op2)+"");
				lastResult=Double.parseDouble(op1)+Double.parseDouble(op2);
				break;
			case "-":
				t.setText(Double.parseDouble(op1)-Double.parseDouble(op2)+"");
				lastResult=Double.parseDouble(op1)-Double.parseDouble(op2);
				break;
			case "x":
				t.setText(Double.parseDouble(op1)*Double.parseDouble(op2)+"");
				lastResult=Double.parseDouble(op1)*Double.parseDouble(op2);
				break;
			case "/":
				t.setText(Double.parseDouble(op1)/Double.parseDouble(op2)+"");
				lastResult=Double.parseDouble(op1)/Double.parseDouble(op2);
				break;
			case "%":
				t.setText(Double.parseDouble(op1)%Double.parseDouble(op2)+"");
				lastResult=Double.parseDouble(op1)%Double.parseDouble(op2);
				break;
			case "^":
				t.setText(Math.pow(Double.parseDouble(op1), Double.parseDouble(op2))+"");
				lastResult=Math.pow(Double.parseDouble(op1), Double.parseDouble(op2));
				break;
			}
		}
			op1=t.getText();
			op2="";
			operator="";
			t2.setText("Last Result: "+lastResult);
			b=false;
			checker=true;
		}else {
			if(s=="."&&dcount>=1&&s.length()==1)
				return;
			if(s==".") {
				dcount++;
			}
			
			if(checker==true) {
				op1="";
				checker=false;
			}
			if(b==false) {
			   op1=op1+s; 
			}else {
				op2=op2+s;
			}
			t.setText(op1+operator+op2);
		}
	}catch(Exception e1) {
		t.setText(e1.getMessage());
	}
	}

	
}
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Rectangle r1=new Rectangle(20,20,240,50);
			r1.setFill(Color.WHITE);
			Text t1=new Text();
			t1.setText("0.0000");
			t1.setFill(Color.RED);
			StackPane sp=new StackPane(r1,t1);
			
			Rectangle r2=new Rectangle(20,20,240,50);
			r2.setFill(Color.WHITE);
			Text t2=new Text();
			t2.setText("");
			t2.setFill(Color.RED);
			StackPane sp1=new StackPane(r2,t2);
			
			GridPane gp = new GridPane();
			
			VBox v1=new VBox();
			v1.getChildren().addAll(sp1,sp,gp);
			sp.setPadding(new Insets(30,0,0,10));
			Scene scene = new Scene(v1,400,400);
			
			Button b0=new Button("0");
			Button b1=new Button("1");
			Button b2=new Button("2");
			Button b3=new Button("3");
			Button b4=new Button("4");
			Button b5=new Button("5");
			Button b6=new Button("6");
			Button b7=new Button("7");
			Button b8=new Button("8");
			Button b9=new Button("9");
			Button add=new Button("+");
			Button sub=new Button("-");
			Button div=new Button("/");
			Button mul=new Button("x");
			Button eq=new Button("=");
			Button per=new Button("%");
			Button clr=new Button("clr");
			Button dot=new Button(".");
			Button AC=new Button("AC");
			Button pow=new Button("^");
			b0.setPrefSize(40, 30);
			b1.setPrefSize(40, 30);
			b2.setPrefSize(40, 30);
			b3.setPrefSize(40, 30);
			b4.setPrefSize(40, 30);
			b5.setPrefSize(40, 30);
			b6.setPrefSize(40, 30);
			b7.setPrefSize(40, 30);
			b8.setPrefSize(40, 30);
			b9.setPrefSize(40, 30);
			add.setPrefSize(40, 30);
			sub.setPrefSize(40, 30);
			div.setPrefSize(40, 30);
			mul.setPrefSize(40, 30);
			eq.setPrefSize(40, 30);
			AC.setPrefSize(40, 30);
			pow.setPrefSize(40, 30);
			dot.setPrefSize(40, 30);
			clr.setPrefSize(40, 30);
			per.setPrefSize(40, 30);
			
			gp.add(AC, 0, 0);
			gp.add(b7, 0, 1);
			gp.add(b4, 0, 2);
			gp.add(b1, 0, 3);
			gp.add(dot, 0, 4);
			gp.add(div, 1, 0);
			gp.add(b8, 1, 1);
			gp.add(b5, 1, 2);
			gp.add(b2, 1, 3);
			gp.add(b0, 1, 4);
			gp.add(mul, 2, 0);
			gp.add(b9, 2, 1);
			gp.add(b6, 2, 2);
			gp.add(b3, 2, 3);
			gp.add(per, 2, 4);
			gp.add(clr, 3, 0);
			gp.add(sub, 3, 1);
			gp.add(add, 3, 2);
			gp.add(pow, 3, 3);
			gp.add(eq, 3, 4);
			gp.setHgap(25);
			gp.setVgap(10);
		    b0.setStyle("-fx-background-color: powderblue");
		    AC.setStyle("-fx-background-color: red");
		    clr.setStyle("-fx-background-color: orange");
		    b1.setStyle("-fx-background-color: powderblue");
		    b2.setStyle("-fx-background-color: powderblue");
		    b3.setStyle("-fx-background-color: powderblue");
		    b4.setStyle("-fx-background-color: powderblue");
		    b5.setStyle("-fx-background-color: powderblue");
		    b6.setStyle("-fx-background-color: powderblue");
		    b7.setStyle("-fx-background-color: powderblue");
		    b8.setStyle("-fx-background-color: powderblue");
		    b9.setStyle("-fx-background-color: powderblue");
		    dot.setStyle("-fx-background-color:powderblue");
		    add.setStyle("-fx-background-color:grey");
		    sub.setStyle("-fx-background-color:grey");
		    div.setStyle("-fx-background-color:grey");
		    mul.setStyle("-fx-background-color:grey");
		    pow.setStyle("-fx-background-color:grey");
		    per.setStyle("-fx-background-color:grey");
		    eq.setStyle("-fx-background-color:goldenrod");
		    b0.setOnAction(new ButtonEvent(t1,t2));
		    b1.setOnAction(new ButtonEvent(t1,t2));
		    b2.setOnAction(new ButtonEvent(t1,t2));
		    b3.setOnAction(new ButtonEvent(t1,t2));
		    b4.setOnAction(new ButtonEvent(t1,t2));
		    b5.setOnAction(new ButtonEvent(t1,t2));
		    b6.setOnAction(new ButtonEvent(t1,t2));
		    b7.setOnAction(new ButtonEvent(t1,t2));
		    b8.setOnAction(new ButtonEvent(t1,t2));
		    b9.setOnAction(new ButtonEvent(t1,t2));
		    add.setOnAction(new ButtonEvent(t1,t2));
		    sub.setOnAction(new ButtonEvent(t1,t2));
		    mul.setOnAction(new ButtonEvent(t1,t2));
		    div.setOnAction(new ButtonEvent(t1,t2));
		    per.setOnAction(new ButtonEvent(t1,t2));
		    dot.setOnAction(new ButtonEvent(t1,t2));
		    clr.setOnAction(new ButtonEvent(t1,t2));
		    pow.setOnAction(new ButtonEvent(t1,t2));
		    eq.setOnAction(new ButtonEvent(t1,t2));
		    AC.setOnAction(new ButtonEvent(t1,t2));
			gp.setPadding(new Insets(scene.getHeight()/6,0,5,scene.getHeight()/4.6));
		
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple Calculator");
			primaryStage.setMinWidth(400);
			primaryStage.setMinHeight(400);
			primaryStage.setMaxWidth(600);
			primaryStage.setMaxHeight(600);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
