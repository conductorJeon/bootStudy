package com.sist.web.vo;

import lombok.Data;

@Data
public class CampingProductVO {
	private int product_code, product_jjim;
	private String name, price, brand, main_image, detail_url, main_category, type;
}
