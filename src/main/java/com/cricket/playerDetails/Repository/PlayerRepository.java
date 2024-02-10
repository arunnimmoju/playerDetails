package com.cricket.playerDetails.Repository;

import com.cricket.playerDetails.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // You can add custom query methods here if needed
}



