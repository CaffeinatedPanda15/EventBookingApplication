package za.ac.cput.util;

import za.ac.cput.EventApplication.models.Booking;
import za.ac.cput.EventApplication.models.BookingDTO;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface  BookingMapper {

    Booking toVehicle(BookingDTO vehicleDto);
    BookingDTO toVehicleDto(Booking vehicle);

    List<BookingDTO> toVehicleDtoList(List<Booking> vehicles);

    void updateVehicle(@MappingTarget BookingDTO target, Booking source);
}
