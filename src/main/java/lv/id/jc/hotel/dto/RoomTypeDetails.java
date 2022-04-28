package lv.id.jc.hotel.dto;

import lv.id.jc.hotel.validator.RoomTypeName;

import javax.validation.constraints.NotBlank;

public record RoomTypeDetails(@RoomTypeName String name, @NotBlank String description) {
}