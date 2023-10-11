package mobral.himuro.farmers.mobralAPI.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mobral.himuro.farmers.mobralAPI.domain.User;
import mobral.himuro.farmers.mobralAPI.dto.UserPostRequestBody;
import mobral.himuro.farmers.mobralAPI.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> list(Pageable pageable) {
        return ResponseEntity.ok(userService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }
}
