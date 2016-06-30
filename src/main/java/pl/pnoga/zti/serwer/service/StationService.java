package pl.pnoga.zti.serwer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pnoga.zti.serwer.model.entity.Station;
import pl.pnoga.zti.serwer.model.repository.StationRepository;

import java.util.List;

@Service
public class StationService {


    @Autowired
    private StationRepository stationRepository;

    public List<Station> getStations() {
        return stationRepository.findAll();
    }
}
