package com.laitram.jpa;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
/**
 * Created by smarino on 8/7/2018
 */
@Dependent
public class StandardRodsDAOController{

    @Inject
    StandardRodsRepo standardRodsRepo;
    @Inject
    StandardRods standardRods;
    @Inject
    ResultStatus resultStatus;

    public StandardRods getDefaultRodAndColor(String seriesInd, String beltStyleInd, String materialInd, String colorInd) {
        List<StandardRods> standardRodsList = standardRodsRepo.getStandardRods(seriesInd, beltStyleInd, materialInd, colorInd);
        standardRods = standardRodsList.get(0);
        standardRods.setResultStatus(resultStatus);
        return standardRods;
    }
}
