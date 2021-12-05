package com.hoangbuix.bicycle.model.request.create;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBrandReq {
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
}
