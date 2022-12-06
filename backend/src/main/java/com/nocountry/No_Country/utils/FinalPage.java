package com.nocountry.No_Country.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class FinalPage {

    private Long totalResult;
    private List<?> content = new ArrayList<>();
}
