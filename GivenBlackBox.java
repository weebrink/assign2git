import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import main.java.BearWorkshop;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BattleScenario> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BattleScenario>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BattleScenario1.class},
                {BattleScenario2.class},
                {BattleScenario3.class},
                {BattleScenario4.class},
                {BattleScenario5.class}

        };
        return Arrays.asList(classes);
    }

    private BattleScenario createBattleScenario(Mascotmon a, Mascotmon d) throws Exception {
        Constructor<BattleScenario> constructor = classUnderTest.getConstructor(Mascotmon.class, Mascotmon.class);
        System.out.println(constructor);
        return constructor.newInstance(a, d);
    }

    
    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
    }

    // sample test

    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception 
     */
    @Test
    public void BvsRSunnyGround() throws Exception {
        
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        
        BattleScenario fight1 = createBattleScenario(attacker1, defender1); 
        System.out.println("    BvsRSunnyGround");
        
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");
        
        //Calculation: 80 * 1 * 1 - 65 * 1 *1
        // 80 put into attack manually, no weather bonuses on either side, Ralphi has 65 defense
        
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 15, 0.2);
    }
    
    /**
     * Battle between Bully and Ralphie on a sunny day with ground attack
     * @throws Exception 
     */
    @Test
    public void RvsBSunnyGround() throws Exception {
        
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight1 = createBattleScenario(attacker1, defender1); 
        System.out.println("    RvsBSunnyGround");
        
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");
        
        //Calculation: 80 * 1.2 * 1 * 1 - 40 * 1 *1
        // 80 put into attack manually, Ralhpie gets bonus for ground attack no weather bonuses or type bonus
        
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 56, 4.2);
    }

    /**
     * Battle between Sparky and Ralphie on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void SvsRSunnyGround() throws Exception {
        System.out.println("Test case 1: Sparky vs Ralphie! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(55, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 37, 5.25);
    }
    /**
     * Battle between Sparky and Ralphie on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void RvsSSunnyGround() throws Exception {
        System.out.println("Test case 2: Sparky vs Ralphie! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(55, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, -5, 5.0);
    }
    /**
     * Battle between Albert and Bully on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void AvsBSunnyGround() throws Exception {
        System.out.println("Test case 3: Albert vs Bully! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsBSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 40, 0.5);
    }
    /**
     * Battle between Albert and Ralphie on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void AvsRSunnyGround() throws Exception {
        System.out.println("Test case 4: Albert vs Ralphie! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsRSunnyGround");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(5, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, -77, 0.3);
    }
    /**
     * Battle between Sparky and Bully on a rainy day with ground attack
     * @throws Exception
     */
    @Test
    public void SvsBRainyGround() throws Exception {
        System.out.println("Test case 5: Sparky vs Bully! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRRainyGround");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(65, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 9, 0.65);
    }
    /**
     * Battle between Sparky and Ralphie on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void AvsSRainyGround() throws Exception {
        System.out.println("Test case 6: Albert vs Sparky! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsSRainyGround");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(75, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 95, 0.1);
    }
    /**
     * Battle between Ralphie and Albert on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void RvsARainyGround() throws Exception {
        System.out.println("Test case 7: Ralphie vs Albert! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    RvsARainyGround");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(55, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 59, 0.2);
    }
    /**
     * Battle between Albert and Ralphie on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void AvsRRainyGround() throws Exception {
        System.out.println("Test case 8: Albert vs Ralphie! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsRRainyGround");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(45, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, -39, 0.25);
    }
    /**
     * Battle between Bully and Sparky on a sunny day with ground attack
     * @throws Exception
     */
    @Test
    public void BvsSSunnyFire() throws Exception {
        System.out.println("Test case 9: Bully vs Sparky! (Fire) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsSSunnyFire");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(50, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.25);
    }
    /**
     * Battle between Albert and Sparky on a rainy day with water attack
     * @throws Exception
     */
    @Test
    public void AvsSRainyWater() throws Exception {
        System.out.println("Test case 10: Albert vs Sparky! (Water) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    AvsSRainyWater");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(75, "Water");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 118, 0.1);
    }
    /**
     * Battle between Bully and Ralphie on a neutral day with ground attack
     * @throws Exception
     */
    @Test
    public void BvsRNeutralGround() throws Exception {
        System.out.println("Test case 11: Bully vs Ralphie! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRNeutralGround");

        fight1.setEnvironment(Environment.Weather.neutral);
        Attack attack = new Attack(55, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.4);
    }
    /**
     * Battle between Bully and Albert on a sunny day with water attack
     * @throws Exception
     */
    @Test
    public void BvsASunnyWater() throws Exception {
        System.out.println("Test case 12: Sparky vs Ralphie! (Water) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsASunnyWater");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(85, "Water");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 55, 0.52);
    }
    /**
     * Battle between Bully and Ralphie on a neutral day with fire attack
     * @throws Exception
     */
    @Test
    public void BvsRNeutralFire() throws Exception {
        System.out.println("Test case 13: Bully vs Ralphie! (Fire) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRNeutralFire");

        fight1.setEnvironment(Environment.Weather.neutral);
        Attack attack = new Attack(25, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.25);
    }
    /**
     * Battle between Sparky and Bully on a drought day with ground attack
     * @throws Exception
     */
    @Test
    public void SvsBDroughtGround() throws Exception {
        System.out.println("Test case 14: Sparky vs Bully! (Ground) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRDroughtGround");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(55, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 25, 0.2);
    }
    /**
     * Battle between Albert and Ralphie on a drought day with fire attack
     * @throws Exception
     */
    @Test
    public void AvsRDroughtFire() throws Exception {
        System.out.println("Test case 15: Albert vs Ralphie! (Fire) ");

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);

        BattleScenario fight1 = createBattleScenario(attacker1, defender1);
        System.out.println("    BvsRDroughtFire");

        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(65, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 0, 0.15);
    }
}