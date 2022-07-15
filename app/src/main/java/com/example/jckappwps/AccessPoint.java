package com.example.jckappwps;

public class AccessPoint {
    private String ssid;
    private String bssid;
    private String rssi;

    public AccessPoint(String ssid, String bssid, String rssi){
        this.ssid=ssid;
        this.bssid=bssid;
        this.rssi=rssi;
    }

    public String getSsid(){
        return ssid;
    }

    public String getBssid(){
        return bssid;
    }

    public String getRssi(){
        return rssi;
    }
}
