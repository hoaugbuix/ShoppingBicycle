package com.hoangbuix.bicycle.model.request.update;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBrandReq {
//    @NotNull(message = "Brand Name trống")
//    @NotEmpty(message = "Brand Name trống")
//    @Email(message = "Brand Name không đúng định dạng")
//    @ApiModelProperty(
//            example = "Brand Name",
//            notes = "Brand Name trống",
//            required = true
//    )
    private String brandName;

//    @NotNull(message = "Thumbnail")
//    @NotEmpty(message = "Thumbnail trống")
//    @ApiModelProperty(
//            example = "Thumbnail",
//            notes = "Thumbnail trống",
//            required = true
//    )
    private String thumbnail;

//    @NotNull(message = "Active Flag")
//    @NotEmpty(message = "Active Flag trống")
//    @ApiModelProperty(
//            example = "Active Flag",
//            notes = "Active Flag trống",
//            required = true
//    )
    private int activeFlag;
}
