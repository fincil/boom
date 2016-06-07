package me.fincil.service;

import me.fincil.model.Model;
import me.fincil.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HSWook on 2016. 6. 7..
*/
@Service
public class CommonService<T extends Model> {

  @Autowired
  CommonRepository<T> repository;

  public Iterable<T> findAll() {
    return repository.findAll();
  }
}
