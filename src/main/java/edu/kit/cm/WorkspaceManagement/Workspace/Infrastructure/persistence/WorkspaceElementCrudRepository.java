package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceElementCrudRepository extends CrudRepository<WorkspaceElementJPA, Long> {


}
