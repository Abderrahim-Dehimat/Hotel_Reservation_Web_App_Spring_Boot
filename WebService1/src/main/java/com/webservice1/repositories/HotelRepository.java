package com.webservice1.repositories;

import com.webservice1.models.Chambre;
import com.webservice1.models.Hotel;
import com.webservice1.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
