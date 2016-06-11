package me.fincil.service;

import me.fincil.model.Model;
import me.fincil.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by HSWook on 2016. 6. 7..
*/
public abstract class ModelService<T extends Model> {

  @Autowired
  ModelRepository<T> repository;

  public Iterable<T> findAll() {
    return repository.findAll();
  }
}
