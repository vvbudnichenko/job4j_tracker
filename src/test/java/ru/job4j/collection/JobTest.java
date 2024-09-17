package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByDescNameAndByDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Lora", 0),
                new Job("Mika", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescPriorityAndByDescName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Mika", 1),
                new Job("Mika", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscPriorityAndByAscByName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("Anna", 0),
                new  Job("Antti", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndByAscByPriority() {
        Comparator<Job> cmpPriorityName = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpPriorityName.compare(
                new Job("Anna", 0),
                new  Job("Antti", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscPriorityAndByAscName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Mika", 1),
                new Job("Mika", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscPriorityAndByAscNameSame() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Mika", 1),
                new Job("Mika", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenComparatorByDescPriorityAndByDescNameSame() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Mika", 1),
                new Job("Mika", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }
}