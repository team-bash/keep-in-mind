package com.teambash.keepinmind.shared.dto;

import lombok.Data;

import java.util.List;

@Data
public class WrapperListResponse<T> {

    private int totalValues;
    private List<T> values;

    public WrapperListResponse(List<T> values) {
        this.values = values;
        this.totalValues = values.size();
    }
}
