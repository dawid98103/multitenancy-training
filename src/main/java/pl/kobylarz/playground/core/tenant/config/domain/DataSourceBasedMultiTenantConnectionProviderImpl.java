package pl.kobylarz.playground.core.tenant.config.domain;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pl.kobylarz.playground.core.master.model.MasterTenant;
import pl.kobylarz.playground.core.master.repository.MasterTenantRepository;
import pl.kobylarz.playground.core.util.DataSourceUtil;
import pl.kobylarz.playground.core.util.TenantContextHolder;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Configuration
class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Autowired
    private MasterTenantRepository masterTenantRepository;
    private Map<String, DataSource> dataSourcesMtApp = new TreeMap<>();

    @Override
    protected DataSource selectAnyDataSource() {
        // This method is called more than once. So check if the data source map
        // is empty. If it is then rescan master_tenant table for all tenant
        // entries.
//        MasterTenant masterTenant1 = MasterTenant.builder()
//                .id(0)
//                .tenantId("1")
//                .url("jdbc:postgresql://localhost:5432/garage")
//                .username("postgres")
//                .password("postgres")
//                .build();
//
//        masterTenantRepository.save(masterTenant1);

        if (dataSourcesMtApp.isEmpty()) {
            List<MasterTenant> masterTenants = masterTenantRepository.findAll();
            log.info(">>>> selectAnyDataSource() -- Total tenants:" + masterTenants.size());
            for (MasterTenant masterTenant : masterTenants) {
                dataSourcesMtApp.put(masterTenant.getTenantId(),
                        DataSourceUtil.createAndConfigureDataSource(masterTenant));
            }
        }
        return this.dataSourcesMtApp.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        // If the requested tenant id is not present check for it in the master
        // database 'master_tenant' table

        tenantIdentifier = TenantContextHolder.getTenant();

        if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
            List<MasterTenant> masterTenants = masterTenantRepository.findAll();
            log.info(
                    ">>>> selectDataSource() -- tenant:" + tenantIdentifier + " Total tenants:" + masterTenants.size());
            for (MasterTenant masterTenant : masterTenants) {
                if (this.dataSourcesMtApp.containsKey(masterTenant.getTenantId())) {
                    continue;
                }
                dataSourcesMtApp.put(masterTenant.getTenantId(),
                        DataSourceUtil.createAndConfigureDataSource(masterTenant));
            }
        }
        //check again if tenant exist in map after rescan master_db, if not, throw UsernameNotFoundException
        if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
            log.warn("Trying to get tenant:" + tenantIdentifier + " which was not found in master db after rescan");
            throw new RuntimeException(
                    String.format(
                            "Tenant not found after rescan, "
                                    + " tenant=%s",
                            tenantIdentifier));
        }
        return this.dataSourcesMtApp.get(tenantIdentifier);
    }
}
