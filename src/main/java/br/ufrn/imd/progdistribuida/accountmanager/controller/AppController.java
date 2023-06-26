package br.ufrn.imd.progdistribuida.accountmanager.controller;

import br.ufrn.imd.progdistribuida.accountmanager.model.App;
import br.ufrn.imd.progdistribuida.accountmanager.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apps")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<App>> findAppsByUserId(@PathVariable String userId) {
        List<App> apps = appService.findAppsByUserId(userId);
        return ResponseEntity.ok(apps);
    }

    @PostMapping
    public ResponseEntity<App> createApp(@RequestBody App app) {
        App createdApp = appService.createApp(app);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApp);
    }

    @PutMapping("/{appId}")
    public ResponseEntity<App> updateApp(@PathVariable String appId, @RequestBody App app) {
        app.setId(appId);
        App updatedApp = appService.updateApp(app);
        return ResponseEntity.ok(updatedApp);
    }

    @DeleteMapping("/{appId}")
    public ResponseEntity<Void> deleteApp(@PathVariable String appId) {
        appService.deleteApp(appId);
        return ResponseEntity.noContent().build();
    }
}
