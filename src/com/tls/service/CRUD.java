package com.tls.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CRUD <Entity,Key>{
    void create(Entity entity);
    void update(Entity entity,Key key);
    void delete(Key key);
    Optional<Entity> readById(Key key);
    Collection<Entity> findAll();
}
