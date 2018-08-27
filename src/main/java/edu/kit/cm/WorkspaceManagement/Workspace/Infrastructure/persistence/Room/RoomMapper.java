package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room;

import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.LocationMapper;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room.PortalGateMapper;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room.RoomIdentifier;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room.RoomJPA;
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
