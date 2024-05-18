package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siemens.booking.dto.LocationDto;
import siemens.booking.entity.Location;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.LocationService;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    private final LocationService locationService;
    private final Mapper<Location, LocationDto> locationMapper;

    @GetMapping
    public LocationDto getLocation(){
        Location location = locationService.getLocation();
        return locationMapper.mapTo(location);  // Fix this line
    }
}
