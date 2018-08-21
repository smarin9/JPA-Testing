package com.laitram.jpa;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.*;
import java.util.List;
/**
 * Created by smarino on 8/7/2018
 */
@Dependent
@Default
public class StandardRodsRepo implements StandardRodsDAO{
    @PersistenceContext(unitName = "DB")
    private EntityManager em;
    @Override
    public List<StandardRods> getStandardRods(String seriesInd, String beltStyleInd, String materialInd, String colorInd)
    {
        Query q =  em.createNamedStoredProcedureQuery("GET_STD_RODS");
        q.setParameter("p_series_ind", seriesInd)
                 .setParameter("p_style_ind", beltStyleInd)
                 .setParameter("p_material_ind", materialInd)
                 .setParameter("p_color_ind", colorInd);
        return (List<StandardRods>) q.getResultList();
    }
}
