package com.projekat.poslovna.controller.value;

import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * Created by milan.miljus on 8/25/19 12:31 PM.
 */
@Getter
@Validated
public class DocumentCreateDTO {

    @Positive
    private Integer sourceWarehouseId;

    @NotEmpty
    @Valid
    private List<DocumentItemCreateDTO> documentItems;

    @Positive
    private Integer targetWarehouseId;

    @Positive
    private Integer businessPartnerId;

}
