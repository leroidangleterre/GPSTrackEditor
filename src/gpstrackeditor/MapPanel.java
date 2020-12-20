package gpstrackeditor;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Display visual information about a list of coordinates.
 *
 * @author arthu
 */
public class MapPanel extends JPanel {

    private GPSTrack track;
    private int HEIGHT = 1000, WIDTH = 800;

    public MapPanel(GPSTrack t) {
        track = t;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("MapPanel.repaint()");
        track.paint(g);
    }
}
