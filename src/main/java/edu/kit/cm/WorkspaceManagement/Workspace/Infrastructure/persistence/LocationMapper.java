package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationMapper {

    public Location map(LocationJPA locationJPA) {
        return new Location(locationJPA.getXPos(), locationJPA.getYPos());
    }

    public LocationJPA map(Location location) {
        return new LocationJPA(location.getXPos(), location.getYPos());
    }

    public List<Location> mapListfromJPA(List<LocationJPA> locationJPAList) {
        List<Location> locationList = new ArrayList<>();
        locationJPAList.forEach(x-> {
        locationList.add(map(x));
        });
        return locationList;
    }

    public List<LocationJPA> mapListToJPA(List<Location> locationList) {
        List<LocationJPA> locationJPAList = new ArrayList<>();
        locationList.forEach(x-> {
            locationJPAList.add(map(x));
        });
        return locationJPAList;
    }

}
