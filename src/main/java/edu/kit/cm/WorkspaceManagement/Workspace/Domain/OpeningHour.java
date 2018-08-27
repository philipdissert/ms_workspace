package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;

import java.util.Calendar;
import java.time.*;

@Getter
public class OpeningHour {

    private LocalTime start;
    private LocalTime end;
    private DayOfWeek weekDay;

    public OpeningHour(DayOfWeek weekDay, LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
        this.weekDay = weekDay;
    }
}
