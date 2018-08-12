package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Workspace;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.WorkspaceElement;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.RoomCrudRepository;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.RoomMapper;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElementCrudRepository;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElementMapper;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkspaceDataService {

    @Autowired
    private RoomCrudRepository roomCrudRepository;
    @Autowired
    private WorkspaceElementCrudRepository workspaceElementCrudRepository;
    @Autowired
    private WorkspaceElementMapper workspaceElementMapper;
    @Autowired
    private RoomMapper roomMapper;

    public void safeWorkspace(Workspace workspace) {
        workspace.getWorkspaceElements().forEach(x -> {
            System.out.println(workspaceElementCrudRepository);
            workspaceElementCrudRepository.save(workspaceElementMapper.map(x, workspace.getId()));
        });
        workspace.getRooms().forEach(x-> {
            roomCrudRepository.save(roomMapper.map(x, workspace.getId()));
        });
    }

    public Workspace getWorkspace(int workspaceId) {
        List<Room> roomList = new ArrayList<>();
        roomCrudRepository.findByRoomIdentifierWorkspaceId(workspaceId).forEach(x-> {
            roomList.add(roomMapper.map(x));
        });
        List<WorkspaceElement> workspaceElementList = new ArrayList<>();
        workspaceElementCrudRepository.findByWorkspaceElementIdentifierWorkspaceId(workspaceId).forEach(x-> {
            workspaceElementList.add(workspaceElementMapper.map(x));
        });
        return new Workspace(workspaceId, workspaceElementList, roomList);
    }
}
