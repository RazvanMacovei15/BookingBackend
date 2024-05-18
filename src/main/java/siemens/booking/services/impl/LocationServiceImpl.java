package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.Location;
import siemens.booking.repository.LocationRepository;
import siemens.booking.services.LocationService;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocation() {
        return locationRepository.findById(1L).orElseThrow();
    }
}
