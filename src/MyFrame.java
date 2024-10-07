import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeformat;
    SimpleDateFormat dateformat;
    SimpleDateFormat dayformat;

    JLabel timelabel;
    JLabel daylabel;
    JLabel datelabel;

    String time;
    String day;
    String date;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 300);
        this.setLayout(new GridLayout(3, 0));
        this.setTitle("Clock");
        this.setResizable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        timeformat = new SimpleDateFormat("hh:mm:ss a");
        dayformat = new SimpleDateFormat("E");
        dateformat = new SimpleDateFormat("MMMMM dd, yyyy");

        timelabel = new JLabel();
        daylabel = new JLabel();
        datelabel = new JLabel();

        timelabel.setHorizontalAlignment(JLabel.CENTER);
        daylabel.setHorizontalAlignment(JLabel.CENTER);
        datelabel.setHorizontalAlignment(JLabel.CENTER);

        timelabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        daylabel.setFont(new Font("Verdana", Font.BOLD, 35));
        datelabel.setFont(new Font("Verdana", Font.ITALIC, 35));

        this.add(timelabel);
        this.add(daylabel);
        this.add(datelabel);
        this.setVisible(true);

        setTime();
    }
    public void setTime(){
        while(true){
            time = timeformat.format(Calendar.getInstance().getTime());
            day = dayformat.format(Calendar.getInstance().getTime());
            date = dateformat.format(Calendar.getInstance().getTime());

            timelabel.setText(time);
            daylabel.setText(day);
            datelabel.setText(date);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
