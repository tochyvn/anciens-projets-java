package navigator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdesktop.jdic.browser.WebBrowser;
 
/**
 * Afficher un Webbrowser dans un JFrame
 * http://www.fobec.com/java/971/integrer-navigateur-internet-jframe.html	
 * @author fobec 2010
 */
public class WebBrowserFrame {
 
    public static void main(String[] args) {
        WebBrowser webbrowser = new WebBrowser();
        URL url = null;
        try {
            url = new URL("http://www.google.fr/");
        } catch (MalformedURLException ex) {
        	//Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        webbrowser.setURL(url);
        webbrowser.setSize(400, 300);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocation(200, 200);
        frame.add(webbrowser);
        webbrowser.setVisible(true);
        frame.setVisible(true);
    }
}