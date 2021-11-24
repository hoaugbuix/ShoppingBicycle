package com.hoangbuix.bicycle.model.message;

import lombok.Data;

@Data
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;
}
