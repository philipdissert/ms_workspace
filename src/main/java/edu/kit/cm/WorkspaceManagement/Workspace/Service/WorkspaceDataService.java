package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Workspace;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElementCrudRepository;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceDataService {

    @Autowired
    private WorkspaceElementCrudRepository workspaceElementCrudRepository;
    @Autowired
    private WorkspaceElementMapper workspaceElementMapper;

    public void safeWorkspace(Workspace workspace) {
        workspace.getWorkspaceElements().forEach(x -> {
            workspaceElementCrudRepository.save(workspaceElementMapper.map(x, workspace.getId()));
        });

    }
}
