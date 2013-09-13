package com.javadocmd.simplelatlng;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.javadocmd.simplelatlng.util.LengthUnit;

public class LatLngToolTest {
    
    private static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) 
                  + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) 
                  * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }

        return (dist);
    }
    
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        LatLng p1 = new LatLng(0, 0);
        LatLng p2 = new LatLng(1, 1);
        LatLng p3 = new LatLng(1, 1);
        LatLng p4 = new LatLng(0.4, 5);

        //System.out.println(LatLngTool.isIntersected(p1, p2, p3, p4));
        
        LatLng pA = new LatLng(39.963, 116.31111);
        LatLng pB = new LatLng(39.955, 116.228111);
        //System.out.println(LatLngTool.initialBearing(pA, pB));
        System.out.println(LatLngTool.distance(pA, pB, LengthUnit.KILOMETER));
        
        System.out.println(distance(pA.getLatitude(), pA.getLongitude(), pB.getLatitude(), pB.getLongitude(), 'K'));
    
        FileReader reader = new FileReader("data//200240889.txt");
        BufferedReader br = new BufferedReader(reader);
        String s1 = null;
        double distance = 0;
        LatLng last = null;
        while((s1 = br.readLine()) != null) {
            String[] point = s1.split(",");
            LatLng p = new LatLng(Double.parseDouble(point[0]), 
                    Double.parseDouble(point[1]));
            if (last != null) {
                distance += LatLngTool.distance(p, last, LengthUnit.KILOMETER);
            }
            last = p;
            System.out.println(distance);
        }
        br.close();
        reader.close();
    }

}
