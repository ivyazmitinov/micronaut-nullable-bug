package nullable.bug;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Context
public class BeanWithSetDependency
{
    private static final Logger LOG = LoggerFactory.getLogger(BeanWithSetDependency.class);

    @Value("${fields}")
    @Nullable
    private Set<String> nullableSet = new HashSet<>();

    @PostConstruct
    public void logSet()
    {
        LOG.info("Injected set:", nullableSet);
    }
}
