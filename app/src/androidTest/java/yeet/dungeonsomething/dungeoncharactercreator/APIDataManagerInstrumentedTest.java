package yeet.dungeonsomething.dungeoncharactercreator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import yeet.dungeonsomething.dungeoncharactercreator.Model.Class;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Equipment;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Proficiency;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Race;
import yeet.dungeonsomething.dungeoncharactercreator.Model.StartingEquipment;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class APIDataManagerInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("yeet.dungeonsomething.dungeoncharactercreator", appContext.getPackageName());

        Class[] loadedClasses = APIDataManager.getInstance(appContext.getAssets()).getClasses();
        assertEquals(12, loadedClasses.length);

        Race[] loadedRaces = APIDataManager.getInstance(appContext.getAssets()).getRaces();
        assertEquals(9, loadedRaces.length);

        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getAbilityScores().length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getDamageTypes().length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getEquipmentCategories().length);
        Equipment[] equipment = APIDataManager.getInstance(appContext.getAssets()).getEquipments();
        assertNotEquals(0, equipment.length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getFeatures().length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getLanguages().length);
        Proficiency[] profs = APIDataManager.getInstance(appContext.getAssets()).getProficiencies();
        assertNotEquals(0, profs.length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getSkills().length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getSpellcasting().length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getSpells().length);
        StartingEquipment[] steq = APIDataManager.getInstance(appContext.getAssets()).getStartingEquipment();
        assertNotEquals(0, steq.length);
        assertNotEquals(0, APIDataManager.getInstance(appContext.getAssets()).getTraits().length);




    }
}
