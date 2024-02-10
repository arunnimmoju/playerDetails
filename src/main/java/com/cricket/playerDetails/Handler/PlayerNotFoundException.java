package com.cricket.playerDetails.Handler;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
