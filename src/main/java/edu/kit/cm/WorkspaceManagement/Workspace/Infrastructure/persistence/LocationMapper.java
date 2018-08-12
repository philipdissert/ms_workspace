package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;

public class LocationMapper {

    public Location map(LocationJPA locationJPA) {
        return new Location(locationJPA.getXPos(), locationJPA.getYPos());
    }

    public LocationJPA map(Location location) {
        return new LocationJPA(location.getXPos(), location.getYPos());
    }
}
