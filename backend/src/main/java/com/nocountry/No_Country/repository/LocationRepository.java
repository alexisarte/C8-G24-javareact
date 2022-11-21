package com.nocountry.No_Country.repository;

import com.nocountry.No_Country.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
