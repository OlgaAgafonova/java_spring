package jpa_springdata.spittr.db;


import jpa_springdata.spittr.domain.Spittle;

import java.util.List;

public interface SpittleRepositoryCustom {

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

}