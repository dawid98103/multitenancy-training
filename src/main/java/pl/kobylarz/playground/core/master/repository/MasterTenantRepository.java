package pl.kobylarz.playground.core.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kobylarz.playground.core.master.model.MasterTenant;

@Repository
public interface MasterTenantRepository extends JpaRepository<MasterTenant, Integer> {
    @Query("select p from MasterTenant p where p.tenantId = :tenantId")
    MasterTenant findByTenantId(String tenantId);
}
