package pl.kobylarz.playground.core.master.service;

import pl.kobylarz.playground.core.master.model.MasterTenant;

interface MasterTenantService {
    MasterTenant findByTenantId(String tenantId);
}
