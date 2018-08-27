package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCrudRepository extends CrudRepository<RoomJPA, Long> {
    public List<RoomJPA> findByRoomIdentifierWorkspaceId(int workspaceId);

    public List<RoomJPA> findAll();
}
