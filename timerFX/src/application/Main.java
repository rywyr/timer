package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Font;


/**
 * JavaFXのメインクラス.
 * @author watanabe
 * @version $Revision$, 2018/06/29
 */
@SuppressWarnings("deprecation")
public class Main extends Application {
  
  @SuppressWarnings("static-access")
  @Override
	public void start(Stage primaryStage) {  
    
      Font font = new Font("MS UI Gothic", 32); //フォントを作成 //$NON-NLS-1$
	  
	  Label label = LabelBuilder.create().text(Timer.timer()).prefWidth(2000).font(font).prefHeight(18).alignment(Pos.TOP_CENTER).build(); // ラベルを作成
	  VBox root = VBoxBuilder.create().spacing( 10 ).children(label).build(); //縦方向一列に配置するレイアウト
	  
	  //タイマーイベント
	  Timeline timer = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>(){ // イベント要素であるタイマーを生成
	    @Override
	    public void handle(@SuppressWarnings("unused") ActionEvent event) {
	      label.setText(Timer.timer());
	    }
	  }));
	  timer.setCycleCount(Timeline.INDEFINITE);
	  timer.play();//タイマーを開始
	  
	  
	  
	  try {
	    Scene scene = new Scene(root,500,40); // シーンを作成
		primaryStage = StageBuilder.create().scene(scene).title("timer").build(); //$NON-NLS-1$//ウィンドウに関する設定
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	 //$NON-NLS-1$ // スタイルシートの設定
		primaryStage.setScene(scene); // シーンを設定
		
		primaryStage.show();
	  } catch(Exception e) {
		e.printStackTrace();
	  }
	}
  
    EventHandler<MouseEvent> mouseEventHandler = new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        Object source = e.getSource();
        EventTarget target = e.getTarget();
        // TODO 
      }
    };
	
	/**
	 * メインクラス.
	 * @param args command line
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
