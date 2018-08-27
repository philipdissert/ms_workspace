package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.Room;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Embeddable
public class RoomIdentifier implements Serializable {

    @NotNull
    private int roomId;
    @NotNull
    private int workspaceId;

    public RoomIdentifier(){

    }

    public RoomIdentifier(int workspaceId, int roomId) {
        this.workspaceId = workspaceId;
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomIdentifier roomIdentifier = (RoomIdentifier) o;
        if(this.roomId == roomIdentifier.roomId) {
            return this.workspaceId == roomIdentifier.workspaceId;
        } else {
            return false;
        }

    }

}
