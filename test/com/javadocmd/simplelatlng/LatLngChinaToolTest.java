/**
 * 
 */
package com.javadocmd.simplelatlng;

/**
 * @author wangbai
 *
 */
public class LatLngChinaToolTest {

	public static void main(String[] args) {
//		LatLng world = new LatLng(23.517846, 113.540124);
//		LatLng mars = new LatLng(23.515152452257, 113.54532931858);
//		
		LatLngChinaTool tool = new LatLngChinaTool();
//		LatLng mars_trans = tool.World2Mars(world);
//		System.out.println(mars_trans.equals(mars));
//		System.out.println(mars_trans);
//		System.out.println(mars);
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
//		
//		LatLng world_trans = tool.Mars2World(mars);
//		System.out.println(world_trans);
//		System.out.println(world);
		
//		double length = 0.001;
//		for(int i = 0; i < 1000; ++i) {
//			LatLng point = new LatLng(23.0 + i * length, 50.248 );
//			
//			LatLng mars = tool.World2Mars(point);
//			double deltaLat = mars.getLatitude() - point.getLatitude();
//			double deltaLon = mars.getLongitude() - point.getLongitude();
//			
//			LatLng mars1 = tool.World2Mars(mars);
//			double deltaLat1 = mars1.getLatitude() - mars.getLatitude();
//			double deltaLon1 = mars1.getLongitude() - mars.getLongitude();
//			
//			System.out.println(point+","+(long)((deltaLat-deltaLat1)*1000000)+","+(long)((deltaLon-deltaLon1)*1000000));		
//		}
		
		LatLng mars = new LatLng(23.517846, 113.540124);
		LatLng baidu = new LatLng(23.524013934862, 113.54658691644);
		
		LatLng baidu_trans = tool.Mars2Baidu(mars);
		System.out.println(baidu_trans.equals(baidu));
		
		LatLng mars_trans = tool.Baidu2Mars(baidu);
		System.out.println(mars_trans);
		System.out.println(mars);
	}

}
