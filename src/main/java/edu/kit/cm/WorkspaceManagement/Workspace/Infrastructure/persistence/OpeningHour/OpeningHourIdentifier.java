package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Embeddable@Getter@Setter
public class OpeningHourIdentifier implements Serializable {
    private LocalTime start;
    private LocalTime end;
    private DayOfWeek dayOfWeek;
    private int workspaceId;
}
