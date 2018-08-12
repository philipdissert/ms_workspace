package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import lombok.Getter;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.List;

@Getter
@Entity
public class RoomJPA {
    @EmbeddedId
    private RoomIdentifier roomIdentifier;
    @ElementCollection
    @Embedded
    private List<LocationJPA> locationJPAList;
    @ElementCollection
    @Embedded
    private List<PortalGateJPA> portalGateJPAList;



    public RoomJPA() {

    }

    public RoomJPA(RoomIdentifier roomIdentifier, List<LocationJPA> locationJPAList, List<PortalGateJPA> portalGateJPAList) {
        this .roomIdentifier = roomIdentifier;
        this.locationJPAList = locationJPAList;
        this.portalGateJPAList = portalGateJPAList;
    }
}
