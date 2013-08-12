package com.javadocmd.simplelatlng;

import com.javadocmd.simplelatlng.chinatool.MarsToBaidu;
import com.javadocmd.simplelatlng.chinatool.WorldToMars;

/*
 * API for all the china offset converters
 * It is thread-safe, so have fun to use in multi-thread application.
 */
public class LatLngChinaTool {

    public static LatLng World2Mars(LatLng worldPoint) {
        WorldToMars wmConverter = new WorldToMars();
        return wmConverter.transcodeFromWgs84toGcj02(worldPoint);
    }

    public static LatLng Mars2World(LatLng marsPoint) {
        WorldToMars wmConverter = new WorldToMars();
        return wmConverter.transcodeFromGcj02toWgs84(marsPoint);
    }

    public static LatLng Mars2Baidu(LatLng marsPoint) {
        MarsToBaidu mbConverter = new MarsToBaidu();
        return mbConverter.transcodeFromGcj02toBd09(marsPoint);
    }

    public static LatLng Baidu2Mars(LatLng baiduPoint) {
        MarsToBaidu mbConverter = new MarsToBaidu();
        return mbConverter.transcodeFromBd09toGcj02(baiduPoint);
    }

    public static LatLng World2Baidu(LatLng worldPoint) {
        LatLng marsPoint = World2Mars(worldPoint);
        return Mars2Baidu(marsPoint);
    }

    public static LatLng Baidu2World(LatLng baiduPoint) {
        LatLng marsPoint = Baidu2Mars(baiduPoint);
        return Mars2World(marsPoint);
    }

    private LatLngChinaTool() {
    }
}
