package com.laitram.jpa;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;
/**
 * Created by smarino on 8/7/2018
 */
@ApplicationPath("/*")
@Path("/standardrods")
@Dependent
public class StandardRodsResource extends Application {

    @Inject
    private StandardRodsDAOController standardRodsDAOController;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public StandardRods getStandardRodsData(@QueryParam("p_series_ind") String seriesInd, @QueryParam("p_style_ind") String beltStyleInd,
                                                  @QueryParam("p_material_ind") String materialInd, @QueryParam("p_color_ind") String colorInd)
    {
        return standardRodsDAOController.getDefaultRodAndColor(seriesInd, beltStyleInd, materialInd, colorInd);
    }
}
