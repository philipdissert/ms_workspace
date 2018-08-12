package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDeskLaptop;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDeskPc;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Printer;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.WorkspaceElement;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceElementMapper {
    private LocationMapper locationMapper;

    public WorkspaceElementMapper() {
        locationMapper = new LocationMapper();
    }


    public WorkspaceElement map(WorkspaceElementJPA workspaceElementJPA) {
        WorkspaceElement workspaceElement;

        String type = workspaceElementJPA.getWorkspaceElementIdentifier().getType();
        switch (type) {
            case "PC": workspaceElement = new LearningDeskPc(workspaceElementJPA.workspaceElementIdentifier.getWorkspaceElementId(), locationMapper.map(workspaceElementJPA.getLocationJPA())); break;
            case "Laptop": workspaceElement = new LearningDeskLaptop(workspaceElementJPA.workspaceElementIdentifier.getWorkspaceElementId(), locationMapper.map(workspaceElementJPA.getLocationJPA())); break;
            case "printer": workspaceElement = new Printer(workspaceElementJPA.workspaceElementIdentifier.getWorkspaceElementId(), locationMapper.map(workspaceElementJPA.getLocationJPA())); break;
            default: workspaceElement = null;
        }

        return workspaceElement;
    }

    public WorkspaceElementJPA map(WorkspaceElement workspaceElement, int workspaceId) {
        WorkspaceElementJPA workspaceElementJPA = new WorkspaceElementJPA();
        workspaceElementJPA.setLength(workspaceElement.getLength());
        workspaceElementJPA.setWidth(workspaceElement.getWidth());
        workspaceElementJPA.setLocationJPA(locationMapper.map(workspaceElement.getLocation()));
        workspaceElementJPA.setWorkspaceElementIdentifier(new WorkspaceElementIdentifier(workspaceId, workspaceElement.getId(), workspaceElement.getType()));
        System.out.println(workspaceElementJPA.getWorkspaceElementIdentifier());
        return workspaceElementJPA;
    }
}
