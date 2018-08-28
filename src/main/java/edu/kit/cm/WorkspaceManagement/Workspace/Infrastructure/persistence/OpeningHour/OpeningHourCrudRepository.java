package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence.OpeningHour;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.OpeningHour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpeningHourCrudRepository extends CrudRepository<OpeningHourJPA, Long> {
    public List<OpeningHourJPA> findByOpeningHourIdentifierWorkspaceId(int workspaceId);

    public void deleteAllByOpeningHourIdentifierWorkspaceId(int workspaceId);
}
