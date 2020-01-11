package Repositories;

import Interfaces.iCalculations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcRep implements iCalculations {
    @Override
    public double ToRad(double degrees) {
        return degrees * (Math.PI / 180);
    }

    @Override
    public double ToDegrees(double radians) {
        return radians * 180 / Math.PI;
    }

    @Override
    public double ToBearing(double radians) {
        // convert radians to degrees (as bearing: 0...360)
        return (ToDegrees(radians) + 360) % 360;
    }

    @Override
    public double DegreeBearing(double lat1, double lon1, double lat2, double lon2) {
        double dLon = ToRad(lon2 - lon1);
        double dPhi = Math.log(
                Math.tan(ToRad(lat2) / 2 + Math.PI / 4) / Math.tan(ToRad(lat1) / 2 + Math.PI / 4));
        if (Math.abs(dLon) > Math.PI)
            dLon = dLon > 0 ? -(2 * Math.PI - dLon) : (2 * Math.PI + dLon);
        return ToBearing(Math.atan2(dLon, dPhi));
    }

//    @Override
//    public boolean isDistanceEnough(float height, float Tilt, double distanceBtw) {
//        double distanceToAb;
//        distanceToAb = height / (Math.tan(Tilt - 4.6) * 3.14 / 180);
//        if (distanceToAb < 0)
//            distanceToAb = distanceToAb * (-1);
//        if (distanceToAb > distanceBtw)
//            return true;
//        return false;
//    }

    @Override
    public boolean isServed(int azimut, int direction, int raznos) {
        int Res = 0;
        if (azimut >= 360 - raznos && azimut <= 360) {
            Res = (azimut + raznos) - 360;
            if ((direction >= 0 && direction <= Res) || (azimut - raznos <= direction && direction <= 360))
                return true;
        } else if (azimut >= 0 && azimut <= raznos) {
            Res = 360 + (azimut - raznos);
            if ((direction >= Res && direction <= 360) || (0 <= direction && direction <= azimut + raznos))
                return true;
        } else {
            if (azimut - raznos <= direction && azimut + raznos >= direction)
                return true;
        }
        return false;
    }


    @Override
    public String getDate(int month) {
        try {
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, +month);
            date = calendar.getTime();
            String strDateFormat = "yyyy-MM-dd";
            DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
            String formatted_date = dateFormat.format(date);
            return formatted_date;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
}
