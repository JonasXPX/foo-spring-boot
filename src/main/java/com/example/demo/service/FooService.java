package com.example.demo.service;

import com.example.demo.Foo;
import com.example.demo.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooService {

    private final FooRepository repository;

    @Autowired
    public FooService(final FooRepository repository) {
        this.repository = repository;
    }

    public Foo save(final Foo data) {
        return repository.save(data);
    }

    public Optional<Foo> get(final Long id) {
        return repository.findById(id);
    }
}
