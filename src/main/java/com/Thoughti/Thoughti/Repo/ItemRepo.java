package com.Thoughti.Thoughti.Repo;

import com.Thoughti.Thoughti.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Items,Integer> {
}
