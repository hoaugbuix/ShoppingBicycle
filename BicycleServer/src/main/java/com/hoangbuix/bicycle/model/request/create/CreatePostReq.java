package com.hoangbuix.bicycle.model.request.create;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePostReq {
    //    @NotNull(message = "Brand Name trống")
//    @NotEmpty(message = "Brand Name trống")
//    @Email(message = "Brand Name không đúng định dạng")
//    @ApiModelProperty(
//            example = "Brand Name",
//            notes = "Brand Name trống",
//            required = true
//    )
    private String title;

    private String content;

    private String slug;

    private String description;

    private String thumbnail;

}
