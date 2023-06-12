package br.ufrn.imd.progdistribuida.accountmanager.controller;

import br.ufrn.imd.progdistribuida.accountmanager.dto.UserAppDto;
import br.ufrn.imd.progdistribuida.accountmanager.model.User;
import br.ufrn.imd.progdistribuida.accountmanager.service.UserService;
import br.ufrn.imd.progdistribuida.accountmanager.util.Endpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("with-app")
    public ResponseEntity<User> save(@RequestBody UserAppDto userApp) {
        return ResponseEntity.ok(userService.save(userApp));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
