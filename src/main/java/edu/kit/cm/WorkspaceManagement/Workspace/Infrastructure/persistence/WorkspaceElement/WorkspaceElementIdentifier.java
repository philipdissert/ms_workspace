package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.WorkspaceElement;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class WorkspaceElementIdentifier implements Serializable {
    @NotNull
    private int workspaceId;
    @NotNull
    private int workspaceElementId;
    @NotNull
    private String type;

    public WorkspaceElementIdentifier(int workspaceId, int workspaceElementId, String type) {
        this.workspaceId = workspaceId;
        this.workspaceElementId = workspaceElementId;
        this.type = type;
    }

    public WorkspaceElementIdentifier() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkspaceElementIdentifier workspaceElementIdentifier = (WorkspaceElementIdentifier) o;

        boolean wID = false;
        boolean wEID = false;
        boolean t = false;
        if(this.workspaceId == workspaceElementIdentifier.workspaceId) wID = true;
        if(this.workspaceElementId == workspaceElementIdentifier.workspaceElementId) wEID = true;
        if(this.type.equals(workspaceElementIdentifier.type)) t = true;

        return wID && wEID && t;
    }
}
