package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceElementCrudRepository extends CrudRepository<WorkspaceElementJPA, Long> {
    public List<WorkspaceElementJPA> findByWorkspaceElementIdentifierWorkspaceId(int workspaceId);
    public void deleteAllByWorkspaceElementIdentifierWorkspaceId(int workspaceId);

}
