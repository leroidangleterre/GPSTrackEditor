package gpstrackeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author arthu
 */
public class GPSTrack {

    private ArrayList<Marker> markerList;

    public GPSTrack(String filename) {
        markerList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));

            String line;
            while ((line = reader.readLine()) != null) {
                line = replace(line, ',', '.');
//                System.out.println("line: <" + line + ">");
                String tab[] = line.split(";");
                double longitude = Double.valueOf(tab[0]);
                double latitude = Double.valueOf(tab[1]);
                markerList.add(new Marker(longitude, latitude));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
        } catch (IOException e) {
            System.out.println("IO exception while reading file.");
        }

    }

    /**
     * Replace every occurrence of 'original' by 'replacement' in the given
     * String.
     *
     * @param line
     * @param original
     * @param replacement
     * @return
     */
    private String replace(String line, char original, char replacement) {
        String result = "";
        for (int rank = 0; rank < line.length(); rank++) {
            if (line.charAt(rank) == original) {
                result = result.concat(replacement + "");
            } else {
                result = result.concat(line.charAt(rank) + "");
            }
        }
        return result;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        g.setColor(Color.red);
        int width = 20;
        g.fillRect(width, width, g.getClipBounds().width - 2 * width, g.getClipBounds().height - 2 * width);
    }
}
