package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.OpeningHour;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Workspace;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.WorkspaceElement;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour.OpeningHourCrudRepository;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour.OpeningHourJPA;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour.OpeningHourMapper;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room.RoomCrudRepository;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room.RoomJPA;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room.RoomMapper;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElement.WorkspaceElementCrudRepository;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElement.WorkspaceElementMapper;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkspaceDataService {

    @Autowired
    private WorkspaceElementCrudRepository workspaceElementCrudRepository;
    @Autowired
    private WorkspaceElementMapper workspaceElementMapper;
    @Autowired
    private RoomCrudRepository roomCrudRepository;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private OpeningHourCrudRepository openingHourCrudRepository;
    @Autowired
    private OpeningHourMapper openingHourMapper;

    public void safeOpeningHours(Workspace workspace) {
        workspace.getOpeningHours().forEach(x-> {
            openingHourCrudRepository.save(openingHourMapper.map(x, workspace.getId()));
        });
    }

    public void safeWorkspace(Workspace workspace) {
        workspace.getWorkspaceElements().forEach(x -> {
            System.out.println(workspaceElementCrudRepository);
            workspaceElementCrudRepository.save(workspaceElementMapper.map(x, workspace.getId()));
        });
        workspace.getRooms().forEach(x-> {
            roomCrudRepository.save(roomMapper.map(x, workspace.getId()));
        });
        workspace.getOpeningHours().forEach(x-> {
            openingHourCrudRepository.save(openingHourMapper.map(x, workspace.getId()));
            System.out.println(workspace.getId());
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
        List<OpeningHour> openingHours = new ArrayList<>();
        openingHourCrudRepository.findByOpeningHourIdentifierWorkspaceId(workspaceId).forEach(x-> {
            openingHours.add(openingHourMapper.map(x));
        });

        return new Workspace(workspaceId, workspaceElementList, roomList, openingHours);
    }

    public List<Integer> getWorkspaceList() {
        List<Integer> integerList = new ArrayList<>();
        List<RoomJPA> roomJPAList = roomCrudRepository.findAll();
        roomJPAList.forEach(x -> {
            if(!integerList.contains(x.getRoomIdentifier().getWorkspaceId()))
            integerList.add(x.getRoomIdentifier().getWorkspaceId());
        });
        return integerList;
    }
}
