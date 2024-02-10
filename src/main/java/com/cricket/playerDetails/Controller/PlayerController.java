package com.cricket.playerDetails.Controller;

import com.cricket.playerDetails.Handler.ApiException;
import com.cricket.playerDetails.Handler.PlayerNotFoundException;
import com.cricket.playerDetails.Model.Player;
import com.cricket.playerDetails.Service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Operation(summary = "Get player by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved player",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class)) }),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) })
    })
    @GetMapping("/{playerId}")
    public ResponseEntity<Object> getPlayerById(@PathVariable Integer playerId) {
        try {
            Player player = playerService.getPlayerById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
            return ResponseEntity.ok(player);
        } catch (PlayerNotFoundException ex) {
            ApiException apiException = new ApiException(404, "Not Found", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ApiException apiException = new ApiException(500, "Internal Server Error", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get all players")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of players",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) })
    })
    @GetMapping
    public ResponseEntity<Object> getAllPlayers() {
        try {
            List<Player> players = playerService.getAllPlayers();
            return ResponseEntity.ok(players);
        } catch (Exception ex) {
            ApiException apiException = new ApiException(500, "Internal Server Error", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Create a new player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) })
    })
    @PostMapping
    public ResponseEntity<Object> createPlayer(@RequestBody Player player) {
        try {
            Player savedPlayer = playerService.savePlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
        } catch (Exception ex) {
            ApiException apiException = new ApiException(500, "Internal Server Error", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update an existing player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class)) }),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) })
    })
    @PutMapping("/{playerId}")
    public ResponseEntity<Object> updatePlayer(@PathVariable Integer playerId, @RequestBody Player playerDetails) {
        try {
            Player updatedPlayer = playerService.updatePlayer(playerId, playerDetails);
            return ResponseEntity.ok(updatedPlayer);
        } catch (PlayerNotFoundException ex) {
            ApiException apiException = new ApiException(404, "Not Found", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ApiException apiException = new ApiException(500, "Internal Server Error", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Player deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiException.class)) })
    })
    @DeleteMapping("/{playerId}")
    public ResponseEntity<Object> deletePlayer(@PathVariable Integer playerId) {
        try {
            playerService.deletePlayer(playerId);
            return ResponseEntity.noContent().build();
        } catch (PlayerNotFoundException ex) {
            ApiException apiException = new ApiException(404, "Not Found", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ApiException apiException = new ApiException(500, "Internal Server Error", ex.getMessage());
            return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
