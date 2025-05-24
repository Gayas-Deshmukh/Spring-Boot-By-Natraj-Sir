package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menuIP")
@Data
public class MenuItemPrices 
{
	@Value("${menu.dhosa.rate}")
	private Float dhosaPrice;
	
	@Value("${menu.idely.rate}")	
	private Float idlyPrice;

	@Value("${menu.poha.rate}")
	private Float pohaprice;

	@Value("${menu.upma.rate}")
	private Float upmaprice;
}
