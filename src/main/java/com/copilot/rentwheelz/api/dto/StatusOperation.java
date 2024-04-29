package com.copilot.rentwheelz.api.dto;

import lombok.Data;

@Data
public class StatusOperation {
    private String status;
    private String message;
    private Integer results;

    private Object data;

    public StatusOperation(String status, Integer results, String message, Object data) {
        this.status = status;
        this.results = results;
        this.message = message;
        this.data = data;
    }

}
