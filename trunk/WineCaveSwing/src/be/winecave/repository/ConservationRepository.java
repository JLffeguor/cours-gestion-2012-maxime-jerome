package be.winecave.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

import be.winecave.exception.NonImplementedException;
import be.winecave.model.Conservation;
@Repository
public class ConservationRepository extends BaseRepository<Conservation> {
	
	public Conservation findConservation(Date minimum, Date maximum, Date debutApogee, Date finApogee, double temperature){
		//TODO
		throw new NonImplementedException("findConservation()");
	}

}
