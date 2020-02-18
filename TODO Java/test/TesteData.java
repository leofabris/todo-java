
import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leofabris
 */
public class TesteData {
    
    public static void main(String[] args) {
        
        Date hoje = new Date();
        JCalendar jcal = new JCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Hoje: " + sdf.format(jcal.getDate()));
        
        
    }
    
}
