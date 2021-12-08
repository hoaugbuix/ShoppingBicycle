package com.hoangbuix.bicycle.model.request.create;

import lombok.*;

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
