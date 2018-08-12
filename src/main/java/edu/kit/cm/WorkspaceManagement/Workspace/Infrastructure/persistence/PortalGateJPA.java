package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
public class PortalGateJPA {
    private String type;
    private LocationJPA locationJPA1;
    //private LocationJPA locationJPA2;

    public PortalGateJPA() {

    }

    public PortalGateJPA(String type, List<LocationJPA> locationJPAList) {
        this.type = type;
        this.locationJPA1 = locationJPAList.get(0);
        //this.locationJPA2 = locationJPAList.get(1);
    }

    public List<LocationJPA> getLocationJPAList(){
        List<LocationJPA> locationJPAList = new ArrayList<>();
        locationJPAList.add(locationJPA1);
       // locationJPAList.add(locationJPA2);
        return locationJPAList;
    }
}
