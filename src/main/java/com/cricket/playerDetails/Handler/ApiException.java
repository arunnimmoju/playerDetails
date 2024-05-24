package com.cricket.playerDetails.Handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class ApiException {

    private int code;
    private String status;
    private String message;

    public ApiException() {
    }

}
