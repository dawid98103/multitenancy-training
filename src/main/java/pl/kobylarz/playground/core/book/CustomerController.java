//package pl.kobylarz.playground.core.book;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pl.kobylarz.playground.core.book.domain.dto.CardRegisterResponse;
//
//@RestController
//@RequestMapping("/customer")
//@RequiredArgsConstructor
//class CustomerController {
//
//    @PostMapping("/{customerId}/cards")
//    ResponseEntity<CardRegisterResponse> mock(@PathVariable String customerId) {
//        return ResponseEntity.ok(CardRegisterResponse.builder()
//                .id("6af05663-d58f-4ac1-a426-8be45848c214")
//                .number("1234560000824003")
//                .provider("UKV")
//                .expiry("2025-05-13")
//                .build());
//    }
//}
