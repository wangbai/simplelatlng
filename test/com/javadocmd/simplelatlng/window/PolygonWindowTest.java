/**
 * 
 */
package com.javadocmd.simplelatlng.window;

import com.javadocmd.simplelatlng.LatLng;

/**
 * @author wangbai
 *
 */
public class PolygonWindowTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LatLng[] points = new LatLng[4];
		points[0] = new LatLng(0,0);
		points[1] = new LatLng(1,0);
		points[2] = new LatLng(1,1);
		points[3] = new LatLng(0,1);
		
		PolygonWindow polygon = new PolygonWindow(points);
		
		System.out.println(polygon.contains(new LatLng(0.3, 0.4)));
	}

}
