package com.library.repository;

import com.library.Patron;
import com.library.AffiliationType;
import java.util.List;

public interface PatronRepository extends Repository<Patron, String> {

    List<Patron> findByAffiliationType(AffiliationType affiliationType);
    List<Patron> findActivePatrons();
}