package com.learn.scala.springscala.service;

import com.learn.scala.springscala.domain.MetaDatabase;
import com.learn.scala.springscala.repository.MetaDatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetaDatabaseService {
    private final MetaDatabaseRepository metaDatabaseRepository;

    @Transactional
    public MetaDatabase save(MetaDatabase metaDatabase) {
        return metaDatabaseRepository.save(metaDatabase);
    }

    public List<MetaDatabase> findAll() {
        return metaDatabaseRepository.findAll();
    }
}
