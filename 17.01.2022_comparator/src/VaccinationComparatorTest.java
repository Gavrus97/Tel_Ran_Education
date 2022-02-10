import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationComparatorTest {

    VaccinationComparator comparator = new VaccinationComparator();

    @Test
    public void testCompare_1(){
        Human vasja = new Human(70, false,"vasja");
        Human petja = new Human(50, false, "petja");

        assertTrue(comparator.compare(vasja, petja) < 0);
        assertTrue(comparator.compare( petja, vasja) > 0);
    }

}