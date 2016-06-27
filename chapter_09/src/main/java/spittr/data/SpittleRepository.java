package spittr.data;


import spittr.Spittle;

import java.util.List;

public interface SpittleRepository {

    /**
     * Returns a list of the Spittles.
     *
     * @param max   is a Spittle ID that represents the maximum ID of any Spittle that should be returned.
     * @param count indicates how many Spittle objects to return.
     * @return a list of the spittles.
     */
    List<Spittle> findSpittles(long max, int count);

    List<Spittle> findRecentSpittles();

    Spittle findOne(long id);

    void save(Spittle spittle);
}
