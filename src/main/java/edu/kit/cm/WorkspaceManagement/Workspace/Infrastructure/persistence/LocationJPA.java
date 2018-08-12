package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter@Setter@Embeddable
public class LocationJPA {
    private long xPos;
    private long yPos;

    public LocationJPA() {

    }

    public LocationJPA(long xPos, long yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
