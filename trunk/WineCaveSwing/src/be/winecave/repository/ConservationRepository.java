package be.winecave.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

import be.winecave.model.Conservation;
@Repository
public class ConservationRepository extends BaseRepository<Conservation> {
	
	public Conservation findAnExactConservation(Date minimum, Date maximum,	Date debutApogee, Date finApogee, double temperatureMinimum, double temperatureMaximum) {
		return getSingleOrNullResult(em.createQuery("select c from Conservation where c.minimum=:minimum and c.maximum=:maximum and c.debutApogee and c.finApogee and c.temperatureMinimum and c.temperatureMaximum")
									 .setParameter("minimum", minimum)
									 .setParameter("maximum", maximum)
									 .setParameter("debutApogee", debutApogee)
									 .setParameter("finApogee", finApogee)
									 .setParameter("temperatureMinimum", temperatureMinimum)
									 .setParameter("temperatureMaximum", temperatureMaximum));
	}

}
