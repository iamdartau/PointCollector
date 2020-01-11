package Interfaces;

import models.Alarms;
import models.Cell;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Set;

public interface iChecker {
    Alarms CheckForAlarms(Set<String> setTotal);

    Set<Cell> GetServedList(Set<Cell> NearCells, Connection connection, double latitude, double longitude);

    String CheckForTransmission(ArrayList<String> TransportBS, Set<String> BTS);

    String CheckForDismantled(ArrayList<String> DismantledBS);

    String CheckBsFormat(String bs);
    String CheckForBsPlanned(ArrayList<String> planedBS);
}
