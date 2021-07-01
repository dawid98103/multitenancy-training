package pl.kobylarz.playground.core.tenant.config.domain;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.junit.platform.commons.util.StringUtils;
import pl.kobylarz.playground.core.util.TenantContextHolder;

class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContextHolder.getTenant();
        return StringUtils.isNotBlank(tenant) ? tenant : "tenant_1";
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
