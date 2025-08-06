package com.coop.vrc.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleResponse {
    private String vehicleMaker, vehicleModel, manufacturingYear, vehicleColor;
}
