package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    private LocationMapper locationMapper = new LocationMapper();
    private PortalGateMapper portalGateMapper = new PortalGateMapper();

    public Room map(RoomJPA roomJPA) {

        return new Room(portalGateMapper.mapListFromJPA(roomJPA.getPortalGateJPAList()),
                locationMapper.mapListfromJPA(roomJPA.getLocationJPAList()),
                roomJPA.getRoomIdentifier().getRoomId()
        );
    }

    public RoomJPA map(Room room, int workspaceId) {
        return new RoomJPA(new RoomIdentifier(workspaceId, room.getId()),
                locationMapper.mapListToJPA(room.getLocation()),
                portalGateMapper.mapListToJpa(room.getPortalGate()));
    }
}
