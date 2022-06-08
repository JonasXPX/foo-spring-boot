package com.example.demo.controller;

import com.example.demo.Foo;
import com.example.demo.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foo")
public class FooController {

    private final FooService service;

    @Autowired
    public FooController(FooService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Foo> save(@RequestBody final Foo data) {
        return ResponseEntity.ok(service.save(data));
    }

    @GetMapping("{id}")
    public ResponseEntity<Foo> get(@PathVariable Long id) {
        return ResponseEntity.of(service.get(id));
    }
}
