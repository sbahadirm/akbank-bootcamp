package com.bahadirmemis.akbankbootcamp.general;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E, R extends JpaRepository<E, Long>> {

  private final R repository;

  public E save(E entity){
    return repository.save(entity);
  }

  public List<E> findAll() {
    return repository.findAll();
  }

  public void delete(Long id){
    repository.deleteById(id);
  }

  public void delete(E entity){
    repository.delete(entity);
  }

  public Optional<E> findById(Long id){
    return repository.findById(id);
  }

  public E findByIdWithControl(Long id){
    return repository.findById(id).orElseThrow();
  }

  public boolean isExist(Long id){
    return repository.existsById(id);
  }
}
