package com.laitram.jpa;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.*;

/**
 * Created by smarino on 8/7/2018
 */
@Entity
@Dependent
@PersistenceUnit(name="DB")
@NamedStoredProcedureQuery(name = "GET_STD_RODS",
        procedureName = "xxlt.xxlt_get_std_rods_test_pkg.get_std_rods", resultClasses = {StandardRods.class},
        parameters = {
                @StoredProcedureParameter(name = "p_series_ind", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "p_style_ind",  mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "p_material_ind",  mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "p_color_ind",  mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "standard_rods_cur",  mode = ParameterMode.REF_CURSOR, type = Class.class),
        })
public class StandardRods{
    @Id
    private String defaultRodMat;

    public String getDefaultRodMat()
    {
        return defaultRodMat;
    }
    public void setDefaultRodMat(String defaultRodMat)
    {
        this.defaultRodMat = defaultRodMat;
    }

    @Basic
    private String defaultRodColor;

    public String getDefaultRodColor()
    {
        return defaultRodColor;
    }

    public void setDefaultRodColor(String defaultRodColor)
    {
        this.defaultRodColor = defaultRodColor;
    }

    @Inject
    @Embedded
    private ResultStatus resultStatus;

    public void setResultStatus(ResultStatus resultStatus)
    {
        this.resultStatus = resultStatus;
    }

    @Override
    public String toString()
    {
        return "Default Color : " + defaultRodColor + ", Default Material : " + defaultRodMat;
    }
}
