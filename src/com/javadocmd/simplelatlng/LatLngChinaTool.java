package com.javadocmd.simplelatlng;

import com.javadocmd.simplelatlng.LatlngChinaTool.MarsToBaidu;
import com.javadocmd.simplelatlng.LatlngChinaTool.WorldToMars;

/*
 * API for all the china offset converters
 * It is thread-safe, so have fun to use in multi-thread application.
 */
public class LatLngChinaTool {
	
	public LatLng World2Mars(LatLng worldPoint) {
		WorldToMars wmConverter = new WorldToMars();
		return wmConverter.transcodeFromWgs84toGcj02(worldPoint);
	}
	
	public LatLng Mars2World(LatLng marsPoint) {
		WorldToMars wmConverter = new WorldToMars();
		return wmConverter.transcodeFromGcj02toWgs84(marsPoint);
	}
	
	public LatLng Mars2Baidu(LatLng marsPoint) {
		MarsToBaidu mbConverter = new MarsToBaidu();
		return mbConverter.transcodeFromGcj02toBd09(marsPoint);
	}
	
	public LatLng Baidu2Mars(LatLng baiduPoint) {
		MarsToBaidu mbConverter = new MarsToBaidu();
		return mbConverter.transcodeFromBd09toGcj02(baiduPoint);
	}
	
	public LatLng World2Baidu(LatLng worldPoint) {
		LatLng marsPoint = this.World2Mars(worldPoint);
		return this.Mars2Baidu(marsPoint);
	}
	
	public LatLng Baidu2World(LatLng baiduPoint) {
		LatLng marsPoint = this.Baidu2Mars(baiduPoint);
		return this.Mars2World(marsPoint);
	}
	
}
