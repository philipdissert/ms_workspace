package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour;

import lombok.Getter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity@Getter
public class OpeningHourJPA {

    @EmbeddedId
    private OpeningHourIdentifier openingHourIdentifier;

    public OpeningHourJPA() {

    }

    public OpeningHourJPA(OpeningHourIdentifier openingHourIdentifier) {
        this.openingHourIdentifier = openingHourIdentifier;
    }
}
