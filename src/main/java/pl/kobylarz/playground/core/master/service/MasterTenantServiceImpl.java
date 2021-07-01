package pl.kobylarz.playground.core.master.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kobylarz.playground.core.master.model.MasterTenant;
import pl.kobylarz.playground.core.master.repository.MasterTenantRepository;

@Service
@RequiredArgsConstructor
class MasterTenantServiceImpl implements MasterTenantService {

    private final MasterTenantRepository masterTenantRepository;

    @Override
    public MasterTenant findByTenantId(String tenantId) {
        return masterTenantRepository.findByTenantId(tenantId);
    }
}
