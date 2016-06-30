package pl.pnoga.zti.serwer.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pnoga.zti.serwer.model.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
    Station findByStation(String station);
}
