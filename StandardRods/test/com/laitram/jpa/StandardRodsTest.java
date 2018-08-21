package com.laitram.jpa;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by smarino on 8/7/2018
 */
@RunWith(Arquillian.class)
public class StandardRodsTest {

    @Deployment
    public static Archive<?> createDeployment()
    {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(StandardRods.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private StandardRodsDAOController standardRodsDAOController;

    @Test
    public void getStandardRodsTest()
    {
       StandardRods standardRodsList = standardRodsDAOController.getDefaultRodAndColor("550", "TIGHT TRANSFER FLAT TOP", "NYLON", "DARK BROWN");
       assertEquals("ABRASION RESIST", standardRodsList.getDefaultRodMat());
       assertEquals("GOLD.BROWN", standardRodsList.getDefaultRodColor());
    }
}
