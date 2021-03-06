package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElement;

import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.LocationJPA;
import edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElement.WorkspaceElementIdentifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter@Setter
@Entity
public class WorkspaceElementJPA {

    @EmbeddedId
    WorkspaceElementIdentifier workspaceElementIdentifier;
    @Embedded
    private LocationJPA locationJPA;

    private int length;
    private int width;


    public WorkspaceElementJPA() {

    }

}
