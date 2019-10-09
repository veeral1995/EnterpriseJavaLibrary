import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.library.controllers.AllControllerTests;
import com.library.model.domain.AllDomainTests;

@RunWith(Suite.class)
@SuiteClasses({AllDomainTests.class, AllControllerTests.class})
public class ApplicationTestSuite {

}