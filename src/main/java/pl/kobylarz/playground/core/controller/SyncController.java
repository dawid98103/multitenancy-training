package pl.kobylarz.playground.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kobylarz.playground.core.master.model.MasterTenant;
import pl.kobylarz.playground.core.master.repository.MasterTenantRepository;
import pl.kobylarz.playground.core.tenant.model.User;
import pl.kobylarz.playground.core.tenant.repository.UserRepository;
import pl.kobylarz.playground.core.util.TenantContextHolder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sync")
class SyncController {

    private final UserRepository userRepository;
    private final MasterTenantRepository masterTenantRepository;

    @PostMapping("/user")
    public void syncUsers(){
        TenantContextHolder.setTenantId("1");
        System.out.println(TenantContextHolder.getTenant());
        List<MasterTenant> masterTenant =  masterTenantRepository.findAll();
        List<User> users =  userRepository.findAll();
        System.out.println(users);
        System.out.println(masterTenant);
    }
}
