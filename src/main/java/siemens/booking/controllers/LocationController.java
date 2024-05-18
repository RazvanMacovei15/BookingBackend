package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siemens.booking.rapidapi.Location;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    private final Location location;

    @GetMapping
    public Location getLocation(){
        return location.getUserCurrentLocation();
    }
}
