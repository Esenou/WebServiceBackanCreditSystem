package com.credit.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayingDto {
    @NotNull
    private Long userId;
    @NotNull
    private Double sum;
    @NotNull
    private Long loanId;
}
