package be.winecave.repository;

import java.util.Date;

import be.winecave.exception.NonImplementedException;
import be.winecave.model.Conservation;

public class ConservationRepository extends BaseRepository<Conservation> {
	
	public Conservation findConservation(Date minimum, Date maximum, Date debutApogee, Date finApogee, double temperature){
		//TODO
		throw new NonImplementedException("findConservation()");
	}

}
