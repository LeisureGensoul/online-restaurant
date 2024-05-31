package com.whu.order.domain.picture.vo;

import lombok.Data;


@Data
public class PictureVO {

    private Integer id;

    private String picName;

    private String picUrl;

    private String base64Data;
}
