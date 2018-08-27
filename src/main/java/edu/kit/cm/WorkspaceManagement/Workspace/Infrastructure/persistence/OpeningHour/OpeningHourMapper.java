package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.OpeningHour;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Component
public class OpeningHourMapper {

    public OpeningHour map(OpeningHourJPA openingHourJPA) {
        LocalTime start = openingHourJPA.getOpeningHourIdentifier().getStart();
        LocalTime end = openingHourJPA.getOpeningHourIdentifier().getEnd();
        DayOfWeek dayOfWeek = openingHourJPA.getOpeningHourIdentifier().getDayOfWeek();

        return new OpeningHour(dayOfWeek, start, end);
    }

    public OpeningHourJPA map(OpeningHour openingHour, int workspaceId) {
        OpeningHourIdentifier openingHourIdentifier = new OpeningHourIdentifier();
        openingHourIdentifier.setStart(openingHour.getStart());
        openingHourIdentifier.setEnd(openingHour.getEnd());
        openingHourIdentifier.setDayOfWeek(openingHour.getWeekDay());
        openingHourIdentifier.setWorkspaceId(workspaceId);
        return new OpeningHourJPA(openingHourIdentifier);
    }
}
