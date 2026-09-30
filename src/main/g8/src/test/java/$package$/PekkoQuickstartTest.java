package $package$;

import org.apache.pekko.actor.testkit.typed.annotations.JUnit5TestKit;
import org.apache.pekko.actor.testkit.typed.javadsl.ActorTestKit;
import org.apache.pekko.actor.testkit.typed.javadsl.TestKitJUnit5Extension;
import org.apache.pekko.actor.testkit.typed.javadsl.TestProbe;
import org.apache.pekko.actor.typed.ActorRef;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

//#definition
@ExtendWith(TestKitJUnit5Extension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PekkoQuickstartTest {

    @JUnit5TestKit
    public final ActorTestKit testKit = ActorTestKit.create();
//#definition

    //#test
    @Test
    public void testGreeterActorSendingOfGreeting() {
        TestProbe<Greeter.Greeted> testProbe = testKit.createTestProbe();
        ActorRef<Greeter.Greet> underTest = testKit.spawn(Greeter.create(), "greeter");
        underTest.tell(new Greeter.Greet("Charles", testProbe.getRef()));
        testProbe.expectMessage(new Greeter.Greeted("Charles", underTest));
    }
    //#test
}
