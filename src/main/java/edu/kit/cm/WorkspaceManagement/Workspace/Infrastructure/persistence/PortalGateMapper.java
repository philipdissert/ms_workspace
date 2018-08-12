package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Door;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Passage;
import edu.kit.cm.WorkspaceManagement.linkedContextes.PortalGate;

import java.util.ArrayList;
import java.util.List;

public class PortalGateMapper {

    public PortalGate map(PortalGateJPA portalGateJPA) {
        LocationMapper locationMapper = new LocationMapper();

        switch(portalGateJPA.getType()) {
            case "passage": return new Door(locationMapper.mapListfromJPA(portalGateJPA.getLocationJPAList()));
            case "door":    return new Passage(locationMapper.mapListfromJPA(portalGateJPA.getLocationJPAList()));
            default: return null;
        }
    }

    public PortalGateJPA map(PortalGate portalGate) {
        LocationMapper locationMapper = new LocationMapper();
        return new PortalGateJPA(portalGate.getType(), locationMapper.mapListToJPA(portalGate.getLocation()));
    }

    public List<PortalGate> mapListFromJPA(List<PortalGateJPA> portalGateJPAList) {
        List<PortalGate> portalGateList = new ArrayList<>();
        portalGateJPAList.forEach(x->{
            portalGateList.add(map(x));
        });
        return portalGateList;
    }

    public List<PortalGateJPA> mapListToJpa(List<PortalGate> portalGateList) {
        List<PortalGateJPA> portalGateJPAList = new ArrayList<>();
        portalGateList.forEach(x-> {
            portalGateJPAList.add(map(x));
        });
        return portalGateJPAList;
    }




}
