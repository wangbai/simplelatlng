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
		
		
		
		LatLng[] points = new LatLng[12];
		points[0] = new LatLng(30, -50);
		points[1] = new LatLng(70, 50);
		points[2] = new LatLng(50, 100);
		points[3] = new LatLng(10, 80);
		
		points[4] = new LatLng(-10, 110);
		points[5] = new LatLng(-30, 110);
		points[6] = new LatLng(-50, -20);
		points[7] = new LatLng(-40, -30);
		
		points[8] = new LatLng(-10, 10);
		points[9] = new LatLng(10, -10);
		points[10] = new LatLng(-20, -30);
		points[11] = new LatLng(-30, -50);
		
		
		PolygonWindow polygon = new PolygonWindow(points);
		
		//when point on the bounder, it can't precisely judge
		System.out.println(polygon.contains(new LatLng(70, 50)));
		System.out.println(polygon.contains(new LatLng(40, 70)));
		System.out.println(polygon.contains(new LatLng(30, -20)));
		System.out.println(polygon.contains(new LatLng(10, 100)));
		System.out.println(polygon.contains(new LatLng(-10, -10)));
		System.out.println(polygon.contains(new LatLng(-20, 40)));
		System.out.println(polygon.contains(new LatLng(-20, 110)));
	}

}
