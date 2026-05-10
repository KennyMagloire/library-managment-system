package com.library.repository;

import com.library.Fine;
import com.library.FineStatus;
import java.util.List;

public interface FineRepository extends Repository<Fine, String> {

    List<Fine> findByPatronId(String patronId);
    List<Fine> findByStatus(FineStatus status);
}