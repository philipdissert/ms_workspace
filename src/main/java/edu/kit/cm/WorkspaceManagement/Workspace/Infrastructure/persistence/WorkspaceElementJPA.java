package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

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
