package siemens.booking.services;


import siemens.booking.entity.Location;

public interface LocationService {
    Location save(Location location);
    Location getLocation();
}
