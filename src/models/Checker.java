package models;

import Interfaces.iChecker;
import Repositories.CalcRep;
import Repositories.Db_command;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker implements iChecker {

    CalcRep calculations = new CalcRep();
    Db_command command = new Db_command();

    @Override
    public Set<Cell> GetServedList(Set<Cell> NearCells, Connection connection, double latitude, double longitude) {
        Set<Cell> CellServed = new HashSet<>();
        for (Cell c : NearCells) {
            double direction = calculations.DegreeBearing(latitude, longitude, c.getLatitude(), c.getLongitude());
            if ((direction + 180) > 360)
                c.setDirectionToAb((int) direction - 180);
            else c.setDirectionToAb((int) direction + 180);
        }

        //set served cells
        for (Cell c : NearCells) {
            if (calculations.isServed(c.getAzimut(), (int) c.getDirectionToAb(), 45))
                CellServed.add(c);
        }
        return CellServed;
    }

    @Override
    public String CheckForTransmission(ArrayList<String> TransportBS, Set<String> BTS) {
       for(String bts: BTS) {
           String bts_n = CheckBsFormat(bts);
           for (String bs : TransportBS) {
               String bs_n = CheckBsFormat(bs);
               if(bs_n.contains(bts_n))
                   return bs_n;
           }
       }
        return null;
    }

    @Override
    public String CheckForDismantled(ArrayList<String> DismantledBS) {
        for (String bs : DismantledBS) {
            return bs;
        }
        return null;
    }


    @Override
    public String CheckBsFormat(String bs) {
        Pattern MY_PATTERN = Pattern.compile("[A-Z]{2,3}\\d{3,4}");
        Matcher m = MY_PATTERN.matcher(bs);
        List<String> listMatches = new ArrayList<String>();
        String Formatted = "";

        while (m.find()) {
            listMatches.add(m.group(0));
        }

        for (String s : listMatches) {
            Formatted = s;
        }
        return Formatted;
    }

    @Override
    public Alarms CheckForAlarms(Set<String> setTotal) {
        for (String bs : setTotal) {
            String bsFormated = CheckBsFormat(bs);
            for (Alarms Alarmed_bs : command.getAlarms()) {
                String alarmFormated = CheckBsFormat(Alarmed_bs.getBts_name());
                if (bsFormated.equals(alarmFormated)&&!(Alarmed_bs.getAlarm_name().equals("NE Is Disconnected"))&&!(Alarmed_bs.getAlarm_name().equals("NodeB Unavailable")))
                    return new Alarms(Alarmed_bs.getBts_name(), Alarmed_bs.getAlarm_name());
            }
        }
        return null;
    }

/*
    public Transport_detail checkTD(ArrayList<String> tdArray){
        Transport_detail transport_detail = null;

        return transport_detail;
    }
 */



    @Override
    public String CheckForBsPlanned(ArrayList<String> planedBS) {

        for (String p : planedBS) {
                return p;
        }
        return null;
    }
}
