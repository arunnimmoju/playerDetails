package com.cricket.playerDetails.Service;

import com.cricket.playerDetails.Handler.PlayerNotFoundException;
import com.cricket.playerDetails.Model.Player;
import com.cricket.playerDetails.Repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }

    public Player updatePlayer(Integer playerId, Player playerDetails) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            // Update player details
            player.setPlayerName(playerDetails.getPlayerName());
            player.setPlayerDob(playerDetails.getPlayerDob());
            player.setPlayerNationality(playerDetails.getPlayerNationality());
            player.setTeamsPlayed(playerDetails.getTeamsPlayed());
            player.setTotalMatches(playerDetails.getTotalMatches());
            player.setBatting(playerDetails.getBatting());
            player.setBowling(playerDetails.getBowling());
            return playerRepository.save(player);
        } else {
            throw new PlayerNotFoundException("Player not found with ID: " + playerId);
        }
    }
}
