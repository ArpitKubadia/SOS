package com.example.arpit.sos;

import android.net.Uri;

/**
 * Created by arpit on 29/3/18.
 */

public class DataPush {
    String personName,personGivenName,personFamilyName,personEmail,personId;
    double longitude,latitude;
    Uri personPhoto;

    public DataPush(String personName, String personGivenName, String personFamilyName, String personEmail, String personId, double longitude, double latitude, Uri personPhoto) {
        this.personName = personName;
        this.personGivenName = personGivenName;
        this.personFamilyName = personFamilyName;
        this.personEmail = personEmail;
        this.personId = personId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.personPhoto = personPhoto;
    }


}
